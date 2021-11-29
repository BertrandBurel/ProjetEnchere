package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.dal.DAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.exceptions.BusinessException;

public class WithdrawalManager {
	private DAO<Withdrawal> withdrawalDao;

	public WithdrawalManager() {
		this.withdrawalDao = DAOFactory.getWithdrawalDao();
	}

	public List<Withdrawal> getWithdrawals() throws BusinessException {
		return withdrawalDao.selectAll();
	}

	public void insertWithdrawal(Withdrawal withdrawal) throws BusinessException {
		withdrawalDao.insert(withdrawal);
	}
}
