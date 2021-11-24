package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.SoldArticle;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOSoldArticle;

public class SoldArticleManager {
	private DAOSoldArticle soldArticleDao;

	public SoldArticleManager() {
		soldArticleDao = DAOFactory.getSoldArticleDao();
	}

	public List<SoldArticle> getCurrentAuctions() {
		return soldArticleDao.selectCurrentAuctions();
	}
}
