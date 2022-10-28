package br.com.atividade.jpa.dao;

import java.util.List;

public interface DAO<T> {

	List<T> findAll();
	void insert(T t);
	void update(T t);
	void delete(T t);
	
}
