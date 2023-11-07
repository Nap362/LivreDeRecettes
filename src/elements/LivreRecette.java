package elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import recettes.KeyRecette;
import recettes.Recette;

public class LivreRecette<T extends Recette> {
	private String nom;
	private List<T> recettes;

	public LivreRecette(String nom) {
		this.recettes = new ArrayList<>();
		this.nom = nom;
	}

	public T getRecette(int indice) {
		return recettes.get(indice);
	}

	public int getNbRecettes() {
		return recettes.size();
	}

	public void ajouter(T recette) {
		recettes.add(recette);
	}

	public void supprimer(int indice) {
		recettes.remove(indice);
	}

	public String afficherListe() {
		StringBuilder affichage = new StringBuilder();
		affichage.append("\t" + nom + " :\n");
		int indice = 1;
		for (T recette : recettes) {
			affichage.append(indice + ". " + recette.getNom() + "\n");
			indice++;
		}
		return affichage.toString();
	}

	// Renvoi l'indice de la recette ou -1
	public int rechercherNom(String nom) {
		Recette recetteAComparer = new KeyRecette(nom);
		return recettes.indexOf(recetteAComparer);
	}

	public String filtrerType(String type) {
		StringBuilder affichage = new StringBuilder();
		int indice = 1;
		for (T recette : recettes) {
			if (recette.getClass().toString().equals(type)) {
				affichage.append("> " + indice + ". " + recette);
				indice++;
			}
		}
		return affichage.toString();
	}

	public String filtrerTemps(int temps) {
		StringBuilder affichage = new StringBuilder();
		int indice = 1;
		for (T recette : recettes) {
			if (recette.getTemps() <= temps) {
				affichage.append("> " + indice + ". " + recette.getNom());
				indice++;
			}
		}
		return affichage.toString();
	}

	public String filtrerEviterIngredients(String[] ingredientsAEviter) {
		StringBuilder affichage = new StringBuilder();
		int indice = 1;
		for (T recette : recettes) {
			if (!recette.recetteContientAuMoinsUnIngredient(ingredientsAEviter)) {
				affichage.append("> " + indice + ". " + recette.getNom());
				indice++;
			}
		}
		return affichage.toString();
	}

	public String filtrerRecettesRealisables(ListeAliments placard) {
		StringBuilder affichage = new StringBuilder();
		int indice = 1;
		for (T recette : recettes) {
			if (recette.recetteRealisable(placard)) {
				affichage.append("> " + indice + ". " + recette.getNom());
				indice++;
			}
		}
		return affichage.toString();
	}

}
