package tests;

import recettes.Recette;
import recettes.Type;
import ingredients.Ingredient;
import ingredients.Unite;

public class Test {
	public static void main(String[] args) {
		Recette gateauNature = new Recette("Gâteau nature", Type.DESSERT, 4, 35);
		Ingredient sucre = new Ingredient("sucre", Unite.CAS);
		Ingredient farine = new Ingredient("farine", Unite.CAS);
		Ingredient lait = new Ingredient("lait", Unite.CAS);
		Ingredient huile = new Ingredient("huile", Unite.CAS);
		Ingredient levure = new Ingredient("levure", Unite.SACHET);
		Ingredient oeuf = new Ingredient("oeuf", Unite.SANS);
		gateauNature.ajouterIngredient(sucre, 4);
		gateauNature.ajouterIngredient(farine, 5);
		gateauNature.ajouterIngredient(lait, 3);
		gateauNature.ajouterIngredient(huile, 2);
		gateauNature.ajouterIngredient(levure, 1);
		gateauNature.ajouterIngredient(oeuf, 1);
		gateauNature.ajouterInstruction("Préchauffez votre four à 180°C. Dans un saladier, mettez tous les ingrédients.", 1);
		gateauNature.ajouterInstruction("Mélangez avec un fouet jusqu'à obtenir une pâte homogène et sans grumeaux.", 2);
		gateauNature.ajouterInstruction("Mélangez tous les ingrédients", 3);
		gateauNature.ajouterInstruction("Versez dans un moule", 4);
		gateauNature.ajouterInstruction("Mettez le moule au four et laissez cuire pendant 25 minutes.", 5);
		gateauNature.afficherRecette();
		gateauNature.supprimerInstruction(3);
		gateauNature.afficherRecette();
	}
	
}
