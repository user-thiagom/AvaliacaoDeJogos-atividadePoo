package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import business.CriarAvaliacaoEspecializada;
import business.CriarAvaliacaoJogador;
import entities.Jogo;

public class AddAvaliacaoJEspecializadaAction implements ActionListener {
	private JTextField txtTitulo;
	private JTextArea txtReview;
	private JTextField txtHoras;
	private JTextField txtnotaNarrativa;
	private JTextField txtnotaDirecaoJogo;
	private JTextField txtnotaDirecaoDeArte;
	private JTextField txtnotaMusicaDoJogo;
	private JTextField txtnotaDirecaoDeAudio;
	private JComboBox<String> todasConquistas;
	private JComboBox<Jogo> idJogo;

	public AddAvaliacaoJEspecializadaAction(JTextField txtTitulo, JTextArea txtReview,
			JTextField txtHoras, JTextField txtnotaNarrativa, JTextField txtnotaDirecaoJogo,
			JTextField txtnotaDirecaoDeArte, JTextField txtnotaMusicaDoJogo, JTextField txtnotaDirecaoDeAudio,
			JComboBox<String> todasConquistas, JComboBox<Jogo> idJogo) {
		super();
		this.txtTitulo = txtTitulo;
		this.txtReview = txtReview;
		this.txtHoras = txtHoras;
		this.txtnotaNarrativa = txtnotaNarrativa;
		this.txtnotaDirecaoJogo = txtnotaDirecaoJogo;
		this.txtnotaDirecaoDeArte = txtnotaDirecaoDeArte;
		this.txtnotaMusicaDoJogo = txtnotaMusicaDoJogo;
		this.txtnotaDirecaoDeAudio = txtnotaDirecaoDeAudio;
		this.todasConquistas = todasConquistas;
		this.idJogo = idJogo;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		String titulo = txtTitulo.getText();
		String review = txtReview.getText();
		String horas = txtHoras.getText();
		String notaNarrativa = txtnotaNarrativa.getText();
		String notaDirecaoJogo = txtnotaDirecaoJogo.getText();
		String notaDirecaoDeArte = txtnotaDirecaoDeArte.getText();
		String notaMusicaDoJogo = txtnotaMusicaDoJogo.getText();
		String notaDirecaoDeAudio = txtnotaDirecaoDeAudio.getText();
		boolean todasConquistas = Boolean.valueOf(String.valueOf(this.todasConquistas.getSelectedIndex()));
		Jogo jogo = (Jogo) this.idJogo.getSelectedItem();
		new CriarAvaliacaoEspecializada(titulo, review, horas, todasConquistas, notaNarrativa, notaDirecaoJogo, notaDirecaoDeArte, notaMusicaDoJogo, notaDirecaoDeAudio, jogo.getId());
	}

}
