package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ButtonAction implements ActionListener {
	private JTextField t;
	
	public ButtonAction(JTextField t) {
		this.t = t;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		String nome = t.getText();
		JOptionPane.showMessageDialog(null, "Foi digitado " + nome);
	}

}
