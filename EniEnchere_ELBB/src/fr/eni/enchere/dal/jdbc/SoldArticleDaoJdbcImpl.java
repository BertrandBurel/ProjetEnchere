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
import fr.eni.enchere.dal.DAOCategory;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOSoldArticle;
import fr.eni.enchere.dal.DAOUser;
import fr.eni.enchere.exceptions.BusinessException;

public class SoldArticleDaoJdbcImpl implements DAOSoldArticle {

	private final String SELECT_ARTICLES_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
	private final String INSERT_ARTICLES = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SELECT_ARTICLES = "SELECT * FROM ARTICLES_VENDUS";
	private final String FILTERS_CATEGORY = "no_categorie = ?";
	private final String FILTERS_STRING = "nom_article LIKE ?";
	private final String DATES_OPEN_AUCTION = "date_debut_encheres > CAST(CURRENT_TIMESTAMP AS DATE)";
	private final String DATES_ONGOING_AUCTION = "date_debut_encheres <= CAST(CURRENT_TIMESTAMP AS DATE) AND date_fin_encheres >= CAST(CURRENT_TIMESTAMP AS DATE)";
	private final String DATE_CLOSED_AUCTION = "date_fin_encheres < CAST(CURRENT_TIMESTAMP AS DATE)";
	private final String FILTER_MODE_SELL = "no_utilisateur = ?";
	private final String FILTER_MODE_BUY = "no_utilisateur != ?";
	private final String WHERE = " WHERE ";
	private final String AND = " AND ";
	private final String ORDER_BY_DATE = " ORDER BY date_fin_encheres ASC";

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
		} catch (BusinessException e) {
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
	public List<SoldArticle> selectAuctions(int category, String research, int mode, int filters, int userId) {
		String request = new String();
		StringBuffer requestBuffer = new StringBuffer(SELECT_ARTICLES);

		switch (filters) {
		case 1: // open
			requestBuffer.append(WHERE + DATES_OPEN_AUCTION);
			break;
		case 2: // ongoing
			requestBuffer.append(WHERE + DATES_ONGOING_AUCTION);
			break;
		case 3: // open + ongoing
			requestBuffer.append(WHERE + "(" + DATES_ONGOING_AUCTION + " OR " + DATES_OPEN_AUCTION + ")");
			break;
		case 4: // closed
			requestBuffer.append(WHERE + DATE_CLOSED_AUCTION);
			break;
		case 5: // open + closed
			requestBuffer.append(WHERE + "(" + DATE_CLOSED_AUCTION + " OR " + DATES_OPEN_AUCTION + ")");
			break;
		case 6: // ongoing + closed
			requestBuffer.append(WHERE + "(" + DATES_ONGOING_AUCTION + " OR " + DATE_CLOSED_AUCTION + ")");
			break;
		case 7: // all
			requestBuffer.append(WHERE + "(" + DATES_ONGOING_AUCTION + " OR " + DATES_OPEN_AUCTION + " OR "
					+ DATES_OPEN_AUCTION + ")");
			break;
		default: // default: ongoing auction list
			requestBuffer.append(WHERE + DATES_ONGOING_AUCTION);
			break;
		}

		if (mode == 1) {
			requestBuffer.append(AND + FILTER_MODE_SELL);
		} else if (mode == 2) {
			requestBuffer.append(AND + FILTER_MODE_BUY);
		} // default: no mode, everything is selected

		// category 0 = all categories
		if (category != 0) {
			requestBuffer.append(AND + FILTERS_CATEGORY);
		}

		// research null = no research String
		if (research != null) {
			requestBuffer.append(AND + FILTERS_STRING);
		}

		requestBuffer.append(ORDER_BY_DATE);

		request = requestBuffer.toString();

		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request);

			int paramNumber = 1;

			if (mode != 0) {
				statement.setInt(paramNumber, userId);
				paramNumber++;
			}

			if (category != 0) {
				statement.setInt(paramNumber, category);
				paramNumber++;
			}

			if (research != null) {
				statement.setString(paramNumber, "%" + research + "%");
			}

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
		} catch (BusinessException e) {
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

	private SoldArticle soldArticleFormatter(ResultSet resultSet) throws SQLException, BusinessException {
		DAOUser daoUser = DAOFactory.getUserDao();
		DAOCategory daoCategory = DAOFactory.getCategoryDao();

		SoldArticle soldArticle = new SoldArticle();
		soldArticle.setId(resultSet.getInt("no_article"));
		soldArticle.setName(resultSet.getString("nom_article"));
		soldArticle.setDescription(resultSet.getString("description"));
		soldArticle.setAuctionStartDate(resultSet.getDate("date_debut_encheres").toLocalDate());
		soldArticle.setAuctionEndDate(resultSet.getDate("date_fin_encheres").toLocalDate());
		soldArticle.setInitialPrice(resultSet.getInt("prix_initial"));
		soldArticle.setSoldPrice(resultSet.getInt("prix_vente"));

		soldArticle.setUser(daoUser.selectById(resultSet.getInt("no_utilisateur")));
		soldArticle.setCategory(daoCategory.selectById(resultSet.getInt("no_categorie")));

		return soldArticle;
	}
}
