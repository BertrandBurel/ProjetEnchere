package fr.eni.enchere.bll;

import java.util.regex.Pattern;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOUser;
import fr.eni.enchere.exceptions.BusinessException;
import fr.eni.enchere.utils.Utils;

public class UserManager {
	 
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
	 
	 public void setNewUser(User user) throws BusinessException {
		 userDao.insert(user);
	 }
	 
	 public boolean getUnicityPseudoEmail(String pseudo, String email) throws BusinessException {
		 return userDao.validateUnicityPseusoEmail(pseudo, email);
	 }
	 
	 public BusinessException validateNewAccount(User user) {
		 BusinessException businessException = new BusinessException();
		 
		 if (user.getPseudonym().length() > 30) {
			 businessException.addError(ErrorCodesBLL.PSEUDO_LENGTH_ERROR);
		 }
		 if (!Pattern.matches(Utils.REGEX_PSEUDO, user.getPseudonym())) {
			 businessException.addError(ErrorCodesBLL.PSEUDO_REGEX_ERROR);
		 }
		 if (user.getLastName().length() > 30) {
			 businessException.addError(ErrorCodesBLL.LASTNAME_LENGTH_ERROR);
		 }
		 if (!Pattern.matches(Utils.REGEX_TEXT, user.getLastName())) {
			 businessException.addError(ErrorCodesBLL.LASTNAME_LENGTH_ERROR);
		 }
		 if (user.getFirstName().length() > 30) {
			 businessException.addError(ErrorCodesBLL.FIRSTSTNAME_LENGTH_ERROR);
		 }
		 if (!Pattern.matches(Utils.REGEX_TEXT, user.getFirstName())) {
			 businessException.addError(ErrorCodesBLL.FIRSTSTNAME_REGEX_ERROR);
		 }
		 if (user.getEmail().length() > 20) {
			 businessException.addError(ErrorCodesBLL.EMAIL_LENGTH_ERROR);
		 }
		 if (!Pattern.matches(Utils.REGEX_TEXT, user.getLastName())) {
			 businessException.addError(ErrorCodesBLL.EMAIL_REGEX_ERROR);
		 }
		 if (user.getPhone().length() > 15) {
			 businessException.addError(ErrorCodesBLL.PHONE_LENGTH_ERROR);
		 }
		 if (!Pattern.matches(Utils.REGEX_PHONE, user.getPhone())) {
			 businessException.addError(ErrorCodesBLL.PHONE_REGEX_ERROR);
		 }
		 if (user.getAddress().length() > 30) {
			 businessException.addError(ErrorCodesBLL.ADDRESS_LENGTH_ERROR);
		 }
		 if (!Pattern.matches(Utils.REGEX_ADDRESS, user.getAddress())) {
			 businessException.addError(ErrorCodesBLL.ADDRESS_REGEX_ERROR);
		 }
		 if (user.getPostalCode().length() > 10) {
			 businessException.addError(ErrorCodesBLL.POSTALCODE_LENGTH_ERROR);
		 }
		 if (!Pattern.matches(Utils.REGEX_POSTAL_CODE, user.getPostalCode())) {
			 businessException.addError(ErrorCodesBLL.POSTALCODE_REGEX_ERROR);
		 }
		 if (user.getCity().length() > 30) {
			 businessException.addError(ErrorCodesBLL.CITY_LENGTH_ERROR);
		 }
		 if (!Pattern.matches(Utils.REGEX_TEXT, user.getPostalCode())) {
			 businessException.addError(ErrorCodesBLL.POSTALCODE_REGEX_ERROR);
		 }
		 if (user.getPassword().length() > 30) {
			 businessException.addError(ErrorCodesBLL.PASSWORD_LENGTH_ERROR);
		 }
		 if (!Pattern.matches(Utils.REGEX_PASSWORD, user.getPassword())) {
			 businessException.addError(ErrorCodesBLL.PASSWORD_REGEX_ERROR);
		 }
		 return businessException;
	 }
	 
	 public boolean validateConfirmPassword(String password, String confirmPassword) {
		 boolean isConfirmed = false;
		 if (password.equals(confirmPassword)) {
			 isConfirmed = true;
		 }
		 return isConfirmed;
	 }
	 
}
