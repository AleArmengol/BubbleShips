package controlador;

import java.util.*;

import gui.VentanaConfiguracion;
import negocio.Cañon;
import negocio.Juego;
import negocio.Jugador;
import negocio.ObjetivoEnemigo;
import negocio.Proyectil;

/**
 * 
 */
public class Controlador {

	private ArrayList<ObjetivoEnemigo> enemigos;
	private Cañon canon;
	private ArrayList<Proyectil> balas;
	private Juego juegoAct;
	private Jugador jugadorAct;
	private static Controlador instance = null;

	private Controlador() {

	}

	public static Controlador getInstance() {
		if (instance == null) {
			instance = new Controlador();
		}
		return instance;
	}

	public ArrayList<String> obtenerPaths() {
		ArrayList<String> paths = new ArrayList<String>();
		for (ObjetivoEnemigo actual : enemigos) {
			paths.add(actual.getPathImagen());
		}
		return paths;
	}

	public ArrayList<Integer> obtenerPosBarcos() {
		ArrayList<Integer> posXs = new ArrayList<Integer>();
		for (ObjetivoEnemigo actual : enemigos) {
			posXs.add(actual.getPosX());
		}
		return posXs;
	}

	public ArrayList<Integer> obtenerPosXBala() {
		ArrayList<Integer> posXsB = new ArrayList<Integer>();
		for (Proyectil actual : balas) {
			posXsB.add(actual.getPosX());
		}

		return posXsB;
	}

	public ArrayList<Integer> obtenerPosYBala() {
		ArrayList<Integer> posYsB = new ArrayList<Integer>();
		for (Proyectil actual : balas) {
			posYsB.add(actual.getPosY());
		}

		return posYsB;
	}

	public ArrayList<ArrayList<Integer>> obtenerEstadoJuego() {
		ArrayList<Integer> posActEn = new ArrayList<>(); // pos actuales enemigos
		ArrayList<Integer> posXBs = new ArrayList<>(); // pos actual x proyectiles
		ArrayList<Integer> posYBs = new ArrayList<>(); // pos actual y proyecyiles
		ArrayList<Integer> puntos = new ArrayList<>(); // [0]puntuacion [1] enemigos destruidos
		ArrayList<ArrayList<Integer>> devolver = new ArrayList<>(); // contiene la posicion de: Enemigos(Eje
																    // x),proyectil(x,y) y puntaje
		ArrayList<Integer> perdio = new ArrayList<>();
		perdio.add(0);
		Iterator<ObjetivoEnemigo> iterador = enemigos.iterator();
		while (iterador.hasNext()) {
			ObjetivoEnemigo enemigoAct = (ObjetivoEnemigo) iterador.next();
			if (!enemigoAct.isDestruido()) {
				posActEn.add(enemigoAct.getPosX()); // lleno el arraylist con todas las pos de los enemigos
			} else {
				enemigoAct.setPosY(1500);
				if(enemigoAct.getVel() > 0) { //se esta moviendo a la derecha
					enemigoAct.setPosX(1201);
				} else {
					enemigoAct.setPosX(-201);
				}
				posActEn.add(enemigoAct.getPosY());
			}
		}

		if (balas != null) {
			for (Proyectil balaAct : balas) {
				if (!balaAct.isColisione()) {
					posXBs.add(balaAct.getPosX()); // lleno el arraylist con todas las pos x de las balas
					posYBs.add(balaAct.getPosY()); // lleno el arraylist con todas las pos y de las balas
				} else {
					balaAct.setPosY(-100);
					posXBs.add(balaAct.getPosX());
					posYBs.add(balaAct.getPosY());

				}
			}
		}
		if(jugadorAct.getVidas() == 0) {
			perdio.set(0, 1);
		}
		

		puntos.add(jugadorAct.getPuntaje());
		puntos.add(juegoAct.getbDestruidos());

		devolver.add(posActEn);
		devolver.add(posXBs);
		devolver.add(posYBs);
		devolver.add(puntos);
		devolver.add(perdio);

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
			if (!enemigoAct.isDestruido()) {
				moverEnemigo(enemigoAct);
			}
		}

		if (balas != null) {
			for (Proyectil balaAct : balas) {
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
		jugadorAct = new Jugador();
		juegoAct.setModo(modo);
		juegoAct.setNivelAct(nivel);
		empezarJuego();
	}

	public void empezarJuego() {
		crearBarcos();
		balas = new ArrayList<Proyectil>();
		canon = new Cañon();
	}

	public void crearBarcos() {

		enemigos = new ArrayList<ObjetivoEnemigo>();

		int velocidad = juegoAct.getModo() * juegoAct.getNivelAct();
		for (int i = 0; i < 10; i++) { // creo los 10 enemigos
			ObjetivoEnemigo nuevo = new ObjetivoEnemigo(velocidad, i);
			enemigos.add(nuevo);
		}

	}

	public boolean pasoUltimoBarco() {
		if (enemigos.get(9).getVel() > 0) { // barco yendo para la derecha
			if (enemigos.get(9).getPosX() > 1200) {
				if (juegoAct.getbDestruidos() < 5) { // no pasa de nivel
					System.out.println("Reinicio Nivel perdiste una vida");
					jugadorAct.setVidas(jugadorAct.getVidas() - 1);
					juegoAct.reiniciarNivel();
					return true;

				} else {
					juegoAct.pasarNivel();
					jugadorAct.setPuntaje(jugadorAct.getPuntaje() + 100);
					return true;
				}
			}
		} else { // barco yendo a la izquierd
			if (enemigos.get(9).getPosX() < -200) {
				if (juegoAct.getbDestruidos() < 5) { // no pasa de nivel
					jugadorAct.setVidas(jugadorAct.getVidas() - 1);
					System.out.println("Reinicio Nivel perdiste una vida");
					juegoAct.reiniciarNivel();
					return true;
				}
				else {
					juegoAct.pasarNivel();
					jugadorAct.setPuntaje(jugadorAct.getPuntaje() + 100);
					return true;
				}
			}
		}

		return false;
	}

	public void finalizarJuego() {

		return;
	}

	public void moverMiraCañon() {

		return;
	}

	// A partir de aca va el codigo para las colisiones, no estoy seguro de si esta
	// bien, consultar
	public void hayColision() {
		ObjetivoEnemigo enemigoImpactado;
		for (Proyectil bala : balas) {
			enemigoImpactado = bala.colisione(enemigos);
			if (enemigoImpactado != null) {
				enemigoImpactado.setDestruido(true);
				// Si impacto actualizo el puntaje y los enemigos impactados
				Integer actPuntaje = jugadorAct.getPuntaje();
				Integer nuevoPuntaje;
				nuevoPuntaje = actPuntaje + 100;
				jugadorAct.setPuntaje(nuevoPuntaje);

				Integer actBDest = juegoAct.getbDestruidos();
				Integer nuevoBDest;
				nuevoBDest = actBDest + 1;
				juegoAct.setbDestruidos(nuevoBDest);
			}

		}
	}

}