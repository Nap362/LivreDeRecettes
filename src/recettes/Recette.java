package recettes;

import ingredients.Ingredient;
import ingredients.ListeIngredients;
import ingredients.Unite;

public class Recette extends ListeIngredients {
	private static final int INSTRUCTIONS_MAX = 20;
	private static final int INGREDIENTS_MAX = 20;
	private String nom;
	private Type type;
	private int nbInstructions = 0;
	private String[] instructions = new String[INSTRUCTIONS_MAX];
	private int personnes;
	private int temps;

	public Recette(String nom, Type type, int personnes, int temps) {
		super(INGREDIENTS_MAX);
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

	public void supprimerInstruction(int numero) {
		if (numero<nbInstructions) {
			nbInstructions--;
			int i = numero - 1;
			while (i < nbInstructions) {
				instructions[i] = instructions[i + 1];
				i++;
			}
			instructions[nbInstructions] = null;
		}
	}
	
	public String afficherListeIngredients(int personnesVoulues) {
		String affichage = "";
		double facteurQuantite = (float) personnesVoulues / personnes;
		for (int i = 0; i < nbIngredients; i++) {
			double quantite = conversionQuantite(ingredients[i].getQuantite() * facteurQuantite);
			String quantiteAffichee ="";
			if (quantite >= 2 || quantite == 1 || quantite == 0) {
				quantiteAffichee += (int) quantite;
			}
			else {
				quantiteAffichee += quantite;
			}
			if (ingredients[i].getUnite() == Unite.SANS) {
				affichage+=" - " + quantiteAffichee + " " + ingredients[i].getNom() + "(s)" + "\n";
			} else {
				affichage+=" - " + quantiteAffichee + " " + ingredients[i].getUnite().toString() + " de " + ingredients[i].getNom()+ "\n";
			}
		}
		return affichage;
	}

	public void afficherRecette(int personnesVoulues) {
		String tempsAffiche = temps + " min";
		if (temps >= 60) {
			tempsAffiche = temps / 60 + "h";
			if (temps % 60 < 10) {
				tempsAffiche += "0";
			}
			tempsAffiche += temps % 60;
		}
		String affichage = "\t" + nom + " :\n" + "Pour " + personnesVoulues + " personnes\n" + "Temps de réalisation : "
				+ tempsAffiche + "\n";
		affichage += afficherListeIngredients(personnesVoulues);
		affichage += "Réalisation :\n";
		for (int i = 0; i < nbInstructions; i++) {
			affichage += (i + 1) + ". " + instructions[i] + "\n";
		}
		System.out.println(affichage);
	}

}
