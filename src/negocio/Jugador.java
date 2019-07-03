package negocio;

public class Jugador {
	
	private int puntaje = 0;
<<<<<<< HEAD
	private int vidas = 1;
	int proximaVida = 300;
=======
	private int vidas = 0; 
>>>>>>> 421ffaa23b4909c9296138246a614d9903ba1aa5
	
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
		aumentarVida();
	}
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	private void aumentarVida() {
		if(this.puntaje >= proximaVida) {
			proximaVida += 300;
			this.vidas += 1;
			System.out.println("SUMASTE UNA VIDA, AHORA TENES: " + this.vidas);
		}
		
	}

}
