package dao;

import dao.impl.AvaliacaoDaoJDBC;
import dao.impl.DesenvolvedoraDaoJDBC;
import dao.impl.JogoDaoJDBC;
import db.DB;

public class DaoFactory {
	public static DesenvolvedoraDao createDesenvlvedorDao() {
		return new DesenvolvedoraDaoJDBC(DB.getConection());
	}
	
	public static JogoDao createJogoDao() {
		return new JogoDaoJDBC(DB.getConection());
	}
	
	public static AvaliacaoDao createAvaliacaoDao() {
		return new AvaliacaoDaoJDBC(DB.getConection());
	}
}
