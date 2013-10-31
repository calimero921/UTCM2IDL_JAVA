package Sensor;

import java.awt.Color;
//import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//activation de listeneurs pour ses objet fils
public class SensorListFrame extends JFrame implements PropertyChangeListener, ActionListener {
	private int width;
	private int height;
	private String titre;		
	
	private Color foreground;
	private Color background;

	private SensorModel sensors;
	private JList capteurListe = new JList();
	private JFileChooser fileDialog = new JFileChooser();

	//création des menus
	private JMenuItem openItem = new JMenuItem("Ouvrir");
	private JMenuItem saveItem = new JMenuItem("Enregistrer");
	private JMenuItem quitItem = new JMenuItem("Quitter");
	private JMenuItem addItem = new JMenuItem("Ajouter");
	private JMenuItem deleteItem = new JMenuItem("Supprimer");

	//création des panneaux internes
	private SensorEditPane editPane = new SensorEditPane(this);
	private SensorMeanPane meanPane = new SensorMeanPane();

	public SensorListFrame(SensorModel liste, int w, int h, String titre, Color f, Color b){
		super();
		this.width = w;
		this.height = h;
		this.titre = titre;
		this.foreground = f;
		this.background = b;
		
		//créé un listener de JList pour gestion de l'interraction 
		this.capteurListe.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				//activation sur changement de selection
				if(e.getValueIsAdjusting() == false) {
					select();
				}
			}
		});
		this.sensors = liste;
		//créé un listener de la liste de sensor pour la fenetre (et ses fils)
		liste.addPropertyChangeListener(this);
		//créé un listener de l'objet moyenne de la liste de sensor pour la fenetre (et ses fils)
		liste.getMoyenne().addPropertyChangeListener(this);

		this.capteurListe.setModel(sensors.getSensorList());

		initFrame();
		initMenu();
		initPanel();

		//indique de terminer le programme en quittant la fenetre.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//optimise les éléments de la fenetre
		this.pack();
		//affiche la fenetre construite
		this.setVisible(true);
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
	
	private void initFrame(){
		//taille et titre de la fenetre
		this.setSize(this.width, this.height);
		this.setTitle(this.titre);

		//met au millieu de l'Ã©cran
		this.setLocationRelativeTo(null);		
	}
	private void initMenu(){
		//Creation du menu
		JMenuBar menu = new JMenuBar();
		
		JMenu fileMenu = new JMenu("Fichier");
		//créé du listener action du menu openItem vers la fenêtre en cours
		openItem.addActionListener(this);
		fileMenu.add(openItem);
		//créé du listener action du menu saveItem vers la fenêtre en cours
		saveItem.addActionListener(this);
		fileMenu.add(saveItem);
		//créé du listener action du menu quitItem vers la fenêtre en cours
		quitItem.addActionListener(this);
		fileMenu.add(quitItem);
		menu.add(fileMenu);
		
		JMenu sensorMenu = new JMenu("Capteur");
		//créé du listener action du menu addItem vers la fenêtre en cours
		addItem.addActionListener(this);
		sensorMenu.add(addItem);
		//créé du listener action du menu deleteItem vers la fenêtre en cours
		deleteItem.addActionListener(this);
		sensorMenu.add(deleteItem);
		menu.add(sensorMenu);
		
		this.setJMenuBar(menu);
	}
	private void initPanel(){
		JSplitPane pan = new JSplitPane();

		//crÃ©ation d'un JPanel
		pan.setForeground(this.foreground);
		pan.setBackground(this.background);
				
		pan.setLeftComponent(new JScrollPane(capteurListe));
		
		//ajout des tabs
		JTabbedPane capteurInfos = new JTabbedPane();
		capteurInfos.addTab("Capteur", this.editPane);
		capteurInfos.addTab("Moyenne", this.meanPane);

		pan.setRightComponent(capteurInfos);
		this.setContentPane(pan);
	}

	public void validateEdit(Sensor newSensor){
		//System.out.println("Bouton Valider");
		this.sensors.updateElement(capteurListe.getSelectedIndex(), newSensor);
	}
	public void select(){
		this.sensors.selectElement(capteurListe.getSelectedIndex());
	}
	
	//prise en charge des retours pour les listeners propertyChange (quelqu'en soit la source)
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//retour compteur de Mean
		if (evt.getPropertyName().equals(Mean.COUNT_NAME)){
			this.meanPane.setCount(evt.getNewValue().toString());
			//System.out.println("Count = " + evt.getNewValue().toString());
		}
		//retour moyenne de Mean
		if (evt.getPropertyName().equals(Mean.AVERAGE_NAME)){
			this.meanPane.setMean(evt.getNewValue().toString());
			//System.out.println("Mean = " + evt.getNewValue().toString());
		}
		//retour name de Sensorlist
		if (evt.getPropertyName().equals(SensorModel.SELECT_NAME)){
			this.editPane.setSensor((Sensor) evt.getNewValue());
			//System.out.println("sensor = " + evt.getNewValue().toString());
		}
	}

	//prise en charge des retours pour les listeners action interface (quelqu'en soit la source)
	@Override
	public void actionPerformed(ActionEvent evt) {
		//retour du menu openItem
		if(evt.getSource().equals(openItem)){
			String filename = "";

			//System.out.println("Menu Ouvrir");
			filename = getFilename("Ouvrir", "*.JSON");
			//System.out.println("Filename = " + fileName);
			if (filename.length()>0) sensors.openFile(filename);
		}
		//retour du menu saveItem
		if(evt.getSource().equals(saveItem)){
			String filename = "";

			//System.out.println("Menu Enregistrer");
			filename = getFilename("Enregistrer", "*.JSON");
			//System.out.println("Filename = " + fileName);
			if (filename.length()>0) sensors.saveFile(filename);
		}
		//retour du menu quitItem
		if(evt.getSource().equals(quitItem)){
			//System.out.println("Menu Quitter");
			System.exit(0);
		}
		//retour du menu addItem
		if(evt.getSource().equals(addItem)){
			Sensor local;
				
			//System.out.println("Menu Ajouter");
			String baseName = "Nouveau";
			int counter = 0;
			String globalName = "";

			globalName = baseName + "_" + counter;
			while (this.sensors.existsElement(globalName)) {
				counter++;
				globalName = baseName + "_" + counter;				
			}
			local = new Sensor(globalName);
			this.sensors.addElement(local);
			select();
		}
		//retour du menu deleteItem
		if(evt.getSource().equals(deleteItem)){
			int oldIndex;
			int newIndex;
			
			//System.out.println("Menu Supprimer");
			//récupère l'index de l'élément en cours
			oldIndex = capteurListe.getSelectedIndex();
			
			if (oldIndex >= 0) {
				newIndex = oldIndex - 1;
			} else {
				newIndex = 0;
			}
			this.capteurListe.setSelectedIndex(newIndex);
			
			//détruit l'élément à l'index récupéré
			this.sensors.deleteElement(oldIndex);
		}
	}
	
	//gestion de la fenêtre de dialogue pour récupération d'un nom de fichier
	private String getFilename(String dialogTitle, String fileType) {
		int dialogState = 0;
		File file;

		String fileName = "";
		fileDialog.setCurrentDirectory(new File("*.JSON"));
		dialogState = fileDialog.showDialog(this, "Enregistrer");
		if (dialogState == JFileChooser.APPROVE_OPTION){
			file = fileDialog.getSelectedFile();
			fileName = file.getName();
		}
		
		return fileName;
	}
}
