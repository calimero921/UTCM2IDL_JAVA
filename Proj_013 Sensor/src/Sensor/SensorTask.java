package Sensor;

import java.util.TimerTask;

//activation de timer pour les sensors 
public class SensorTask extends TimerTask{
	Sensor model;
	
	public SensorTask(Sensor m){
		//associe le timer à l'objet en paramètre
		this.model = m;
	}

	@Override
	public void run(){
		//appel la propriété action de l'objet en paramètre
		//en fonction des paramètres de l'initialisation
		model.action();
	}
}
