package controlador;

import java.util.*;

import negocio.Cañon;
import negocio.Juego;
import negocio.ObjetivoEnemigo;
import negocio.Proyectil;

/**
 * 
 */
public class Controlador {

	private ArrayList<ObjetivoEnemigo> enemigos;
	private Cañon canon;
	private ArrayList <Proyectil> balas;
	//private ArrayList<String> paths; // contiene direccion de las imagenes de cada Enemigo
	//private ArrayList<Integer> posXs; // contiene posicion X de cada enemigo



	private Juego juegoAct;

	public Controlador() {
		enemigos = new ArrayList<ObjetivoEnemigo>();
		balas = new ArrayList<Proyectil>();
		juegoAct = new Juego(1);
		canon = new Cañon();

		for (int i = 0; i < 10; i++) { //creo los 10 enemigos
			ObjetivoEnemigo nuevo = new ObjetivoEnemigo(juegoAct.getNivelAct(), i);
			enemigos.add(nuevo);
		}

	}
	
	
	public ArrayList<String> obtenerPaths(){
		ArrayList<String> paths = new ArrayList<String>();
		for (ObjetivoEnemigo actual : enemigos) {
			paths.add(actual.getPathImagen());
		}
		return paths;
	}
	
	
	public ArrayList<Integer> obtenerPosBarcos(){
		ArrayList<Integer> posXs = new ArrayList<Integer>();
		for (ObjetivoEnemigo actual: enemigos) {
			posXs.add(actual.getPosX());
		}
		return posXs;
	}
	
	public ArrayList<Integer> obtenerPosXBala(){
		ArrayList<Integer> posXsB = new ArrayList<Integer>();
		for (Proyectil actual: balas) {
			posXsB.add(actual.getPosX());
		}
		
		return posXsB;
	}
	
	public ArrayList<Integer> obtenerPosYBala(){
		ArrayList<Integer> posYsB = new ArrayList<Integer>();
		for (Proyectil actual: balas) {
			posYsB.add(actual.getPosY());
		}
		
		return posYsB;
	}

	public ArrayList<ArrayList<Integer>> obtenerEstadoJuego() {
		ArrayList<Integer> posActEn = new ArrayList<>(); //pos actuales enemigos
		ArrayList<Integer> posXBs = new ArrayList<>();    //pos actual x proyectiles
		ArrayList<Integer> posYBs = new ArrayList<>();    //pos actual y proyecyiles
		ArrayList<ArrayList<Integer>> devolver = new ArrayList<>(); //contiene la posicion de: Enemigos(Eje x),proyectil(x,y) y puntaje
		
		Iterator<ObjetivoEnemigo> iterador = enemigos.iterator();
		while (iterador.hasNext()) {
			ObjetivoEnemigo enemigoAct = (ObjetivoEnemigo) iterador.next();
			posActEn.add(enemigoAct.getPosX()); //lleno el arraylist con todas las pos de los enemigos
		}
		
		if(balas != null) {
			for(Proyectil balaAct : balas) {
				posXBs.add(balaAct.getPosX()); //lleno el arraylist con todas las pos x de las balas
				posYBs.add(balaAct.getPosY()); //lleno el arraylist con todas las pos y de las balas
			}
		}
		devolver.add(posActEn);
		devolver.add(posXBs);
		devolver.add(posYBs);
		
		return devolver;
	}
	

	public int moverEnemigo(ObjetivoEnemigo enemigoActual) {
		int posNueva = enemigoActual.mover(juegoAct.getTiempo()); // 
		return posNueva;
	}
	
	public void actualizarTiempoJuego(int tiempoNuevo) {
		juegoAct.setTiempo(tiempoNuevo);
	}
	
	public int obtenerTiempoJuego() {
		return juegoAct.getTiempo();
	}

	public void actualizarEstadoJuego() {
		Iterator<ObjetivoEnemigo> iterador = enemigos.iterator();
		while (iterador.hasNext()) {
			ObjetivoEnemigo enemigoAct = (ObjetivoEnemigo) iterador.next();
			moverEnemigo(enemigoAct);

		}
		
		if(balas != null) {
			for(Proyectil balaAct: balas) {
				balaAct.recorrerPantalla();
			}
		}
	}
	
	public void dispararCañon(float angulo, int potencia) {
		Proyectil bala = canon.disparar(angulo, potencia);
		balas.add(bala);
	}
	
	public void moverProyectil(Proyectil balaAct) {
		balaAct.recorrerPantalla();
	}

	public void configurarJuego(String dificultad) {

	}
	
	
	private void seleccionarDificultadInicio(String dif) {
		
		return;
	}
	
	public void empezarJuego() {
		
		return;
	}
	
	public void finalizarJuego() {
		
		return;
	}
	
	
	public void moverMiraCañon() {
		
		return;
	}

}