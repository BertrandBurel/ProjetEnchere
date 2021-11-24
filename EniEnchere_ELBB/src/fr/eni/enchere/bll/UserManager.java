package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.DAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOUser;

public class UserManager {
	
	 private DAO<User> listeUserDao;
	 private DAOUser userDao;
	 
	 public UserManager() {
		 this.listeUserDao = DAOFactory.getUserDao();
	 }
	 
	 public User getUserById(int index) {
		 return this.listeUserDao.selectById(index);
	 }
	 
	 public User getUserByPseudo(String pseudo) {
		 return this.userDao.selectByPseudo(pseudo);
	 }
	 
	 public User getUserByEmail(String email) {
		 return this.userDao.selectByEmail(email);
	 }
}
