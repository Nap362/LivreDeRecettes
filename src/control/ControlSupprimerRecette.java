package control;

import elements.LivreRecette;
import recettes.Recette;

public class ControlSupprimerRecette {
private LivreRecette<Recette> recettes;
	
	public ControlSupprimerRecette(LivreRecette<Recette> recettes) {
		this.recettes = recettes;
	}
	
	public void supprimerRecette(int indice) {
		recettes.supprimer(indice);
	}
}
