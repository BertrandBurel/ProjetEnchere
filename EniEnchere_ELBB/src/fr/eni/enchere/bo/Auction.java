package fr.eni.enchere.bo;

import java.util.Date;

public class Auction {
	private User user;
	private SoldArticle article;
	private Date auctionDate;
	private int bidPrice;

	/**
	 * Default constructor
	 */
	public Auction() {
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param user
	 * @param article
	 * @param auctionDate
	 * @param bidPrice
	 */
	public Auction(User user, SoldArticle article, Date auctionDate, int bidPrice) {
		this.user = user;
		this.article = article;
		this.auctionDate = auctionDate;
		this.bidPrice = bidPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SoldArticle getArticle() {
		return article;
	}

	public void setArticle(SoldArticle article) {
		this.article = article;
	}

	public Date getAuctionDate() {
		return auctionDate;
	}

	public void setAuctionDate(Date auctionDate) {
		this.auctionDate = auctionDate;
	}

	public int getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}

	@Override
	public String toString() {
		return "Auction [user=" + getUser() + ", article=" + getArticle() + ", auctionDate=" + getAuctionDate()
				+ ", bidPrice=" + getBidPrice() + "]";
	}
}
