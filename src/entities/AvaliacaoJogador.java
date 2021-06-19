package entities;

public class AvaliacaoJogador extends Avaliacao {
	//Atributos
	private Boolean recomenda;
	
	//Construtores
	public AvaliacaoJogador() {
		super();
	}
	
	public AvaliacaoJogador(Double nota, Boolean avaliacaoEspecializada, Review review,
			TempoParaTerminar tempoParaTerminar, Boolean recomenda) {
		super(nota, avaliacaoEspecializada, review, tempoParaTerminar);
		this.recomenda = recomenda;
	}

	public AvaliacaoJogador(Integer id, Double nota, Review review,TempoParaTerminar tempoParaTerminar, Boolean recomenda) {
		super(id, nota, review, tempoParaTerminar);
		this.recomenda = recomenda;
		this.avaliacaoEspecializada = false;
	}
	
	public Boolean getRecomenda() {
		return recomenda;
	}

	public void setRecomenda(Boolean recomenda) {
		this.recomenda = recomenda;
	}

	//Métodos
	@Override
	public void calcularNota() {}

	@Override
	public String toString() {
		String recomenda;
		if (this.recomenda) {
			recomenda = "Sim";
		} else {
			recomenda = "Não";
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append("--- Avaliacao ---");
		builder.append("Nota: " + String.format("%.2f",nota)).append("\n");
		builder.append("").append("\n");
		builder.append(review.getTitulo()).append("\n");
		builder.append(review.getTexto()).append("\n");
		builder.append("Tempo para Terminar o jogo: " + tempoParaTerminar.getHoras()).append("\n");
		builder.append("Recomenda o jogo: " + recomenda).append("\n");
		builder.append("Avaliação de Jogador").append("\n");
		return builder.toString();
	}

	

	
}
