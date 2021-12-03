package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.dal.DAOAuction;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.exceptions.BusinessException;

public class AuctionManager {
	private DAOAuction daoAuction;

	public AuctionManager() {
		daoAuction = DAOFactory.getAuctionDao();
	}

	public void insertAuction(Auction auction) throws BusinessException {
		daoAuction.insert(auction);
	}

	public Auction getBestAuctionById(int articleId) {
		return daoAuction.getBestAuctionById(articleId);
	}
}
