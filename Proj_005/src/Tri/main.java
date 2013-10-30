package Tri;

import java.util.*;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		q1();
		q2();
	}

	static void q1(){
		Integer[] table = new Integer[]{5, 1, 7, 2, 9, 3, 6, 0, 8, 4};
		
		List<Integer> liste = Arrays.asList(table);
		Collections.sort(liste);
		System.out.println(liste);		
	}
	
	static void q2(){
		Integer[] table = new Integer[]{5, 1, 7, 2, 9, 3, 6, 0, 8, 4};
		
		List<Integer> liste = Arrays.asList(table);
		Collections.sort(liste, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2){
				return i2.compareTo(i1);
			}
		});
		System.out.println(liste);		
	}
}
