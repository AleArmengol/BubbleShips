package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
			br = new BufferedReader(new FileReader("D:\\Documentos\\GitHub\\BubbleShips\\Ranking.txt"));
			String linea;
			
			int cont = 0;
			while((linea = br.readLine()) != null){
				String[] registro = linea.split("\\s+");
				String nombreRegistro = registro[0];
				String puntRegistro = registro[1];
				int puntRegistroInt = Integer.parseInt(puntRegistro);
				for(int i = 0; i < 50; i++) {
					int aux;
					int puntoComparar = Integer.parseInt(jugadores[i][1]);
					if(puntRegistroInt < puntoComparar){
						for()
					}
				}
				
				
				jugadores[cont][0] = nombreRegistro;
				jugadores[cont][1] = puntRegistro;
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
}
