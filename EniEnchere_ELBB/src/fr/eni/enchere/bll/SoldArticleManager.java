package fr.eni.enchere.bll;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import fr.eni.enchere.bo.SoldArticle;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.DAOSoldArticle;
import fr.eni.enchere.exceptions.BusinessException;
import fr.eni.enchere.utils.Utils;

public class SoldArticleManager {
	private DAOSoldArticle soldArticleDao;

	public SoldArticleManager() {
		soldArticleDao = DAOFactory.getSoldArticleDao();
	}

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
	 * @return Article list
	 * @throws BusinessException
	 */
	public List<SoldArticle> getAuctions(int category, String research, int mode, int filters, int userId)
			throws BusinessException {
		if (research == null || research.equals("")) {
			research = null;
			return soldArticleDao.selectAuctions(category, research, mode, filters, userId);
		}

		if (Pattern.matches(Utils.REGEX_TEXT, research)) {
			return soldArticleDao.selectAuctions(category, research, mode, filters, userId);
		} else {
			throw new BusinessException();
		}
	}

	public void insertSoldArticle(SoldArticle soldArticle) throws BusinessException {
		boolean valid = true;
		if (Pattern.matches(Utils.REGEX_TEXT, soldArticle.getName())) {
			if (Pattern.matches(Utils.REGEX_TEXT, soldArticle.getDescription())) {
				soldArticleDao.insert(soldArticle);
			} else {
				valid = false;
			}
		} else {
			valid = false;
		}

		if (!valid) {
			throw new BusinessException();
		}
	}

	public SoldArticle getArticleById(int id) throws BusinessException {
		return soldArticleDao.selectById(id);
	}

	public BusinessException validateNewAccount(SoldArticle soldArticle) {
		BusinessException businessException = new BusinessException();

		if (soldArticle.getName().length() == 0) {
			businessException.addError(ErrorCodesBLL.ARTICLE_NAME_NULL_ERROR);
		}
		if (soldArticle.getName().length() > 30) {
			businessException.addError(ErrorCodesBLL.ARTICLE_NAME_LENGHT_ERROR);
		}
		if (soldArticle.getDescription().length() == 0) {
			businessException.addError(ErrorCodesBLL.ARTICLE_DESCRIPTION_NULL_ERROR);
		}
		if (soldArticle.getDescription().length() > 300) {
			businessException.addError(ErrorCodesBLL.ARTICLE_DESCRIPTION_LENGHT_ERROR);
		}
		if (soldArticle.getCategory() == null) {
			businessException.addError(ErrorCodesBLL.NO_CATEGORY_ERROR);
		}
		if (soldArticle.getInitialPrice() <= 0) {
			businessException.addError(ErrorCodesBLL.NEGATIVE_PRICE_ERROR);
		}
		if (soldArticle.getAuctionStartDate() == null) {
			businessException.addError(ErrorCodesBLL.STARTING_DATE_NULL_ERROR);
		} else {
			if (soldArticle.getAuctionStartDate().atStartOfDay().isBefore(LocalDate.now().atStartOfDay())) {
				businessException.addError(ErrorCodesBLL.PAST_STARTING_DATE_ERROR);
			}
		}
		if (soldArticle.getAuctionEndDate() == null) {
			businessException.addError(ErrorCodesBLL.ENDING_DATE_NULL_ERROR);
		} else {
			if (soldArticle.getAuctionStartDate().isAfter(soldArticle.getAuctionEndDate())) {
				businessException.addError(ErrorCodesBLL.ENDING_DATE_BEFORE_START_ERROR);
			}
		}
		return businessException;
	}
}
