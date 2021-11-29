package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.SoldArticle;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOSoldArticle;
import fr.eni.enchere.exceptions.BusinessException;

public class SoldArticleManager {
	private DAOSoldArticle soldArticleDao;

	public SoldArticleManager() {
		soldArticleDao = DAOFactory.getSoldArticleDao();
	}

	public List<SoldArticle> getCurrentAuctions() throws BusinessException {
		return soldArticleDao.selectCurrentAuctions();
	}

	public void insertSoldArticle(SoldArticle soldArticle) throws BusinessException {
		soldArticleDao.insert(soldArticle);
	}
}
