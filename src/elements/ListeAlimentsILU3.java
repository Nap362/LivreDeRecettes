package elements;

import java.util.HashSet;
import java.util.Set;

public class ListeAlimentsILU3 {
	private String aliments;
	//liste de la forme "nom,quant,unit;nom,quant,unit"

	public ListeAlimentsILU3(String aliments) {
		this.aliments = aliments;
	}

	public void ajouter(Aliment aliment) {
		//TODO appel Ocaml
	}

	public void supprimer(String aliment) {
		//TODO appel Ocaml
	}

	public String afficherListe() {
		StringBuilder affichage = new StringBuilder();
		String[] listeAliments = aliments.split(";");
		for (String aliment : listeAliments) {
			String[] elems = aliment.split(",");
			affichage.append(" - " + elems[0] + " : " + elems[1] + " " + elems[2] + "\n");
		}
		return affichage.toString();
	}
	
	public Aliment rechercherAliment(String nomAliment) {
		//TODO appel Ocaml
		return null;
	}

	public double getQuantiteAliment(String nomAliment) {
		//TODO appel Ocaml
		return 0.;
	}

	public void modifierNom(String nomAliment, String nouveauNom) {
		//TODO appel OCaml
	}

	public void modifierQuantite(String nomAliment, double nouvelleQuantite) {
		//TODO appel OCaml
	}

	/* Affichage de la liste pour un certain nombre de personnes */
	public String afficherListePersonne(int personnes) {
		//TODO appel OCaml
		return null;
	}

	// Uniquement pour la liste de courses
	public void faireCourses(ListeAliments placard) {
		//TODO appel OCaml
	}

	/* La liste contient au moins UN aliment d'une autre liste */
	public boolean contientAuMoinsUnIngredient(String[] listeAliments) {
		//TODO appel OCaml
		return false;
	}

	public boolean tousIngredientsDisponibles(ListeAliments listeAliments) {
		//TODO appel OCaml
		return false;
	}

}
