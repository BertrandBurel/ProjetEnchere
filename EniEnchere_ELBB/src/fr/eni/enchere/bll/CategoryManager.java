package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Category;
import fr.eni.enchere.dal.DAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.exceptions.BusinessException;

public class CategoryManager {
	private DAO<Category> categoryDao;

	public CategoryManager() {
		this.categoryDao = DAOFactory.getCategoryDao();
	}

	public List<Category> getCategories() throws BusinessException {
		return categoryDao.selectAll();
	}
}
