package ingredients;

public class Ingredient {
	private String nom;
	private int quantite;
	private Unite unite;

	public Ingredient(String nom, Unite unite) {
		this.nom = nom;
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
	
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String afficherIngredient() {
		return (quantite + " " + unite.toString() + " de " + nom);
	}

}
