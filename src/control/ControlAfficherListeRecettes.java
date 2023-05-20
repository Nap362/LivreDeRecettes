package control;

import elements.LivreRecette;
import recettes.Recette;

public class ControlAfficherListeRecettes {
	private LivreRecette<Recette> recettes;
	
	public ControlAfficherListeRecettes(LivreRecette<Recette> recettes) {
		this.recettes = recettes;
	}
	
	public String afficherListeRecettes() {
		return recettes.afficherListe();
	}
}
