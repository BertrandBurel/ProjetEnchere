package fr.eni.enchere.dal;

import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

public interface DAOUser extends DAO<User> {

	User selectByPseudo(String pseudo) throws BusinessException;
	User selectByEmail(String email) throws BusinessException;
	Boolean validateUnicityPseusoEmail(String pseudo, String email) throws BusinessException;
	
}
