package entities;

public abstract class Avaliacao {
	//Atributos
	protected Integer id;
	protected Double nota;
	protected Boolean avaliacaoEspecializada;
	
	//Atributos de Associação
	protected Review review;
	protected TempoParaTerminar tempoParaTerminar;
	
	//Construtores com sobrecarga
	public Avaliacao() {
		
	}

	public Avaliacao(Integer id, Review review, TempoParaTerminar tempoParaTerminar) {
		this.id = id;
		this.review = review;
		this.tempoParaTerminar = tempoParaTerminar;
	}
	
	public Avaliacao(Integer id, Double nota, Review review,TempoParaTerminar tempoParaTerminar) {
		this.id = id;
		
		if (nota >=0 && nota <= 10) {
			this.nota = nota;
		} else {
			this.nota = 0.0;
		}
		
		this.review = review;
		this.tempoParaTerminar = tempoParaTerminar;
	}

	//Getters & Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		if (nota >=0 && nota <= 10) {
			this.nota = nota;
		}
		
	}

	public Boolean getAvaliacaoEspecializada() {
		return avaliacaoEspecializada;
	}

	public void setAvaliacaoEspecializada(Boolean avaliacaoEspecializada) {
		this.avaliacaoEspecializada = avaliacaoEspecializada;
	}
	
	//Métodos
	public abstract void calcularNota();

	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("--- Avaliacao ---");
		builder.append("Nota: " + nota);
		builder.append("");
		builder.append(review.getTitulo());
		builder.append(review.getTexto());
		builder.append("Tempo para Terminar o jogo: " + tempoParaTerminar.getHoras());
		return builder.toString();
	}*/
	
	
}
