package TP01;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Geometrie table[];
		table = new Geometrie[5];
		Geometrie dupli[];
		dupli = new Geometrie[5];
		
		table[0] = new Sommet(2, 4);
		table[1] = new Cercle(2, 4, 3);
		table[2] = new Carre(2, 4, 3);
		table[3] = new Rectangle(2, 4, 3, 5);
		table[4] = new Triangle(2, 4, 3, 5, 3, 4);
		
		for (int i=0; i< table.length; i++) {
			table[i].affiche();
			table[i].symX();
			table[i].affiche();
			table[i].symY();
			table[i].affiche();
			table[i].symO();
			table[i].affiche();
			dupli[i] = table[i].duplicate(10, 10);
			dupli[i].affiche();
		}
	}
}
