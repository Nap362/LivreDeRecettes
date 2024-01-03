package elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListeAlimentsTest {

	@Test
	void testListeAliments() {
		ListeAliments liste = new ListeAliments();
		assertNotNull(liste, "Constructeur ne renvoie pas null");
	}

	@Test
	void testAjouter() {
		ListeAliments liste = new ListeAliments();
		Aliment aliment = new Aliment("farine", "G", 100);
		Aliment aliment2 = new Aliment("farine", "G", 100);
		assertNull(liste.rechercherAliment(aliment.getNom())); //Non présent
		liste.ajouter(aliment);
		assertEquals(liste.rechercherAliment(aliment.getNom()), aliment); //Présent à l'indice 0
		assertEquals(liste.getNbrAliments(), 1);
		liste.ajouter(aliment2);
		assertEquals(liste.getNbrAliments(), 1); //aliment2 n'a pas été ajouté car deja présent
		
	}

	@Test
	void testSupprimer() {
		ListeAliments liste = new ListeAliments();
		Aliment aliment1 = new Aliment("farine", "G", 100);
		Aliment aliment2 = new Aliment("sucre", "G", 300);
		Aliment aliment3 = new Aliment("sel", "G", 20);
		liste.ajouter(aliment1);
		liste.ajouter(aliment2);
		liste.ajouter(aliment3);
		assertEquals(liste.rechercherAliment(aliment1.getNom()), aliment1); //Présent à l'indice 0
		liste.supprimer(aliment1.getNom());
		assertNull(liste.rechercherAliment(aliment1.getNom())); //Non présent
		assertEquals(liste.rechercherAliment(aliment3.getNom()), aliment3); //Présent à l'indice 0
		liste.supprimer(aliment3.getNom());
		assertNull(liste.rechercherAliment(aliment3.getNom())); //Non présent
	}

	@Test
	void testAfficherListe() {
		ListeAliments liste = new ListeAliments();
		Aliment aliment1 = new Aliment("farine", "G", 100);
		Aliment aliment2 = new Aliment("sucre", "SACHET", 2);
		liste.ajouter(aliment1);
		assertEquals(liste.afficherListe(), " - farine : 100 g\n");
		liste.ajouter(aliment2);
		assertEquals(liste.afficherListe(), " - sucre : 2 sachet(s)\n - farine : 100 g\n");
	}

	@Test
	void testGetQuantiteAliment() {
		ListeAliments liste = new ListeAliments();
		Aliment aliment = new Aliment("farine", "G", 100);
		liste.ajouter(aliment);
		assertEquals(liste.getQuantiteAliment(aliment.getNom()), aliment.getQuantite());
	}

	@Test
	void testModifierNom() {
		ListeAliments liste = new ListeAliments();
		Aliment aliment = new Aliment("farine", "G", 100);
		liste.ajouter(aliment);
		liste.modifierNom(aliment.getNom(), "farine de blé");
		assertEquals(aliment.getNom(), "farine de blé");
		assertNotEquals(aliment.getNom(), "farine");
	}

	@Test
	void testModifierQuantite() {
		ListeAliments liste = new ListeAliments();
		Aliment aliment = new Aliment("farine", "G", 100);
		liste.ajouter(aliment);
		liste.modifierQuantite(aliment.getNom(), 200);
		assertEquals(aliment.getQuantite(), 200);
		assertNotEquals(aliment.getQuantite(), 100);
	}

	@Test
	void testAfficherListePersonne() {
		ListeAliments liste = new ListeAliments();
		Aliment aliment1 = new Aliment("farine", "G", 100);
		Aliment aliment2 = new Aliment("sucre", "SACHET", 2);
		liste.ajouter(aliment1);
		liste.ajouter(aliment2);
		assertEquals(liste.afficherListePersonne(2), " - sucre : 4 sachet(s)\n - farine : 200 g\n");
		assertEquals(liste.afficherListePersonne(3), " - sucre : 6 sachet(s)\n - farine : 300 g\n");
		assertEquals(liste.afficherListePersonne(1), liste.afficherListe());
	}

	@Test
	void testRechercherAliment() {
		ListeAliments liste = new ListeAliments();
		Aliment aliment = new Aliment("sucre", "SACHET", 2);
		liste.ajouter(aliment);
		assertEquals(liste.rechercherAliment(aliment.getNom()), aliment);
		assertNull(liste.rechercherAliment("Sucre"));
		assertNull(liste.rechercherAliment("farine"));
	}

	@Test
	void testFaireCourses() {
		ListeAliments listeCourses = new ListeAliments();
		ListeAliments placard = new ListeAliments();
		Aliment aliment1 = new Aliment("sucre", "SACHET", 1);
		Aliment aliment2 = new Aliment("farine", "G", 200);
		Aliment aliment3 = new Aliment("pomme", "SANS", 5);
		Aliment aliment4 = new Aliment("pomme", "SANS", 1);
		listeCourses.ajouter(aliment1);
		listeCourses.ajouter(aliment2);
		listeCourses.ajouter(aliment3);
		placard.ajouter(aliment4);
		listeCourses.faireCourses(placard);
		assertNull(listeCourses.rechercherAliment(aliment1.getNom()));
		assertNull(listeCourses.rechercherAliment(aliment2.getNom()));
		assertNull(listeCourses.rechercherAliment(aliment3.getNom()));
		assertEquals(placard.rechercherAliment(aliment1.getNom()), aliment1);
		assertEquals(placard.rechercherAliment(aliment2.getNom()), aliment2);
		assertEquals(placard.rechercherAliment(aliment3.getNom()), aliment3);
		assertEquals(placard.getQuantiteAliment(aliment4.getNom()), 6);
	}

	@Test
	void testContientAuMoinsUnIngredient() {
		ListeAliments liste = new ListeAliments();
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
		ListeAliments liste = new ListeAliments();
		ListeAliments placard = new ListeAliments();
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
