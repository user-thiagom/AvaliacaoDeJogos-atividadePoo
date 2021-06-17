package application;

import java.util.List;
import java.util.Scanner;

import dao.DaoFactory;
import dao.DesenvolvedoraDao;
import entities.Desenvolvedora;

public class Program2 {

	public static void main(String[] args) {
		//Testando Desenvolvedora 
		Scanner sc = new Scanner(System.in);
		DesenvolvedoraDao devDao = DaoFactory.createDesenvlvedorDao();
		System.out.println("--- Teste 1: Dev FindByID ---");
		Desenvolvedora dev = devDao.findById(2);
		System.out.println(dev);
		
		System.out.println("--- Teste 2: Dev FindAll ---");
		List<Desenvolvedora> dev2 = devDao.findAll();
		for (Desenvolvedora s : dev2) {
			System.out.println(s);
		}
		
		System.out.println("--- Teste 3: Dev Insert ---");
		Desenvolvedora newDev = new Desenvolvedora(null, "Mojang", 0.0);
		devDao.insert(newDev);
		System.out.println("Inserido! novo id = " + newDev.getId());
		
		System.out.println("--- Teste 4: Jogo Delete ---");
		System.out.println("Digite um código");
		int cod = sc.nextInt();
		devDao.deleteById(cod);
		System.out.println("Concluido");
				
		sc.close();
		//Funcionou aaaaaaaa
	}

}
