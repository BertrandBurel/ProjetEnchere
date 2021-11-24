package fr.eni.enchere.dal;

import fr.eni.enchere.bo.User;

public interface DAOUser extends DAO<User> {

	User selectByPseudo(String pseudo);
	User selectByEmail(String email);
	
}
