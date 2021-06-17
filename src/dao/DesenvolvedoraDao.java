package dao;

import java.util.List;

import entities.Desenvolvedora;

public interface DesenvolvedoraDao {
	void insert (Desenvolvedora obj);
	void deleteById(Integer id);
	Desenvolvedora findById(Integer id);
	List<Desenvolvedora> findAll();
}
