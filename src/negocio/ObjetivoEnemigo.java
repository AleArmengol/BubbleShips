package negocio;

public class ObjetivoEnemigo {
	private int posX;
	private int posY;
	private float vel;
	private boolean destruido;
	
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
	public float getVel() {
		return vel;
	}
	public void setVel(float vel) {
		this.vel = vel;
	}
	public boolean isDestruido() {
		return destruido;
	}
	public void setDestruido(boolean destruido) {
		this.destruido = destruido;
	}
	
	
}
