package business;

import dao.DaoFactory;
import dao.JogoDao;

public class DeletarJogo {
	private Integer id;

	public DeletarJogo(Integer id) {
		this.id = id;
		deletarJogo();
	}

	private void deletarJogo() {
		JogoDao jogoDao = DaoFactory.createJogoDao();
		jogoDao.deleteById(id);
	}
}
