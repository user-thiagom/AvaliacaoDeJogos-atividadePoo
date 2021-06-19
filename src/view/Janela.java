package view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Janela extends JFrame{
	public Janela() {
		setTitle("Minha Aplicação");
		setSize(600,300);
		setLocation(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Menus
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic('A');
		
		JMenu menuEditar = new JMenu("Editar");
		menuEditar.setMnemonic('E');
		
		//Menu Itens
		JMenuItem menuItemNovo = new JMenuItem("Novo");
		menuItemNovo.setMnemonic('N');
		
		JMenuItem menuItemSair = new JMenuItem(new SairAction());
		menuItemSair.setText("Sair");
		menuItemSair.setMnemonic('S');
		
		JMenuItem menuItemCopiar = new JMenuItem("Copiar");
		menuItemCopiar.setMnemonic('C');
		
		//Adicionanado menu itens em menus
		menuArquivo.add(menuItemNovo);
		menuArquivo.add(menuItemSair);
		menuEditar.add(menuItemCopiar);
		
		menuBar.add(menuArquivo);
		menuBar.add(menuEditar);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Janela();
		
	}

}
