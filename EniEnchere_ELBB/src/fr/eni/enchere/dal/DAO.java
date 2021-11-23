package fr.eni.enchere.dal;

import java.util.List;

public interface DAO<T> {

	public void insert(T t);

	public T selectById(int index);

	public List<T> selectAll();

	public void update(T t);

	public void delete(int index);
}
