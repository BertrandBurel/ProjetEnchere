package fr.eni.enchere.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.CategoryManager;
import fr.eni.enchere.bll.SoldArticleManager;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.SoldArticle;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryManager categoryManager;
	SoldArticleManager soldArticleManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		categoryManager = new CategoryManager();
		soldArticleManager = new SoldArticleManager();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categories = categoryManager.getCategories();
		List<SoldArticle> currentAuctionList = soldArticleManager.getCurrentAuctions();

		request.setAttribute("categories", categories);
		request.setAttribute("current_auction_list", currentAuctionList);

		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
