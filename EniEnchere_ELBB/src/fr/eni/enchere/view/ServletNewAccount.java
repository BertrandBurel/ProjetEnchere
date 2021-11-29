package fr.eni.enchere.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletNewAccount
 */
@WebServlet("/ServletNewAccount")
public class ServletNewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String newUserPSeudo;
	private String newUserLastname;
	private String newUserFirstname;
	private String newUserEmail;
	private String newUserPhone;
	private String newUserAddress;
	private String newUserPostalCode;
	private String newUserCity;
	private String newUserPassword;
	private String newUserConfirmPwd;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("cancel") != null) {
			response.sendRedirect("/index");
		}
		if (request.getParameter("create") != null) {
			newUserPSeudo = request.getParameter("");
		}
		
	}

}
