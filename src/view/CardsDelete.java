package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.AvaliacaoDao;
import dao.DaoFactory;
import dao.DesenvolvedoraDao;
import dao.JogoDao;
import entities.Avaliacao;
import entities.Desenvolvedora;
import entities.Jogo;
import entities.enums.Genero;
import view.actions.AddAvaliacaoJEspecializadaAction;
import view.actions.AddAvaliacaoJogadorAction;
import view.actions.AddDesenvolvedoraAction;
import view.actions.AddJogoAction;
import view.actions.RemoveDesenvolvedoraAction;
import view.actions.RemoveJogoAction;

public class CardsDelete {
	public static JPanel DeletarDesenvolvedor() {
		DesenvolvedoraDao devDao = DaoFactory.createDesenvlvedorDao();
		List<Desenvolvedora> devs = devDao.findAll();
		JPanel card = new JPanel(new GridLayout());
		JLabel label = new JLabel("Selecione uma Desenvolvedora Para Deletar");

		JComboBox<Desenvolvedora> desenvolvedoras = new JComboBox<>();

		for (Desenvolvedora desenvolvedora : devs) {
			desenvolvedoras.addItem(desenvolvedora);
		}
		
		desenvolvedoras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				desenvolvedoras.getSelectedItem();
				
			}
		});
		
		JButton btnDel = new JButton("Deletar");
		btnDel.addActionListener(new RemoveDesenvolvedoraAction(desenvolvedoras));

		card.add(label);
		card.add(desenvolvedoras);
		card.add(btnDel);

		return card;
	}

	public static JPanel DeletarJogo() {
		JogoDao jogoDao = DaoFactory.createJogoDao();
		List<Jogo> jogos = jogoDao.findAll();
		JPanel card = new JPanel(new GridLayout());
		JLabel label = new JLabel("Selecione um jogo Para Deletar");

		JComboBox<Jogo> cbJogos = new JComboBox<>();

		for (Jogo j : jogos) {
			cbJogos.addItem(j);
		}
		
		cbJogos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbJogos.getSelectedItem();
				
			}
		});
		
		JButton btnDel = new JButton("Deletar");
		btnDel.addActionListener(new RemoveJogoAction(cbJogos));

		card.add(label);
		card.add(cbJogos);
		card.add(btnDel);

		return card;
	}

	/*public static JPanel DeletarAvaliacao() {
		AvaliacaoDao avDao = DaoFactory.createAvaliacaoDao();
		List<Avaliacao> avaliacoes = avDao.findAllByGameId(1);
		JPanel card = new JPanel(new GridLayout());
		JLabel label = new JLabel("Selecione um jogo Para Deletar");

		JComboBox<Jogo> cbJogos = new JComboBox<>();

		for (Jogo j : jogos) {
			cbJogos.addItem(j);
		}
		
		cbJogos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbJogos.getSelectedItem();
				
			}
		});
		
		JButton btnDel = new JButton("Deletar");
		btnDel.addActionListener(new RemoveJogoAction(cbJogos));

		card.add(label);
		card.add(cbJogos);
		card.add(btnDel);

		return card;
	}*/

}
