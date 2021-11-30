package fr.eni.enchere.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.ErrorCodesBLL;
import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Servlet implementation class ServletNewAccount
 */
@WebServlet("/new_account")
public class ServletNewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String newUserPassword;
	private String newUserConfirmPwd;
	private boolean isValidated;
       
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
			UserManager userManager = new UserManager();
			BusinessException businessException = new BusinessException();
			newUserPassword = request.getParameter("password");
			newUserConfirmPwd = request.getParameter("confirmpassword");
			User user = new User(
					request.getParameter("identifier"),
					request.getParameter("lastname"),
					request.getParameter("firstname"),
					request.getParameter("email"),
					request.getParameter("phone"),
					request.getParameter("address"),
					request.getParameter("postalcode"),
					request.getParameter("city"),
					newUserPassword,
					0,
					false
					);
			
			try {
				businessException = userManager.validateNewAccount(user);
				if (!userManager.validateConfirmPassword(newUserPassword, newUserConfirmPwd)) {
					businessException.addError(ErrorCodesBLL.CONFIRM_PASSWORD_ERROR);
				}
				if (!userManager.getUnicityPseudoEmail(user.getPseudonym(), user.getEmail())) {
					businessException.addError(ErrorCodesBLL.UNICITY_ERROR);
				}
				if (businessException.hasErrors()) {
					request.setAttribute("businessException", businessException);
					request.setAttribute("userInput", user);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/createAccount.jsp");
					rd.forward(request, response);
				} else {
					userManager.setNewUser(user);
					response.sendRedirect("");
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		
	}

}
