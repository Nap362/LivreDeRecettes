package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import elements.Aliment;
import recettes.Dessert;
import elements.LivreRecette;
import recettes.Poisson;
import recettes.Recette;
import elements.Type;
import elements.Unite;
import recettes.Vegetarien;
import recettes.Viande;

public class main {
	private static LivreRecette livreDeRecettes;

	private static String inputTexte(String instruction) {
		System.out.println(instruction);
		BufferedReader ligne = new BufferedReader(new InputStreamReader(System.in));
		String entree = "";
		try {
			entree = ligne.readLine();
		} catch (IOException e) {
			System.out.println("Erreur valeur entrée");
			menu();
		}
		return entree;
	}

	private static int inputInt(String instruction) {
		String entree = inputTexte(instruction);
		try {
			return Integer.parseInt(entree);
		} catch (NumberFormatException e) {
			System.out.println("Veuillez entrer un nombre valide");
			return inputInt(instruction);
		}
	}

	public static void menu() {
		System.out.println("\t Menu principal :\n");
		System.out.println("1. Voir toutes les recettes\n");
		System.out.println("2. Ajouter une recette\n");
		System.out.println("3. Rechercher une recette\n");
		System.out.println("0. Sortir\n");

		int selection = inputInt("Veuillez entrer le chiffre correspondant à votre requête :");
		switch (selection) {
		case 0: {
			System.exit(0);
		}
		case 1: {
			afficherToutesRecettes();
			break;
		}
		case 2: {
			Recette nouvelleRecette = creerRecette();
			livreDeRecettes.ajouterRecette(nouvelleRecette);
			menu();
			break;
		}
		case 3: {
			rechercheRecette();
			break;
		}
		default:
			System.out.println("Veuillez entrer un numéro entre 0 et 3.");
			menu();
		}
	}

	private static void afficherToutesRecettes() {
		livreDeRecettes.afficherListeRecettes();
		System.out.println("\n1. Afficher une recette\n");
		System.out.println("2. Supprimer une recette\n");
		System.out.println("3. Retour au menu\n");
		System.out.println("0. Sortir\n");
		int selection = inputInt("Veuillez entrer le chiffre correspondant à votre requête :");
		switch (selection) {
		case 0: {
			System.exit(0);
		}
		case 1: {
			affichageRecette();
			break;
		}
		case 2: {
			supprimerRecette();
			break;
		}
		case 3: {
			menu();
			break;
		}
		default:
			System.out.println("Veuillez entrer un numéro compris entre 0 et 3");
			afficherToutesRecettes();
			break;
		}
	}

	private static void affichageRecette() {
		int choix = inputInt("Veuillez entrer le numéro de la recette :");
		while (choix < 0 || choix > livreDeRecettes.getNbRecettes()) {
			System.out.println("Veuillez entrer un numéro entre 1 et " + livreDeRecettes.getNbRecettes() + ".");
			choix = inputInt("Veuillez entrer le numéro de la recette :");
		}
		Recette recetteChoisie = livreDeRecettes.getRecette(choix - 1);
		int personnes = inputInt("Nombre de personnes voulu :");
		recetteChoisie.afficherRecette(personnes);
		
		System.out.println("\n1. Modifier la recette\n");
		System.out.println("2. Faire la recette\n");
		System.out.println("3. Retour au menu\n");
		System.out.println("0. Sortir\n");
		int selection = inputInt("Veuillez entrer le chiffre correspondant à votre requête :");
		switch (selection) {
		case 0: {
			System.exit(0);
		}
		case 1: {
			modifierRecette(choix - 1);
			break;
		}
		case 2: {
			faireRecette(choix - 1);
			menu();
			break;
		}
		case 3: {
			menu();
			break;
		}
		default:
			System.out.println("Veuillez entrer un numéro compris entre 0 et 3");
			affichageRecette();
			break;
		}

	}

	private static void faireRecette(int indice) {
		// TODO Auto-generated method stub

	}

	private static void modifierRecette(int indice) {
		// TODO Auto-generated method stub

	}

	private static void supprimerRecette() {
		int choix = inputInt("Veuillez entrer le numéro de la recette :");
		while (choix < 0 || choix >= livreDeRecettes.getNbRecettes()) {
			System.out.println("Veuillez entrer un numéro entre 1 et " + livreDeRecettes.getNbRecettes() + ".");
			choix = inputInt("Veuillez entrer le numéro de la recette :");
		}
		livreDeRecettes.supprimerRecette(choix - 1);
	}

	private static Recette creerRecette() {
		String nom = inputTexte("Entrez le nom de votre recette :");
		String type = inputTexte(
				"Entrez le type de votre recette en suivant le format:\n DESSERT VIANDE POISSON VEGE\n");
		int personnes = inputInt("Veuillez entrer le nombre de personnes :");
		int temps = inputInt("Veuillez entrer le temps nécessaire à sa réalisation :");
		Recette recette = new Recette(nom, Type.valueOf(type), personnes, temps);
		int suite = 1;
		while (suite != 2) {
			String nomIngredient = inputTexte("Entrez un ingrédient :");
			String unite = inputTexte(
					"Entrez son unité en suivant le format :\n KG | G | MG | L | CL | ML | PINCEE | CAS | CAC | SACHET | SANS\n");
			double quantite = Double.parseDouble(inputTexte("Entrez la quantité :"));
			recette.ajouterIngredient(new Aliment(nomIngredient, Unite.valueOf(unite), quantite));
	
			System.out.println("Voulez vous ajouter un autre ingrédient ?");
			suite=questionFerme();
		}
		return recette;
	}

	private static int questionFerme() {
		int reponse = inputInt("1. Oui | 2. Non\n");
		if (reponse != 1 && reponse != 2) {
			System.out.println("Veuillez entrer 1 ou 2");
			questionFerme();
		}
		return reponse;
	}

	private static void rechercheRecette() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		LivreRecette<Recette> livre = new LivreRecette<>(new Recette[10], "recettes");
		LivreRecette<Viande> livreViande = new LivreRecette<>(new Viande[10], "recettes de viandes");
		LivreRecette<Poisson> livrePoisson = new LivreRecette<>(new Poisson[10], "recettes de poissons");
		LivreRecette<Vegetarien> livreVege = new LivreRecette<>(new Vegetarien[10], "recettes végétariennes");
		LivreRecette<Dessert> livreDessert = new LivreRecette<>(new Dessert[10], "recettes de desserts");
		
		Viande viande = new Viande("Boeuf bourgignon", 300, "BOEUF");
		Poisson poisson = new Poisson("Cabillaud en sauce", 120, "CABILLAUD");
		Vegetarien vege = new Vegetarien("Pates au gruyère", 20, false);
		Dessert dessert = new Dessert("Gateau au chocolat", 30);
		livre.ajouter(viande);
		livre.ajouter(poisson);
		livre.ajouter(vege);
		livre.ajouter(dessert);
		livreViande.ajouter(viande);
		livrePoisson.ajouter(poisson);
		livreVege.ajouter(vege);
		livreDessert.ajouter(dessert);
		System.out.println(livre.afficherListe());
		System.out.println(livreViande.afficherListe());
		System.out.println(livrePoisson.afficherListe());
		System.out.println(livreVege.afficherListe());
		System.out.println(livreDessert.afficherListe());
	}

}
