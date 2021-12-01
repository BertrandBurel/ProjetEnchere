package fr.eni.enchere.view;

import java.io.IOException;

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

	}

}
