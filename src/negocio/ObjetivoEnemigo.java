package negocio;

import java.util.Random;

public class ObjetivoEnemigo {
	private int posX;
	private int posY;
	private int delay;
	private int vel;
	private String pathImagen;
	private Random r;
	
	public ObjetivoEnemigo(int nivel) {
		r = new Random();
		int factor = 10; //factor de velocidad
		int rand = r.nextInt(2); //genero un random para determinar la direccion del enemigo
		int randDelay = r.nextInt(3) + 1; // segundos a esperar hasta que salga cada enemigo
		delay = randDelay;
		if(rand == 0) {
			vel = -1 * factor * nivel; // el enemigo recorre la pantalla de derecha a izquierda
			posX = 850;
			posY = 50;
			pathImagen = "imagenes\\veleroBack.gif";
		} else {
			vel = factor * nivel; // el enemigo recorre la pantalla de izquierda a derecha
			posX = -250;
			posY = 200;
			pathImagen = "imagenes\\velero.gif";
		}
	}
	
	public int mover(int segContador) {
		int nuevaPos = getPosX() + getVel();
		if(segContador > delay) {
			setPosX(nuevaPos);
			return nuevaPos;
		}
		return getPosX();
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getVel() {
		return vel;
	}
	public void setVel(int vel) {
		this.vel = vel;
	}
	public boolean isDestruido() {
		return destruido;
	}
	public void setDestruido(boolean destruido) {
		this.destruido = destruido;
	}
	public String getPathImagen() {
		return pathImagen;
	}
	
	public void setPathImagen(String pathImagen) {
		this.pathImagen = pathImagen;
	}
	private boolean destruido;
	
	
}
