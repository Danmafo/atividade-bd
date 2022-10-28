package br.com.atividade.jpa.interfaces;

import java.util.List;

public interface DAO<T> {

	List<T> findAll();
	void insert(T t);
	void update(T t);
	void delete(T t);
	
}
