package controlador;

import java.util.*;

import gui.VentanaConfiguracion;
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
	private Juego juegoAct;

	public Controlador() {
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
			if(!enemigoAct.isDestruido()) {
				posActEn.add(enemigoAct.getPosX()); //lleno el arraylist con todas las pos de los enemigos
			}
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
			if(!enemigoAct.isDestruido()) {
				moverEnemigo(enemigoAct);
			}
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

	public void configurarJuego(int modo, int nivel) {
		juegoAct = new Juego();
		juegoAct.setModo(modo);
		juegoAct.setNivelAct(nivel);
		empezarJuego();
	}
	
	public void empezarJuego() {
		
		enemigos = new ArrayList<ObjetivoEnemigo>();
		balas = new ArrayList<Proyectil>();
		canon = new Cañon();
		int velocidad = juegoAct.getModo() * juegoAct.getNivelAct();
		for (int i = 0; i < 10; i++) { //creo los 10 enemigos
			ObjetivoEnemigo nuevo = new ObjetivoEnemigo(velocidad, i);
			enemigos.add(nuevo);
		}

		
	}
	
	public void finalizarJuego() {
		
		return;
	}
	
	
	public void moverMiraCañon() {
		
		return;
	}
	
	//A partir de aca va el codigo para las colisiones, no estoy seguro de si esta bien, consultar
	public void hayColision() {
		ObjetivoEnemigo enemigoImpactado;
		for (Proyectil bala: balas) {
			 enemigoImpactado = bala.colisione(enemigos);
			 if(enemigoImpactado != null) {
				 enemigoImpactado.setDestruido(true);
				 //enemigos.remove(enemigoImpactado);
			 }
			
		}
	}
	

}