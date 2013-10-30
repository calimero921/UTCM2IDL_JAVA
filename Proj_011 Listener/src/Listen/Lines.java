package Listen;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Scanner;

public class Lines{
	public final static String CHARNUMBER="charNumber";
	public final static String CHAINE="chaine";

	private String chaine;
	private int charNumber;
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

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
	
		Scanner clavier = new Scanner(System.in);
			
		tempo = clavier.nextLine();
		while(tempo.length() > 0) {
			this.chaine += tempo;
			tempo = clavier.nextLine();
		}
		clavier.close();

		this.pcs.firePropertyChange(this.CHAINE, oldChaine, this.chaine);
		this.charNumber = this.chaine.length();
		this.pcs.firePropertyChange(this.CHARNUMBER, oldCharNumber, this.charNumber);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(pcl);
	}
}
