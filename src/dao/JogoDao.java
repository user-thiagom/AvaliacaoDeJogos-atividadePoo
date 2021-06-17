package dao;

import java.util.List;

import entities.Jogo;

public interface JogoDao {
	void insert (Jogo obj);
	void deleteById(Integer id);
	Jogo findById(Integer id);
	List<Jogo> findAll();
}
