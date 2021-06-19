package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import business.CriarDesenvolvedor;

public class AddDesenvolvedoraAction implements ActionListener{
	private JTextField txt;
	
	public AddDesenvolvedoraAction(JTextField txt) {
		this.txt = txt;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String nome = txt.getText();
		new CriarDesenvolvedor(nome);
	}

}
