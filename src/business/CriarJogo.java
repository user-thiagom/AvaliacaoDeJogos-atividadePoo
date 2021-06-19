package business;

import java.util.Date;

import dao.DaoFactory;
import dao.JogoDao;
import entities.Desenvolvedora;
import entities.Jogo;
import entities.Plataforma;
import entities.enums.Genero;

public class CriarJogo {
	private String nomeJogo;
	private Date dataLanamento;
	private Integer idDev;
	private Integer idPlat;
	private Genero genero;
	
	
	public CriarJogo(String nomeJogo, Date dataLanamento, Integer idDev, Integer idPlat, String genero) {
		super();
		this.nomeJogo = nomeJogo;
		this.dataLanamento = dataLanamento;
		this.idDev = idDev;
		this.idPlat = idPlat;
		this.genero = Genero.valueOf(genero);
		CriarESalvarJogo();
	}


	private void CriarESalvarJogo() {
		JogoDao jogoDao = DaoFactory.createJogoDao();
		Jogo jogo = new Jogo(nomeJogo, 0.0, 0.0, dataLanamento, genero, new Plataforma(idPlat, null), new Desenvolvedora(idDev, null, null));
		System.out.println(jogo);
		jogoDao.insert(jogo);
	}
}
