package business;

import javax.swing.JTextField;

import dao.AvaliacaoDao;
import dao.DaoFactory;
import entities.Avaliacao;
import entities.AvaliacaoEspecializada;
import entities.AvaliacaoJogador;
import entities.Review;
import entities.TempoParaTerminar;

public class CriarAvaliacaoEspecializada {
	private String titulo;
	private String review;
	private Integer horas;
	private Boolean todasConquistas;
	private Double txtnotaNarrativa;
	private Double txtnotaDirecaoJogo;
	private Double txtnotaDirecaoDeArte;
	private Double txtnotaMusicaDoJogo;
	private Double txtnotaDirecaoDeAudio;
	private Integer idJogo;
	
	public CriarAvaliacaoEspecializada(String titulo, String review, String horas, Boolean todasConquistas,
			String txtnotaNarrativa, String txtnotaDirecaoJogo, String txtnotaDirecaoDeArte, String txtnotaMusicaDoJogo,
			String txtnotaDirecaoDeAudio, Integer idJogo) {
		this.titulo = titulo;
		this.review = review;
		this.horas = Integer.valueOf(horas);
		this.todasConquistas = todasConquistas;
		this.txtnotaNarrativa = Double.valueOf(txtnotaNarrativa);
		this.txtnotaDirecaoJogo = Double.valueOf(txtnotaDirecaoJogo);
		this.txtnotaDirecaoDeArte = Double.valueOf(txtnotaDirecaoDeArte);
		this.txtnotaMusicaDoJogo = Double.valueOf(txtnotaMusicaDoJogo);
		this.txtnotaDirecaoDeAudio = Double.valueOf(txtnotaDirecaoDeAudio);
		this.idJogo = idJogo;
		criarAvaliacao();
	}

	private void criarAvaliacao() {
		AvaliacaoDao avaDao = DaoFactory.createAvaliacaoDao();
		Avaliacao avaliacao = new AvaliacaoEspecializada(true, new Review(null, titulo, review), new TempoParaTerminar(null, horas, todasConquistas), txtnotaNarrativa, txtnotaDirecaoJogo, txtnotaDirecaoDeArte, txtnotaMusicaDoJogo, txtnotaDirecaoDeAudio);
		avaDao.insert(avaliacao, idJogo);
	}
}
