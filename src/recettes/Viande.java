package recettes;

public class Viande extends Recette {
	private enum Type {
		AGNEAU, BOEUF, CANARD, DINDE, GIBIER, LAPIN, MOUTON, PINTADE, PORC, POULET, VEAU;
	}

	private Type typeViande;

	public Viande(String nom, int temps, String typeViande) {
		super.nom = nom;
		super.temps = temps;
		this.typeViande = Type.valueOf(typeViande);
	}

	public String getType() {
		return typeViande.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == Viande.class) {
			Viande recette = (Viande) obj;
			return recette.nom == nom;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}

}
