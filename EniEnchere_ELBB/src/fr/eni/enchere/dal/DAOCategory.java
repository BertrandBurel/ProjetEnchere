package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Category;

public interface DAOCategory extends DAO<Category> {

	public Category getCategoryByName(String name);
}
