package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.SoldArticle;
import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.dal.jdbc.AuctionDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.CategoryDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.SoldArticleDaoJdbcImpl;
import fr.eni.enchere.dal.jdbc.WithdrawalDaoJdbcImpl;

public class DAOFactory {

	public static DAO<Auction> getAuctionDao() {
		DAO<Auction> auctionDao = new AuctionDaoJdbcImpl();
		return auctionDao;
	}

	public static DAO<Category> getCategoryDao() {
		DAO<Category> categoryDao = new CategoryDaoJdbcImpl();
		return categoryDao;
	}

	public static DAO<SoldArticle> getSoldArticleDao() {
		DAO<SoldArticle> soldArticleDao = new SoldArticleDaoJdbcImpl();
		return soldArticleDao;
	}

	public static DAO<Withdrawal> getWithdrawalDao() {
		DAO<Withdrawal> withdrawalDao = new WithdrawalDaoJdbcImpl();
		return withdrawalDao;
	}

}
