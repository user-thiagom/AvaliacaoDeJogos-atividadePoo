package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import business.DeletarJogo;
import entities.Jogo;

public class RemoveJogoAction implements ActionListener {
	private JComboBox<Jogo> jogo;

	public RemoveJogoAction(JComboBox<Jogo> jogo) {
		this.jogo = jogo;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Jogo jogo = (Jogo) this.jogo.getSelectedItem();
		new DeletarJogo(jogo.getId());
	}

}
