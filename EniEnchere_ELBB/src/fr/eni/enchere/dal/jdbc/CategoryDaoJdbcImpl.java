package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Category;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DAOCategory;

public class CategoryDaoJdbcImpl implements DAOCategory {

	private final String INSERT_CATEGORY = "INSERT INTO CATEGORIES (libelle) " + "VALUES (?)";
	private final String SELECT_CATEGORY_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie=?";
	private final String SELECT_CATEGORIES = "SELECT * FROM CATEGORIES";
	private final String UPDATE_CATEGORY = "UPDATE CATEGORIES SET libelle=? " + "WHERE no_categorie=?";
	private final String DELETE_CATEGORY = "DELETE CATEGORIES WHERE no_categorie=?";
	private final String SELECT_CATEGORY_BY_NAME = "SELECT * FROM CATEGORIES WHERE libelle=?";
	private final String SELECT_CATEGORY_BY_ARTICLE = "SELECT c.no_categorie, c.libelle FROM CATEGORIES c INNER JOIN ARTICLES_VENDUS a ON a.no_categorie = c.no_categorie WHERE a.no_article = ?";

	@Override
	public void insert(Category category) {
		String request = new String(INSERT_CATEGORY);
		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);

			statement.setString(1, category.getName());

			statement.executeUpdate();

			ResultSet resultId = statement.getGeneratedKeys();
			if (resultId.next()) {
				int id = resultId.getInt("GENERATED_KEYS");

				category.setId(id);
			}

			statement.close();

			connection.close();
		} catch (SQLException e) {
			System.err.println("Insertion en BDD échouée");
			e.printStackTrace();
		}
	}

	@Override
	public Category selectById(int index) {
		String request = new String(SELECT_CATEGORY_BY_ID);

		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request);
			statement.setInt(1, index);

			ResultSet resultSet = statement.executeQuery();

			Category category = null;
			if (resultSet.next()) {
				category = categoryFormatter(resultSet);
			}

			statement.close();
			connection.close();

			return category;
		} catch (SQLException e) {
			System.err.println("Select par Ids impossible");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> selectAll() {
		String request = new String(SELECT_CATEGORIES);

		try {
			Connection connection = ConnectionProvider.getConnection();

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(request);

			List<Category> categories = new ArrayList<>();
			Category category;
			while (resultSet.next()) {
				category = categoryFormatter(resultSet);
				categories.add(category);
			}

			statement.close();
			connection.close();

			return categories;
		} catch (SQLException e) {
			System.err.println("Select global impossible");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Category category) {
		String request = new String(UPDATE_CATEGORY);
		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request);

			statement.setString(1, category.getName());
			statement.setInt(2, category.getId());

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println("Modification en BDD échouée");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int index) {
		String request = new String(DELETE_CATEGORY);
		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request);

			statement.setInt(1, index);

			statement.executeUpdate();

			statement.close();
			connection.isClosed();
		} catch (SQLException e) {
			System.err.println("Suppression en BDD échouée");
			e.printStackTrace();
		}
	}

	@Override
	public Category getCategoryByName(String name) {
		String request = new String(SELECT_CATEGORY_BY_NAME);

		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request);
			statement.setString(1, name);

			ResultSet resultSet = statement.executeQuery();

			Category category = null;
			if (resultSet.next()) {
				category = categoryFormatter(resultSet);
			}

			statement.close();
			connection.close();

			return category;
		} catch (SQLException e) {
			System.err.println("Select par name impossible");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category getCategoryByArticle(int idArticle) {
		String request = new String(SELECT_CATEGORY_BY_ARTICLE);

		try {
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(request);
			statement.setInt(1, idArticle);

			ResultSet resultSet = statement.executeQuery();

			Category category = null;
			if (resultSet.next()) {
				category = categoryFormatter(resultSet);
			}

			statement.close();
			connection.close();

			return category;
		} catch (SQLException e) {
			System.err.println("Select par idArticle impossible");
			e.printStackTrace();
		}
		return null;
	}

	private Category categoryFormatter(ResultSet resultSet) throws SQLException {
		Category category = new Category();
		category.setId(resultSet.getInt("no_categorie"));
		category.setName(resultSet.getString("libelle"));

		return category;
	}
}
