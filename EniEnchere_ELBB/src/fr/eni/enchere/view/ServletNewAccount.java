package fr.eni.enchere.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.ErrorCodesBLL;
import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;
import fr.eni.enchere.messages.MessagesReader;

/**
 * Servlet implementation class ServletNewAccount
 */
@WebServlet("/new_account")
public class ServletNewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		List<String> listErrors = new ArrayList<>();
		
		if (request.getParameter("cancel") != null) {
			response.sendRedirect("/index");
		}
		if (request.getParameter("create") != null) {
			UserManager userManager = new UserManager();
			BusinessException businessException = new BusinessException();
			newUserPassword = request.getParameter("password").trim();
			newUserConfirmPwd = request.getParameter("confirmpassword").trim();
			User user = new User(
					request.getParameter("lastname").trim(),
					request.getParameter("firstname").trim(),
					request.getParameter("pseudo").trim(),
					request.getParameter("email").trim(),
					request.getParameter("phone").trim(),
					request.getParameter("address").trim(),
					request.getParameter("postalcode").trim(),
					request.getParameter("city").trim(),
					newUserPassword,
					0,
					false
					);
			System.out.println(user.toString());
			
			try {
				businessException = userManager.validateNewAccount(user);
				if (!userManager.validateConfirmPassword(newUserPassword, newUserConfirmPwd)) {
					businessException.addError(ErrorCodesBLL.CONFIRM_PASSWORD_ERROR);
				}
				if (!userManager.getUnicityPseudoEmail(user.getPseudonym(), user.getEmail())) {
					businessException.addError(ErrorCodesBLL.UNICITY_ERROR);
				}
				if (businessException.hasErrors()) {
					for (Integer codeError : businessException.getListErrorCodes()) {
						listErrors.add(MessagesReader.getMessageError(codeError));
					}
					request.setAttribute("listErrors", listErrors);
					request.setAttribute("userPseudo", user.getPseudonym());
					request.setAttribute("userLastname", user.getLastName());
					request.setAttribute("userFirstname", user.getFirstName());
					request.setAttribute("userEmail", user.getEmail());
					request.setAttribute("userPhone", user.getPhone());
					request.setAttribute("userAddress", user.getAddress());
					request.setAttribute("userPostalCode", user.getPostalCode());
					request.setAttribute("userCity", user.getCity());
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/createAccount.jsp");
					rd.forward(request, response);
				} else {
//					userManager.setNewUser(user);
//					session.setAttribute("pseudo", user.getPseudonym());
//					response.sendRedirect("");
					user.toString();
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		
	}

}
