package fr.eni.enchere.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.User;

/**
 * Servlet implementation class ServletSignin
 */
@WebServlet("/ServletSignin")
public class ServletSignin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String userPseudoInput;
	private String userPwdInput;
	private boolean userCheck;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserManager userManager = new UserManager();
		User user = null;
		userPseudoInput = request.getParameter("identifier");
		userPwdInput = request.getParameter("inputPassword");
		try {
			if (userPseudoInput.contains("@")) {
				user = userManager.getUserByEmail(userPseudoInput);
			} else {
				user = userManager.getUserByPseudo(userPwdInput);
			}
			if (user == null) {
				String errorConnect = "Pseudo ou mot de passe incorrect";
				request.setAttribute("errorConnect", errorConnect);
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp");
				rd.forward(request, response);
			} else {
				if (user.getPassword() == userPwdInput) {
					session.setAttribute("connected", "ok");
					response.sendRedirect("/WEB-INF/auctionsList.jsp");
				} else {
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/connection.jsp");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
