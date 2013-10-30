package Ville;

public class Prj2_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Il y a " + Prj2_Ville.getNbreInstance() + " instance(s) de Ville");
		
		Prj2_Capitale Ville1 = new Prj2_Capitale("Paris", 200, "France", "Delanoe");

		System.out.println("Il y a " + Prj2_Ville.getNbreInstance() + " instance(s) de Ville");
		
		Prj2_Ville Ville2 = new Prj2_Ville();

		System.out.println("Il y a " + Prj2_Ville.getNbreInstance() + " instance(s) de Ville");
		
		Ville2.setNomVille ("Marseille");
		Ville2.setNomPays ("France");
		Ville2.setNbreHabitant (200);
		
		Ville1.Affiche();
		Ville2.Affiche();
	}
}
