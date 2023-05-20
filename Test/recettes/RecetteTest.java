package recettes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elements.Aliment;
import elements.ListeAliments;

class RecetteTest {
	private Recette viande;
	private Recette poisson;
	private Recette vege;
	private Recette dessert;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		viande = new Viande("Hamburger", 40, "BOEUF");
		poisson = new Poisson("Poisson pané", 20, "CABILLAUD");
		vege = new Vegetarien("Jardinière de légumes", 50, true);
		dessert = new Dessert("Ile flottante", 60);
	}

	@Test
	void testGetNom() {
		assertEquals(viande.getNom(), "Hamburger");
		assertEquals(poisson.getNom(), "Poisson pané");
		assertEquals(vege.getNom(), "Jardinière de légumes");
		assertEquals(dessert.getNom(), "Ile flottante");
	}

	@Test
	void testGetTemps() {
		assertEquals(viande.getTemps(), 40);
		assertEquals(poisson.getTemps(), 20);
		assertEquals(vege.getTemps(), 50);
		assertEquals(dessert.getTemps(), 60);
	}

	@Test
	void testSetTemps() {
		viande.setTemps(45);
		assertEquals(viande.getTemps(), 45);
		poisson.setTemps(25);
		assertEquals(poisson.getTemps(), 25);
		vege.setTemps(45);
		assertEquals(vege.getTemps(), 45);
		dessert.setTemps(50);
		assertEquals(dessert.getTemps(), 50);
	}

	@Test
	void testAfficherDansListe() {
		assertEquals(viande.afficherDansListe(), "Hamburger");
		assertEquals(poisson.afficherDansListe(), "Poisson pané");
		assertEquals(vege.afficherDansListe(), "Jardinière de légumes");
		assertEquals(dessert.afficherDansListe(), "Ile flottante");
	}

	@Test
	void testSetListeIngredients() {
		ListeAliments liste = new ListeAliments(2);
		liste.ajouter(new Aliment("sel", "PINCEE", 1));
		viande.setListeIngredients(liste);
		assertEquals(viande.ingredients, liste);
		poisson.setListeIngredients(liste);
		assertEquals(poisson.ingredients, liste);
		vege.setListeIngredients(liste);
		assertEquals(vege.ingredients, liste);
		dessert.setListeIngredients(liste);
		assertEquals(dessert.ingredients, liste);
	}

	@Test
	void testAjouterInstuction() {
		viande.ajouterInstuction("Faire cuire le steak haché.");
		poisson.ajouterInstuction("Battre les oeufs dans une assiette.");
		vege.ajouterInstuction("Couper les carrottes en dés.");
		dessert.ajouterInstuction("Monter les blancs en neige.");
		//Pas de vérification
	}

	@Test
	void testSupprimerInstuction() {
		viande.ajouterInstuction("Faire cuire le steak haché.");
		viande.ajouterInstuction("Faire cuire le steak haché à feu moyen.");
		viande.supprimerInstuction(0);
		poisson.ajouterInstuction("Battre les oeufs dans une assiette.");
		poisson.supprimerInstuction(0);
		vege.ajouterInstuction("Couper les carrottes en dés.");
		vege.supprimerInstuction(0);
		dessert.ajouterInstuction("Monter les blancs en neige.");
		dessert.supprimerInstuction(0);
		//Pas de vérification
	}

	@Test
	void testInsererInstuction() {
		viande.ajouterInstuction("Faire cuire le steak haché.");
		viande.ajouterInstuction("Mettre la salade sur le pain inférieur.");
		viande.insererInstuction("Couper et faire dorer le pain.", 1);
		poisson.ajouterInstuction("Battre les oeufs dans une assiette.");
		poisson.ajouterInstuction("Recouvrir le poisson de chapelure.");
		poisson.insererInstuction("Tremper le poisson dans les oeufs battus.", 1);
		vege.ajouterInstuction("Couper les carrottes en dés.");
		vege.ajouterInstuction("Faire revenir les légumes.");
		vege.insererInstuction("Ajouter les autres légumes", 1);
		dessert.ajouterInstuction("Monter les blancs en neige.");
		dessert.ajouterInstuction("Ajouter le sucre.");
		dessert.insererInstuction("Mélanger les jaunes et le lait", 1);
		//Pas de vérification
	}

	@Test
	void testAfficher() {
		ListeAliments liste = new ListeAliments(2);
		liste.ajouter(new Aliment("steak haché", "SANS", 1));
		liste.ajouter(new Aliment("pain à hamburger", "SANS", 1));
		viande.setListeIngredients(liste);
		viande.ajouterInstuction("Faire cuire le steak haché.");
		StringBuilder affichage1 = new StringBuilder();
		affichage1.append("\tHamburger :\n");
		affichage1.append("Pour 2 personnes\nTemps de réalisation : 40 min\n");
		affichage1.append("Ingrédients :\n (1) steak haché : 2\n (2) pain à hamburger : 2\n");
		affichage1.append("\nRéalisation :\nInstructions :\n1. Faire cuire le steak haché.\n");
		assertEquals(viande.afficher(2), affichage1.toString());
		viande.setTemps(65);
		StringBuilder affichage2 = new StringBuilder();
		affichage2.append("\tHamburger :\n");
		affichage2.append("Pour 2 personnes\nTemps de réalisation : 1h05\n");
		affichage2.append("Ingrédients :\n (1) steak haché : 2\n (2) pain à hamburger : 2\n");
		affichage2.append("\nRéalisation :\nInstructions :\n1. Faire cuire le steak haché.\n");
		assertEquals(viande.afficher(2), affichage2.toString());
		//Idem pour autres types
	}

	@Test
	void testRecetteRealisable() {
		ListeAliments liste = new ListeAliments(2);
		liste.ajouter(new Aliment("steak haché", "SANS", 1));
		liste.ajouter(new Aliment("pain à hamburger", "SANS", 1));
		viande.setListeIngredients(liste);
		ListeAliments placard = new ListeAliments(2);
		placard.ajouter(new Aliment("steak haché", "SANS", 3));
		assertFalse(viande.recetteRealisable(placard));
		placard.ajouter(new Aliment("pain à hamburger", "SANS", 1));
		assertTrue(viande.recetteRealisable(placard));
		//Idem pour autres types
	}

	@Test
	void testRecetteContientAuMoinsUnIngredient() {
		ListeAliments liste = new ListeAliments(2);
		liste.ajouter(new Aliment("steak haché", "SANS", 1));
		liste.ajouter(new Aliment("pain à hamburger", "SANS", 1));
		viande.setListeIngredients(liste);
		String[] recherche1 = {"oeuf", "noix de cajou", "carrote"};
		String[] recherche2 = {"tomate", "steak haché"};
		assertFalse(viande.recetteContientAuMoinsUnIngredient(recherche1));
		assertTrue(viande.recetteContientAuMoinsUnIngredient(recherche2));
		//Idem pour autres types
	}

}
