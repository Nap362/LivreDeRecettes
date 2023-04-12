package recettes;

public class Poisson extends Recette {
	private enum Type {
		BAR, CABILLAUD, DORADE, EGLEFIN, HARENG, LIMANDE, MAQUEREAU, MERLAN, MERLU, SAR, SAUMON, SOLE, TRUITE, TURBOT,
		CRABE, CREVETTE, ECREVISSE, GAMBAS, HOMARD, LANGOUSTE, LANGOUSITNE, TOURTEAU, BIGORNEAU, BULOT, CLAM, COQUE,
		STJACQUE, COUTEAU, HUITRE, MOULE, PALOURDE, PETONCLE, TELLINE;
	}

	private Type poisson;

	public Poisson(String nom, int temps, String poisson) {
		super.nom = nom;
		super.temps = temps;
		this.poisson = Type.valueOf(poisson);
	}

	public String getPoisson() {
		return String.valueOf(poisson);
	}

}
