package tests;

import cuisine.LivreRecette;
import elements.Ingredient;
import elements.Recette;
import elements.Type;
import elements.Unite;

public class Test {
	private LivreRecette livreRecettes;
	private Recette dessert;
	
	
	public static void main(String[] args) {
		Recette gateauNature = new Recette("Gâteau nature", Type.DESSERT, 4,35);
		Ingredient ingredient = new Ingredient("sucre", Unite.CAS,4);
		gateauNature.ajouterIngredient(ingredient);
		gateauNature.ajouterIngredient(new Ingredient("farine", Unite.CAS,5));
		Ingredient lait = new Ingredient("lait", Unite.CAS,3);
		Ingredient huile = new Ingredient("huile", Unite.CAS,2);
		Ingredient levure = new Ingredient("levure", Unite.SACHET,0.5);
		Ingredient oeuf = new Ingredient("oeuf", Unite.SANS,1);
		gateauNature.ajouterIngredient(lait);
		gateauNature.ajouterIngredient(huile);
		gateauNature.ajouterIngredient(levure);
		gateauNature.ajouterIngredient(oeuf);
		gateauNature.ajouterInstruction("Préchauffez votre four à 180°C. Dans un saladier, mettez tous les ingrédients.", 1);
		gateauNature.ajouterInstruction("Mélangez avec un fouet jusqu'à obtenir une pâte homogène et sans grumeaux.", 2);
		gateauNature.ajouterInstruction("Mélangez tous les ingrédients", 3);
		gateauNature.ajouterInstruction("Versez dans un moule.", 4);
		gateauNature.ajouterInstruction("Mettez le moule au four et laissez cuire pendant 25 minutes.", 5);
		gateauNature.afficherRecette(4);
		gateauNature.supprimerInstruction(3);
		gateauNature.afficherRecette(6);
		gateauNature.afficherRecette(4);
		
	}
	
}
