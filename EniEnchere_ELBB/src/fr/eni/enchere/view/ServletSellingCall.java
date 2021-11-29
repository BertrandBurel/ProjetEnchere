package fr.eni.enchere.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.CategoryManager;
import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Provide the resources for the selling.jsp display
 */
@WebServlet("/selling")
public class ServletSellingCall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Category> categories;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSellingCall() {
		super();
		CategoryManager manager = new CategoryManager();

		try {
			categories = manager.getCategories();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserManager userManager = new UserManager();

		HttpSession session = request.getSession();

		// tests
		session.setAttribute("pseudo", "VikingBreton");
		Cookie cookie = new Cookie("pseudo", "VikingBreton");
		cookie.setMaxAge(60 * 5);
		response.addCookie(cookie);
		// tests

		String pseudo = String.valueOf(session.getAttribute("pseudo"));

		User user = null;

		try {
			user = userManager.getUserByPseudo(pseudo);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		request.setAttribute("user", user);
		request.setAttribute("categories", categories);

		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/selling.jsp");
		rd.forward(request, response);
	}
}
