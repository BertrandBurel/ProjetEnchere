package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DAOUser;

public class UserDaoJdbcImpl implements DAOUser {

	private static final String SELECT_USER_BY_ID = "select * from UTILISATEURS where no_utilisateur = ?";
	private static final String SELECT_USER_BY_PSEUDO = "select * from UTILISATEURS where pseudo = ?";
	private static final String SELECT_USER_BY_EMAIL = "select * from UTILISATEURS where email = ?";
	private static final String INSERT_USER = "insert into UTILISATEURS (pseudo, nom, prenom,"
						+ "email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
						+ "values (?,?,?,?,?,?,?,?,?,?,?)";
	
	@Override
	public void insert(User user) {
//		if (user == null) {
//			BusinessException businessException = new BusinessException();
//			businessException.ajouterErreur(CodesDAL.INSERT_OBJECT_NULL);
//			throw businessException;
//		}
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, user.getPseudonym());
				pstmt.setString(2, user.getLastName());
				pstmt.setString(3, user.getFirstName());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getPhone());
				pstmt.setString(6, user.getAddress());
				pstmt.setString(7, user.getPostalCode());
				pstmt.setString(8, user.getCity());
				pstmt.setString(9, user.getPassword());
				pstmt.setString(10, "0");
				pstmt.setString(11, "0");
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				while (rs.next()) {
					user.setId(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
			} finally {
				cnx.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
