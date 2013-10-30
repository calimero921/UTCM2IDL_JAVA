package Tri;

public class StringList {
	private String chaine;
	private Integer longueur;

	public StringList(String chaine) {
		this.chaine = chaine;
		this.longueur = chaine.length();
	}

	public String getChaine() {
		return chaine;
	}
	public void setChaine(String chaine) {
		this.chaine = chaine;
	}

	public Integer getLongueur() {
		return longueur;
	}
	public void setLongueur(Integer longueur) {
		this.longueur = longueur;
	}

}
