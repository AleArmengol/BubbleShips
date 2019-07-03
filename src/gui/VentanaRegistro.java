package gui;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;




public class VentanaRegistro extends JFrame {
	
	private JButton btnguardar;
	private JLabel name;
	private JTextField nombre;
	private String n;

	
	public VentanaRegistro(int puntuacion) {
		
		final Container c = this.getContentPane();
		c.setLayout(null);
		
		name = new JLabel("Nombre:");
		name.setBounds(10, 10, 200, 30);
		c.add(name);
	
		
		btnguardar= new JButton("Guardar");
		btnguardar.setBounds(70,100,150,30);
		c.add(btnguardar);
		
		nombre = new JTextField("Jugador");
		nombre.setBounds(10, 40, 200, 30);
		c.add(nombre);
		
		this.setSize(300,200);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Registro");
 		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
 	
 		
 		btnguardar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
 				dispose();
 				
 				try(FileWriter fw = new FileWriter("Ranking.txt", true);
 						BufferedWriter bw = new BufferedWriter(fw);
 						PrintWriter out = new PrintWriter(bw))
 				{
 					String n = nombre.getText();
 					String nombre= n+" "+puntuacion;
 					out.println(nombre);
 				} catch (IOException e1) {
 					
 					
 				}
 				new VentanaRankings();
			}
		});
	}
}
 
 		







