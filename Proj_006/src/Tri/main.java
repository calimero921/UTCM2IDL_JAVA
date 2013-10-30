package Tri;

import java.util.*;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		q3();
		q4();
	}

	static void q3(){
		StringList[] table = new StringList[]{new StringList("Paris"),
											  new StringList("Lyon"),
											  new StringList("Marseille"),
											  new StringList("Bordeaux")};

		TreeMap<String, Integer> liste = new TreeMap<String, Integer>();

		for(int i=0; i<table.length ; i++)
			liste.put(table[i].getChaine(),table[i].getLongueur());
		
		System.out.println(liste);		
	}
	
	static void q4(){
		StringList[] table = new StringList[]{new StringList("Paris"),
				  							  new StringList("Lyon"),
				  							  new StringList("Marseille"),
				  							  new StringList("Lille"),
				  							  new StringList("Strasbourg"),
				  							  new StringList("Rennes"),
				  							  new StringList("Nantes"),
				  							  new StringList("Bordeaux")};

		TreeMap<Integer, ArrayList<String>> liste = new TreeMap<Integer, ArrayList<String>>();
		
		for(int i=0; i<table.length ; i++) {
			if(liste.containsKey(table[i].getLongueur())){
				ArrayList<String> array = liste.get(table[i].getLongueur());
				array.add(table[i].getChaine());
				liste.put(table[i].getLongueur(), array);
			} else {
				ArrayList<String> array = new ArrayList<String>();
				array.add(table[i].getChaine());
				liste.put(table[i].getLongueur(), array);			
			}
		}
		
		Set<Integer> index;
		index = liste.keySet();
		for(Integer id : index){
			Collections.sort(liste.get(id));
		}
		
		System.out.println(liste);		
	}
}
