package control;

import elements.LivreRecette;
import recettes.Recette;

public class ControlVoirRecette {
	private LivreRecette<Recette> recettes;
	
	public ControlVoirRecette(LivreRecette<Recette> recettes) {
		this.recettes = recettes;
	}
	
	public String voirRecette(int indice, int nbrPersonnes) {
		return recettes.getRecette(indice).afficher(nbrPersonnes);
	}
}
