package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.ConnectionProvider;
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
		List<User> usersList = new ArrayList<User>();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				usersList.add(new User(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("email"), rs.getString("mot_de_passe")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
