package fr.eni.enchere.bo;

public class Withdrawal {
	private SoldArticle article;
	private String street;
	private String postalCode;
	private String town;

	public Withdrawal() {
	}

	public Withdrawal(SoldArticle article, String street, String postalCode, String town) {
		this.article = article;
		this.street = street;
		this.postalCode = postalCode;
		this.town = town;
	}

	public SoldArticle getArticle() {
		return article;
	}

	public void setArticle(SoldArticle article) {
		this.article = article;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "Withdrawal [article=" + getArticle() + ", street=" + getStreet() + ", postalCode=" + getPostalCode()
				+ ", town=" + getTown() + "]";
	}
}
