package q3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Random;

public class Values {
	public static int DELAY = 1000;
	PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	private ArrayList<Integer> getDefaultVal() {
		Random r = new Random();
		ArrayList<Integer> v = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			v.add(Math.abs(r.nextInt()) % 21 - 10);
		}
		return v;
	}

	public void sendValues() {
		int oldValue = 0;
		int newValue;
		ArrayList<Integer> val = getDefaultVal();
		for (Integer n : val) {
			/*
			 * Affichage des valeurs
			 */
			newValue = n;
			this.pcs.firePropertyChange("VALUE", oldValue, newValue);
			//System.out.println(n);
			try {
				/*
				 * Temporise DELAY millisecondes
				 */
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pcs.addPropertyChangeListener(pcl);
	}
}
