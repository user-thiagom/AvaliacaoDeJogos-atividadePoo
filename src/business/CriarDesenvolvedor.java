package business;

import dao.DaoFactory;
import dao.DesenvolvedoraDao;
import entities.Desenvolvedora;

public class CriarDesenvolvedor {
	private String nomeDesenvolvedora;
	
	public CriarDesenvolvedor(String nomeDesenvolvedora) {
		this.nomeDesenvolvedora = nomeDesenvolvedora;
		criarDesenvolvedora();
	}

	private void criarDesenvolvedora() {
		Desenvolvedora dev = new Desenvolvedora(nomeDesenvolvedora, 0.0);
		DesenvolvedoraDao devDao = DaoFactory.createDesenvlvedorDao();
		devDao.insert(dev);
	}
}
