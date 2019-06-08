package negocio;


import java.util.*;

/**
 * 
 */
public class Cañon {

	Proyectil bala;
    /**
     * Default constructor
     */
    public Cañon() {
    }

    /**
     * 
     */
    private int posX;

    /**
     * 
     */
    private int posY;

    /**
     * 
     */
    private int tiempoEspera;

    /**
     * 
     */
    private float potenciaDispario;





    /**
     * @param posX 
     * @param posY 
     * @return
     */
    public Proyectil disparar(float angulo, int potencia) {
        
    	bala = new Proyectil(angulo, potencia);
    	
    	return bala;
    }

    /**
     * @param angulo 
     * @return
     */
    public void moverMira(float angulo) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public boolean puedoDisparar() {
        // TODO implement here
        return false;
    }

}