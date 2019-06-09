package negocio;

import java.util.Random;

public class ObjetivoEnemigo {
	private int posX;
	private int posY;
	private final int width = 200;
	private final int height = 200;
	private int delay;
	private int vel;
	private String pathImagen;
	private Random r;
	
	public ObjetivoEnemigo(int nivel, int d) {
		r = new Random();
		int factor = 10; //factor de velocidad
		int rand = r.nextInt(2); //genero un random para determinar la direccion del enemigo
		//int randDelay = r.nextInt(6) + 1; // segundos a esperar hasta que salga cada enemigo va de 1 a 10
		delay =  d * 3;
		if(rand == 0) {
			vel = -1 * factor * nivel; // el enemigo recorre la pantalla de derecha a izquierda
			posX = 1050;
			posY = 50;
			pathImagen = "imagenes\\veleroBack.gif";
		} else {
			vel = factor * nivel; // el enemigo recorre la pantalla de izquierda a derecha
			posX = -250;
			posY = 200;
			pathImagen = "imagenes\\velero.gif";
		}
	}
	
	public int mover(int tiempoTransc) {
		int nuevaPos = getPosX() + getVel();
		if(tiempoTransc > delay) {
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
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	private boolean destruido;
	
	
}
