package elements;

public class Aliment{
	private String nom;
	private double quantite;
	private Unite unite;

	public Aliment(String nom, Unite unite, double quantite) {
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


	public String afficherDansListe() {
		return nom + " : " + quantite + " " + unite.toString() + "(s)";
	}
	
	/* Affichage pour un certain nombre de personnes (facteur = nbrPersonnesModifie/nbrPersonnesInitial
	 * Permet de ne pas modifier les quantités enregistrées */
	public String afficherQuantiteModifiee(int personnes) {
		//Valeur arrondie au quart
		double quantiteAffichee = Math.round((quantite*personnes) * 4) / 4f;
		StringBuilder texte = new StringBuilder();
		texte.append(nom + " : ");
		if (quantiteAffichee>5 || quantiteAffichee==(int)quantiteAffichee) {
			texte.append((int) quantiteAffichee);
		}
		else {
			texte.append(quantiteAffichee);
		}
		texte.append(" " + unite.toString());
		return texte.toString();
	}
	
	
	public boolean verifierQuantiteSuffisante(double quantiteVoulue) {
		boolean quantiteSuffisante = false;
		if (quantite>=quantiteVoulue) {
			quantiteSuffisante=true;
		}
		return quantiteSuffisante;
	}
}
