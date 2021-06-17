package application;

import java.util.List;
import java.util.Scanner;

import dao.AvaliacaoDao;
import dao.DaoFactory;
import entities.Avaliacao;
import entities.AvaliacaoEspecializada;
import entities.AvaliacaoJogador;
import entities.Review;
import entities.TempoParaTerminar;

public class Program3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AvaliacaoDao avDao = DaoFactory.createAvaliacaoDao();
		System.out.println("--- Teste 1: Avalia��o FindByID ---");
		Avaliacao av = avDao.findById(1);
		System.out.println(av);
		
		System.out.println("--- Teste 2: Avalia��o FindByGameID ---");
		List<Avaliacao> av2 = avDao.findAllByGameId(3);
		for (Avaliacao s : av2) {
			System.out.println(s);
		}
		
		System.out.println("--- Teste 3: Avalia��o Insert ---");
		Review review = new Review(null, "GoTY!", "Jogo Bom demais, valeu cada minuto investido, �timo gr�fico, anima��es espetaculares, multiplayer divertido");
		TempoParaTerminar tempoParaTerminar = new TempoParaTerminar(null, 3, false);
		Avaliacao newAv = new AvaliacaoEspecializada(null, review, tempoParaTerminar, 3.5, 2.0, 5.1, 1.3, 4.33);
		avDao.insert(newAv, 3);
		System.out.println("Inserido! novo id = " + newAv.getId());
		
		System.out.println("--- Teste 4: Jogo Delete ---");
		System.out.println("Digite um c�digo");
		int cod = sc.nextInt();
		avDao.deleteById(cod);
		System.out.println("Concluido");
				
		sc.close();
		//Funcionou!!!!
	}

}
