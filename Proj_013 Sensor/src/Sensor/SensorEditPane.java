package Sensor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SensorEditPane extends JPanel implements ActionListener {
	private JTextField textfieldName = new JTextField(20);
	private JTextField textfieldDelay = new JTextField(20);
	private JTextField textfieldInterval = new JTextField(20);
	private JButton validateButton = new JButton("Valider");
	private SensorListFrame frame;

	public SensorEditPane(SensorListFrame frame){
		this.frame = frame;
		
		Box leftBox = Box.createVerticalBox();
		leftBox.add(new JLabel("Nom :"));
		leftBox.add(new JLabel("Retard :"));
		leftBox.add(new JLabel("Frequence :"));
		this.add(leftBox,BorderLayout.EAST);

		Box rightBox = Box.createVerticalBox();
		rightBox.add(this.textfieldName);
		rightBox.add(this.textfieldDelay);
		rightBox.add(this.textfieldInterval);
		this.add(rightBox,BorderLayout.CENTER);	
		
		validateButton.addActionListener(this);
		this.add(validateButton,BorderLayout.SOUTH);
	}

	public Sensor getSensor() {
		return new Sensor(textfieldName.getText(), 
				Long.parseLong(textfieldDelay.getText()), 
				Long.parseLong(textfieldInterval.getText()));
	}
	public void setSensor(Sensor localSensor) {
		textfieldName.setText(localSensor.getName());
		textfieldDelay.setText(Long.toString(localSensor.getDelay()));
		textfieldInterval.setText(Long.toString(localSensor.getInterval()));
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource().equals(validateButton)){
			frame.validateEdit(getSensor());
		}
	}
}
