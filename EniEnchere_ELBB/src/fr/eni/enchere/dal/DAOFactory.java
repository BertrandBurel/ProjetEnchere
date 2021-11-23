package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.SoldArticle;
import fr.eni.enchere.bo.User;
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
	public static DAO<Auction> getAuctionDao() {
		DAO<Auction> auctionDao = new AuctionDaoJdbcImpl();
		return auctionDao;
	}

	/**
	 * Give a DAO instance for Category manipulation
	 * 
	 * @return DAO<Category>
	 */
	public static DAO<Category> getCategoryDao() {
		DAO<Category> categoryDao = new CategoryDaoJdbcImpl();
		return categoryDao;
	}

	/**
	 * Give a DAO instance for SoldArticle manipulation
	 * 
	 * @return DAO<SoldArticle>
	 */
	public static DAO<SoldArticle> getSoldArticleDao() {
		DAO<SoldArticle> soldArticleDao = new SoldArticleDaoJdbcImpl();
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
	
	public static DAO<User> getUserDao() {
		DAO<User> userDao = new UserDaoJdbcImpl();
		return userDao;
	}
}
