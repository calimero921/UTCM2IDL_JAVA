package Flux;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//q5();
		//q6();
		//q7();
		q8();
	}

	private static void q5(){
		TreeSet<String> chaines = new TreeSet<String>();
		String chaine;
	
		Scanner clavier = new Scanner(System.in);
			
		chaine = clavier.nextLine();
		while(chaine.length() > 0) {
			chaines.add(chaine);
			chaine = clavier.nextLine();
		}
		
		System.out.println(chaines);
	}
	private static void q6() {
		TreeSet<String> chaines = new TreeSet<String>();
		String chaine;
		String fileName = "question6.dat";
				
		Scanner clavier = new Scanner(System.in);
			
		chaine = clavier.nextLine();
		while(chaine.length() > 0) {
			chaines.add(chaine);
			chaine = clavier.nextLine();
		}
		
		try {
			ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(fileName));
			outputFile.writeObject(chaines);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
	static private void q7(){
		TreeSet<String> chaines = new TreeSet<String>();
		String fileName = "question6.dat";
			
		try {
			ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(fileName));
			chaines = (TreeSet<String>) inputFile.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		System.out.println(chaines);
	}
	static private void q8(){
		TreeSet<String> chaines = new TreeSet<String>();
		String inputFileName = "question6.dat";
		String outputFileName = "question8.txt";
		StringBuffer buffer = new StringBuffer();
			
		try {
			ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(inputFileName));
			chaines = (TreeSet<String>) inputFile.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		
		for(String s : chaines){
			buffer.append(s + ";");
		}
		buffer.append("\n");

		try {
			FileWriter outputFile = new FileWriter(outputFileName, true);
			outputFile.write(buffer.toString());
			outputFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
