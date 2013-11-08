package q3;

import java.awt.Color;

public class MainQ3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Values v = new Values();
		Display dis = new Display();
		
		//Q3-b
		v.addPropertyChangeListener(dis);
		v.sendValues();

		//Q3-c
		DisplayFrame frame = new DisplayFrame("Affichage");
	}
}
