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
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == Vegetarien.class) {
			Vegetarien recette = (Vegetarien) obj;
			return recette.nom == nom;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}
}
