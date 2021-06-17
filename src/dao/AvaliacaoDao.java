package dao;

import java.util.List;

import entities.Avaliacao;

public interface AvaliacaoDao {
	void insert (Avaliacao obj, Integer idJogo);
	void deleteById(Integer id);
	Avaliacao findById(Integer id);
	List<Avaliacao> findAllByGameId(Integer id);
}
