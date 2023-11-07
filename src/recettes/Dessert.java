package recettes;

public class Dessert extends Recette {
	public Dessert(String nom, int temps) {
		super.nom = nom;
		super.temps = temps;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == Dessert.class) {
			Dessert recette = (Dessert) obj;
			return recette.nom == nom;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}
}
