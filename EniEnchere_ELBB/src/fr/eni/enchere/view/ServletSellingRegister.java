package fr.eni.enchere.view;

import java.io.IOException;
import java.time.LocalDate;

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
		SoldArticle soldArticle = new SoldArticle();
		User user = null;
		Withdrawal withdrawal = new Withdrawal();
		Category category = new Category();

		withdrawal.setStreet(request.getParameter("road"));
		withdrawal.setPostalCode(request.getParameter("postal_code"));
		withdrawal.setTown(request.getParameter("town"));

		soldArticle.setName(request.getParameter("name"));
		soldArticle.setDescription(request.getParameter("description"));

		soldArticle.setInitialPrice(Integer.valueOf(request.getParameter("start_price")));

		soldArticle.setAuctionStartDate(LocalDate.parse(request.getParameter("start_date")));
		soldArticle.setAuctionEndDate(LocalDate.parse(request.getParameter("end_date")));

		HttpSession session = request.getSession();
		String pseudo = String.valueOf(session.getAttribute("pseudo"));

		try {
			user = userManager.getUserByPseudo(pseudo);
			category = categoryManager.getCategoryByName(request.getParameter("category_choice"));
			soldArticle.setCategory(category);
			soldArticle.setUser(user);
			soldArticleManager.insertSoldArticle(soldArticle);

			withdrawal.setArticle(soldArticle);
			withdrawalManager.insertWithdrawal(withdrawal);

		} catch (BusinessException e) {
			e.printStackTrace();
		}

		response.sendRedirect("index");
	}
}
