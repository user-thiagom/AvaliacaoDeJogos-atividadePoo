package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import entities.enums.ClassificacaoIndicativa;
import entities.enums.Genero;

public class Jogo {
	//Atributos
	private Integer id;
	private String nome;
	private Double notaDosCriticos;
	private Double notaDosJogadores;
	private Date dataDeLancamento;
	
	//Atributos de Associação
	private Genero genero;
	private Plataforma plataforma;
	private List<Avaliacao> avaliacoes;
	private Desenvolvedora desenvolvedora;
	
	//Construtores
	public Jogo() {
		this.avaliacoes = new ArrayList<>();
	}
	
	public Jogo(String nome, Double notaDosCriticos, Double notaDosJogadores, Date dataDeLancamento, Genero genero,
			Plataforma plataforma, Desenvolvedora desenvolvedora) {
		this.nome = nome;
		this.notaDosCriticos = notaDosCriticos;
		this.notaDosJogadores = notaDosJogadores;
		this.dataDeLancamento = dataDeLancamento;
		this.genero = genero;
		this.plataforma = plataforma;
		this.desenvolvedora = desenvolvedora;
		this.avaliacoes = new ArrayList<>();
	}

	public Jogo(Integer id, String nome, Double notaDosCriticos, Double notaDosJogadores, Date dataDeLancamento,Plataforma plataforma, Genero genero, Desenvolvedora desenvolvedora) {
		this.id = id;
		this.nome = nome;
		this.notaDosCriticos = notaDosCriticos;
		this.notaDosJogadores = notaDosJogadores;
		this.dataDeLancamento = dataDeLancamento;
		this.plataforma = plataforma;
		this.genero = genero;
		this.desenvolvedora = desenvolvedora;
		this.avaliacoes = new ArrayList<>();
	}
	
	//Getters & Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNotaDosCriticos() {
		return notaDosCriticos;
	}

	public void setNotaDosCriticos(Double notaDosCriticos) {
		this.notaDosCriticos = notaDosCriticos;
	}

	public Double getNotaDosJogadores() {
		return notaDosJogadores;
	}

	public void setNotaDosJogadores(Double notaDosJogadores) {
		this.notaDosJogadores = notaDosJogadores;
	}

	public Date getDataDeLancamento() {
		return dataDeLancamento;
	}

	public void setDataDeLancamento(Date dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	public Genero getGenero() {
		return genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Desenvolvedora getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	
	//Metodos
	public void addAvaliacao(Avaliacao avaliacao) {
		avaliacoes.add(avaliacao);
		atualizarNotaCriticos();
		atualizarNotajogadores();
	}
	
	public void removerAvaliacaoPorId(int id) {
		avaliacoes.removeIf(x -> x.getId() == id);
	}
	
	public void removerGenero(Genero genero) {
		avaliacoes.remove(genero);
	}
	
	public void atualizarNotaCriticos() {
		List<Avaliacao> notasCriticos = this.avaliacoes.stream().filter(x -> x.getAvaliacaoEspecializada() == true).collect(Collectors.toList());
		double sum = 0;
		for (Avaliacao avaliacao : notasCriticos) {
			sum += avaliacao.getNota();
		}
		double nota = sum / notasCriticos.size();
		this.notaDosCriticos = nota;
	}
	
	public void atualizarNotajogadores() {
		List<Avaliacao> notasJogadores = this.avaliacoes.stream().filter(x -> x.getAvaliacaoEspecializada() == false).collect(Collectors.toList());
		double sum = 0;
		for (Avaliacao avaliacao : notasJogadores) {
			sum += avaliacao.getNota();
		}
		double nota = sum / notasJogadores.size();
		this.notaDosJogadores = nota;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(", " + nome);
		return builder.toString();
	}
	
	
}
