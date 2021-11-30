package fr.eni.enchere.view;

import java.io.IOException;
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
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.SoldArticle;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Provide ressources for the index.jsp displays
 */
@WebServlet("/index")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CategoryManager categoryManager;
	SoldArticleManager soldArticleManager;
	UserManager userManager;
	List<Category> categories;
	List<SoldArticle> currentAuctionList;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletIndex() {
		super();
		categoryManager = new CategoryManager();
		soldArticleManager = new SoldArticleManager();
		userManager = new UserManager();
		try {
			categories = categoryManager.getCategories();
		} catch (BusinessException e) {
			// TODO gestion d'exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = null;

		try {
			String pseudo = String.valueOf(session.getAttribute("pseudo"));

			// tests
			pseudo = "VikingBreton";
			// tests

			if (!pseudo.equals("null")) {
				user = userManager.getUserByPseudo(pseudo);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (user != null) {
				request.setAttribute("connected", "true");
			}
		}

		request.setAttribute("categories", categories);
		request.setAttribute("current_auction_list", currentAuctionList);

		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category = new String();

		if (request.getParameter("category_choice") != null) {
			category = request.getParameter("category_choice");
		}

		// TODO filter results

		doGet(request, response);
	}
}
