package q3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Display implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		int newValue;
		if (arg0.getPropertyName().equals("VALUE")){
			newValue = (Integer) arg0.getNewValue();
			if (newValue>=0){
				System.out.println(newValue);
			}
		}
	}

}
