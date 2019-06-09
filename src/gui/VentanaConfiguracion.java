package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import negocio.Juego;

public class VentanaConfiguracion extends JFrame {
	
	private JButton btnCerrar;
	private JButton btnNom;
	private JTextField campoNombre;
	private JLabel txtNombre;
	private JLabel txtDificultad;
	private JLabel txtNombreJugador;
	
	
	
	public VentanaConfiguracion() {

		final Container c = this.getContentPane();
		c.setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		campoNombre = new JTextField("");
		txtDificultad= new JLabel("Dificultad:");
		txtNombreJugador= new JLabel("Nombre:");
		
		btnCerrar.setBounds(110, 190,80,20);
		campoNombre.setBounds(10,25, 200, 30);
		txtDificultad.setBounds(10, 50, 200, 30);
		txtNombreJugador.setBounds(10,0,200,30);
		
		c.add(btnCerrar);
		c.add(campoNombre);
		c.add(txtDificultad);
		c.add(txtNombreJugador);
		
		//botones dificultad
		JRadioButton optionFa = new JRadioButton("Facil",true);
		JRadioButton optionMe = new JRadioButton("Medio");
		JRadioButton optionDi = new JRadioButton("Dificil");
		
		ButtonGroup group = new ButtonGroup();
		group.add(optionFa);
		group.add(optionMe);
		group.add(optionDi);
		
		c.add(optionFa);
		c.add(optionMe);
		c.add(optionDi);
		
		optionFa.setBounds(10,100,100,50);
		optionMe.setBounds(110,100,100,50);
		optionDi.setBounds(210,100,110,50);
		
		
		this.setSize(300,260);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Configuracion");
 		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
 		
 		btnCerrar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				
			
				//negocio.Juego.setNombre(campoNombre.getText()); 
				
				
				if(optionFa.isSelected()){
					
				}
				else if(optionMe.isSelected()){
					
				}
				else{
					
				}
			}			
 		});
		
				
 		btnCerrar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				dispose();
			}
		});
	}
}
