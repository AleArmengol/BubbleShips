package negocio;

public class Juego {

	private String nombre = "BubbleShips";

	private int nivelAct;
	private int modo;
	private int tiempo;
	private int puntaje = 0;
	private int bDestruidos = 0;





	public Juego() {
	}
	
	
	public int getbDestruidos() {
		return bDestruidos;
	}
	
	public void setbDestruidos(int bDestruidos) {
		this.bDestruidos = bDestruidos;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	
	
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	
	
	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public int getNivelAct() {
		return nivelAct;
	}
	
	public void setNivelAct(int nivelAct) {
		this.nivelAct = nivelAct;
	}
	
	public int getModo() {
		return modo;
	}
	
	public void setModo(int modo) {
		this.modo = modo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void siguienteNivel() {
		nivelAct++;
	}

	public void reiniciarNivel() {

		return;
	}


}
