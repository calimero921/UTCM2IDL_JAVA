package TP01;

public class Triangle implements Geometrie {
	private Sommet m1;
	private Sommet m2;
	private Sommet m3;
	
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.m1 = new Sommet(x1, y1);
		this.m2 = new Sommet(x2, y2);
		this.m3 = new Sommet(x3, y3);
	}
	
	public Sommet getM1() {
		return m1;
	}
	public void setM1(Sommet m1) {
		this.m1 = m1;
	}

	public Sommet getM2() {
		return m2;
	}
	public void setM2(Sommet m2) {
		this.m2 = m2;
	}

	public Sommet getM3() {
		return m3;
	}
	public void setM3(Sommet m3) {
		this.m3 = m3;
	}

	@Override
	public void affiche() {
		System.out.println("Triangle : ");
		this.m1.affiche();
		this.m2.affiche();
		this.m3.affiche();
	}
	@Override
	public void translate(int x, int y) {
		this.m1.translate(x, y);
		this.m2.translate(x, y);
		this.m3.translate(x, y);
	}
	@Override
	public void symX() {
		this.m1.symX();
		this.m2.symX();
		this.m3.symX();
	}
	@Override
	public void symY() {
		this.m1.symY();
		this.m2.symY();
		this.m3.symY();
	}
	@Override
	public void symO() {
		this.symX();
		this.symY();
	}
	@Override
	public Geometrie duplicate(int x, int y) {
		Triangle result = new Triangle(this.m1.x, this.m1.y, this.m2.x, this.m2.y, this.m3.x, this.m3.y);
		result.translate(x, y);
		return result;
	}
}
