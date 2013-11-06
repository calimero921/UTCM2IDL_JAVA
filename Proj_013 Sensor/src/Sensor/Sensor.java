package Sensor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;
import java.util.Timer;

//support de listener pour les sensors
public class Sensor {
	//objet permettant la gestion de retour pour des listeners
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	//chaine d'identification pour les retours aux listeners
	public final static String VALUE_NAME="value";

	//variables locales
	private String name;
	private long delay;
	private long interval;
	private int value;
	private	Timer t = new Timer();
	private Random randomGenerator = new Random();
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
	public String toString() {
		return name;
	}
	public void start(){
		if (this.interval>0 && !started) {
			//activation d'un timer pour mettre à jour la valeur du sensor
			//après le délai et dans l'interval paramétrés
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
	//appelé par le timer activé dans start
	public void action(){
		int oldValue = this.value;
		this.value = randomGenerator.nextInt(11) + 5;
		//envoi une notification aux listeners pour le changement de valeur
		this.pcs.firePropertyChange(VALUE_NAME, oldValue, this.value);
	}
	
	//prise en charge des demandes d'abonnement des listeners
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(pcl);
	}
}