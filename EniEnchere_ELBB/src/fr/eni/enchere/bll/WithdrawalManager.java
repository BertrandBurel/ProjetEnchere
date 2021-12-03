package fr.eni.enchere.bll;

import java.util.List;
import java.util.regex.Pattern;

import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.dal.DAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.exceptions.BusinessException;
import fr.eni.enchere.utils.Utils;

public class WithdrawalManager {
	private DAO<Withdrawal> withdrawalDao;

	public WithdrawalManager() {
		this.withdrawalDao = DAOFactory.getWithdrawalDao();
	}

	public List<Withdrawal> getWithdrawals() throws BusinessException {
		return withdrawalDao.selectAll();
	}

	public void insertWithdrawal(Withdrawal withdrawal) throws BusinessException {
		boolean valid = true;
		if (Pattern.matches(Utils.REGEX_ADDRESS, withdrawal.getStreet())) {
			if (Pattern.matches(Utils.REGEX_TEXT, withdrawal.getTown())) {
				withdrawalDao.insert(withdrawal);
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

	public Withdrawal getWithdrawalById(int id) throws BusinessException {
		return withdrawalDao.selectById(id);
	}

	public BusinessException validateNewAccount(Withdrawal withdrawal) {
		BusinessException businessException = new BusinessException();

		if (withdrawal.getStreet().length() > 30) {
			businessException.addError(ErrorCodesBLL.ADDRESS_LENGTH_ERROR);
		}
		if (!Pattern.matches(Utils.REGEX_ADDRESS, withdrawal.getStreet())) {
			businessException.addError(ErrorCodesBLL.ADDRESS_REGEX_ERROR);
		}
		if (withdrawal.getPostalCode().length() > 5) {
			businessException.addError(ErrorCodesBLL.POSTALCODE_LENGTH_ERROR);
		}
		if (!Pattern.matches(Utils.REGEX_POSTAL_CODE, withdrawal.getPostalCode())) {
			businessException.addError(ErrorCodesBLL.POSTALCODE_REGEX_ERROR);
		}
		if (withdrawal.getTown().length() > 30) {
			businessException.addError(ErrorCodesBLL.CITY_LENGTH_ERROR);
		}
		if (!Pattern.matches(Utils.REGEX_TEXT, withdrawal.getTown())) {
			businessException.addError(ErrorCodesBLL.CITY_REGEX_ERROR);
		}
		return businessException;
	}
}
