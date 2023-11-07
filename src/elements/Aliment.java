package elements;

public class Aliment{
	
	private enum Unite {
		G("g"), MG("mg"), L("L"), CL("cL"), ML("mL"), PINCEE("pincée(s)"), CAS("cuillère(s) à soupe"),
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
	
	private String nom;
	private double quantite;
	private final Unite unite;

	public Aliment(String nom, String unite, double quantite) {
		this.nom = nom;
		this.unite = Unite.valueOf(unite);
		this.quantite = quantite;

	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public String getNom() {
		return nom;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}


	public String afficherDansListe() {
		return afficherQuantiteModifiee(1);
	}
	
	/* Affichage pour un certain nombre de personnes (facteur = nbrPersonnesModifie/nbrPersonnesInitial
	 * Permet de ne pas modifier les quantités enregistrées */
	public String afficherQuantiteModifiee(int personnes) {
		//Valeur arrondie au dixieme
		double quantiteAffichee = Math.round((quantite*personnes) * 10.0) / 10.0;
		if (quantiteAffichee>=10 && unite!=Unite.L && unite!=Unite.SACHET && unite!=Unite.SANS) {
			//Pour éviter d'avoir par exemple 1000.25 g de quelque chose
			quantiteAffichee = Math.round(quantiteAffichee);
		}
		StringBuilder texte = new StringBuilder();
		texte.append(nom + " : ");
		if (quantiteAffichee==(int)quantiteAffichee) {
			texte.append((int) quantiteAffichee);
		}
		else {
			texte.append(quantiteAffichee);
		}
		if (unite!=Unite.SANS) {
			texte.append(" " + unite.toString());
		}
		return texte.toString();
	}
	
	
	public boolean verifierQuantiteSuffisante(double quantiteVoulue) {
		boolean quantiteSuffisante = false;
		if (quantite>=quantiteVoulue) {
			quantiteSuffisante=true;
		}
		return quantiteSuffisante;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == Aliment.class) {
			Aliment aliment = (Aliment) obj;
			return aliment.nom == nom;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}
	
}
