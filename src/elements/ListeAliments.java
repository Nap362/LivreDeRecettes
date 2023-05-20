package elements;

public class ListeAliments implements GestionTableau<Aliment> {
	private final int NB_MAX_ALIMENTS;
	private int nbrAliments = 0;
	private Aliment[] aliments;

	public ListeAliments(int nbMaxAliments) {
		this.NB_MAX_ALIMENTS = nbMaxAliments;
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
			affichage.append(" (" + (i + 1) + ") " + aliments[i].afficherDansListe() + "\n");
		}
		return affichage.toString();
	}

	public double getQuantiteAliment(int indice) {
		return aliments[indice].getQuantite();
	}

	public void modifierNom(int indice, String nouveauNom) {
		aliments[indice].setNom(nouveauNom);
	}

	public void modifierQuantite(int indice, double nouvelleQuantite) {
		aliments[indice].setQuantite(nouvelleQuantite);
	}

	/* Affichage de la liste pour un certain nombre de personnes */
	public String afficherListePersonne(int personnes) {
		StringBuilder affichage = new StringBuilder();
		for (int i = 0; i < nbrAliments; i++) {
			affichage.append(" (" + (i+1) + ") " + aliments[i].afficherQuantiteModifiee(personnes) + "\n");
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

	// Uniquement pour la liste de courses
	public void faireCourses(ListeAliments placard) {
		while (nbrAliments > 0) {
			Aliment aliment = aliments[nbrAliments - 1];
			int indicePlacard = placard.rechercherAliment(aliment.getNom());
			if (indicePlacard != -1) {
				// L'aliment est dejà présent dans le placard on ajoute la quantité achetée à la
				// quantité présente
				double quantite = placard.getQuantiteAliment(indicePlacard);
				double nouvelleQuantite = quantite + aliment.getQuantite();
				placard.modifierQuantite(indicePlacard, nouvelleQuantite);
			} else {
				// L'aliment n'est pas présent dans le placard on l'ajoute
				placard.ajouter(aliment);
			}
			supprimer(nbrAliments - 1);
		}
	}

	/* La liste contient au moins UN aliment d'une autre liste */
	public boolean contientAuMoinsUnIngredient(String[] listeAliments) {
		boolean contientAuMoinsUnIngredient = false;
		for (int i = 0; i < listeAliments.length && !contientAuMoinsUnIngredient; i++) {
			int indice = rechercherAliment(listeAliments[i]);
			if (indice != -1) {
				contientAuMoinsUnIngredient = true;
			}
		}
		return contientAuMoinsUnIngredient;
	}

	public boolean tousIngredientsDisponibles(ListeAliments listeAliments) {
		boolean tousIngredientsDisponibles = true;
		for (int i = 0; i < listeAliments.nbrAliments && tousIngredientsDisponibles; i++) {
			Aliment alimentCourant = listeAliments.aliments[i];
			int indice = rechercherAliment(alimentCourant.getNom());
			if (indice == -1 || !aliments[indice].verifierQuantiteSuffisante(alimentCourant.getQuantite())) {
				tousIngredientsDisponibles = false;
			}
		}
		return tousIngredientsDisponibles;
	}

}
