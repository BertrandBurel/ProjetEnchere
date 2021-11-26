package fr.eni.enchere.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Servlet implementation class ServletToConnection
 */
@WebServlet("/ServletToConnection")
public class ServletToConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserManager userManager = new UserManager();
		User user = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("pseudo")) {
					try {
						user = userManager.getUserByPseudo(cookie.getValue());
						request.setAttribute("pseudo", user.getPseudonym());
						request.setAttribute("password", user.getPassword());
					} catch (BusinessException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		} else {
			if (session.getAttribute("pseudo") != null) {
				String pseudoSession = (String) session.getAttribute("pseudo");
				try {
					user = userManager.getUserByPseudo(pseudoSession);
				request.setAttribute("pseudo", user.getPseudonym());
				request.setAttribute("password", user.getPassword());
				} catch (BusinessException e) {
					e.printStackTrace();
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connection.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
