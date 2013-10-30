package Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame implements PropertyChangeListener {
	private int width;
	private int height;
	private String titre;
	private Color foreground;
	private Color background;

	private JPanel pan = new JPanel();
	private JLabel labelNombre = new JLabel("Nombre  :");
	private JLabel labelMoyenne = new JLabel("Moyenne :");
	private JTextField textfieldNombre = new JTextField(10);
	private JTextField textfieldMoyenne = new JTextField(10);

	public Fenetre() {
		super();
		this.width = 500;
		this.height = 200;
		this.titre = "Test de fenetre";
		this.foreground = Color.BLUE;
		this.background = Color.ORANGE;
		init();
	}
	public Fenetre(int w, int h, String titre, Color f, Color b){
		super();
		this.width = w;
		this.height = h;
		this.titre = titre;
		this.foreground = f;
		this.background = b;
		init();
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Color getForeground() {
		return foreground;
	}
	public void setForeground(Color foreground) {
		this.foreground = foreground;
	}
	public Color getBackground() {
		return background;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
	
	private void init(){
		this.setSize(this.width, this.height);
		this.setTitle(this.titre);
		
		//met au millieu de l'écran
		this.setLocationRelativeTo(null);
		
		//création d'un JPanel
		this.pan.setForeground(this.foreground);
		this.pan.setBackground(this.background);
		
		
		//mise en forme des box
		Box globalBox = Box.createVerticalBox();

		Box topBox = Box.createHorizontalBox();
		topBox.add(this.labelNombre);
		topBox.add(this.textfieldNombre);
		globalBox.add(topBox,BorderLayout.NORTH);

		Box bottomBox = Box.createHorizontalBox();
		bottomBox.add(this.labelMoyenne);
		bottomBox.add(this.textfieldMoyenne);
		globalBox.add(bottomBox,BorderLayout.SOUTH);
		
		//met le JPanel en fond de fenetre
		this.pan.add(globalBox,BorderLayout.CENTER);
		this.setContentPane(pan);
		
		//indique de terminer le programme en quittant la fenetre.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(Mean.COUNT_NAME)){
			this.textfieldNombre.setText(evt.getNewValue().toString());
		}
		if (evt.getPropertyName().equals(Mean.AVERAGE_NAME)){
			this.textfieldMoyenne.setText(evt.getNewValue().toString());
		}
	}
}
