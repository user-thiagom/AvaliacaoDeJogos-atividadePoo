package business;

import dao.DaoFactory;
import dao.DesenvolvedoraDao;

public class DeletarDesenvolvedora {
private Integer id;
	
	public DeletarDesenvolvedora(Integer id) {
		this.id = id;
		deletarDesenvolvedora();
	}

	private void deletarDesenvolvedora() {
		DesenvolvedoraDao devDao = DaoFactory.createDesenvlvedorDao();
		devDao.deleteById(id);
	}
}
