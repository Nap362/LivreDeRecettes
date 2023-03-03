package elements;

public class Ingredient {
	private String nom;
	private double quantite;
	private Unite unite;

	public Ingredient(String nom, Unite unite, double quantite) {
		this.nom = nom;
		this.unite = unite;
		this.quantite = quantite;

	}

	public String getNom() {
		return nom;
	}

	public double getQuantite() {
		return quantite;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

}
