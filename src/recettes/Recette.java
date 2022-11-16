package recettes;

import ingredients.Ingredient;

public class Recette {
	private static final int INGREDIENTS_MAX = 20;
	private static final int INSTRUCTIONS_MAX = 20;
	private String nom;
	private Type type;
	private int nbIngredients = 0;
	private int nbInstructions = 0;
	private Ingredient[] ingredients = new Ingredient[INGREDIENTS_MAX];
	private String[] instructions = new String[INSTRUCTIONS_MAX];
	private int personnes;
	private int temps;

	public Recette(String nom, Type type, int personnes, int temps) {
		this.nom = nom;
		this.type = type;
		this.personnes = personnes;
		this.temps = temps;
	}

	public String getNom() {
		return nom;
	}

	public Type getType() {
		return type;
	}

	public int getTemps() {
		return temps;
	}

	public void setPersonnes(int personnes) {
		this.personnes = personnes;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public void ajouterIngredient(Ingredient ingredient, int quantite) {
		ingredient.setQuantite(quantite);
		ingredients[nbIngredients] = ingredient;
		nbIngredients++;
	}

	public void ajouterInstruction(String instruction, int numero) {
		if ((numero - 1) < nbInstructions) {
			int i = numero - 1;
			while (i < nbInstructions) {
				instructions[i + 1] = instructions[i];
				i++;
			}
		}
		instructions[numero - 1] = instruction;
		nbInstructions++;
	}

	public void supprimerIngredient(String nom) {
		nbIngredients--;
		int i = 0;
		while (i < nbIngredients && ingredients[i].getNom() != nom) {
			i++;
		}
		ingredients[i] = ingredients[nbIngredients];
		ingredients[nbIngredients] = null;
	}

	public void supprimerInstruction(int numero) {
		nbInstructions--;
		int i = numero - 1;
		while (i < nbInstructions) {
			instructions[i] = instructions[i + 1];
			i++;
		}
		instructions[nbInstructions] = null;
	}

	public void afficherRecette() {
		String affichage = "\t" + nom + " :\n" + "Pour " + personnes + " personnes\n" + "Temps de réalisation : "
				+ temps + "\n";
		for (int i = 0; i < nbIngredients; i++) {
			affichage += " - " + ingredients[i].afficherIngredient() + "\n";
		}
		affichage += "Réalisation :\n";
		for (int i = 0; i < nbInstructions; i++) {
			affichage += (i + 1) + ". " + instructions[i] + "\n";
		}
		System.out.println(affichage);
	}

}
