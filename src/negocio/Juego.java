package negocio;

public class Juego {

	private String nombre = "BubbleShips";

	private int nivelAct;
	private int modo;
	private int tiempo;

	public Juego() {
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
