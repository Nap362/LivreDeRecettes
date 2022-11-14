package ingredients;

public class Ingredient {
	private String nom;
	private int quantite;
	private Unite unite;

	public Ingredient(String nom, int quantite, Unite unite) {
		this.nom=nom;
		this.quantite = quantite;
		this.unite = unite; 
		
	}

	public String getNom() {
		return nom;
	}

	public int getQuantite() {
		return quantite;
	}

	public Unite getUnite() {
		return unite;
	}


}
