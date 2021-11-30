package fr.eni.enchere.bll;

import java.util.regex.Pattern;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOUser;
import fr.eni.enchere.exceptions.BusinessException;

public class UserManager {

	 private static final String REGEX_PSEUDO = "[a-zA-Z0-9]+";
	 // https://emailregex.com
	 private static final String REGEX_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\""
	 		+ "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@"
	 		+ "(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]"
	 		+ "?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:("
	 		+ "?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	 private static final String REGEX_PHONE = "(([0-8][0-9])|(9[0-5]))[0-9]{3}$";
	 
	 private DAOUser userDao;
	 
	 public UserManager() {
		 userDao = DAOFactory.getUserDao();
	 }
	 
	 public User getUserById(int index) throws BusinessException {
		 return userDao.selectById(index);
	 }
	 
	 public User getUserByPseudo(String pseudo) throws BusinessException {
		 return userDao.selectByPseudo(pseudo);
	 }
	 
	 public User getUserByEmail(String email) throws BusinessException {
		 return userDao.selectByEmail(email);
	 }
	 
	 public BusinessException validateNewAccount(User user) {
		 BusinessException businessException = new BusinessException();
		 
		 if (user.getPseudonym().length() > 30) {
			 businessException.addError(ErrorCodesBLL.PSEUDO_LENGTH_ERROR);
		 }
		 if (!Pattern.matches(REGEX_PSEUDO, user.getPseudonym())) {
			 businessException.addError(ErrorCodesBLL.PSEUDO_REGEX_ERROR);
		 }
		 
		 return businessException;
	 }
}
