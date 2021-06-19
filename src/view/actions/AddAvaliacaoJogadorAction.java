package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import business.CriarAvaliacaoJogador;
import entities.Jogo;

public class AddAvaliacaoJogadorAction implements ActionListener {
	private JTextField txtNota;
	private JTextField txtTitulo;
	private JTextArea txtReview;
	private JTextField txtHoras;
	private JComboBox<String> todasConquistas;
	private JComboBox<String> recomenda;
	private JComboBox<Jogo> idJogo;
	
	public AddAvaliacaoJogadorAction(JTextField txtNota, JTextField txtTitulo, JTextArea txtReview, JTextField txtHoras,
			JComboBox<String> todasConquistas, JComboBox<String> recomenda, JComboBox<Jogo> idJogo) {
		this.txtNota = txtNota;
		this.txtTitulo = txtTitulo;
		this.txtReview = txtReview;
		this.txtHoras = txtHoras;
		this.todasConquistas = todasConquistas;
		this.recomenda = recomenda;
		this.idJogo = idJogo;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String nota = txtNota.getText();
		String titulo = txtTitulo.getText();
		String review = txtReview.getText();
		String horas = txtHoras.getText();
		boolean todasConquistas = Boolean.valueOf(String.valueOf(this.todasConquistas.getSelectedIndex()));
		boolean recomenda = Boolean.valueOf(String.valueOf(this.recomenda.getSelectedIndex()));
		Jogo jogo = (Jogo) this.idJogo.getSelectedItem();
		new CriarAvaliacaoJogador(nota, titulo, review, horas, todasConquistas, recomenda, jogo.getId());
	}

}
