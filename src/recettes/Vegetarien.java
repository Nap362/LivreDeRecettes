package recettes;


public class Vegetarien extends Recette{
	private boolean vegan;
	
	public Vegetarien(String nom, int temps, boolean vegan) {
		super.nom = nom;
		super.temps = temps;
		this.vegan = vegan;
	}

	public boolean convientVegan() {
		return vegan;
	}
	
}
