package elements;

public abstract class Element {
	private String nom;
	
	protected Element(String nom) {
		this.nom = nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public abstract String afficherDansListe();

}
