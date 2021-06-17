package entities;

public class Plataforma {
	//Atributos
	private Integer id;
	private String nome;
	
	//Construtores
	public Plataforma() {
		super();
	}

	public Plataforma(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Plataforma [id=" + id + ", nome=" + nome + "]";
	}
	
}
