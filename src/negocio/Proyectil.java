package negocio;

import java.util.*;

public class Proyectil {
	
	ArrayList<ObjetivoEnemigo> enemigos;
	
	private int posX;
	private int posY;
	private boolean colisione = false;

	private final int height = 50;
	private final int width = 50;
	private int vel;
	private float decActX = 0; //guardan los decimales sobrantes de las operaciones ya que no se puede dibujar en pixeles con decimales
	private float decActY = 0; //cuando estos sobrantes sean mayor a 1, se agrega una unidad a la pos correspondiente
	private float catX;
	private float catY;
	private double angulo;
	//private float tiempo; // para que sirve??

    public Proyectil(float angulo, int potencia) {
    	
    	this.angulo = Math.toRadians(angulo);
    	int hip = potencia;
    	catX = (float) Math.cos(this.angulo) * hip;
    	catY = (float) Math.sin(this.angulo) * hip;
    	this.vel = potencia;
    	this.posX = 459;
    	this.posY = 652;
    }

    public boolean isColisione() {
    	return colisione;
    }



    public void recorrerPantalla() {
    	decActX += Math.abs(catX) - Math.abs((int) catX); //.54
    	decActY += Math.abs(catY) - (int) catY;
    	int nuevaPosX = this.posX + (int) catX;
    	int nuevaPosY = this.posY - (int) catY;
    	if(decActX > 1) {
    		if(catX < 0) {
    			nuevaPosX--;
    		} else {    			
    			nuevaPosX++;
    			decActX -= 1;
    		}
    	}
    	if(decActY > 1) {
    		nuevaPosY++;
    		decActY -= 1;
    	}
    	setPosX(nuevaPosX);
    	setPosY(nuevaPosY);
    	
    }

    public ObjetivoEnemigo colisione(ArrayList<ObjetivoEnemigo> enems) {
    	if(this.posX > 0 && this.posX < 1000) { //para que no le pegue a los enemigos que estan fuera de la pantalla
	    	for (ObjetivoEnemigo act : enems) {
	    		if(this.posY <= act.getPosY() + act.getHeight() && this.posX >= act.getPosX() && this.posX + this.width <= act.getPosX() + act.getWidth() && this.posY > act.getPosY() ) {
	    			System.out.println("Colisiono");
	    			this.colisione = true;
	    			return act;
	    		}
	    	}
    	}
    	return null;
    	
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
