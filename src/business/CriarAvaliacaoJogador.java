package business;

import dao.AvaliacaoDao;
import dao.DaoFactory;
import entities.Avaliacao;
import entities.AvaliacaoJogador;
import entities.Review;
import entities.TempoParaTerminar;

public class CriarAvaliacaoJogador {
	private String nota;
	private String titulo;
	private String review;
	private Integer horas;
	private Boolean todasConquistas;
	private Boolean recomenda;
	private Integer idJogo;
	
	public CriarAvaliacaoJogador(String nota, String titulo, String review, String horas, Boolean todasConquistas,
			Boolean recomenda, Integer idJogo) {
		this.nota = nota;
		this.titulo = titulo;
		this.review = review;
		this.horas = Integer.valueOf(horas);
		this.todasConquistas = todasConquistas;
		this.recomenda = recomenda;
		this.idJogo = idJogo;
		criarAvaliacao();
	}
	
	private void criarAvaliacao() {
		AvaliacaoDao avaDao = DaoFactory.createAvaliacaoDao();
		Avaliacao avaliacao = new AvaliacaoJogador(Double.valueOf(this.nota), false, new Review(null, titulo, review), new TempoParaTerminar(null, this.horas, this.todasConquistas), this.recomenda);
		avaDao.insert(avaliacao, idJogo);
	}
}
