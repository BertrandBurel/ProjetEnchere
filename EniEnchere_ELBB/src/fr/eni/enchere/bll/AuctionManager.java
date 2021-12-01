package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.dal.DAOAuction;
import fr.eni.enchere.dal.DAOFactory;

public class AuctionManager {
	private DAOAuction daoAuction;

	public AuctionManager() {
		daoAuction = DAOFactory.getAuctionDao();
	}

	public Auction getBestAuctionById(int articleId) {
		return daoAuction.getBestAuctionById(articleId);
	}
}
