package Listen;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CharNumber implements PropertyChangeListener{
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Lines.CHARNUMBER)){
			System.out.println(Lines.CHARNUMBER + " : de " + evt.getOldValue() + " à " + evt.getNewValue() + " caractere(s).");
		}
		if (evt.getPropertyName().equals(Lines.CHAINE)){
			System.out.println(Lines.CHAINE + " : de " + evt.getOldValue() + " à " + evt.getNewValue() + ".");
		}
	}
}
