package Listen;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

public class Lines{
	//objet de support des listener clients
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	//chaine permettant de de nommer les param�tres de retour du support
	public final static String CHARNUMBER="charNumber";
	public final static String CHAINE="chaine";

	//variable internes de gestion des donn�es
	private String chaine;
	private int charNumber;
	
	public Lines() {
		this.chaine = "";
		this.charNumber = 0;
	}

	public String getChaine() {
		return chaine;
	}

	public int getCharNumber() {
		return charNumber;
	}

	public void readKeyboard(){
		String tempo;
		int oldCharNumber = this.charNumber;
		String oldChaine = this.chaine;
	
		//active l'�coute de l'entr�e system.in (clavier)
		Scanner clavier = new Scanner(System.in);
			
		//attends jusqu'� l'appuye sur une touche entr�e pour une fin de chaine
		tempo = clavier.nextLine();
		
		//boucle tant que la ligne saisie n'est pas vide
		while(tempo.length() > 0) {
			//ajoute la chaine d�tect�e � la chaine globale
			this.chaine += tempo;
			//attends jusqu'� l'appuye sur une touche entr�e pour une fin de chaine
			tempo = clavier.nextLine();
		}
		//une ligne vide � �t� d�tect�e (fin de saisie)
		clavier.close();

		//active un �v�nement attendu par le listener avec la chaine en param�tre
		this.pcs.firePropertyChange(CHAINE, oldChaine, this.chaine);
		this.charNumber = this.chaine.length();
		
		//active un �v�nement attendu par le listener avec la longueur de chaine en param�tre
		this.pcs.firePropertyChange(CHARNUMBER, oldCharNumber, this.charNumber);
	}

	//permet l'abonnement des listeners
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(pcl);
	}
}
