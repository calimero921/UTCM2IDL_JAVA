package TD;

import java.util.Scanner;
import java.util.TreeSet;

public class InAndOut {
	private  TreeSet<String> chaines;

	public InAndOut() {
		this.chaines = new TreeSet<String>();
	}

	public TreeSet<String> getChaines() {
		return chaines;
	}
	public void setChaines(TreeSet<String> chaines) {
		this.chaines = chaines;
	}

	public void readKeyboard(){
		String tempo;
	
		Scanner clavier = new Scanner(System.in);
			
		tempo = clavier.nextLine();
		while(tempo.length() > 0) {
			this.chaines.add(tempo);
			tempo = clavier.nextLine();
		}
	}
}
