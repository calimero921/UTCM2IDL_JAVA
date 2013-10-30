package Sensor;

import java.util.TimerTask;

public class SensorTask extends TimerTask{
	Sensor model;
	
	public SensorTask(Sensor m){
		this.model = m;
	}

	@Override
	public void run(){
		model.action();
	}
}
