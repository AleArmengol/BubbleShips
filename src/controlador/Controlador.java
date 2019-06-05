package controlador;

import java.util.*;

import negocio.Juego;
import negocio.ObjetivoEnemigo;

/**
 * 
 */
public class Controlador {

	private ArrayList<ObjetivoEnemigo> enemigos;
	private ArrayList<String> paths; // contiene direccion de las imagenes de cada Enemigo
	private ArrayList<Integer> posXs; // contiene posicion X de cada enemigo



	private Juego juegoAct;
	private int segCount = 0;

	public Controlador() {
		enemigos = new ArrayList<ObjetivoEnemigo>();
		juegoAct = new Juego(1);
		paths = new ArrayList<String>();
		posXs = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) { //creo los 10 enemigos
			ObjetivoEnemigo temp = new ObjetivoEnemigo(juegoAct.getNivelAct());
			enemigos.add(temp);
			paths.add(temp.getPathImagen());
			posXs.add(temp.getPosX());
		}

	}

	// private float areaPantalla;

	private void seleccionarDificultadInicio(String dif) {

		return;
	}

	public void empezarJuego() {

		return;
	}

	public void finalizarJuego() {

		return;
	}

	public void dispararCañon() {

		return;
	}

	public void moverMiraCañon() {

		return;
	}

	public ArrayList<ArrayList<Integer>> obtenerEstadoJuego() {
		ArrayList<Integer> posActEn = new ArrayList<>(); //pos actuales enemigos
		ArrayList<ArrayList<Integer>> devolver = new ArrayList<>(); //contiene la posicion de: Enemigos(Eje x),proyectil(x,y) y puntaje
		
		Iterator<ObjetivoEnemigo> iterador = enemigos.iterator();
		while (iterador.hasNext()) {
			ObjetivoEnemigo enemigoAct = (ObjetivoEnemigo) iterador.next();
			posActEn.add(enemigoAct.getPosX()); //lleno el arraylist con todas las pos de los enemigos
		}
		devolver.add(posActEn);
		
		return devolver;
	}

	public int moverEnemigo(ObjetivoEnemigo enemigoActual) {
		int posNueva = enemigoActual.mover(segCount);
		return posNueva;
	}

	public void actualizarEstadoJuego() {
		Iterator<ObjetivoEnemigo> iterador = enemigos.iterator();
		while (iterador.hasNext()) {
			ObjetivoEnemigo enemigoAct = (ObjetivoEnemigo) iterador.next();
			moverEnemigo(enemigoAct);

		}
	}

	public void configurarJuego(String dificultad) {

	}

	public int getSegCount() {
		return segCount;
	}

	public void setSegCount(int segCount) {
		this.segCount = segCount;
	}

	public ArrayList<ObjetivoEnemigo> getEnemigos() {
		return enemigos;
	}
	
	public ArrayList<String> getPaths() {
		return paths;
	}
	
	public void setPaths(ArrayList<String> paths) {
		this.paths = paths;
	}

	public void setEnemigos(ArrayList<ObjetivoEnemigo> enemigos) {
		this.enemigos = enemigos;
	}
	public ArrayList<Integer> getPosXs() {
		return posXs;
	}
	
	public void setPosXs(ArrayList<Integer> posXs) {
		this.posXs = posXs;
	}

}