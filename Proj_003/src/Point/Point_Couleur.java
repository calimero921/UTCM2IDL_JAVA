package Point;

public class Point_Couleur extends Point_Base {
	private byte couleur;

	public Point_Couleur(int x, int y, byte couleur) {
		super(x, y);
		this.couleur = couleur;
	}

	public byte getCouleur() {
		return couleur;
	}
	public void setCouleur(byte couleur) {
		this.couleur = couleur;
	}

	public void affiche () {
		super.affiche();
		System.out.println(" de couleur " + this.couleur);
	}
}
