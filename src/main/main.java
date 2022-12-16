package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import recettes.ListeDesRecettes;
import recettes.Recette;

public class main {
	private static ListeDesRecettes livreDeRecettes;

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
			Recette nouvelleRecette=creerRecette();
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
		while (choix<0 || choix>=livreDeRecettes.getNbRecettes()) {
			System.out.println("Veuillez entrer un numéro entre 1 et " + livreDeRecettes.getNbRecettes() + ".");
			choix = inputInt("Veuillez entrer le numéro de la recette :");
		}
		Recette recetteChoisie =livreDeRecettes.getRecette(choix-1);
		recetteChoisie.afficherRecette(choix);
		
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
			modifierRecette(choix-1);
			break;
		}
		case 2: {
			faireRecette(choix-1);
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
		while (choix<0 || choix>=livreDeRecettes.getNbRecettes()) {
			System.out.println("Veuillez entrer un numéro entre 1 et " + livreDeRecettes.getNbRecettes() + ".");
			choix = inputInt("Veuillez entrer le numéro de la recette :");
		}
		livreDeRecettes.supprimerRecette(choix-1);
	}


	private static Recette creerRecette() {
		return null;
		// TODO Auto-generated method stub

	}
	private static void rechercheRecette() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		livreDeRecettes = new ListeDesRecettes();
		menu();
	}

}
