package recettes;

import elements.ListeAliments;

public abstract class Recette {
	protected static final int INGERDIENTS_MAX = 20;
	protected String nom;
	protected int temps;
	protected ListeAliments ingredients = new ListeAliments(INGERDIENTS_MAX);
	protected ListeInstructions listeInstructions = new ListeInstructions();

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

	private class ListeInstructions{
		private static final int INSTRUCTIONS_MAX = 20;
		private int nbrInstructions = 0;
		private String[] instructions = new String[INSTRUCTIONS_MAX];

		private void ajouter(String instruction) {
			if (nbrInstructions < INSTRUCTIONS_MAX) {
				instructions[nbrInstructions] = instruction;
				nbrInstructions++;
			}
		}
		
		private void supprimer(int indice) {
			nbrInstructions--;
			if (indice < nbrInstructions) {
				for (int i = indice; i < nbrInstructions; i++) {
					instructions[i] = instructions[i + 1];
				}
			}
			instructions[nbrInstructions] = null;
		}
		
		private void inserer(String instruction, int indice) {
			for (int i = indice; i < nbrInstructions; i++) {
				instructions[i + 1] = instructions[i];
				i++;
			}
			instructions[indice] = instruction;
			nbrInstructions++;
		}
		
		private String afficherListe() {
			StringBuilder texte = new StringBuilder();
			texte.append("Instructions :\n");
			for (int i = 0; i < nbrInstructions; i++) {
				texte.append((i + 1) + ". " + instructions[i] + "\n");
			}
			return texte.toString();
		}
	}
	
	public void ajouterInstuction(String instruction) {
		listeInstructions.ajouter(instruction);
	}
	
	public void supprimerInstuction(int indice) {
		listeInstructions.supprimer(indice);
	}
	
	public void insererInstuction(String instruction, int indice) {
		listeInstructions.inserer(instruction, indice);
	}

	private String afficherTemps() {
		StringBuilder tempsTexte = new StringBuilder();
		if (temps >= 60) {
			tempsTexte.append(temps / 60 + "h");
			if (temps % 60 < 10) {
				tempsTexte.append("0");
			}
			tempsTexte.append(temps % 60);
		}
		else {
			tempsTexte.append(temps + " min");
		}
		return tempsTexte.toString();
	}

	public String afficher(int personnes) {
		StringBuilder affichage = new StringBuilder();
		affichage.append("\t" + nom + " :\n" + "Pour " + personnes + " personnes\n" + "Temps de réalisation : "
				+ afficherTemps() + "\n");
		affichage.append("Ingrédients : \n" + ingredients.afficherListePersonne(personnes));
		affichage.append("\nRéalisation :\n" + listeInstructions.afficherListe());
		return affichage.toString();
	}
	

	public boolean recetteRealisable(ListeAliments placard) {
		return placard.tousIngredientsDisponibles(ingredients);
	}
	
	public boolean recetteContientAuMoinsUnIngredient(String[] AlimentsRecherches) {
		return ingredients.contientAuMoinsUnIngredient(AlimentsRecherches);
	}
}
