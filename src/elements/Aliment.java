package elements;

public class Aliment extends Element {
	private double quantite;
	private Unite unite;

	public Aliment(String nom, Unite unite, double quantite) {
		super(nom);
		this.unite = unite;
		this.quantite = quantite;

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

	@Override
	public String afficherDansListe() {
		return super.getNom() + " : " + quantite + " " + unite.toString() + "(s)";
	}
	
	/* Affichage pour un certain nombre de personnes (facteur = nbrPersonnesModifie/nbrPersonnesInitial
	 * Permet de ne pas modifier les quantités enregistrées */
	public String afficherQuantiteModifiee(double facteur) {
		//Valeur arrondie au quart
		double quantiteProvisoire = Math.round((quantite * facteur) * 4) / 4f;
		StringBuilder texte = new StringBuilder();
		texte.append(super.getNom() + " : ");
		if (quantiteProvisoire>5 || quantiteProvisoire==(int)quantiteProvisoire) {
			texte.append((int) quantiteProvisoire);
		}
		else {
			texte.append(quantiteProvisoire);
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
