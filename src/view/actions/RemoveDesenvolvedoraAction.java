package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import business.DeletarDesenvolvedora;
import entities.Desenvolvedora;

public class RemoveDesenvolvedoraAction implements ActionListener {
	private JComboBox<Desenvolvedora> dev;

	public RemoveDesenvolvedoraAction(JComboBox<Desenvolvedora> dev) {
		this.dev = dev;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Desenvolvedora dev = (Desenvolvedora) this.dev.getSelectedItem();
		new DeletarDesenvolvedora(dev.getId());
	}

}
