package negocio;

import java.util.*;

public class Proyectil {
	
	ArrayList<ObjetivoEnemigo> enemigos;
	private int posX;

	private int posY;
	private int vel;
	private float angulo;
	private float pendiente;
	private float tiempo; // para que sirve??

    public Proyectil(float angulo, int potencia) {
    	this.angulo = angulo;
    	float anguloRad = (float) Math.toRadians(this.angulo);
    	this.pendiente = (float) Math.tan(anguloRad);
    	this.vel = potencia;
    	this.posX = 459;
    	this.posY = 652;
    }




    public void recorrerPantalla() {
    	int nuevaPosX = (int) ((this.posX * pendiente) + vel);
    	int nuevaPosY = (int) (this.posY - vel);
    	setPosX(nuevaPosX);
    	setPosY(nuevaPosY);
    	
    }

    public boolean colisione() {
        // TODO implement here
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
