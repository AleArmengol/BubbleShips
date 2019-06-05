package negocio;

public class Juego {

	private String nombre = "BubbleShips";
	private int nivelAct;

	public Juego(int primerNivel) {
		this.nivelAct = primerNivel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivelAct() {
		return nivelAct;
	}

	public void setNivelAct(int nivelAct) {
		this.nivelAct = nivelAct;
	}

	public void siguienteNivel() {
		nivelAct++;
	}

	public void reiniciarNivel() {

		return;
	}

}
