package elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListeAlimentsTest {

	@Test
	void testListeAliments() {
		ListeAliments liste = new ListeAliments(10);
		assertNotNull(liste, "Constructeur ne renvoie pas null");
	}

	@Test
	void testAjouter() {
		ListeAliments liste = new ListeAliments(1);
		Aliment aliment = new Aliment("farine", "G", 100);
		Aliment aliment2 = new Aliment("sucre", "G", 100);
		assertEquals(liste.rechercherAliment(aliment.getNom()), -1); //Non présent
		liste.ajouter(aliment);
		liste.ajouter(aliment2);
		assertEquals(liste.rechercherAliment(aliment.getNom()), 0); //Présent à l'indice 0
		assertEquals(liste.rechercherAliment(aliment2.getNom()), -1); // n'a pas pu être ajouté
	}

	@Test
	void testSupprimer() {
		ListeAliments liste = new ListeAliments(10);
		Aliment aliment1 = new Aliment("farine", "G", 100);
		Aliment aliment2 = new Aliment("sucre", "G", 300);
		Aliment aliment3 = new Aliment("sel", "G", 20);
		liste.ajouter(aliment1);
		liste.ajouter(aliment2);
		liste.ajouter(aliment3);
		assertEquals(liste.rechercherAliment(aliment1.getNom()), 0); //Présent à l'indice 0
		liste.supprimer(0);
		assertEquals(liste.rechercherAliment(aliment1.getNom()), -1); //Non présent
		assertEquals(liste.rechercherAliment(aliment3.getNom()), 1); //Présent à l'indice 0
		liste.supprimer(1);
		assertEquals(liste.rechercherAliment(aliment3.getNom()), -1); //Non présent
	}

	@Test
	void testAfficherListe() {
		ListeAliments liste = new ListeAliments(10);
		Aliment aliment1 = new Aliment("farine", "G", 100);
		Aliment aliment2 = new Aliment("sucre", "SACHET", 2);
		liste.ajouter(aliment1);
		assertEquals(liste.afficherListe(), " (1) farine : 100 g\n");
		liste.ajouter(aliment2);
		assertEquals(liste.afficherListe(), " (1) farine : 100 g\n (2) sucre : 2 sachet(s)\n");
	}

	@Test
	void testGetQuantiteAliment() {
		ListeAliments liste = new ListeAliments(10);
		Aliment aliment = new Aliment("farine", "G", 100);
		liste.ajouter(aliment);
		assertEquals(liste.getQuantiteAliment(0), aliment.getQuantite());
	}

	@Test
	void testModifierNom() {
		ListeAliments liste = new ListeAliments(10);
		Aliment aliment = new Aliment("farine", "G", 100);
		liste.ajouter(aliment);
		liste.modifierNom(0, "farine de blé");
		assertEquals(aliment.getNom(), "farine de blé");
		assertNotEquals(aliment.getNom(), "farine");
	}

	@Test
	void testModifierQuantite() {
		ListeAliments liste = new ListeAliments(10);
		Aliment aliment = new Aliment("farine", "G", 100);
		liste.ajouter(aliment);
		liste.modifierQuantite(0, 200);
		assertEquals(aliment.getQuantite(), 200);
		assertNotEquals(aliment.getQuantite(), 100);
	}

	@Test
	void testAfficherListePersonne() {
		ListeAliments liste = new ListeAliments(10);
		Aliment aliment1 = new Aliment("farine", "G", 100);
		Aliment aliment2 = new Aliment("sucre", "SACHET", 2);
		liste.ajouter(aliment1);
		liste.ajouter(aliment2);
		assertEquals(liste.afficherListePersonne(2), " (1) farine : 200 g\n (2) sucre : 4 sachet(s)\n");
		assertEquals(liste.afficherListePersonne(3), " (1) farine : 300 g\n (2) sucre : 6 sachet(s)\n");
		assertEquals(liste.afficherListePersonne(1), liste.afficherListe());
	}

	@Test
	void testRechercherAliment() {
		ListeAliments liste = new ListeAliments(10);
		Aliment aliment = new Aliment("sucre", "SACHET", 2);
		liste.ajouter(aliment);
		assertEquals(liste.rechercherAliment(aliment.getNom()), 0);
		assertEquals(liste.rechercherAliment("Sucre"), -1);
		assertEquals(liste.rechercherAliment("farine"), -1);
	}

	@Test
	void testFaireCourses() {
		ListeAliments listeCourses = new ListeAliments(10);
		ListeAliments placard = new ListeAliments(10);
		Aliment aliment1 = new Aliment("sucre", "SACHET", 1);
		Aliment aliment2 = new Aliment("farine", "G", 200);
		Aliment aliment3 = new Aliment("pomme", "SANS", 5);
		Aliment aliment4 = new Aliment("pomme", "SANS", 1);
		listeCourses.ajouter(aliment1);
		listeCourses.ajouter(aliment2);
		listeCourses.ajouter(aliment3);
		placard.ajouter(aliment4);
		listeCourses.faireCourses(placard);
		assertEquals(listeCourses.rechercherAliment(aliment1.getNom()), -1);
		assertEquals(listeCourses.rechercherAliment(aliment2.getNom()), -1);
		assertEquals(listeCourses.rechercherAliment(aliment3.getNom()), -1);
		assertEquals(placard.rechercherAliment(aliment1.getNom()), 2);
		assertEquals(placard.rechercherAliment(aliment2.getNom()), 1);
		assertEquals(placard.rechercherAliment(aliment3.getNom()), 0);
		assertEquals(placard.getQuantiteAliment(0), 6);
	}

	@Test
	void testContientAuMoinsUnIngredient() {
		ListeAliments liste = new ListeAliments(10);
		String[] recherche1 = {"lait", "fromage", "yaourt", "crème fraiche"} ;
		String[] recherche2 = {"noix", "cacahuete", "noisette"} ;
		Aliment aliment1 = new Aliment("sucre", "SACHET", 1);
		Aliment aliment2 = new Aliment("farine", "G", 200);
		Aliment aliment3 = new Aliment("yaourt", "SANS", 2);
		liste.ajouter(aliment1);
		liste.ajouter(aliment2);
		liste.ajouter(aliment3);
		assertTrue(liste.contientAuMoinsUnIngredient(recherche1));
		assertFalse(liste.contientAuMoinsUnIngredient(recherche2));
	}

	@Test
	void testTousIngredientsDisponibles() {
		ListeAliments liste = new ListeAliments(10);
		ListeAliments placard = new ListeAliments(10);
		Aliment aliment1 = new Aliment("sucre", "SACHET", 4);
		Aliment aliment2 = new Aliment("farine", "G", 200);
		Aliment aliment3 = new Aliment("yaourt", "SANS", 2);
		placard.ajouter(aliment1);
		placard.ajouter(aliment2);
		placard.ajouter(aliment3);
		liste.ajouter(new Aliment("sucre", "SACHET", 3));
		liste.ajouter(new Aliment("farine", "G", 200));
		assertTrue(placard.tousIngredientsDisponibles(liste));
		liste.ajouter(new Aliment("oeuf", "SANS", 3));
		assertFalse(placard.tousIngredientsDisponibles(liste));
	}

}
