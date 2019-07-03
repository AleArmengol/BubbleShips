package negocio;

public class Jugador {
	
	private int puntaje = 0;
	private int vidas = 1;
	int proximaVida = 300;
	
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
