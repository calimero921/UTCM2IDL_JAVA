package TP01;

public interface Geometrie {
	public void affiche();
	public void translate (int x, int y);
	public void symX();
	public void symY();
	public void symO();
	public Geometrie duplicate(int x, int y);
}
