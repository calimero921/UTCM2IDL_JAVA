package Sensor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SensorModel {
	public final static String SELECT_NAME="sensor";

	private PropertyChangeSupport pcs;
	private DefaultListModel sensorList;
	private Mean moyenne;

	public SensorModel(){
		pcs = new PropertyChangeSupport(this);
		sensorList = new DefaultListModel();
		moyenne = new Mean();
		bindMean();
	}

	public DefaultListModel getSensorList() {
		return this.sensorList;
	}
	public void setSensorListe(DefaultListModel sensorList) {
		this.sensorList = sensorList;
	}
	
	public boolean existsElement(String name) {
		boolean result = false;
		Sensor local;
		//parcours la liste à la recherche d'un élément portant le nom de name
		for (int index = 0; index < this.sensorList.getSize(); index++) {
			local = (Sensor) this.sensorList.getElementAt(index);
			if (local.getName().equals(name)) {
				result = true;
			}
		}
		return result;
	}
	public void addElement(Sensor newSensor) {
		this.sensorList.addElement(newSensor);
	}
	public void updateElement(int index, Sensor newSensor){
		this.sensorList.set(index, newSensor);
	}
	public void deleteElement(int index) {
		if (!this.sensorList.isEmpty()){
			if (index >= 0 && index < this.sensorList.getSize()) {
				this.sensorList.remove(index);
			}
		}
	}
	public void selectElement(int index) {
		if (!this.sensorList.isEmpty()) {
			if (index >= 0 && index < this.sensorList.getSize()) {
				this.pcs.firePropertyChange(SensorModel.SELECT_NAME, null, this.sensorList.getElementAt(index));
			}
		}
	}

	public Mean getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(Mean moyenne) {
		this.moyenne = moyenne;
	}

	public void openFile(String filename){
		Sensor local;
		
		//arrêt des timers
		for (int index = 0; index < this.sensorList.getSize(); index++) {
			local = (Sensor) this.sensorList.getElementAt(index);
			local.stop();
		}
		
		//vidage de la sensorList
		this.sensorList.removeAllElements();

		//lit les éléments du fichier
		JsonFactory j = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper();
		JsonParser jp;

		try {
			jp = j.createParser(new File(filename));
			jp.nextToken();
			while (jp.nextToken() == JsonToken.START_OBJECT){
				local = mapper.readValue(jp, Sensor.class);
				this.sensorList.addElement(local);
				//System.out.println(localSensor.toString());				
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		bindMean();
	}
	public void saveFile(String filename){
		List<Sensor> liste = new ArrayList<Sensor>();
		for (int index = 0; index < this.sensorList.getSize(); index++) {
			liste.add((Sensor) this.sensorList.elementAt(index));
		}
			
		ObjectMapper mapper = new ObjectMapper();

		try {
			File f = new File(filename);
			mapper.writeValue(f, liste);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void bindMean(){
		Sensor local;
		for (int index = 0; index < this.sensorList.getSize(); index++) {
			local = (Sensor) this.sensorList.elementAt(index);
			local.addPropertyChangeListener(moyenne);
		}
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		this.pcs.addPropertyChangeListener(pcl);
	}
}
