package JSON;

public class Ville {
	private String nom;
	private int nbreHabitants;
	
	public Ville() {
		super();
	}
	public Ville(String nom, int nbreHabitants) {
		super();
		this.nom = nom;
		this.nbreHabitants = nbreHabitants;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbreHabitants() {
		return nbreHabitants;
	}
	public void setNbreHabitants(int nbreHabitants) {
		this.nbreHabitants = nbreHabitants;
	}
	public String toString(){
		return "Ville : " + this.nom + ", Habitants : " + this.nbreHabitants;
	}
}
