package TP01;

public class Carre implements Geometrie {
	private Sommet m;
	private int w;

	public Carre(int x, int y, int w) {
		this.m = new Sommet(x, y);
		this.w = w;
	}

	public Sommet getM() {
		return m;
	}
	public void setM(Sommet m) {
		this.m = m;
	}

	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	
	@Override
	public void affiche() {
		System.out.println("Carré : ");
		this.m.affiche();
		System.out.println("w = " + this.w);
	}
	@Override
	public void translate (int x, int y) {
		this.m.translate(x, y);
	}
	@Override
	public void symX() {
		this.m.symX();
		this.m.translate(-this.getW(), 0);
	}
	@Override
	public void symY() {
		this.m.symY();
		this.m.translate(0,+this.getW());
	}
	@Override
	public void symO() {
		this.symX();
		this.symY();
	}	
	@Override
	public Geometrie duplicate(int x, int y) {
		Carre result = new Carre(this.m.x, this.m.y, this.w);
		result.translate(x, y);
		return result;
	}
}
