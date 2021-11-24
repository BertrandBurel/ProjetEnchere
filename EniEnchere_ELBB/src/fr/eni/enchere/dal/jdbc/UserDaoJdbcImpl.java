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

	private static final String SELECT_USER_BY_ID = "select * from UTILISATEURS where no_utilisateur = ?";
	private static final String SELECT_USER_BY_PSEUDO = "select * from UTILISATEURS where pseudo = ?";
	private static final String SELECT_USER_BY_EMAIL = "select * from UTILISATEURS where email = ?";
	
	@Override
	public void insert(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User selectById(int index) {
		User user = new User();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_BY_ID);
			pstmt.setInt(1, index);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("no_utilisateur"));
				user.setPseudonym(rs.getString("pseudo"));
				user.setLastName(rs.getString("nom"));
				user.setFirstName(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("telephone"));
				user.setAddress(rs.getString("rue"));
				user.setPostalCode(rs.getString("code_postal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setAdministrator(rs.getBoolean("administrateur"));
			}
			rs.close();
			pstmt.close();
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> selectAll() {
		// TODO: handle exception
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
	
	public User selectByPseudo(String pseudo) {
		User user = new User();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_BY_PSEUDO);
			pstmt.setString(1, pseudo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("no_utilisateur"));
				user.setPseudonym(rs.getString("pseudo"));
				user.setLastName(rs.getString("nom"));
				user.setFirstName(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("telephone"));
				user.setAddress(rs.getString("rue"));
				user.setPostalCode(rs.getString("code_postal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setAdministrator(rs.getBoolean("administrateur"));
			}
			rs.close();
			pstmt.close();
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User selectByEmail(String email) {
		User user = new User();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_USER_BY_EMAIL);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getInt("no_utilisateur"));
				user.setPseudonym(rs.getString("pseudo"));
				user.setLastName(rs.getString("nom"));
				user.setFirstName(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("telephone"));
				user.setAddress(rs.getString("rue"));
				user.setPostalCode(rs.getString("code_postal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mot_de_passe"));
				user.setCredit(rs.getInt("credit"));
				user.setAdministrator(rs.getBoolean("administrateur"));
			}
			rs.close();
			pstmt.close();
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
