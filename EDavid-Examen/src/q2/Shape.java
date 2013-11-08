package q2;

public class Shape {
	String nom;
	Integer nbCote;

	public Shape() {
		this.nom = "sans";
		this.nbCote = -1;
	}
	public Shape(String nom, Integer nbCote) {
		this.nom = nom;
		this.nbCote = nbCote;
	}

	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNbCote() {
		return this.nbCote;
	}
	public void setNbCote(Integer nbCote) {
		this.nbCote = nbCote;
	}

	public String toString() {
		return "Shape : nom=" + this.nom + ", nbCote=" + this.nbCote;
	}
}
