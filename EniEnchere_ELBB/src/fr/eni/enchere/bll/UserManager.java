package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.DAO;
import fr.eni.enchere.dal.DAOFactory;

public class UserManager {
	
	 private DAO<User> listeUserDao;
	 
	 public UserManager() {
		 this.listeUserDao = DAOFactory.getUserDao();
	 }
	 
	 public List<User> getUsersForConnection() {
		 return this.listeUserDao.selectAll();
	 }

}
