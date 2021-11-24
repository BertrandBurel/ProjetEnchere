package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.SoldArticle;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DAOSoldArticle;

public class SoldArticleDaoJdbcImpl implements DAOSoldArticle {

	private final String SELECT_ARTICLES_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
	private final String SELECT_ARTICLES_BY_DATES = "SELECT * FROM ARTICLES_VENDUS WHERE date_debut_encheres < CAST(CURRENT_TIMESTAMP AS DATE) AND date_fin_encheres > CAST(CURRENT_TIMESTAMP AS DATE) ORDER BY date_fin_encheres ASC";
	private final String INSERT_ARTICLES = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public void insert(SoldArticle soldArticle) {
		String request = new String(INSERT_ARTICLES);
		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);

			queryParametrisation(statement, soldArticle);

			statement.executeUpdate();

			ResultSet resultId = statement.getGeneratedKeys();
			if (resultId.next()) {
				int id = resultId.getInt("GENERATED_KEYS");

				soldArticle.setId(id);
			}

			statement.close();

			connection.close();
		} catch (SQLException e) {
			System.err.println("Insertion en BDD échouée");
			e.printStackTrace();
		}
	}

	@Override
	public SoldArticle selectById(int index) {
		String request = new String(SELECT_ARTICLES_BY_ID);

		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request);
			statement.setInt(1, index);

			ResultSet resultSet = statement.executeQuery();

			SoldArticle soldArticle = null;
			if (resultSet.next()) {
				soldArticle = soldArticleFormatter(resultSet);
			}

			statement.close();
			connection.close();

			return soldArticle;
		} catch (SQLException e) {
			System.err.println("Select par Ids impossible");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SoldArticle> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SoldArticle soldArticle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SoldArticle> selectCurrentAuctions() {
		String request = new String(SELECT_ARTICLES_BY_DATES);

		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request);

			ResultSet resultSet = statement.executeQuery();

			List<SoldArticle> soldArticleList = new ArrayList<>();
			while (resultSet.next()) {
				soldArticleList.add(soldArticleFormatter(resultSet));
			}

			statement.close();
			connection.close();

			return soldArticleList;
		} catch (SQLException e) {
			System.err.println("Select par Ids impossible");
			e.printStackTrace();
		}
		return null;
	}

	private PreparedStatement queryParametrisation(PreparedStatement statement, SoldArticle soldArticle)
			throws SQLException {
		statement.setString(1, soldArticle.getName());
		statement.setString(2, soldArticle.getDescription());
		statement.setDate(3, Date.valueOf(soldArticle.getAuctionStartDate()));
		statement.setDate(4, Date.valueOf(soldArticle.getAuctionEndDate()));
		statement.setInt(5, soldArticle.getInitialPrice());
		if (soldArticle.getSoldPrice() != 0) {
			statement.setInt(6, soldArticle.getSoldPrice());
		} else {
			statement.setNull(6, Types.INTEGER);
		}
		statement.setInt(7, soldArticle.getUser().getId());
		statement.setInt(8, soldArticle.getCategory().getId());

		return statement;
	}

	private SoldArticle soldArticleFormatter(ResultSet resultSet) throws SQLException {
		SoldArticle soldArticle = new SoldArticle();
		soldArticle.setId(resultSet.getInt("no_article"));
		soldArticle.setName(resultSet.getString("nom_article"));
		soldArticle.setDescription(resultSet.getString("description"));
		soldArticle.setAuctionStartDate(resultSet.getDate("date_debut_encheres").toLocalDate());
		soldArticle.setAuctionEndDate(resultSet.getDate("date_fin_encheres").toLocalDate());
		soldArticle.setInitialPrice(resultSet.getInt("prix_initial"));
		soldArticle.setSoldPrice(resultSet.getInt("prix_vente"));
		// TODO
		// soldArticle.setUser(resultSet.getString("no_utilisateur"));
		// soldArticle.setCategory(resultSet.getString("no_categorie"));

		return soldArticle;
	}
}
