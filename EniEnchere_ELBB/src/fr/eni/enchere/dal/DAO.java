package fr.eni.enchere.dal;

import java.util.List;

public interface DAO<T> {

	/**
	 * Insert the set Object in database
	 * 
	 * @param t
	 *            BO Object T to insert
	 */
	public void insert(T t);

	/**
	 * Select Object by id in database
	 * 
	 * @param index
	 *            id to search
	 * @return BO Object T
	 */
	public T selectById(int index);

	/**
	 * Return the whole database table
	 * 
	 * @return BO Object T
	 */
	public List<T> selectAll();

	/**
	 * Update the set Object in database
	 * 
	 * @param t
	 *            BO Object to update
	 */
	public void update(T t);

	/**
	 * Delete the set Object in database
	 * 
	 * @param index
	 *            id of the Object to delete
	 */
	public void delete(int index);
}
