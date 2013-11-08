package q3;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DisplayFrame extends JFrame implements PropertyChangeListener {
    JPanel mainPanel;
    JTextArea display;
	public DisplayFrame() throws HeadlessException {
		super();
		initialize();
	}
	public DisplayFrame(String title) throws HeadlessException {
		super(title);
		initialize();
	}
	public void initialize() {
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setMainPane();
		setVisible(true);
	}
	private void setMainPane() {
		mainPanel = new JPanel();
		display = new JTextArea();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(new JScrollPane(display));
		setContentPane(mainPanel);
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		
	}

  
}
