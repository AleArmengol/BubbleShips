package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCreadores extends JFrame{
	
	private JTextField titulo;
	private JButton btncerrar;
	private JLabel tex;
	private JLabel creador1;
	private JLabel creador2;
		
	public VentanaCreadores() {
		final Container co = this.getContentPane();
		co.setLayout(null);
		btncerrar = new JButton("Cerrar");
		titulo = new JTextField("Creadores");
		tex=new  JLabel("GRUPO 2:");
		creador1 = new JLabel("Alexis Armengo");
		creador2 = new JLabel("Gonzalo Bacigalupe");
		
		tex.setBounds(10, 10, 200, 30);
		creador1.setBounds(10, 40, 150, 20);
		creador2.setBounds(10, 70, 150, 20);
		btncerrar.setBounds(130, 190, 100, 20);
		
		this.setSize(250, 250);
		this.setVisible(true);
		this.setTitle(titulo.getText());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
 		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
 		
 		co.add(btncerrar);
 		co.add(titulo);
 		co.add(tex);
 		co.add(creador1);
 		co.add(creador2);
 	
 		btncerrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				dispose();
			}
		});
	}	
 }		
	


