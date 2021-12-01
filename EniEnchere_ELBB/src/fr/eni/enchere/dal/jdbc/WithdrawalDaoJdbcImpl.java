package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOSoldArticle;
import fr.eni.enchere.exceptions.BusinessException;

public class WithdrawalDaoJdbcImpl implements DAO<Withdrawal> {

	private final String INSERT_WITHDRAWAL = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?)";
	private final String SELECT_WITHDRAWAL_BY_ID = "SELECT * FROM RETRAITS WHERE no_article = ?";

	@Override
	public void insert(Withdrawal withdrawal) {
		String request = new String(INSERT_WITHDRAWAL);
		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);

			queryParametrisation(statement, withdrawal);

			statement.executeUpdate();

			statement.close();

			connection.close();
		} catch (SQLException e) {
			System.err.println("Insertion en BDD échouée");
			e.printStackTrace();
		}
	}

	@Override
	public Withdrawal selectById(int index) {
		String request = new String(SELECT_WITHDRAWAL_BY_ID);

		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request);
			statement.setInt(1, index);

			ResultSet resultSet = statement.executeQuery();

			Withdrawal withdrawal = null;
			if (resultSet.next()) {
				withdrawal = withdrawalFormatter(resultSet);
			}

			statement.close();
			connection.close();

			return withdrawal;
		} catch (SQLException e) {
			System.err.println("Select par Ids impossible");
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Withdrawal> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Withdrawal t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub

	}

	private PreparedStatement queryParametrisation(PreparedStatement statement, Withdrawal withdrawal)
			throws SQLException {
		statement.setInt(1, withdrawal.getArticle().getId());
		statement.setString(2, withdrawal.getStreet());
		statement.setString(3, withdrawal.getPostalCode());
		statement.setString(4, withdrawal.getTown());

		return statement;
	}

	private Withdrawal withdrawalFormatter(ResultSet resultSet) throws SQLException, BusinessException {
		DAOSoldArticle daoSoldArticle = DAOFactory.getSoldArticleDao();

		Withdrawal withdrawal = new Withdrawal();
		withdrawal.setArticle(daoSoldArticle.selectById(resultSet.getInt("no_article")));
		withdrawal.setStreet(resultSet.getString("rue"));
		withdrawal.setPostalCode(resultSet.getString("code_postal"));
		withdrawal.setTown(resultSet.getString("ville"));

		return withdrawal;
	}
}
