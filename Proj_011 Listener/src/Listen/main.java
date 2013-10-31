package Listen;

public class main {
	public static void main(String[] args) {
		//créé un objet ligne(Lines)
		//permettant l'abonnement de listener
		Lines ligne = new Lines();

		//créé un objet compte(CharNumber)
		//qui recevra les notification de ligne
		//afin d'afficher des informations sur la saisie
		CharNumber compte = new CharNumber();

		//ajoute un listener pour compte sur l'objet ligne (Lines)
		ligne.addPropertyChangeListener(compte);
		
		//active la lecture du clavier de ligne
		ligne.readKeyboard();
		
		//affiche la chaine concaténée avec les saisies clavier
		System.out.println("chaine = " + ligne.getChaine());
	}	
}
