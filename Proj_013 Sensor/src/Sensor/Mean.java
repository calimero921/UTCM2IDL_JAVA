package Sensor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

//listener de l'objet sensor et support de listener pour le calcul de moyenne
public class Mean implements PropertyChangeListener{
	//objet permettant la gestion de retour pour des listeners
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	//chaine d'identification pour les retours aux listeners
	public final static String COUNT_NAME="count";
	public final static String AVERAGE_NAME="average";

	//variables locales
	private long total;
	private int count;
	private float average;
	
	public Mean() {
		super();
		total = 0;
		count = 0;
	}

	public long getTotal() {
		return total;
	}
	public int getCount() {
		return count;
	}
	public float getAverage() {
		return average;
	}

	//prise en charge des retours du listener
	public void propertyChange(PropertyChangeEvent evt) {
		int oldCount = this.count;
		float oldAverage = this.average;
		
		//test la valuer du paramètre de retour ()
		if (evt.getPropertyName().equals(Sensor.VALUE_NAME)){
			total = total + (Integer) evt.getNewValue();

			count ++;
			//envoi une notification aux listeners pour le changement de compteur
			this.pcs.firePropertyChange(COUNT_NAME, oldCount, this.count);

			average = total/count;
			//envoi une notification aux listeners pour le calcul de moyenne
			this.pcs.firePropertyChange(AVERAGE_NAME, oldAverage, this.average);
		}
	}
	
	//prise en charge des demande d'abonnement des listeners
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(pcl);
	}
}
