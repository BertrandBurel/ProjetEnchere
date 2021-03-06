package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.dal.jdbc.AuctionDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.CategoryDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.SoldArticleDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.UserDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.WithdrawalDaoJdbcImpl;

public class DAOFactory {

	/**
	 * Give a DAO instance for Auction manipulation
	 * 
	 * @return DAO<Auction>
	 */
	public static DAOAuction getAuctionDao() {
		DAOAuction auctionDao = new AuctionDaoJdbcImpl();
		return auctionDao;
	}

	/**
	 * Give a DAO instance for Category manipulation
	 * 
	 * @return DAO<Category>
	 */
	public static DAOCategory getCategoryDao() {
		DAOCategory categoryDao = new CategoryDaoJdbcImpl();
		return categoryDao;
	}

	/**
	 * Give a DAO instance for SoldArticle manipulation
	 * 
	 * @return DAOSoldArticle
	 */
	public static DAOSoldArticle getSoldArticleDao() {
		DAOSoldArticle soldArticleDao = new SoldArticleDaoJdbcImpl();
		return soldArticleDao;
	}

	/**
	 * Give a DAO instance for Withdrawal manipulation
	 * 
	 * @return DAO<Withdrawal>
	 */
	public static DAO<Withdrawal> getWithdrawalDao() {
		DAO<Withdrawal> withdrawalDao = new WithdrawalDaoJdbcImpl();
		return withdrawalDao;
	}

	public static DAOUser getUserDao() {
		DAOUser userDao = new UserDaoJdbcImpl();
		return userDao;
	}
}
