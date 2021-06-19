package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Program extends JFrame {
	JPanel cards;
	
	public Program() {
		setTitle("Avaliação de Jogo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(600,300);
		setSize(200, 300);
		setLocation(400,400);
		
		//Barra de Menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Menu
		JMenu menuNovo = new JMenu("Novo");
		menuNovo.setMnemonic('N');
		
		JMenu menuDeletar = new JMenu("Deletar");
		menuDeletar.setMnemonic('D');
		
		//Menu Item
		JMenuItem miNovoDesenvolvedor = new JMenuItem();
		miNovoDesenvolvedor.setText("Desenvolvedor");
		miNovoDesenvolvedor.setMnemonic('D');
		miNovoDesenvolvedor.setActionCommand("1");
		miNovoDesenvolvedor.addActionListener(new ChangeCardlayoutListener());
		
		JMenuItem miNovoJogo = new JMenuItem();
		miNovoJogo.setText("Jogo");
		miNovoJogo.setMnemonic('J');
		miNovoJogo.setActionCommand("2");
		miNovoJogo.addActionListener(new ChangeCardlayoutListener());
		
		JMenuItem miNovoAvaliacaoJogador = new JMenuItem();
		miNovoAvaliacaoJogador.setText("Avaliação Jogador");
		miNovoAvaliacaoJogador.setMnemonic('A');
		miNovoAvaliacaoJogador.setActionCommand("3");
		miNovoAvaliacaoJogador.addActionListener(new ChangeCardlayoutListener());
		
		JMenuItem miNovoAvaliacaoEspecializada = new JMenuItem();
		miNovoAvaliacaoEspecializada.setText("Avaliação Especializada");
		miNovoAvaliacaoEspecializada.setMnemonic('E');
		miNovoAvaliacaoEspecializada.setActionCommand("7");
		miNovoAvaliacaoEspecializada.addActionListener(new ChangeCardlayoutListener());
		
		JMenuItem miDeletarDesenvolvedor = new JMenuItem();
		miDeletarDesenvolvedor.setText("Desenvolvedor");
		miDeletarDesenvolvedor.setMnemonic('D');
		miDeletarDesenvolvedor.setActionCommand("4");
		miDeletarDesenvolvedor.addActionListener(new ChangeCardlayoutListener());
		
		JMenuItem miDeletarJogo = new JMenuItem();
		miDeletarJogo.setText("Jogo");
		miDeletarJogo.setMnemonic('J');
		miDeletarJogo.setActionCommand("5");
		miDeletarJogo.addActionListener(new ChangeCardlayoutListener());
		
		JMenuItem miDeletarAvaliacao = new JMenuItem();
		miDeletarAvaliacao.setText("Avaliação");
		miDeletarAvaliacao.setMnemonic('A');
		miDeletarAvaliacao.setActionCommand("6");
		
		//Configurando o menu
		menuNovo.add(miNovoDesenvolvedor);
		menuNovo.add(miNovoJogo);
		menuNovo.add(miNovoAvaliacaoJogador);
		menuNovo.add(miNovoAvaliacaoEspecializada);
		menuDeletar.add(miDeletarAvaliacao);
		menuDeletar.add(miDeletarDesenvolvedor);
		menuDeletar.add(miDeletarJogo);
		menuBar.add(menuNovo);
		menuBar.add(menuDeletar);
		
		JPanel cardAddDesenvolvedor = CardsNovo.NovoDesenvolvedor();
		JPanel cardAddJogo = CardsNovo.NovoJogo();
		JPanel cardAddAvaliacaoJogador = CardsNovo.NovaAvaliacaoJogador();
		JPanel cardAddAvaliacaoEspecializada = CardsNovo.NovaAvaliacaoEspecializada();
		JPanel cardDeleteDesenvolvedor = CardsDelete.DeletarDesenvolvedor();
		JPanel cardDeleteJogo = CardsDelete.DeletarJogo();
		JPanel cardBranco = new JPanel(new GridLayout());
		cards = new JPanel(new CardLayout());
		cards.add(cardBranco, "0");
		cards.add(cardAddDesenvolvedor, "1");
		cards.add(cardAddJogo, "2");
		cards.add(cardAddAvaliacaoJogador, "3");
		cards.add(cardAddAvaliacaoEspecializada, "7");
		cards.add(cardDeleteDesenvolvedor, "4");
		cards.add(cardDeleteJogo, "5");
        //cards.add(card2, TEXTPANEL);
		
		getContentPane().add(cards, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
	class ChangeCardlayoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, (String) evt.getActionCommand());
        }

    }
	
	public static void main(String[] args) {
		new Program();
	}

}
