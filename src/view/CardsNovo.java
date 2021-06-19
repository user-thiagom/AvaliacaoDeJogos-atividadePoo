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

import dao.DaoFactory;
import dao.DesenvolvedoraDao;
import dao.JogoDao;
import entities.Desenvolvedora;
import entities.Jogo;
import entities.enums.Genero;
import view.actions.AddAvaliacaoJEspecializadaAction;
import view.actions.AddAvaliacaoJogadorAction;
import view.actions.AddDesenvolvedoraAction;
import view.actions.AddJogoAction;

public class CardsNovo {
	public static JPanel NovoDesenvolvedor() {
		JPanel card = new JPanel(new GridLayout());
		JLabel labelNome = new JLabel("Nome da Desenvolvedora");
		JTextField txtField = new JTextField();
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.addActionListener(new AddDesenvolvedoraAction(txtField));
		
		card.add(labelNome);
		card.add(txtField);
		card.add(btnAdd);
		
		return card;
	}
	
	public static JPanel NovoJogo() {
		DesenvolvedoraDao devDao = DaoFactory.createDesenvlvedorDao();
		List<Desenvolvedora> devs = devDao.findAll();
		List<Genero>generos = Arrays.asList(Genero.values());
		JPanel card = new JPanel(new GridLayout());
		JLabel labelNome = new JLabel("Nome do Jogo:");
		JTextField txtNome = new JTextField();
		JLabel labelData = new JLabel("Data de Lançamento (dd/MM/yyy):");
		JTextField txtData = new JTextField();
		JComboBox<Desenvolvedora> desenvolvedoras = new JComboBox<>();
		
		for (Desenvolvedora desenvolvedora : devs) {
			desenvolvedoras.addItem(desenvolvedora);
		}
		
		desenvolvedoras.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				desenvolvedoras.getSelectedItem();
				System.out.println(desenvolvedoras.getSelectedItem());
			}
		});
		
		JComboBox<String> genero = new JComboBox<>();
		for (int i = 0; i < generos.size(); i++) {
			genero.addItem(generos.get(i).toString());
		}
		
		genero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				genero.getSelectedItem();
			}
		});
		
		JComboBox<String> plataforma = new JComboBox<>();
		plataforma.addItem("PlayStation 4");
		plataforma.addItem("PlayStation 5");
		plataforma.addItem("Xbox One");
		plataforma.addItem("Xbox Series X");
		
		plataforma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				plataforma.getSelectedIndex();
			}
		});
		
		JButton btnAdd = new JButton("Adicionar Jogo");
		btnAdd.addActionListener(new AddJogoAction(txtNome,txtData,desenvolvedoras,plataforma,genero));
		
		card.add(labelNome);
		card.add(txtNome);
		card.add(labelData);
		card.add(txtData);
		card.add(desenvolvedoras);
		card.add(plataforma);
		card.add(genero);
		card.add(btnAdd);
				
		return card;
	}
	
	public static JPanel NovaAvaliacaoJogador() {
		JogoDao jogoDao = DaoFactory.createJogoDao();
		List<Jogo> jogos = jogoDao.findAll();
		JComboBox<Jogo> cbJogos = new JComboBox<>();
		for (Jogo jogo : jogos) {
			cbJogos.addItem(jogo);
		}
		cbJogos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbJogos.getSelectedItem();
				
			}
		});
		
		JPanel card = new JPanel(new GridLayout());
		JLabel lblNota = new JLabel("Nota: ");
		JTextField txtNota = new JTextField();
		JLabel lblTitulo = new JLabel("Titulo da Review");
		JTextField txtTitulo = new JTextField();
		JLabel lblTexto = new JLabel("Review:");
		JTextArea txtTexto = new JTextArea();
		JLabel lblHoras = new JLabel("Horas Jogadas:");
		JTextField txtHoras = new JTextField();
		JLabel lblConquistas = new JLabel("Todas as Conquista? ");
		
		JComboBox<String> cbTodasConquistas = new JComboBox<>();
		cbTodasConquistas.addItem("Sim");
		cbTodasConquistas.addItem("Não");
		cbTodasConquistas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbTodasConquistas.getSelectedIndex();
				
			}
		});
		
		JLabel lblRecomenda = new JLabel("Recomenda Este Jogo?");
		JComboBox<String> cbRecomenda = new JComboBox<>();
		cbRecomenda.addItem("Sim");
		cbRecomenda.addItem("Não");
		cbRecomenda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbRecomenda.getSelectedIndex();
			}
		});
		
		JButton btnAvaliar = new JButton("Adicionar Avaliação");
		btnAvaliar.addActionListener(new AddAvaliacaoJogadorAction(txtNota, txtTitulo, txtTexto, txtHoras, cbTodasConquistas, cbRecomenda, cbJogos));
		
		card.add(cbJogos);
		card.add(lblNota);
		card.add(txtNota);
		card.add(lblTitulo);
		card.add(txtTitulo);
		card.add(lblTexto);
		card.add(txtTexto);
		card.add(lblHoras);
		card.add(txtHoras);
		card.add(lblConquistas);
		card.add(cbTodasConquistas);
		card.add(lblRecomenda);
		card.add(cbRecomenda);
		card.add(btnAvaliar);
		return card;
	}
	
	public static JPanel NovaAvaliacaoEspecializada() {
		JogoDao jogoDao = DaoFactory.createJogoDao();
		List<Jogo> jogos = jogoDao.findAll();
		JComboBox<Jogo> cbJogos = new JComboBox<>();
		for (Jogo jogo : jogos) {
			cbJogos.addItem(jogo);
		}
		cbJogos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbJogos.getSelectedItem();
				
			}
		});
		
		JPanel card = new JPanel(new GridLayout());
		JLabel lblTitulo = new JLabel("Titulo da Review");
		JTextField txtTitulo = new JTextField();
		JLabel lblTexto = new JLabel("Review:");
		JTextArea txtTexto = new JTextArea();
		JLabel lblHoras = new JLabel("Horas Jogadas:");
		JTextField txtHoras = new JTextField();
		JLabel lblConquistas = new JLabel("Todas as Conquista? ");
		
		JComboBox<String> cbTodasConquistas = new JComboBox<>();
		cbTodasConquistas.addItem("Sim");
		cbTodasConquistas.addItem("Não");
		cbTodasConquistas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbTodasConquistas.getSelectedIndex();
				
			}
		});
		
		JLabel lblnotaNarrativa = new JLabel("Nota Narrativa");
		JTextField txtnotaNarrativa = new JTextField();
		JLabel lblnotaDirecaoJogo = new JLabel("Nota Direção do Jogo");
		JTextField txtnotaDirecaoJogo = new JTextField();
		JLabel lblnotaDirecaoDeArte = new JLabel("Nota Direção de Arte");
		JTextField txtnotaDirecaoDeArte = new JTextField();
		JLabel lblnotaMusicaDoJogo = new JLabel("Nota Música do Jogo");
		JTextField txtnotaMusicaDoJogo = new JTextField();
		JLabel lblnotaDirecaoDeAudio = new JLabel("Nota Direção de Aúdio");
		JTextField txtnotaDirecaoDeAudio = new JTextField();
		
		JButton btnAvaliar = new JButton("Adicionar Avaliação");
		btnAvaliar.addActionListener(new AddAvaliacaoJEspecializadaAction(txtTitulo, txtTexto, txtHoras, txtnotaNarrativa, txtnotaDirecaoJogo, txtnotaDirecaoDeArte, txtnotaMusicaDoJogo, txtnotaDirecaoDeAudio,cbTodasConquistas , cbJogos));
		
		card.add(cbJogos);
		card.add(lblnotaDirecaoDeArte);
		card.add(txtnotaDirecaoDeArte);
		card.add(lblnotaDirecaoDeAudio);
		card.add(txtnotaDirecaoDeAudio);
		card.add(lblnotaDirecaoJogo);
		card.add(txtnotaDirecaoJogo);
		card.add(lblnotaMusicaDoJogo);
		card.add(txtnotaMusicaDoJogo);
		card.add(lblnotaNarrativa);
		card.add(txtnotaNarrativa);
		card.add(lblTitulo);
		card.add(txtTitulo);
		card.add(lblTexto);
		card.add(txtTexto);
		card.add(lblHoras);
		card.add(txtHoras);
		card.add(lblConquistas);
		card.add(cbTodasConquistas);
		card.add(btnAvaliar);
		return card;
	}
}
