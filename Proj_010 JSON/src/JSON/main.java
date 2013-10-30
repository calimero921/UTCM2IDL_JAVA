package JSON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String uneville = "exercice101.json";
		String desvilles = "exercice102.json";
		q1(uneville);
		q2(uneville);
		q3(desvilles);
		q4(desvilles);
		q5();
	}

	private static void q1(String filename){
		Ville city = new Ville("Paris", 2000);
		ObjectMapper mapper = new ObjectMapper();

		try {
			File f = new File(filename);
			mapper.writeValue(f, city);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	private static void q2(String filename){
		ObjectMapper mapper = new ObjectMapper();

		try {
			File f = new File(filename);
			Ville city = mapper.readValue(f, Ville.class);
			System.out.println(city.toString());
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	private static void q3(String filename){
		List<Ville> liste = new ArrayList<Ville>();

		liste.add(new Ville("Paris", 2000));
		liste.add(new Ville("Lyon", 1500));
		liste.add(new Ville("Marseille", 1000));
		liste.add(new Ville("Lille", 600));
		liste.add(new Ville("Bordeaux", 400));
		liste.add(new Ville("Rennes", 200));
		
		ObjectMapper mapper = new ObjectMapper();

		try {
			File f = new File(filename);
			mapper.writeValue(f, liste);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	private static void q4(String filename){
		List<Ville> liste = new ArrayList<Ville>();
		JsonFactory j = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper();
		JsonParser jp;

		try {
			jp = j.createParser(new File(filename));
			jp.nextToken();
			while (jp.nextToken() == JsonToken.START_OBJECT){
				Ville city = mapper.readValue(jp, Ville.class);
				System.out.println(city.toString());				
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	private static void q5(){
		List<Ville> liste = new ArrayList<Ville>();

		liste.add(new Ville("Paris", 2000));
		liste.add(new Ville("Lyon", 1500));
		liste.add(new Ville("Marseille", 1000));
		liste.add(new Ville("Lille", 600));
		liste.add(new Ville("Bordeaux", 400));
		liste.add(new Ville("Rennes", 200));
		
		ObjectMapper mapper = new ObjectMapper();

		try {
			System.out.println(mapper.writeValueAsString(liste));
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	
	}
}
