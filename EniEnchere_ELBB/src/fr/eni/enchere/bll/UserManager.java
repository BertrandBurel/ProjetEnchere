package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.DAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOUser;
import fr.eni.enchere.exceptions.BusinessException;

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
}
