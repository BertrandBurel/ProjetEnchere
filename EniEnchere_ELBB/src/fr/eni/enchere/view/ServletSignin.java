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

/**
 * Servlet implementation class ServletSignin
 */
@WebServlet("/signin")
public class ServletSignin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String userPseudoInput;
	private String userPwdInput;
	private String userCheck;
       
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserManager userManager = new UserManager();
		User user;

		String errorConnect = "Pseudo ou mot de passe incorrect";
		userPseudoInput = request.getParameter("identifier");
		userPwdInput = request.getParameter("inputPassword");
		userCheck = request.getParameter("remmemberMe");
		try {
			if (userPseudoInput.contains("@")) {
				user = userManager.getUserByEmail(userPseudoInput);
			} else {
				user = userManager.getUserByPseudo(userPseudoInput);
			}
			if (user.getId() == 0) {
				request.setAttribute("errorConnect", errorConnect);
				if (userPseudoInput != null) {
					request.setAttribute("pseudo", userPseudoInput);
				}
				if (userPseudoInput != null) {
					request.setAttribute("password", userPwdInput);
				}
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp");
				rd.forward(request, response);
			} else {
				if (user.getPassword().equals(userPwdInput)) {
					session.setAttribute("pseudo", user.getPseudonym());
					if (userCheck != null) {
						Cookie cookie = new Cookie("pseudo", user.getPseudonym());
						cookie.setMaxAge(60*5);
						response.addCookie(cookie);
					}
					response.sendRedirect(request.getContextPath() + "/index");
				} else {
					request.setAttribute("errorConnect", errorConnect);
					request.setAttribute("pseudo", userPseudoInput);
					request.setAttribute("password", userPwdInput);
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
