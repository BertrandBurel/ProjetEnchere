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

			if (!pseudo.equals("null")) {
				user = userManager.getUserByPseudo(pseudo);
			}

			if (request.getAttribute("article_list") == null) {
				List<SoldArticle> articleList = null;
				if (user != null) {
					articleList = soldArticleManager.getAuctions(0, null, 0, 0, user.getId());
				} else {
					// userId = 0 is "no user", since mode = 0, user will never be tested
					articleList = soldArticleManager.getAuctions(0, null, 0, 0, 0);
				}
				request.setAttribute("article_list", articleList);
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

		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String categoryParam = null;
		int categoryId = 0;
		String research = null;

		// Can be 0: all, 1: sell or 2: buy
		int mode = 0;

		// By selecting filters, the user add 1 for open auctions, 2 for ongoing auction
		// and 4 for closed auction. The result between 0 and 7 determine the filter
		// starting dates and ending date. 0 is the default value, the result is the
		// disconnected one: only current auctions.
		int filters = 0;
		HttpSession session = request.getSession();
		String pseudo = String.valueOf(session.getAttribute("pseudo"));
		User user = null;
		List<SoldArticle> articleList = null;

		if (request.getParameter("category_choice") != null && !request.getParameter("category_choice").equals("")) {
			categoryParam = request.getParameter("category_choice");
			categoryId = Integer.valueOf(categoryParam);
		}

		if (request.getParameter("search_string") != null && !request.getParameter("search_string").equals("")) {
			research = request.getParameter("search_string");
		}

		if (request.getParameter("auction_type") != null && !request.getParameter("auction_type").equals("")) {
			if (request.getParameter("auction_type").equals("buy")) {
				mode = 2;
				if (request.getParameter("open_auctions") != null
						&& !request.getParameter("open_auctions").equals("")) {
					filters += 1;
				}
				if (request.getParameter("ongoing_auctions") != null
						&& !request.getParameter("ongoing_auctions").equals("")) {
					filters += 2;
				}
				if (request.getParameter("won_auctions") != null && !request.getParameter("won_auctions").equals("")) {
					filters += 4;
				}
			} else if (request.getParameter("auction_type").equals("sell")) {
				mode = 1;
				if (request.getParameter("open_sells") != null && !request.getParameter("open_sells").equals("")) {
					filters += 1;
				}
				if (request.getParameter("ongoing_sells") != null
						&& !request.getParameter("ongoing_sells").equals("")) {
					filters += 2;
				}
				if (request.getParameter("closed_sells") != null && !request.getParameter("closed_sells").equals("")) {
					filters += 4;
				}
			}
		}

		try {
			if (!pseudo.equals("null")) {
				user = userManager.getUserByPseudo(pseudo);
			}

			if (user != null) {
				articleList = soldArticleManager.getAuctions(categoryId, research, mode, filters, user.getId());
			} else {
				// userId = 0 is "no user", since mode = 0, user will never be tested
				articleList = soldArticleManager.getAuctions(categoryId, research, 0, filters, 0);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("article_list", articleList);

		doGet(request, response);
	}
}
