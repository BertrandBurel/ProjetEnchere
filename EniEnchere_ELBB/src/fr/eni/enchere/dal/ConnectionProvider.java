package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	private static DataSource dataSource;

	static {
		Context context;

		try {
			context = new InitialContext();
			// ConnectionProvider.dataSource = (DataSource)
			// context.lookup("java:comp/env/jdbc/pool_cnx_notes");
			ConnectionProvider.dataSource = (DataSource) context.lookup("context.xml");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot access the database");
		}

	}

	/**
	 * Récupère une connexion du pool de connexion.
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ConnectionProvider.dataSource.getConnection();
	}
}
