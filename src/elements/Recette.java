package elements;

import cuisine.OperationListe;
import cuisine.Liste;
import cuisine.ListeCourses;

public class Recette extends ListeCourses {
	private static final int INGERDIENTS_MAX = 20;
	private String nom;
	private Type type;
	private int personnes;
	private int temps;
	private Instructions instructions = new Instructions();

	public Recette(String nom, Type type, int personnes, int temps) {
		super(INGERDIENTS_MAX);
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

	private class Instructions extends Liste<String> {
		private static final int INSTRUCTIONS_MAX = 20;

		public Instructions() {
			super(new String[INSTRUCTIONS_MAX], INSTRUCTIONS_MAX);
		}

		public void supprimer(String numero) {
			nbrElements--;
			int indice = Integer.parseInt(numero) - 1;
			if (indice < nbrElements) {
				for (int i = indice; i<nbrElements; i++) {
					elements[i] = elements[i + 1];
				}
			}
			elements[nbrElements] = null;
		}

		@Override
		public String afficherListe() {
			//TODO
			return null;
		}

		public void inserer(String instruction, int numero) {
			if ((numero - 1) < nbrInstructions) {
				int i = numero - 1;
				while (i < nbrInstructions) {
					instructions[i + 1] = instructions[i];
					i++;
				}
			}
			instructions[numero - 1] = instruction;
			nbrInstructions++;
		}
	}

	@Override
	public String afficherListeIngredients() {
		String affichage = "";
		for (int i = 0; i < nbIngredients; i++) {
			double quantite = conversionQuantite(ingredients[i].getQuantite());
			String quantiteAffichee = "";
			if (quantite >= 2 || quantite == 1 || quantite == 0) {
				quantiteAffichee += (int) quantite;
			} else {
				quantiteAffichee += quantite;
			}
			if (ingredients[i].getUnite() == Unite.SANS) {
				affichage += " - " + quantiteAffichee + " " + ingredients[i].getNom() + "(s)" + "\n";
			} else {
				affichage += " - " + quantiteAffichee + " " + ingredients[i].getUnite().toString() + " de "
						+ ingredients[i].getNom() + "\n";
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
		/* Conversion des quantités pour les personnes voulues */
		for (int i = 0; i < nbIngredients; i++) {
			ingredients[i].setQuantite(ingredients[i].getQuantite() / personnes * personnesVoulues);
		}
		affichage += afficherListeIngredients();
		/* Retour au quantités initiales */
		for (int i = 0; i < nbIngredients; i++) {
			ingredients[i].setQuantite(ingredients[i].getQuantite() / personnesVoulues * personnes);
		}
		affichage += "\nRéalisation :\n";
		affichage += instructions.afficherListe();
		System.out.println(affichage);
	}

}
