package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DAOAuction;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOSoldArticle;
import fr.eni.enchere.dal.DAOUser;
import fr.eni.enchere.exceptions.BusinessException;

public class AuctionDaoJdbcImpl implements DAOAuction {

	private final String INSERT_AUCTION = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?)";
	private final String SELECT_BEST_BID = "SELECT * FROM ENCHERES WHERE no_article = ? AND montant_enchere = (SELECT MAX(montant_enchere) FROM ENCHERES WHERE no_article = ?)";

	@Override
	public void insert(Auction auction) {
		String request = new String(INSERT_AUCTION);
		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);

			queryParametrisation(statement, auction);

			statement.executeUpdate();

			statement.close();

			connection.close();
		} catch (SQLException e) {
			System.err.println("Insertion en BDD échouée");
			e.printStackTrace();
		}
	}

	@Override
	public Auction selectById(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auction> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Auction t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public Auction getBestAuctionById(int idArticle) {
		String request = new String(SELECT_BEST_BID);

		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request);
			statement.setInt(1, idArticle);
			statement.setInt(2, idArticle);

			ResultSet resultSet = statement.executeQuery();

			Auction auction = null;
			if (resultSet.next()) {
				try {
					auction = auctionFormatter(resultSet);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			statement.close();
			connection.close();

			return auction;
		} catch (SQLException e) {
			System.err.println("Select par idArticle impossible");
			e.printStackTrace();
		}
		return null;
	}

	private PreparedStatement queryParametrisation(PreparedStatement statement, Auction auction) throws SQLException {
		statement.setInt(1, auction.getUser().getId());
		statement.setInt(2, auction.getArticle().getId());
		statement.setDate(3, Date.valueOf(auction.getAuctionDate()));
		statement.setInt(4, auction.getBidPrice());

		return statement;
	}

	private Auction auctionFormatter(ResultSet resultSet) throws SQLException, BusinessException {
		DAOUser daoUser = DAOFactory.getUserDao();
		DAOSoldArticle daoSoldArticle = DAOFactory.getSoldArticleDao();

		Auction auction = new Auction();
		auction.setUser(daoUser.selectById(resultSet.getInt("no_utilisateur")));
		auction.setArticle(daoSoldArticle.selectById(resultSet.getInt("no_article")));
		auction.setAuctionDate(resultSet.getDate("date_enchere").toLocalDate());
		auction.setBidPrice(resultSet.getInt("montant_enchere"));

		return auction;
	}
}
