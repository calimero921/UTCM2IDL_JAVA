package Sensor;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SensorMeanPane extends JPanel{
	private JTextField textfieldCount = new JTextField(20);
	private JTextField textfieldMean = new JTextField(20);

	public SensorMeanPane() {
		Box leftBox = Box.createVerticalBox();
		leftBox.add(new JLabel("Nombre :"));
		leftBox.add(new JLabel("Moyenne :"));

		Box rightBox = Box.createVerticalBox();
		rightBox.add(this.textfieldCount);
		rightBox.add(this.textfieldMean);
		
		//met le JPanel en fond de fenetre
		this.add(leftBox,BorderLayout.EAST);
		this.add(rightBox,BorderLayout.CENTER);	
	}

	public String getCount() {
		return textfieldCount.getText();
	}
	public void setCount(String Count) {
		this.textfieldCount.setText(Count);
	}

	public String getMean() {
		return textfieldMean.getText();
	}
	public void setMean(String Mean) {
		this.textfieldMean.setText(Mean);
	}
}
