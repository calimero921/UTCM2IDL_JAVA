package Listen;

public class main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lines ligne = new Lines();
		CharNumber compte = new CharNumber();
		ligne.addPropertyChangeListener(compte);
		
		ligne.readKeyboard();
		System.out.println("chaine = " + ligne.getChaine());
	}	
}
