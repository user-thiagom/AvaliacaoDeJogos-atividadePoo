package entities;

import java.util.ArrayList;
import java.util.List;

public class Desenvolvedora {
	//Atributos
	private Integer id;
	private String nome;
	private Double nota;
	
	//Atributos de Associaçõ
	private List<Jogo> jogos;

	//Construtores
	public Desenvolvedora() {
		jogos = new ArrayList<>();
	}
	
	public Desenvolvedora(String nome, Double nota) {
		this.nome = nome;
		this.nota = nota;
		jogos = new ArrayList<>();
	}

	public Desenvolvedora(Integer id, String nome, Double nota) {
		this.id = id;
		this.nome = nome;
		this.nota = nota;
		jogos = new ArrayList<>();
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

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(", " + nome);
		return builder.toString();
	}
	
}
