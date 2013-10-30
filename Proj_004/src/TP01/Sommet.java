package TP01;

public class Sommet implements Geometrie {
	protected int x;
	protected int y;
	
	public Sommet(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void affiche() {
		System.out.println("Sommet x = " + this.x + ", y = " + this.y);
	}
	@Override
	public void translate (int x, int y) {
		setX (getX() + x);
		setY (getY() + y);
	}
	@Override
	public void symX() {
		setX(-getX());
	}
	@Override
	public void symY() {
		setY(-getY());
	}
	@Override
	public void symO() {
		this.symX();
		this.symY();
	}

	@Override
	public Geometrie duplicate(int x, int y) {
		Sommet result = new Sommet(this.x, this.y);
		result.translate(x, y);
		return result;
	}
}
