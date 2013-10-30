package Ville;

public class Prj2_Capitale extends Prj2_Ville {
	private String maire;

	public Prj2_Capitale() {
		/*super();*/
		System.out.println("Création d'une capitale.");
		this.nomVille = "Iconnu";
		this.nomPays = "Inconnu";
		this.nbreHabitant = 0;
		this.maire = "inconnu";
	}
	public Prj2_Capitale(String pNom, int pNbre, String pPays, String pMaire) {
		/*super(pNom, pNbre, pPays);*/
		System.out.println("Initialisation d'une capitale.");
 		this.nomVille = pNom;
		this.nbreHabitant = pNbre;
		this.nomPays = pPays;
		this.maire = pMaire;
	}

	public String getMaire() {
		return maire;
	}
	public void setMaire(String maire) {
		this.maire = maire;
	}
}
