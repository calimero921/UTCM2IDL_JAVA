package Ville;

/**
 * @author formationa02
 *
 */
public class Prj2_Ville {
	protected String nomVille;
	protected String nomPays;
	protected int nbreHabitant;
	private static int nbreInstance = 0;
	
	public Prj2_Ville(){
		System.out.println("Création d'une ville.");
		this.nomVille = "Iconnu";
		this.nomPays = "Inconnu";
		this.nbreHabitant = 0;
		Prj2_Ville.nbreInstance++;
	}
	public Prj2_Ville(String pNom, int pNbre, String pPays){
		System.out.println("Initialisation d'une ville.");
		this.nomVille = pNom;
		this.nomPays = pPays;
		this.nbreHabitant = pNbre;
		Prj2_Ville.nbreInstance++;
	}

	public static int getNbreInstance() {
		return nbreInstance;
	}
	public static void setNbreInstance(int nbreInstance) {
		Prj2_Ville.nbreInstance = nbreInstance;
	}

	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public String getNomPays() {
		return nomPays;
	}
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	public int getNbreHabitant() {
		return nbreHabitant;
	}
	public void setNbreHabitant(int nbreHabitant) {
		this.nbreHabitant = nbreHabitant;
	}
	
	public void Affiche(){
		System.out.println("La ville de " + nomVille + " est en " + nomPays + " et possède " + nbreHabitant + " habitant(s)");
	}
}
