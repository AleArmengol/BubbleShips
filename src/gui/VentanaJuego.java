package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.sun.prism.Image;

import controlador.Controlador;

public class VentanaJuego extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel lblCanon;
	private JLabel lblMira;
	private JLabel lblFondo;
	private JPanel panelDatosJuego;
	private JTextField textPuntaje;
	private JTextField textEnemDest;
	private JTextField textVidas;
	private ArrayList <JLabel> lblBalas;
	private ArrayList<JLabel> lblEnemigos;
	private Container c; //puedo poner el container en el frame? para poder accederlo desde el keyListener y asi agregar un JFrame ?

	
	public VentanaJuego() {
		lblEnemigos = new ArrayList<JLabel>();
		lblBalas = new ArrayList<JLabel>();
		configurar();
		eventos();
		this.setTitle("Bubble Ships");
		this.setSize(1000,800);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void eventos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addKeyListener(new ManejadorTeclas());
		
		Timer t = new Timer(30 , new ManejadorEventos(0));
		
		t.start();
	}

	private void configurar() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(206,206,255));
		
		//fondo
//		lblFondo = new JLabel();
//		lblFondo.setIcon(new ImageIcon("imagenes\\fondoAgua.png"));
//		lblFondo.setBounds(50, 50, 50, 500);
//		c.add(lblFondo);
		
		//datosJuegos
		panelDatosJuego = new JPanel();
		panelDatosJuego.setLayout(null);
		panelDatosJuego.setVisible(true);
		panelDatosJuego.setBackground(Color.BLACK);
		panelDatosJuego.setBounds(0, 0, 1000, 35);
		//c.add(panelDatosJuego);
		
		//Fuente para los textos
		Font font = new Font("Courier", Font.BOLD, 20);
		
		textPuntaje = new JTextField("Puntuacion: 0");
		textPuntaje.setFont(font);
		textPuntaje.setBackground(Color.BLACK);
		textPuntaje.setBorder(null);
		textPuntaje.setForeground(Color.GREEN);
		textPuntaje.setBounds(10, 0, 190, 30);
		panelDatosJuego.add(textPuntaje);
		
		textEnemDest = new JTextField("Destruidos: 0");
		textEnemDest.setFont(font);
		textEnemDest.setBackground(Color.BLACK);
		textEnemDest.setBorder(null);
		textEnemDest.setForeground(Color.GREEN);
		textEnemDest.setBounds(410, 0, 200, 30);
		panelDatosJuego.add(textEnemDest);
		
		
		textVidas = new JTextField("Vidas: 3");
		
		panelDatosJuego.add(textEnemDest);
		panelDatosJuego.add(textVidas);
		
		
		//cañon
		lblCanon = new JLabel();
		lblCanon.setIcon(new ImageIcon("imagenes\\canonSF.png"));
		lblCanon.setBounds(425, 655, 112, 112);
		c.add(lblCanon);
		
		//mira
		lblMira = new JLabel();
		c.add(lblMira);
		lblMira.setBounds(465, 490, 21, 201);
		lblMira.setIcon(new ImageIcon("imagenes\\mira3.png"));
		

		
		//enemigos
		Iterator<String> iteradorPath = Controlador.getInstance().obtenerPaths().iterator();
		int iteradorPos = 0;
		while(iteradorPath.hasNext()) {
			JLabel lblAct = new JLabel();
			String pathTemp = iteradorPath.next();
			lblAct.setIcon(new ImageIcon(pathTemp));
			
			if(pathTemp.equals("imagenes\\velero.gif")) {
				lblAct.setBounds(Controlador.getInstance().obtenerPosBarcos().get(iteradorPos), 200, 200, 200); //arreglo[5] = arraylist.get(5)
				
			} else {
				lblAct.setBounds(Controlador.getInstance().obtenerPosBarcos().get(iteradorPos), 50, 200, 200);
			}
			
			
			lblEnemigos.add(lblAct);
			c.add(lblAct);
			iteradorPos ++;
		}
		
		
	}
	
	class ManejadorEventos implements ActionListener{
		private int contador; //cada iteracion le sumamos 1, y cuando llega a 10 (pasó un segundo) modificamos el delay en el controlador
		ManejadorEventos(int conta){
			contador = conta;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// cada 100 ms...
			contador ++;
			if(contador > 9) {
				contador = 0;
				Controlador.getInstance().actualizarTiempoJuego(Controlador.getInstance().obtenerTiempoJuego() + 1); //obtenemos el tiempo actual y le sumamos 1 y actualizamos
			}
			ArrayList<ArrayList<Integer>> estadoJuego = null;
			Controlador.getInstance().actualizarEstadoJuego();
			estadoJuego = Controlador.getInstance().obtenerEstadoJuego();
			
			ArrayList<Integer> posEnem = estadoJuego.get(0);
			ArrayList<Integer> posBalasX = estadoJuego.get(1);
			ArrayList<Integer> posBalasY = estadoJuego.get(2);
			//int puntuacion = estadoJuego.get(3).get(0);
			
			
			//REDIBUJO LOS ENEMIGOS
			
			int itPosEnem = 0;
			for(JLabel enemAct: lblEnemigos) {
				if(enemAct != null) {
					enemAct.setBounds(posEnem.get(itPosEnem), enemAct.getY(), 200, 200);
					itPosEnem++;
				}
			}
			
			//REDIBUJO LAS BALAS
			int itPosBala = 0;
			for(JLabel balaAct: lblBalas) {
				balaAct.setBounds(posBalasX.get(itPosBala), posBalasY.get(itPosBala), 50, 50);
				itPosBala ++;
			}
			
			//Chequeo Colision
			Controlador.getInstance().hayColision();
			
			//
		}
		
	}
	
	class ManejadorTeclas implements KeyListener{

		//@Override
		int angulo = 90;
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == 37) {
				angulo += 10;
			}
			
			if(e.getKeyCode() == 39) {
				angulo -= 10;
			}
			
			if(e.getKeyCode() == 32) { //barra espaciadora
				
				JLabel nuevaBala = new JLabel();
				nuevaBala.setIcon(new ImageIcon("imagenes\\bala.png"));
			    nuevaBala.setBounds(459, 652, 50, 50);
			    c.add(nuevaBala);
				lblBalas.add(nuevaBala);
				Controlador.getInstance().dispararCañon(angulo, 20); //pasar angulo de la mira y potencia
			}
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}
		
	}

	
}
