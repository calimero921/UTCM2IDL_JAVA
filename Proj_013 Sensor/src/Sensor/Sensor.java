package Sensor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;
import java.util.Timer;

public class Sensor {
	public final static String VALUE_NAME="value";

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	private String name;
	private long delay;
	private long interval;
	private	Timer t = new Timer();
	private Random randomGenerator = new Random();
	private int value;
	private boolean started = false;
	
	public Sensor() {
		super();
		this.name = "";
		this.delay = 0;
		this.interval = 0;
	}
	public Sensor(String name) {
		super();
		this.name = name;
		this.delay = 0;
		this.interval = 0;
	}
	public Sensor(String name, long delay, long interval) {
		super();
		this.name = name;
		this.delay = delay;
		this.interval = interval;
		start();
	}

	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getDelay() {
		return delay;
	}
	public void setDelay(long delay) {
		this.delay = delay;
	}

	public long getInterval() {
		return interval;
	}
	public void setInterval(long interval) {
		stop();
		this.interval = interval;
		start();
	}

	public void setTimerInfos(long delay, long interval) {
		setDelay(delay);
		setInterval(interval);
	}

	public void start(){
		if (this.interval>0 && !started) {
			t.schedule(new SensorTask(this), this.delay, this.interval);
			started = true;
		}
	}
	public void stop(){
		if(started) {
			t.cancel();
			t.purge();
			started = false;
		}
	}

	public void action(){
		int oldValue = this.value;
		this.value = randomGenerator.nextInt(11) + 5;
		//System.out.println("valeur = " + this.value);
		this.pcs.firePropertyChange(this.VALUE_NAME, oldValue, this.value);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(pcl);
	}
}