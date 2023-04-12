package elements;

import recettes.Recette;

public class LivreRecette<T extends Recette> implements GestionTableau<T>{
	private static final int NB_MAX_RECETTES = 100;
	private String nom;
	private T[] recettes;
	private int nbRecettes = 0;
	
	public LivreRecette(T[] recettes, String nom) {
		this.recettes = recettes;
		this.nom = nom;
	}
	
	public T getRecette(int i) {
		return recettes[i];
	}
	
	public int getNbRecettes() {
		return nbRecettes;
	}

	@Override
	public void ajouter(T recette) {
		if (nbRecettes<NB_MAX_RECETTES) {
			recettes[nbRecettes]=recette;
			nbRecettes++;
		} 
	}
	
	@Override
	public void supprimer(int indice) {
		nbRecettes--;
		if (indice < nbRecettes) {
			for (int i = indice; i < nbRecettes; i++) {
				recettes[i] = recettes[i + 1];
			}
		}
		recettes[nbRecettes] = null;
	}
	
	@Override
	public String afficherListe() {
		StringBuilder affichage = new StringBuilder();
		affichage.append("\tVos " + nom +" :\n");
		for (int i=0; i<nbRecettes;i++) {
			affichage.append((i+1)+". " + recettes[i].getNom() + "\n");
		}
		return affichage.toString();
	}
	
	// Renvoi l'indice de la recette ou -1
	public int rechercherNom(String nom) {
		int indiceRecetteRecherchee = -1;
		for (int i = 0; i<nbRecettes && indiceRecetteRecherchee==-1; i++) {
			if (recettes[i].getNom().equals(nom)) {
				indiceRecetteRecherchee = i;
			}
		}
		return indiceRecetteRecherchee;
	}

	
	public String filtrerEviterIngredients(String[] ingredientsAEviter) {
		StringBuilder affichage = new StringBuilder();
		for (int i=0; i<nbRecettes; i++) {
			if (!recettes[i].recetteContientAuMoinsUnIngredient(ingredientsAEviter)) {
				affichage.append(" ~ " + recettes[i].getNom() + "\n");
			}
		}
		return affichage.toString();
	}
	
	public String filtrerRecettesRealisables(ListeAliments placard) {
		StringBuilder affichage = new StringBuilder();
		for (int i=0; i<nbRecettes; i++) {
			if (!recettes[i].recetteRealisable(placard)) {
				affichage.append(" ~ " + recettes[i].getNom() + "\n");
			}
		}
		return affichage.toString();
	}

}
