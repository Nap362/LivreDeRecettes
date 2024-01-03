package recettes;

import java.util.ArrayList;
import java.util.List;

import elements.ListeAliments;

public abstract class Recette {
	protected String nom;
	protected int temps;
	protected ListeAliments ingredients;
	private List<String> instructions = new ArrayList<>();

	public String getNom() {
		return nom;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public String afficherDansListe() {
		return nom;
	}

	public void setListeIngredients(ListeAliments ingredients) {
		this.ingredients = ingredients;
	}

	public void ajouterInstuction(String instruction) {
		instructions.add(instruction);
	}

	public void supprimerInstuction(int indice) {
		instructions.remove(indice);
	}

	public void insererInstuction(String instruction, int indice) {
		instructions.add(indice, instruction);
	}
	
	private String afficherInstructions() {
		StringBuilder texte = new StringBuilder();
		texte.append("Instructions :\n");
		int indice = 1;
		for (String instruction : instructions) {
			texte.append(indice + ". " + instruction + "\n");
			indice++;
		}
		return texte.toString();
	}

	private String afficherTemps() {
		StringBuilder tempsTexte = new StringBuilder();
		if (temps >= 60) {
			tempsTexte.append(temps / 60 + "h");
			if (temps % 60 < 10) {
				tempsTexte.append("0");
			}
			tempsTexte.append(temps % 60);
		} else {
			tempsTexte.append(temps + " min");
		}
		return tempsTexte.toString();
	}

	public String afficher(int personnes) {
		StringBuilder affichage = new StringBuilder();
		affichage.append("\t" + nom + " :\n" + "Pour " + personnes + " personnes\n" + "Temps de réalisation : "
				+ afficherTemps() + "\n");
		affichage.append("Ingrédients :\n" + ingredients.afficherListePersonne(personnes));
		affichage.append("\nRéalisation :\n" + afficherInstructions());
		return affichage.toString();
	}

	public boolean recetteRealisable(ListeAliments placard) {
		return placard.tousIngredientsDisponibles(ingredients);
	}

	public boolean recetteContientAuMoinsUnIngredient(String[] AlimentsRecherches) {
		return ingredients.contientAuMoinsUnIngredient(AlimentsRecherches);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Recette) {
			Recette recette = (Recette) obj;
			return recette.nom == nom;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}
	
}
