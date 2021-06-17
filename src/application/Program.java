package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.DaoFactory;
import dao.JogoDao;
import entities.Desenvolvedora;
import entities.Jogo;
import entities.Plataforma;
import entities.enums.Genero;

public class Program {

	public static void main(String[] args) {
		//Testando JogoDao
		Scanner sc = new Scanner(System.in);
		JogoDao jogoDao = DaoFactory.createJogoDao();
		System.out.println("--- Teste 1: Jogo FindByID ---");
		Jogo jogo = jogoDao.findById(2);
		System.out.println(jogo);
		
		System.out.println("--- Teste 2: Jogo FindAll ---");
		List<Jogo> jogo2 = jogoDao.findAll();
		for (Jogo s : jogo2) {
			System.out.println(s);
		}
		
		System.out.println("--- Teste 3: Jogo Insert ---");
		Jogo newJogo = new Jogo(null, "Assassin's Creed 2", 0.0, 0.0, new Date(), new Plataforma(2, "hm"), Genero.ACAO, new Desenvolvedora(4, "Sega", 0.0));
		jogoDao.insert(newJogo);
		System.out.println("Inserido! novo id = " + newJogo.getId());
		
		System.out.println("--- Teste 4: Jogo Delete ---");
		System.out.println("Digite um código");
		int cod = sc.nextInt();
		jogoDao.deleteById(cod);
		System.out.println("Concluido");
				
		sc.close();
		
		//Funcionou aeeeeeee
	}

}
