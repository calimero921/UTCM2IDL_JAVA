package Point;

public class Point_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point_Base p = new Point_Base(3, 5);
		p.affiche();
		
		Point_Couleur pc = new Point_Couleur(4, 8, (byte) 2);
		pc.affiche();
		
		p = pc;
		p.affiche();
		
		p = new Point_Base(5, 7);
		p.affiche();
		p.deplace(3, 4);
		p.affiche();
		
		Point_Base table[] = new Point_Base[4];
		table[0] = new Point_Base(0,2);
		table[1] = new Point_Couleur(1, 5, (byte) 3);
		table[2] = new Point_Couleur(8, 9, (byte) 5);
		table[3] = new Point_Base(0, 2);
		for (int i = 0; i< table.length; i++)
			table[i].affiche();
	}
}
