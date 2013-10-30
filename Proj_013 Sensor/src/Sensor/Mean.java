package Sensor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Mean implements PropertyChangeListener{
	public final static String COUNT_NAME="count";
	public final static String AVERAGE_NAME="average";

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

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

	public void propertyChange(PropertyChangeEvent evt) {
		int oldCount = this.count;
		float oldAverage = this.average;
		
		if (evt.getPropertyName().equals(Sensor.VALUE_NAME)){
			total = total + (Integer) evt.getNewValue();
			
			count ++;
			this.pcs.firePropertyChange(this.COUNT_NAME, oldCount, this.count);
			
			average = total/count;
			this.pcs.firePropertyChange(this.AVERAGE_NAME, oldAverage, this.average);
			//System.out.println("Valeur : " + evt.getNewValue() + " => Moyenne : " + average);
		}
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(pcl);
	}
}
