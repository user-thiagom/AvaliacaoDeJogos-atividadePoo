package entities;

public class AvaliacaoEspecializada extends Avaliacao {
	//Atributos 
	private Double notaNarrativa;
	private Double notaDirecaoDoJogo;
	private Double notaDirecaoDeArte;
	private Double notaMusicaDoJogo;
	private Double notaDirecaoDeAudio;
	
	//Construtores
	public AvaliacaoEspecializada() {
		super();
	}
	
	public AvaliacaoEspecializada(Integer id, Review review,TempoParaTerminar tempoParaTerminar, Double notaNarrativa, Double notaDirecaoDoJogo,Double notaDirecaoDeArte, Double notaMusicaDoJogo, Double notaDirecaoDeAudio) {
		super(id, review, tempoParaTerminar);
		this.notaNarrativa = notaNarrativa;
		this.notaDirecaoDoJogo = notaDirecaoDoJogo;
		this.notaDirecaoDeArte = notaDirecaoDeArte;
		this.notaMusicaDoJogo = notaMusicaDoJogo;
		this.notaDirecaoDeAudio = notaDirecaoDeAudio;
		this.avaliacaoEspecializada = true;
		calcularNota();
	}
	
	//Getters & Setters
	public Double getNotaNarrativa() {
		return notaNarrativa;
	}

	public void setNotaNarrativa(Double notaNarrativa) {
		this.notaNarrativa = notaNarrativa;
		//calcularNota();
	}

	public Double getNotaDirecaoDoJogo() {
		return notaDirecaoDoJogo;
	}

	public void setNotaDirecaoDoJogo(Double notaDirecaoDoJogo) {
		this.notaDirecaoDoJogo = notaDirecaoDoJogo;
		//calcularNota();
	}

	public Double getNotaDirecaoDeArte() {
		return notaDirecaoDeArte;
	}

	public void setNotaDirecaoDeArte(Double notaDirecaoDeArte) {
		this.notaDirecaoDeArte = notaDirecaoDeArte;
		//calcularNota();
	}

	public Double getNotaMusicaDoJogo() {
		return notaMusicaDoJogo;
	}

	public void setNotaMusicaDoJogo(Double notaMusicaDoJogo) {
		this.notaMusicaDoJogo = notaMusicaDoJogo;
		//calcularNota();
	}

	public Double getNotaDirecaoDeAudio() {
		return notaDirecaoDeAudio;
	}

	public void setNotaDirecaoDeAudio(Double notaDirecaoDeAudio) {
		this.notaDirecaoDeAudio = notaDirecaoDeAudio;
		//calcularNota();
	}

	//Metodos
	@Override
	public void calcularNota() {
		double mediaNotas = (notaNarrativa + notaDirecaoDoJogo + notaDirecaoDeArte + notaMusicaDoJogo + notaDirecaoDeAudio) / 5;
		this.nota = mediaNotas;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("--- Avaliacao ---").append("\n");
		builder.append("Nota: " + String.format("%.2f",nota)).append("\n");
		builder.append("Critérios Para a Nota: ").append("\n");
		builder.append("Narrativa("+String.format("%.2f",notaNarrativa)+")").append("\n");
		builder.append("Direção do Jogo("+String.format("%.2f",notaDirecaoDoJogo)+")").append("\n");
		builder.append("Direção de Arte("+String.format("%.2f",notaDirecaoDeArte)+")").append("\n");
		builder.append("Direção de Audio("+String.format("%.2f",notaDirecaoDeAudio)+")").append("\n");
		builder.append("Musica do Jogo("+String.format("%.2f",notaMusicaDoJogo)+")").append("\n");
		builder.append("").append("\n");
		builder.append(review.getTitulo()).append("\n");
		builder.append(review.getTexto()).append("\n");
		builder.append("Tempo para Terminar o jogo: " + tempoParaTerminar.getHoras()).append("\n");
		builder.append("Avaliação Especializada").append("\n");
		return builder.toString();
	}
}
