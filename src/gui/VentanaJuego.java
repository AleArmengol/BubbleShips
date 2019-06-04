package gui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Controlador;

public class VentanaJuego extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel canon;
	private Controlador c;
	
	public VentanaJuego() {
		configurar();
		eventos();
		c = new Controlador();
		this.setTitle("Bubble Ships");
		this.setSize(800,600);
		this.setVisible(true);
	}

	private void eventos() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void configurar() {
		// TODO Auto-generated method stub
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		//cañon
		canon = new JLabel();
		canon.setIcon(new ImageIcon("imagenes\\canonSF.png"));
		canon.setBounds(338, 468, 112, 112);
		c.add(canon);
	}
}
