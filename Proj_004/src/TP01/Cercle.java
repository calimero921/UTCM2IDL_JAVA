package TP01;

public class Cercle implements Geometrie {
	private Sommet c;
	private int r;
	
	public Cercle(int x, int y, int r) {
		this.c = new Sommet(x, y);
		this.r = r;
	}

	public Sommet getC() {
		return c;
	}
	public void setC(Sommet c) {
		this.c = c;
	}

	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	
	@Override
	public void affiche() {
		System.out.println("Cercle : ");
		this.c.affiche();
		System.out.println("r = " + this.r);
	}
	@Override
	public void translate (int x, int y) {
		this.c.translate(x, y);
	}
	@Override
	public void symX() {
		this.c.symX();
	}
	@Override
	public void symY() {
		this.c.symY();
	}
	@Override
	public void symO() {
		this.symX();
		this.symY();
	}	
	@Override
	public Geometrie duplicate(int x, int y) {
		Cercle result = new Cercle(this.c.x, this.c.y, this.r);
		result.translate(x, y);
		return result;
	}
}
