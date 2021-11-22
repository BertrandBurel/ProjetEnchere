package fr.eni.enchere.bo;

import java.util.Date;

public class SoldArticle {
	private int id;
	private String name;
	private String description;
	private Date auctionStartDate;
	private Date auctionEndDate;
	private int initialPrice;
	private int soldPrice;
	private Category category;
	private User user;

	public SoldArticle() {
	}

	public SoldArticle(int id, String name, String description, Date auctionStartDate, Date auctionEndDate,
			int initialPrice, int soldPrice, Category category, User user) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.auctionStartDate = auctionStartDate;
		this.auctionEndDate = auctionEndDate;
		this.initialPrice = initialPrice;
		this.soldPrice = soldPrice;
		this.category = category;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getAuctionStartDate() {
		return auctionStartDate;
	}

	public void setAuctionStartDate(Date auctionStartDate) {
		this.auctionStartDate = auctionStartDate;
	}

	public Date getAuctionEndDate() {
		return auctionEndDate;
	}

	public void setAuctionEndDate(Date auctionEndDate) {
		this.auctionEndDate = auctionEndDate;
	}

	public int getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(int initialPrice) {
		this.initialPrice = initialPrice;
	}

	public int getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SoldArticle [id=" + getId() + ", name=" + getName() + ", description=" + getDescription()
				+ ", auctionStartDate=" + getAuctionStartDate() + ", auctionEndDate=" + getAuctionEndDate()
				+ ", initialPrice=" + getInitialPrice() + ", soldPrice=" + getSoldPrice() + ", category="
				+ getCategory() + ", user=" + getUser() + "]";
	}
}
