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

	public BusinessException validateNewAccount(Auction auction, int actualPrice) {
		BusinessException businessException = new BusinessException();

		if (auction.getBidPrice() <= actualPrice) {
			businessException.addError(ErrorCodesBLL.BID_INFERIOR_TO_PRICE_ERROR);
		}
		return businessException;
	}
}
