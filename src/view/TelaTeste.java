package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTeste {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("Janela Teste");
		f.setSize(300,200);
		f.setLocation(500,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Um texto qualquer");
		panel.add(label);
		
		JTextField textField = new JTextField(10);
		panel.add(textField);
		
		JButton button = new JButton("Ok");
		ButtonAction action = new ButtonAction(textField);
		button.addActionListener(action);
		panel.add(button);
		
		
		f.add(panel);
		f.setVisible(true);
	}

}
