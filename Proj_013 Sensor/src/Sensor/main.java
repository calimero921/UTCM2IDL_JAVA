package Sensor;

import java.awt.Color;

public class main {

	public static void main(String[] args) {
		SensorModel sensorListe = new SensorModel();
		SensorListFrame frame = new SensorListFrame(sensorListe, 700, 300, "Affichage des capteurs", Color.BLACK, Color.WHITE);
	}
}