package Sensor;

import java.awt.Color;

public class main {

	public static void main(String[] args) {
		//cr�� un objet pour g�rer la liste de sensor
		SensorModel sensorListe = new SensorModel();
		
		//cr�� une fenetre affichant l'objet sensorListe 
		SensorListFrame frame = new SensorListFrame(sensorListe, 700, 300, "Affichage des capteurs", Color.BLACK, Color.WHITE);
	}
}