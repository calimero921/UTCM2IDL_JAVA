package Swing;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	public Panneau(){
		super();
	}
	
	public void paintComponent (Graphics g) {
		int x1 = this.getWidth()/4;
		int x2 = this.getHeight()/4;
		
		g.fillOval(x1, x2, this.getWidth()/2, this.getHeight()/2);
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
		g.drawLine(this.getWidth(), 0, 0, this.getHeight());
		g.drawRect(x1, x2, this.getWidth()/2, this.getHeight()/2);
	}
}
