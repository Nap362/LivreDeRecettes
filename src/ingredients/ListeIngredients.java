package ingredients;

import java.util.Objects;

public class ListeIngredients {
	protected int NB_MAX_INGREDIENTS;
	protected int nbIngredients = 0;
	protected Ingredient[] ingredients;
	
	/* Constructeur pour les listes de courses */
	public ListeIngredients() {
		this.NB_MAX_INGREDIENTS = 50;
		this.ingredients = new Ingredient[NB_MAX_INGREDIENTS];
	}
	
	/* Constructeur pour les listes dans les recettes */
	public ListeIngredients(int nbMaxIngredients) {
		this.NB_MAX_INGREDIENTS = nbMaxIngredients;
		this.ingredients = new Ingredient[NB_MAX_INGREDIENTS];
	}

	public void supprimerIngredient(String nom) {
		nbIngredients--;
		int i = 0;
		while (i < nbIngredients && !Objects.equals(ingredients[i].getNom(), nom)) {
			i++;
		}
		ingredients[i] = ingredients[nbIngredients];
		ingredients[nbIngredients] = null;
	}

	public void ajouterIngredient(Ingredient ingredient, double quantite) {
		ingredient.setQuantite(quantite);
		if (nbIngredients < NB_MAX_INGREDIENTS) {
			ingredients[nbIngredients] = ingredient;
			nbIngredients++;
		}
	}

	protected double conversionQuantite(double quantite) {
		if (quantite < 2) {
			// Arrondir au quart pour les petites quantités
			quantite = Math.round(quantite * 4) / 4f;
		} else {
			// Arrondir à l'entier pour les quantités plus grandes
			quantite = Math.round(quantite);
		}
		return quantite;
	}

	public String afficherListeIngredients() {
		String affichage = "";
		for (int i = 0; i < nbIngredients; i++) {
			double quantite = conversionQuantite(ingredients[i].getQuantite());
			String quantiteAffichee = "";
			if (quantite > 2 || quantite == 1 || quantite == 0) {
				quantiteAffichee += (int) quantite;
			} else {
				quantiteAffichee += quantite;
			}
			affichage += " - " + ingredients[i].getNom() + " :" + quantiteAffichee
					+ ingredients[i].getUnite().toString() + "(s) \n";
		}
		return affichage;
	}

}
