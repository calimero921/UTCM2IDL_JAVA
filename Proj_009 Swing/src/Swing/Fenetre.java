package Swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements ActionListener {
	private int width;
	private int height;
	private String titre;
	private Color foreground;
	private Color background;

	private Panneau pan = new Panneau();
	private JButton boutonOk = new JButton("Ok");
	private JButton boutonCancel = new JButton("Annuler");
	private JMenuItem openItem = new JMenuItem("Open");
	private JMenuItem quitItem = new JMenuItem("Quit");
	
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
		JMenuBar menu = new JMenuBar();
		JMenu mainMenu = new JMenu("Fichier");

		this.setSize(this.width, this.height);
		this.setTitle(this.titre);
		
		//met au millieu de l'écran
		this.setLocationRelativeTo(null);
		
		//création d'un JPanel
		this.pan.setForeground(this.foreground);
		this.pan.setBackground(this.background);

		//Creation du menu
		openItem.addActionListener(this);
		quitItem.addActionListener(this);
		mainMenu.add(openItem);
		mainMenu.add(quitItem);
		menu.add(mainMenu);
		this.setJMenuBar(menu);
		
		//creation des boutons
		this.boutonOk.setPreferredSize(new Dimension(100, 25));
		this.boutonOk.addActionListener(this);
		this.pan.add(boutonOk);

		this.boutonCancel.setPreferredSize(new Dimension(100, 25));
		this.boutonCancel.addActionListener(this);
		this.pan.add(boutonCancel);
		
		//met le JPanel en fond de fenetre
		this.setContentPane(pan);
		
		//indique de terminer le programme en quittant la fenetre.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(this.boutonOk)) 
			JOptionPane.showMessageDialog(this, "appuye sur le bouton OK.", "Information", JOptionPane.INFORMATION_MESSAGE);
		if (e.getSource().equals(this.boutonCancel))
			JOptionPane.showMessageDialog(this, "appuye sur le bouton Cancel.", "Warning", JOptionPane.WARNING_MESSAGE);
	}
}
