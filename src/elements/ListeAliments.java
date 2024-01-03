package elements;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ListeAliments {
	private Set<Aliment> aliments;

	public ListeAliments() {
		this.aliments = new HashSet<>();
	}
	
	public int getNbrAliments() {
		return aliments.size();
	}

	public void ajouter(Aliment aliment) {
		aliments.add(aliment);
	}

	public void supprimer(String aliment) {
		Aliment alim = new KeyAliment(aliment);
		aliments.remove(alim);
	}

	public String afficherListe() {
		StringBuilder affichage = new StringBuilder();
		for (Aliment aliment : aliments) {
			affichage.append(" - " + aliment.afficherDansListe() + "\n");
		}
		return affichage.toString();
	}
	
	public Aliment rechercherAliment(String nomAliment) {
		Aliment alimentRecherche = new KeyAliment(nomAliment);
		for (Aliment aliment : aliments) {
			if (aliment.equals(alimentRecherche)) {
				return aliment;
			}
		}
		return null;
	}

	public double getQuantiteAliment(String nomAliment) {
		Aliment aliment = rechercherAliment(nomAliment);
		if (aliment==null) {
			throw new NullPointerException();
		}
		return aliment.getQuantite();
	}

	public void modifierNom(String nomAliment, String nouveauNom) {
		Aliment aliment = rechercherAliment(nomAliment);
		if (aliment==null) {
			throw new NullPointerException();
		}
		aliment.setNom(nouveauNom);
	}

	public void modifierQuantite(String nomAliment, double nouvelleQuantite) {
		Aliment aliment = rechercherAliment(nomAliment);
		if (aliment==null) {
			throw new NullPointerException();
		}
		aliment.setQuantite(nouvelleQuantite);
	}

	/* Affichage de la liste pour un certain nombre de personnes */
	public String afficherListePersonne(int personnes) {
		StringBuilder affichage = new StringBuilder();
		for (Aliment aliment : aliments) {
			affichage.append(" - " + aliment.afficherQuantiteModifiee(personnes) + "\n");
		}
		return affichage.toString();
	}

	// Uniquement pour la liste de courses
	public void faireCourses(ListeAliments placard) {
		for (Aliment alimentAchete : aliments) {
			Aliment alimentPlacard = placard.rechercherAliment(alimentAchete.getNom());
			if (alimentPlacard != null) {
				// L'aliment est présent dans le placard on l'ajoute
				alimentPlacard.setQuantite(alimentAchete.getQuantite() + alimentPlacard.getQuantite());
			} else {
				// L'aliment n'est pas présent dans le placard on l'ajoute
				placard.ajouter(alimentAchete);
			}
		}
		aliments.clear();
	}

	/* La liste contient au moins UN aliment d'une autre liste */
	public boolean contientAuMoinsUnIngredient(String[] listeAliments) {
		boolean contientAuMoinsUnIngredient = false;
		for (int i = 0; i < listeAliments.length && !contientAuMoinsUnIngredient; i++) {
			contientAuMoinsUnIngredient = (rechercherAliment(listeAliments[i]) != null) ;
		}
		return contientAuMoinsUnIngredient;
	}

	public boolean tousIngredientsDisponibles(ListeAliments listeAliments) {
		boolean tousIngredientsDisponibles = true;
		for (Aliment alimentCourant : listeAliments.aliments){
			Aliment aliment  = rechercherAliment(alimentCourant.getNom());
			if (aliment == null || !aliment.verifierQuantiteSuffisante(alimentCourant.getQuantite())) {
				tousIngredientsDisponibles = false;
			}
		}
		return tousIngredientsDisponibles;
	}

}
