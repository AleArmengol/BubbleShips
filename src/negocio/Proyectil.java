package negocio;

import java.util.*;

public class Proyectil {
	
	ArrayList<ObjetivoEnemigo> enemigos;
	
	private int posX;
	private int posY;
	private final int height = 50;
	private final int width = 50;
	private int vel;
	private int factor = 1;
	private double angulo;
	private float pendiente;
	//private float tiempo; // para que sirve??

    public Proyectil(float angulo, int potencia) {
    	//this.angulo = Math.toRadians(this.angulo);
    	this.angulo = potencia;
    	//this.pendiente = (float) Math.tan(anguloRad);
    	this.vel = potencia;
    	this.posX = 459;
    	this.posY = 652;
    }




    public void recorrerPantalla() {
    	int nuevaPosX = this.posX + vel;
    	int nuevaPosY = this.posY - vel;
    	setPosX(nuevaPosX);
    	setPosY(nuevaPosY);
    	
    }

    public boolean colisione(ArrayList<ObjetivoEnemigo> enems) {
    	
        return false;
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
}
