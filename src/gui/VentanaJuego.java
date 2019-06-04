package gui;

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
		this.setSize(300,500);
		this.setVisible(true);
	}

	private void eventos() {
		// TODO Auto-generated method stub
		
	}

	private void configurar() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		canon = new JLabel();
		canon.setIcon(new ImageIcon("C:\\Users\\aearm\\Documents\\GitHub\\BubbleShips\\imagenes\\imagenCanon.jpg"));
		canon.setBounds(10, 350, 100, 100);
	}
}
