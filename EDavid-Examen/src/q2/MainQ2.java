package q2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainQ2 {

	public static String DOC1 = "documents/q2doc1.json";
	public static String DOC2 = "documents/q2doc2.json";
	public static String DOC3 = "documents/q2doc3.json";
	public static String DOC4 = "documents/q2doc4.json";

	public static void main(String[] args) {
		//Q2-1
		Shape q2Obj1;
		q2Obj1 = readJSONfile(DOC1);
		System.out.println(q2Obj1.toString());
		
		Shape q2Obj2;
		q2Obj2 = readJSONfile(DOC2);
		System.out.println(q2Obj2.toString());

		Shape q2Obj3;
		q2Obj3 = readJSONfile(DOC3);
		System.out.println(q2Obj3.toString());
		
		//Q2-2
		Shape q2obj4=new Shape();
		q2obj4.setNom("Octogone");
		q2obj4.setNbCote(8);
		saveJSONfile(DOC4,q2obj4);
		System.out.println(q2Obj3.toString());
		
		//Q2-3
		List<Shape> liste = new ArrayList<Shape>();
		liste.add(new Shape("Triangle", 3));
		liste.add(new Shape("Carre", 4));
		liste.add(new Shape("pentagone", 5));
		liste.add(new Shape("Hexagone", 6));

		//Q2-4
		//la clé représentant le nombre de coté sera stocké dans l'Integer de tête 
		//tandis que les objets seront stockes dans la liste qui suit
		TreeMap<Integer, ArrayList<Shape>> map = new TreeMap<Integer, ArrayList<Shape>>();
	}
	
	public static Shape readJSONfile(String filename){	
		Shape local= new Shape();
		
		//lit les éléments du fichier
		JsonFactory j = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper();
		JsonParser jp;

		try {
			File f = new File(filename);
			local = mapper.readValue(f, Shape.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return local;
	}
	public static void saveJSONfile(String filename, Shape local){
		ObjectMapper mapper = new ObjectMapper();

		try {
			File f = new File(filename);
			mapper.writeValue(f, local);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
