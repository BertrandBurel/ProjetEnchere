package fr.eni.enchere.view;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.CategoryManager;
import fr.eni.enchere.bll.SoldArticleManager;
import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bll.WithdrawalManager;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.SoldArticle;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.exceptions.BusinessException;
import fr.eni.enchere.messages.MessagesReader;

/**
 * Servlet implementation class ServletSellingRegister
 */
@WebServlet("/selling_register")
public class ServletSellingRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SoldArticleManager soldArticleManager;
	private WithdrawalManager withdrawalManager;
	private UserManager userManager;
	private CategoryManager categoryManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSellingRegister() {
		super();
		soldArticleManager = new SoldArticleManager();
		withdrawalManager = new WithdrawalManager();
		userManager = new UserManager();
		categoryManager = new CategoryManager();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusinessException businessException = new BusinessException();
		List<String> listErrors = new ArrayList<>();
		SoldArticle soldArticle = new SoldArticle();
		User user = null;
		Withdrawal withdrawal = new Withdrawal();
		Category category = new Category();
		HttpSession session = request.getSession();
		String pseudo = String.valueOf(session.getAttribute("pseudo"));

		withdrawal.setStreet(request.getParameter("road"));
		withdrawal.setPostalCode(request.getParameter("postal_code"));
		withdrawal.setTown(request.getParameter("town"));

		soldArticle.setName(request.getParameter("name"));
		soldArticle.setDescription(request.getParameter("description"));

		if (request.getParameter("start_price") != null && request.getParameter("start_price") != "") {
			soldArticle.setInitialPrice(Integer.valueOf(request.getParameter("start_price")));
		} else {
			soldArticle.setInitialPrice(0); // generate a controlled exception
		}
		if (request.getParameter("start_date") != null && request.getParameter("start_date") != "") {
			soldArticle.setAuctionStartDate(LocalDate.parse(request.getParameter("start_date")));
		}
		if (request.getParameter("end_date") != null && request.getParameter("end_date") != "") {
			soldArticle.setAuctionEndDate(LocalDate.parse(request.getParameter("end_date")));
		}

		try {
			user = userManager.getUserByPseudo(pseudo);
			category = categoryManager.getCategoryByName(request.getParameter("category_choice"));
			soldArticle.setCategory(category);
			soldArticle.setUser(user);

			BusinessException tempError = withdrawalManager.validateNewAccount(withdrawal);
			List<Integer> errors = tempError.getListErrorCodes();

			businessException = soldArticleManager.validateNewAccount(soldArticle);

			for (Integer error : errors) {
				businessException.addError(error);
			}

			if (businessException.hasErrors()) {
				for (Integer codeError : businessException.getListErrorCodes()) {
					listErrors.add(MessagesReader.getMessageError(codeError));
				}

				request.setAttribute("listErrors", listErrors);
				request.setAttribute("user", user);
				request.setAttribute("categories", categoryManager.getCategories());

				request.setAttribute("article", soldArticle);

				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/selling.jsp");
				rd.forward(request, response);
				return;
			} else {

				soldArticleManager.insertSoldArticle(soldArticle);

				withdrawal.setArticle(soldArticle);
				withdrawalManager.insertWithdrawal(withdrawal);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		response.sendRedirect("index");
	}
}
