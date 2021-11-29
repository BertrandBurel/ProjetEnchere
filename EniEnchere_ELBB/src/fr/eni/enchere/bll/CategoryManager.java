package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Category;
import fr.eni.enchere.dal.DAOCategory;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.exceptions.BusinessException;

public class CategoryManager {
	private DAOCategory categoryDao;

	public CategoryManager() {
		this.categoryDao = DAOFactory.getCategoryDao();
	}

	public List<Category> getCategories() throws BusinessException {
		return categoryDao.selectAll();
	}

	public Category getCategoryByName(String name) {
		return categoryDao.getCategoryByName(name);
	}
}
