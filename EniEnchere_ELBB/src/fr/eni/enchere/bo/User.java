package fr.eni.enchere.bo;

public class User {

	private int id;
	private String lastName;
	private String firstName;
	private String pseudonym;
	private String email;
	private String phone;
	private String address;
	private String postalCode;
	private String city;
	private String password;
	private int credit;
	private boolean administrator;
	
	/**
	 * default constructor
	 */
	public User() {
	}
	
	/**
	 * constructor with id
	 */
	public User(int id, String lastName, String firstName, String pseudonym, String email, String phone, String address,
			String postalCode, String city, String password, int credit, boolean administrator) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.pseudonym = pseudonym;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.password = password;
		this.credit = credit;
		this.administrator = administrator;
	}

	/**
	 * constructor without id
	 */
	public User(String lastName, String firstName, String pseudonym, String email, String phone, String address,
			String postalCode, String city, String password, int credit, boolean administrator) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.pseudonym = pseudonym;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.password = password;
		this.credit = credit;
		this.administrator = administrator;
	}

	/**
	 * constructor for connection
	 */
	public User(int id, String pseudonym, String email, String password) {
		this.id = id;
		this.pseudonym = pseudonym;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", pseudonym=" + pseudonym
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", postalCode=" + postalCode
				+ ", city=" + city + ", password=" + password + ", credit=" + credit + ", administrator="
				+ administrator + "]";
	}
	
}
