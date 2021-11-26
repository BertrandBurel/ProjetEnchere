package fr.eni.enchere.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Servlet implementation class ServletProfile
 */
@WebServlet("/ServletProfile")
public class ServletProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManager userManager = new UserManager();
		User user = null; 
		String pseudo = request.getParameter("pseudo");
		try {
			user = userManager.getUserByPseudo(pseudo);
			request.setAttribute("pseudo", user.getPseudonym());
			request.setAttribute("lastname", user.getLastName());
			request.setAttribute("firstname", user.getFirstName());
			request.setAttribute("email", user.getEmail());
			request.setAttribute("phone", user.getPhone());
			request.setAttribute("address", user.getAddress());
			request.setAttribute("postal_code", user.getPostalCode());
			request.setAttribute("city", user.getCity());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/profile.jsp");
			rd.forward(request, response);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}
