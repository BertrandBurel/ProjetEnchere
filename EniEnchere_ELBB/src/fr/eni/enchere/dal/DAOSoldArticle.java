package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.SoldArticle;

public interface DAOSoldArticle extends DAO<SoldArticle> {

	public List<SoldArticle> selectCurrentAuctions();
}
