package fr.eni.enchere.bo;

public class Category {
	private int id;
	private String name;

	/**
	 * Default constuctor
	 */
	public Category() {
	}

	/**
	 * Constructor with id
	 * 
	 * @param id
	 * @param name
	 */
	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Constructor without id
	 * 
	 * @param name
	 */
	public Category(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Category [id=" + getId() + ", name=" + getName() + "]";
	}

}
