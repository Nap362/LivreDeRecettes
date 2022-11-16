package recettes;

public enum Type {
	DESSERT("Dessert"), VIANDE("Viande"), POISSON("Poisson"), VEGE("Végétarien");

	private String nom;

	private Type(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom;
	}
}
