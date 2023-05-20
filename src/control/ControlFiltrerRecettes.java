package control;

import elements.ListeAliments;
import elements.LivreRecette;
import recettes.Recette;

public class ControlFiltrerRecettes {
	private LivreRecette<Recette> recettes;
	private ListeAliments placard;
	
	public ControlFiltrerRecettes(LivreRecette<Recette> recettes, ListeAliments placard) {
		this.recettes = recettes;
		this.placard = placard;
	}
	
	public String filtrerType(String type) {
		StringBuilder liste = new StringBuilder();
		liste.append("\tRecettes de types " + type + " :\n");
		liste.append(recettes.filtrerType(type));
		return liste.toString();
	}
	
	public String filtrerTemps(int temps) {
		StringBuilder liste = new StringBuilder();
		liste.append("\tRecettes réalisables en moins de " + temps + "min :\n");
		liste.append(recettes.filtrerTemps(temps));
		return liste.toString();
	}
	
	public String filtrerRealisable() {
		StringBuilder liste = new StringBuilder();
		liste.append("\tRecettes réalisables avec ce que vous avez dans votre placard :\n");
		liste.append(recettes.filtrerRecettesRealisables(placard));
		return liste.toString();
	}
	
	public String filtrerAlimentsAEviter(String[] alimentsAEviter) {
		StringBuilder liste = new StringBuilder();
		liste.append("\tRecettes qui ne contiennent pas ces aliments :\n");
		liste.append(recettes.filtrerEviterIngredients(alimentsAEviter));
		return liste.toString();
	}
	
}
