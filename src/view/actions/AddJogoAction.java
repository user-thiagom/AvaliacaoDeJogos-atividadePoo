package view.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import business.CriarJogo;
import entities.Desenvolvedora;

public class AddJogoAction implements ActionListener {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField nome;
	private JTextField data;
	private JComboBox<Desenvolvedora> idDesenvolvedor;
	private JComboBox<String> idPlataforma;
	private JComboBox<String> genero;
	
	public AddJogoAction(JTextField nome, JTextField data, JComboBox<Desenvolvedora> idDesenvolvedor, JComboBox<String> idPlataforma, JComboBox<String> genero) {
		this.nome = nome;
		this.data = data;
		this.idDesenvolvedor = idDesenvolvedor;
		this.idPlataforma = idPlataforma;
		this.genero = genero;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			String nome = this.nome.getText();
			Date dataLancamento = sdf.parse(this.data.getText());
			Desenvolvedora dev = (Desenvolvedora) idDesenvolvedor.getSelectedItem();
			
			System.out.println("teste"  + dev);
			new CriarJogo(nome, dataLancamento, dev.getId(), (idPlataforma.getSelectedIndex()+1), genero.getSelectedItem().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
