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
import javax.swing.JOptionPane;
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
	private int segundos = 1;
	Timer t;
	
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
		
		t = new Timer(25 , new ManejadorEventos(0));
		
		t.start();
	}

	private void configurar() {
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(206,206,255));
		
		//fondo
		lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon("imagenes\\fondoAgua.png"));
		lblFondo.setBounds(50, 50, 50, 500);
		c.add(lblFondo);

		//datosJuegos
		panelDatosJuego = new JPanel();
		panelDatosJuego.setLayout(null);
		panelDatosJuego.setVisible(true);
		panelDatosJuego.setBackground(Color.BLACK);
		panelDatosJuego.setBounds(0, 0, 1000, 35);
		
		
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
	
		//c.add(panelDatosJuego);
		
		//cañon
		lblCanon = new JLabel();
		lblCanon.setIcon(new ImageIcon("imagenes\\canonSF.png"));
		lblCanon.setBounds(425, 655, 112, 112);
		c.add(lblCanon);
		
		//mira
		lblMira = new JLabel();
		c.add(lblMira);
		lblMira.setBounds(420, 170, 125, 125);
		lblMira.setIcon(new ImageIcon("imagenes\\mira5.png"));
		

		
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
			
			// cada 25 ms...
			contador ++;
			if(contador > 40) { // cada 1 segundo
				segundos ++;
				contador = 0;
				Controlador.getInstance().actualizarTiempoJuego(Controlador.getInstance().obtenerTiempoJuego() + 1); //obtenemos el tiempo actual y le sumamos 1 y actualizamos
				if(Controlador.getInstance().pasoUltimoBarco()) {
					Controlador.getInstance().crearBarcos();
					System.out.println("Termino nivel");
					System.out.println("CREO BARCOS");
					Controlador.getInstance().actualizarTiempoJuego(0); //reiniciamos el tiempo de juego a 0
				}
			}
			
			ArrayList<ArrayList<Integer>> estadoJuego = null;
			Controlador.getInstance().actualizarEstadoJuego();
			estadoJuego = Controlador.getInstance().obtenerEstadoJuego();
			
			ArrayList<Integer> posEnem = estadoJuego.get(0);
			ArrayList<Integer> posBalasX = estadoJuego.get(1);
			ArrayList<Integer> posBalasY = estadoJuego.get(2);
			int puntuacion = estadoJuego.get(3).get(0);
			int perdio = estadoJuego.get(4).get(0);
			
			
			//REDIBUJO LOS ENEMIGOS
			if(perdio != 1) {
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
			} else {
				t.stop();
				new VentanaRegistro(puntuacion);
			}
		}
		
	}
	
	class ManejadorTeclas implements KeyListener{

		//@Override
		int angulo = 90;
		int potencia = 7;
		public void keyPressed(KeyEvent e) {
			//JOptionPane.showInternalMessageDialog(null, e.getKeyCode());
			if(e.getKeyCode() == 37) { //izq
				
//				angulo += 5;
//				double anguloRad = Math.toRadians(angulo - 90);
//				double tanAng = Math.tan(anguloRad);
//	
//				double ady = 484 - lblMira.getY();
//				double opuesto = ady * Math.abs(tanAng);
//	
//				int nuevaPosMira = 420 - (int)opuesto;
//				int vecesMovido = (angulo - 90) / 5;
//				lblMira.setBounds(nuevaPosMira - ((int)125/2), lblMira.getY(), 125, 125);
				angulo += 5;
				if(angulo > 135) {
					angulo = 135;
				}
			}
			
			if(e.getKeyCode() == 39) { //derecha
//				int opuesto = 420;
//				int ady = Math.abs(484 - lblMira.getX()) ; //484 pos de donde sale la bala (centro)
//				angulo = (int) Math.toDegrees((Math.atan(opuesto/ady)));
//				System.out.println(angulo);
//				int nuevaPosMira = lblMira.getX() + 10;
//				lblMira.setBounds(nuevaPosMira, lblMira.getY(), 125, 125);
				angulo -= 5;
				if(angulo < 45) {
					angulo = 45;
				}
			}
			
			if(e.getKeyCode() == 77) { //letra M
				potencia += 3;
			}
			if(e.getKeyCode() == 78) { //letra N
				potencia -= 3;
				if (potencia < 1) {
					potencia = 1;
				}
			}
			
			if(segundos >= 1) {
				if(e.getKeyCode() == 32) { //barra espaciadora
					
					JLabel nuevaBala = new JLabel();
					nuevaBala.setIcon(new ImageIcon("imagenes\\bala.png"));
				    nuevaBala.setBounds(459, 652, 50, 50);
				    c.add(nuevaBala);
					lblBalas.add(nuevaBala);
					Controlador.getInstance().dispararCañon(angulo, potencia); //pasar angulo de la mira y potencia
					segundos = 0;
				}
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
