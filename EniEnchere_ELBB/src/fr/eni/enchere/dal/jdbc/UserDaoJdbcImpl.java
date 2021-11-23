package fr.eni.enchere.dal.jdbc;

import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.DAO;

public class UserDaoJdbcImpl implements DAO<User> {

	private static final String SELECT_ALL_USERS = "select no_utilisateur, pseudo, email, mot_de_passe from UTILISATEURS";
	
	@Override
	public void insert(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User selectById(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
		
	}

}
