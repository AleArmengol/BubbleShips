package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Container;


public class VentanaRankings extends JFrame {
	private static final long serialVersionUID = 1L;
	JTable tabla;

	public VentanaRankings() {
		
		this.setTitle("Rankings");
		//final Container c = this.getContentPane();
		//c.setLayout(null);
		String [][] jugadores = new String[50][2];
		String[] nombreColumnas = {"Nombre", "Puntuacion"};
		
		//lectura del archivo
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\aearm\\Documents\\GitHub\\BubbleShips\\Ranking.txt"));
			String linea;
			
			ArrayList<MapaPuntos> registrosMapeados = new ArrayList<>();
			while((linea = br.readLine()) != null){
				String[] registro = linea.split("\\s+");
				String nombreRegistro = registro[0];
				String puntRegistro = registro[1];
				
				Integer puntajeNuevo = Integer.parseInt(puntRegistro);
				
				MapaPuntos mapa = new MapaPuntos(nombreRegistro, puntajeNuevo);
				registrosMapeados.add(mapa);

			}
			Collections.sort(registrosMapeados);
			Collections.reverse(registrosMapeados);
			int cont = 0;
			for(MapaPuntos actual: registrosMapeados) {
				jugadores[cont][0] = actual.getNombre();
				jugadores[cont][1] = actual.getPuntos().toString();
				cont++;
			}
			
		} catch (IOException e) {
			
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		tabla = new JTable(jugadores, nombreColumnas);
		tabla.setBounds(0, 0, 400, 400);
		this.add(tabla);
		this.setSize(500, 500);
		this.setVisible(true);
		
	}
	class MapaPuntos implements Comparable<MapaPuntos>{
		
		String nombre;
		Integer puntos;
		
		
		MapaPuntos(String nombre, Integer puntos){
			this.nombre = nombre;
			this.puntos = puntos;
		}
		@Override
		public int compareTo(MapaPuntos arg0) {
			Integer temp = this.getPuntos();
			Integer temp2 = arg0.getPuntos();
			int respuesta = temp.compareTo(temp2);
			
			if(respuesta == 0) {
				String nombreAux = this.getNombre();
				String nombreAux2 = arg0.getNombre();
				respuesta = nombreAux2.compareTo(nombreAux);
			}
			//-1,0,1 menor que, igual, mayor que
			return respuesta;
		}
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Integer getPuntos() {
			return puntos;
		}
		public void setPuntos(Integer puntos) {
			this.puntos = puntos;
		}
		
	}
}
