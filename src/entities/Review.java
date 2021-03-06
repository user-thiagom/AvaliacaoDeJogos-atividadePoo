package entities;

public class Review {
	//Atributos
	private Integer id;
	private String titulo;
	private String texto;
	
	//Construtor
	public Review(Integer id, String titulo, String texto) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
	}
	
	public Review() {
	}

	//Getters & Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
