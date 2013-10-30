package TP01;

public class Rectangle implements Geometrie {
	private Sommet m;
	private int w;
	private int h;

	public Rectangle(int x, int y, int w, int h) {
		this.m = new Sommet(x, y);
		this.w = w;
		this.h =h;
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
	
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}

	@Override
	public void affiche() {
		System.out.println("Rectangle :");
		this.m.affiche();
		System.out.println("w = " + this.w + ", h = " + this.h);
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
		this.m.translate(0,+this.getH());
	}
	@Override
	public void symO() {
		this.symX();
		this.symY();
	}	
	@Override
	public Geometrie duplicate(int x, int y) {
		Rectangle result = new Rectangle(this.m.x, this.m.y, this.w, this.h);
		result.translate(x, y);
		return result;
	}
}
