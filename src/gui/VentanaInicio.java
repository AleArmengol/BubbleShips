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

public class VentanaInicio extends JFrame{
	
	//Botones
	private JButton btnjugar;
	private JButton btncreadores;
	private JButton btnsalir;
	private JTextField name;
	private ImageIcon fondo;
	private JLabel logotipo;
	
	
	
	public VentanaInicio() {
		final Container co = this.getContentPane();
		
		//creacion
		btnjugar= new JButton("Jugar");
		btncreadores=new JButton("Creadores");
		btnsalir=new JButton("Salir");
		name=new JTextField("Bubble Ships");
		fondo= new ImageIcon("imagenes\\060fc97f2bdd82bc7ac35617658c362a.png");
		logotipo= new JLabel(fondo);
		
		
		//posiciones
		//logotipo.setBounds(200, 5, 600, 250);
		btnjugar.setBounds(625, 80, 125, 27);
		btncreadores.setBounds(625, 140, 125, 27);
		btnsalir.setBounds(625, 170, 125, 27);	
		
		//configuracion frame
		this.setSize(1400,800);
		this.setTitle(name.getText());
		this.setLocationRelativeTo(null); //posiciona en mitad de la pantalla
		this.setResizable(false);
		this.getContentPane().setBackground(Color.black);
 		this.setVisible(true);
 		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
 		
 		//agregacion al contenedor
 		co.add(btnjugar);
		co.add(btncreadores);
		co.add(btnsalir);
		co.add(name);
		co.add(logotipo);
		
		
		//push boton jugar
		btnjugar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				co.setVisible(false);
				dispose();
				new VentanaConfiguracion();
			}
		});

		//push boton creaadores
		btncreadores.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new VentanaCreadores();
			}
		});
			
		
		//push boton salir
		btnsalir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
					
	}
	

}











