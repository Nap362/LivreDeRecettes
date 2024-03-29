package control;

import java.util.ArrayList;
import java.util.List;

import elements.ListeAliments;
import elements.LivreRecette;
import recettes.Dessert;
import recettes.Poisson;
import recettes.Recette;
import recettes.Vegetarien;
import recettes.Viande;

public class ControlCreerRecette {
	private LivreRecette<Recette> livreRecette;
	private Recette recette;
	private ControlAjouterAliment controlAjouterListeAliment;
	private ListeAliments listeAliments = new ListeAliments();
	private List<String> instructions = new ArrayList<>();

	public ControlCreerRecette(LivreRecette<Recette> livreRecette) {
		this.livreRecette = livreRecette;
		controlAjouterListeAliment = new ControlAjouterAliment(listeAliments);
	}

	public void creerViande(String nom, int temps, String typeViande) {
		recette = new Viande(nom, temps, typeViande);
		recette.setListeIngredients(listeAliments);
		for (String instruction : instructions) {
			recette.ajouterInstuction(instruction);
		}
		livreRecette.ajouter(recette);
	}

	public void creerPoisson(String nom, int temps, String typePoisson) {
		recette = new Poisson(nom, temps, typePoisson);
		recette.setListeIngredients(listeAliments);
		livreRecette.ajouter(recette);
	}

	public void creerVegetarien(String nom, int temps, boolean vegan) {
		recette = new Vegetarien(nom, temps, vegan);
		recette.setListeIngredients(listeAliments);
		livreRecette.ajouter(recette);
	}

	public void creerDessert(String nom, int temps) {
		recette = new Dessert(nom, temps);
		recette.setListeIngredients(listeAliments);
		livreRecette.ajouter(recette);
	}

	public void ajouterAliment(String nom, String unite, double quantite) {
		controlAjouterListeAliment.ajouterAliment(nom, unite, quantite);
	}

	public void ajouterInstruction(String instruction) {
		instructions.add(instruction);
	}

}
