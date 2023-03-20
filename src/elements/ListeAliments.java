package elements;

public class ListeAliments implements OperationsListe<Aliment> {
	private int NB_MAX_ALIMENTS;
	private int nbrAliments = 0;
	private Aliment[] aliments;

	/* Constructeur pour les listes d'ingrédients */
	public ListeAliments(int nbMaxaliments) {
		this.NB_MAX_ALIMENTS = nbMaxaliments;
		this.aliments = new Aliment[NB_MAX_ALIMENTS];
	}

	@Override
	public void ajouter(Aliment ingredient) {
		if (nbrAliments < NB_MAX_ALIMENTS) {
			aliments[nbrAliments] = ingredient;
			nbrAliments++;
		}
	}

	@Override
	public void supprimer(int indice) {
		nbrAliments--;
		if (indice < nbrAliments) {
			for (int i = indice; i < nbrAliments; i++) {
				aliments[i] = aliments[i + 1];
			}
		}
		aliments[nbrAliments] = null;
	}

	@Override
	public String afficherListe() {
		StringBuilder affichage = new StringBuilder();
		for (int i = 0; i < nbrAliments; i++) {
			affichage.append(" - " + aliments[i].afficherDansListe() + "\n");
		}
		return affichage.toString();
	}
	
	/* Affichage de la liste pour un certain nombre de personnes (facteur = nbrPersonnesModifie/nbrPersonnesInitial*/
	public String afficherListeQuantite(double facteur) {
		StringBuilder affichage = new StringBuilder();
		for (int i = 0; i < nbrAliments; i++) {
			affichage.append(" - " + aliments[i].afficherQuantiteModifiee(facteur) + "\n");
		}
		return affichage.toString();
	}

	public int rechercherAliment(String nom) {
		int indiceAlimentRecherche = -1;
		for (int i = 0; i < nbrAliments && indiceAlimentRecherche == -1; i++) {
			if (aliments[i].getNom().equals(nom)) {
				indiceAlimentRecherche = i;
			}
		}
		return indiceAlimentRecherche;
	}

	/* La liste contient au moins TOUS les aliments d'une autre liste*/
	public boolean contientTousIngredients(String[] listeAliments) {
		boolean contientTousIngredients = true;
		for (int i = 0; i < listeAliments.length && contientTousIngredients; i++) {
			int indice =rechercherAliment(listeAliments[i]);
			if (indice==-1) {
				contientTousIngredients=false;
			}
		}
		return contientTousIngredients;
	}
	
	/* La liste contient au moins UN aliment d'une autre liste*/
	public boolean contientAuMoinsUnIngredient(String[] listeAliments) {
		boolean contientAuMoinsUnIngredient = false;
		for (int i = 0; i < listeAliments.length && !contientAuMoinsUnIngredient; i++) {
			int indice =rechercherAliment(listeAliments[i]);
			if (indice!=-1) {
				contientAuMoinsUnIngredient=true;
			}
		}
		return contientAuMoinsUnIngredient;
	}
	
	public boolean tousIngredientsDisponibles(ListeAliments listeAliments) {
		boolean tousIngredientsDisponibles = true;
		for (int i = 0; i < listeAliments.nbrAliments && tousIngredientsDisponibles; i++) {
			Aliment alimentCourant = listeAliments.aliments[i];
			int indice =rechercherAliment(alimentCourant.getNom());
			if (indice==-1 || !aliments[indice].verifierQuantiteSuffisante(alimentCourant.getQuantite())) {
				tousIngredientsDisponibles=false;
			}
		}
		return tousIngredientsDisponibles;
	}

}
