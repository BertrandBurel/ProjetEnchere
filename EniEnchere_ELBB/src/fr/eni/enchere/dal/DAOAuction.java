package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Auction;

public interface DAOAuction extends DAO<Auction> {

	public Auction getBestAuctionById(int articleId);
}
