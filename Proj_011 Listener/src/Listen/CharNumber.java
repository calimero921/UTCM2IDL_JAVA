package Listen;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//cr�ation d'un objet ChaNumber qui recevra des notification
public class CharNumber implements PropertyChangeListener{

	//prise en charge des notifications
	public void propertyChange(PropertyChangeEvent evt) {
		//identification du type de retour grace au nom

		//il s'agit d'un retour pour "charNumber" 
		if (evt.getPropertyName().equals(Lines.CHARNUMBER)){
			System.out.println(Lines.CHARNUMBER + " : de " + evt.getOldValue() + " à " + evt.getNewValue() + " caractere(s).");
		}
		
		//il s'agit d'un retour pour "chaine" 
		if (evt.getPropertyName().equals(Lines.CHAINE)){
			System.out.println(Lines.CHAINE + " : de " + evt.getOldValue() + " à " + evt.getNewValue() + ".");
		}
	}
}
