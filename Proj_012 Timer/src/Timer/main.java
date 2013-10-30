package Timer;

import java.awt.Color;

public class main {
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		Sensor capteur1 = new Sensor(0,1000);
		Sensor capteur2 = new Sensor(250,1000);
		Sensor capteur3 = new Sensor(500,1000);
		Sensor capteur4 = new Sensor(750,1000);

		Mean moyenne = new Mean();
		
		capteur1.addPropertyChangeListener(moyenne);
		capteur2.addPropertyChangeListener(moyenne);
		capteur3.addPropertyChangeListener(moyenne);
		capteur4.addPropertyChangeListener(moyenne);

		Fenetre fenetre = new Fenetre(500, 200, "Affichage des capteurs", Color.BLACK, Color.WHITE);
		moyenne.addPropertyChangeListener(fenetre);
		
		capteur1.start();
		capteur2.start();
		capteur3.start();
		capteur4.start();
	}
}
