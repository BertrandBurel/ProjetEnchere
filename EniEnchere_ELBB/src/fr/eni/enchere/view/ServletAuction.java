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

import fr.eni.enchere.bll.AuctionManager;
import fr.eni.enchere.bll.SoldArticleManager;
import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bll.WithdrawalManager;
import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.SoldArticle;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.exceptions.BusinessException;
import fr.eni.enchere.messages.MessagesReader;

/**
 * Servlet implementation class ServletAuction
 */
@WebServlet("/auction")
public class ServletAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SoldArticleManager soldArticleManager;
	private UserManager userManager;
	private AuctionManager auctionManager;
	private WithdrawalManager withdrawalManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAuction() {
		super();
		soldArticleManager = new SoldArticleManager();
		userManager = new UserManager();
		auctionManager = new AuctionManager();
		withdrawalManager = new WithdrawalManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		SoldArticle soldArticle = null;
		int soldArticleId = 0;
		User user = null;
		String userPseudo = null;
		Category category = null;
		Withdrawal withdrawal = null;
		Auction auction = null;

		soldArticleId = Integer.valueOf(request.getParameter("article_no"));
		userPseudo = String.valueOf(session.getAttribute("pseudo"));

		if (userPseudo.equals("null")) {
			response.sendRedirect(request.getContextPath() + "/index");
			return;
		}

		try {
			soldArticle = soldArticleManager.getArticleById(soldArticleId);
			request.setAttribute("article", soldArticle);

			user = soldArticle.getUser();
			request.setAttribute("seller", user);

			category = soldArticle.getCategory();
			request.setAttribute("category", category);

			withdrawal = withdrawalManager.getWithdrawalById(soldArticle.getId());
			request.setAttribute("withdrawal", withdrawal);

			auction = auctionManager.getBestAuctionById(soldArticle.getId());
			request.setAttribute("auction", auction);

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/auction.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		BusinessException businessException = new BusinessException();
		List<String> listErrors = new ArrayList<>();
		String articleId = request.getParameter("article_id");
		String userPseudo = String.valueOf(session.getAttribute("pseudo"));
		int bid = Integer.valueOf(request.getParameter("bid"));

		try {
			SoldArticle soldArticle = soldArticleManager.getArticleById(Integer.valueOf(articleId));
			User user = userManager.getUserByPseudo(userPseudo);

			Auction auction = new Auction(user, soldArticle, LocalDate.now(), bid);

			businessException = auctionManager.validateNewAccount(auction,
					Integer.valueOf(request.getParameter("min_bid")));
			if (businessException.hasErrors()) {
				for (Integer codeError : businessException.getListErrorCodes()) {
					listErrors.add(MessagesReader.getMessageError(codeError));
				}

				Withdrawal withdrawal = withdrawalManager.getWithdrawalById(soldArticle.getId());

				request.setAttribute("listErrors", listErrors);
				request.setAttribute("article", soldArticle);
				request.setAttribute("seller", soldArticle.getUser());
				request.setAttribute("category", soldArticle.getCategory());
				request.setAttribute("withdrawal", withdrawal);
				request.setAttribute("auction", auction);

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/auction.jsp");
				rd.forward(request, response);
				return;
			} else {
				auctionManager.insertAuction(auction);
			}
		} catch (NumberFormatException | BusinessException e) {
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/index");
	}
}
