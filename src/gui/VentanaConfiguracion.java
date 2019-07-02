package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controlador.Controlador;
import negocio.Juego;

public class VentanaConfiguracion extends JFrame {
	
	private JButton btnEmpezar;
	private JLabel txtDificultad;
	private JRadioButton optionFa; 
	private JRadioButton optionMe; 
	private JRadioButton optionDi;
	private JLabel nivel;
	private JComboBox<String> comboNiveles;
	
	
	public VentanaConfiguracion() {

		final Container c = this.getContentPane();
		c.setLayout(null);
		
		btnEmpezar = new JButton("Empezar");
		txtDificultad= new JLabel("Modo:");
		
		btnEmpezar.setBounds(90, 160,100,40);
		txtDificultad.setBounds(10, 10, 200, 30);
		
		c.add(btnEmpezar);
		c.add(txtDificultad);
		
		//botones dificultad
		optionFa = new JRadioButton("Cadete", true);
		optionMe = new JRadioButton("Guerrero");
		optionDi = new JRadioButton("Diablo"); 
		
		nivel = new JLabel("Nivel: ");
		nivel.setBounds(10, 80, 75, 20);
		c.add(nivel);
		
		//lista desplegable Niveles
		String [] niveles = { "1", "2", "3", "4", "5" };
		comboNiveles = new JComboBox(niveles);
		comboNiveles.setBounds(60, 80, 35, 20);
		c.add(comboNiveles);
		
		ButtonGroup group = new ButtonGroup();
		group.add(optionFa);
		group.add(optionMe);
		group.add(optionDi);
		
		c.add(optionFa);
		c.add(optionMe);
		c.add(optionDi);
		
		optionFa.setBounds(10,30,100,50);
		optionMe.setBounds(110,30,100,50);
		optionDi.setBounds(210,30,110,50);
		
		
		this.setSize(300,260);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Configuracion");
 		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
				
 		btnEmpezar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int numModo;
				int numNivel = Integer.parseInt(comboNiveles.getSelectedItem().toString());
				if(optionFa.isSelected()) {
					numModo = 1;
				} else if(optionMe.isSelected()) {
					numModo = 2;
				} else {
					numModo = 3;
				}
				Controlador.getInstance().configurarJuego(numModo, numNivel);
				setVisible(false); 
				dispose();
				new VentanaJuego();
			}
		});
	}
}
