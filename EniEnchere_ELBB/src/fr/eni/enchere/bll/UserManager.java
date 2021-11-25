package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.DAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOUser;
import fr.eni.enchere.exceptions.BusinessException;

public class UserManager {
	
	 private DAO<User> listeUserDao;
	 private DAOUser userDao;
	 
	 public UserManager() {
		 this.listeUserDao = DAOFactory.getUserDao();
	 }
	 
	 public User getUserById(int index) throws BusinessException {
		 return this.listeUserDao.selectById(index);
	 }
	 
	 public User getUserByPseudo(String pseudo) throws BusinessException {
		 return this.userDao.selectByPseudo(pseudo);
	 }
	 
	 public User getUserByEmail(String email) throws BusinessException {
		 return this.userDao.selectByEmail(email);
	 }
}
