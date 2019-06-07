package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.sun.prism.Image;

import controlador.Controlador;

public class VentanaJuego extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel canon;
	private JLabel mira;
	private ArrayList<JLabel> lblEnemigos;
	private Controlador cont;
	
	public VentanaJuego() {
		lblEnemigos = new ArrayList<JLabel>();
		cont = new Controlador();//genera todo lo del controlador
		configurar();
		eventos();
		this.setTitle("Bubble Ships");
		this.setSize(800,600);
		//this.setResizable(false);
		this.setVisible(true);
	}

	private void eventos() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Timer t = new Timer(100, new ManejadorEventos(0));
		
		t.start();
	}

	private void configurar() {
		// TODO Auto-generated method stub
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(206,206,255));
		
		//cañon
		canon = new JLabel();
		canon.setIcon(new ImageIcon("imagenes\\canonSF.png"));
		canon.setBounds(338, 458, 112, 112);
		c.add(canon);
		
		//mira
		mira = new JLabel();
		mira.setIcon(new ImageIcon("imagenes\\mira3.png"));
		mira.setBounds(378, 290 , 21, 201);
		c.add(mira);
		

		
		//enemigos
		Iterator<String> iteradorPath = cont.obtenerPaths().iterator();
		int iteradorPos = 0;
		while(iteradorPath.hasNext()) {
			JLabel lblAct = new JLabel();
			String pathTemp = iteradorPath.next();
			lblAct.setIcon(new ImageIcon(pathTemp));
			
			if(pathTemp.equals("imagenes\\velero.gif")) {
				lblAct.setBounds(cont.obtenerPosBarcos().get(iteradorPos), 200, 200, 200); //arreglo[5] = arraylist.get(5)
				
			} else {
				lblAct.setBounds(cont.obtenerPosBarcos().get(iteradorPos), 50, 200, 200);
			}
			
			
			lblEnemigos.add(lblAct);
			c.add(lblAct);
			iteradorPos ++;
		}
		System.out.println(lblEnemigos.size());
		
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
				cont.actualizarTiempoJuego(cont.obtenerTiempoJuego() + 1); //obtenemos el tiempo actual y le sumamos 1 y actualizamos
			}
			ArrayList<ArrayList<Integer>> estadoJuego = null;
			cont.actualizarEstadoJuego();
			estadoJuego = cont.obtenerEstadoJuego();
			
			ArrayList<Integer> posEnem = estadoJuego.get(0);
			//ArrayList<Integer> posBalasX = estadoJuego.get(1);
			//ArrayList<Integer> posBalasY = estadoJuego.get(2);
			//int puntaje = estadoJuego.get(3).get(0);
			
			//REDIBUJO LOS ENEMIGOS
			Iterator<JLabel> iteradorEnem = lblEnemigos.iterator();
			int iteradorPos = 0;
			while(iteradorEnem.hasNext()) {
				JLabel act = iteradorEnem.next();
				act.setBounds(posEnem.get(iteradorPos), act.getY(), 200, 200);
				iteradorPos++;
			}
	
		}
		
	}
}
