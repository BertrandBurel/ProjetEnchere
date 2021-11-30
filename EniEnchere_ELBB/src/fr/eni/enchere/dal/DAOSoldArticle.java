package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.SoldArticle;
import fr.eni.enchere.exceptions.BusinessException;

public interface DAOSoldArticle extends DAO<SoldArticle> {

	/**
	 * Get the article lists in auction responding to research filters
	 * 
	 * @param category
	 *            category filter, if 0, no filter is applied
	 * @param research
	 *            research String, if null, no filter is applied
	 * @param mode
	 *            2 for buying mode, 1 for selling mode, 0 for all
	 * @param filters
	 *            add 1 for open auction list, 2 for ongoing auction list and 4 for
	 *            closed auction list. The result is between 1 and 7. Any other
	 *            number return the ongoing list by default.
	 * @param userId
	 *            Current user Id
	 * @return Article list. The soldPrice is set to the actual price based on the
	 *         last bid. (initialPrice if no bid)
	 * @throws BusinessException
	 */
	public List<SoldArticle> selectAuctions(int category, String research, int mode, int filters, int userId);
}
