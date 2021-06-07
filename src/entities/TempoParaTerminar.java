package entities;

public class TempoParaTerminar {
	private Integer id;
	private Integer horas;
	private Boolean todasConquistas;
	
	public TempoParaTerminar(Integer id, Integer horas, Boolean todasConquistas) {
		this.id = id;
		this.horas = horas;
		this.todasConquistas = todasConquistas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Boolean getTodasConquistas() {
		return todasConquistas;
	}

	public void setTodasConquistas(Boolean todasConquistas) {
		this.todasConquistas = todasConquistas;
	}
	
}
