package Sensor;

import java.util.TimerTask;

//activation de timer pour les sensors 
public class SensorTask extends TimerTask{
	Sensor model;
	
	public SensorTask(Sensor m){
		//associe le timer � l'objet en param�tre
		this.model = m;
	}

	@Override
	public void run(){
		//appel la propri�t� action de l'objet en param�tre
		//en fonction des param�tres de l'initialisation
		model.action();
	}
}
