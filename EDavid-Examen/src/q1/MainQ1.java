package q1;

public class MainQ1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	  //Q1.a
	  String[] tab = new String[]{"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};

	  //Q1.b
	  System.out.println(tab.length);

	  //Q1.c
	  for(int i=tab.length-1; i>=0; i--){
		  System.out.println(tab[i].toUpperCase());
	  }

	  //Q1.d
	  String[] t3 = new String[tab.length];
	  
	  for(int i=0; i<tab.length; i++){
		  t3[i] = tab[i].substring(0, 3);
		  System.out.println(t3[i]);
	  }
	}
}
