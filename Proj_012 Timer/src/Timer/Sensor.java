package Timer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;
import java.util.Timer;

public class Sensor {
	public final static String VALUE_NAME="value";

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	private Random randomGenerator = new Random();
	private int value;
	private long delay;
	private long interval;
	
	public Sensor(int delay, int interval) {
		super();
		this.delay = delay;
		this.interval = interval;
	}

	public void start(){
		Timer t = new Timer();
		t.schedule(new SensorTask(this), this.delay, this.interval);	
	}

	public void action(){
		int oldValue = this.value;
		this.value = randomGenerator.nextInt(11) + 5;
		//System.out.println("valeur = " + this.value);
		this.pcs.firePropertyChange(VALUE_NAME, oldValue, this.value);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(pcl);
	}
}