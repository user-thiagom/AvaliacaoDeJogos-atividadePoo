package application;

import entities.Avaliacao;
import entities.AvaliacaoEspecializada;
import entities.Review;
import entities.TempoParaTerminar;

public class Program {

	public static void main(String[] args) {
		Review review1 = new Review(1, "Excelente Trabalho", "O jogo está maravilhoso supimpa belissimo");
		TempoParaTerminar t1 = new TempoParaTerminar(2, 12, false);
		Avaliacao av1 = new AvaliacaoEspecializada(1, review1, t1, 6.2, 8.65, 7.4, 9.0, 4.5, 6.3);
		System.out.println(av1);
	}

}
