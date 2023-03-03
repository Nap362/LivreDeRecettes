package elements;

public enum Unite {
	KG("kg"), G("g"), MG("mg"), L("L"), CL("cL"), ML("mL"), PINCEE("pincée(s)"), CAS("cuillère(s) à soupe"),
	CAC("cuillère(s) à café"), SACHET("sachet(s)"), SANS("");

	private String nom;

	private Unite(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}
}
