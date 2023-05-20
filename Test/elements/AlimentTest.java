package elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class AlimentTest {
	
	@Test
	void testAliment() {
		Aliment aliment = new Aliment("oeuf","SANS",6);
		assertNotNull(aliment, "Constructeur ne renvoie pas null");
	}

	@Test
	void testSetNom() {
		Aliment aliment = new Aliment("oeuf","SANS",6);
		aliment.setNom("gros oeuf");
		assertNotEquals(aliment.getNom(), "oeuf");
		assertEquals(aliment.getNom(), "gros oeuf");
	}

	@Test
	void testGetNom() {
		String nom = "oeuf";
		Aliment aliment = new Aliment(nom,"SANS",6);
		assertEquals(aliment.getNom(), nom);
	}

	@Test
	void testGetQuantite() {
		double quantite = 6;
		Aliment aliment = new Aliment("oeuf","SANS", quantite);
		assertEquals(aliment.getQuantite(), 6);
	}

	@Test
	void testSetQuantite() {
		Aliment aliment = new Aliment("oeuf","SANS", 6);
		aliment.setQuantite(4);
		assertNotEquals(aliment.getQuantite(), 6);
		assertEquals(aliment.getQuantite(), 4);
	}

	@Test
	void testAfficherDansListe() {
		Aliment aliment1 = new Aliment("oeuf","SANS", 6.0);
		assertEquals(aliment1.afficherDansListe(), "oeuf : 6");
		Aliment aliment2 = new Aliment("lait","L", 1.50);
		assertEquals(aliment2.afficherDansListe(), "lait : 1.5 L");
		Aliment aliment3 = new Aliment("farine","G", 65.3);
		assertEquals(aliment3.afficherDansListe(), "farine : 65 g");
	}

	@Test
	void testAfficherQuantiteModifiee() {
		Aliment aliment1 = new Aliment("oeuf","SANS", 6);
		assertEquals(aliment1.afficherQuantiteModifiee(2), "oeuf : 12");
		Aliment aliment2 = new Aliment("lait","L", 0.4333);
		assertEquals(aliment2.afficherQuantiteModifiee(2), "lait : 0.9 L");
		Aliment aliment3 = new Aliment("farine","G", 15.3);
		assertEquals(aliment3.afficherQuantiteModifiee(3), "farine : 46 g");
	}

	@Test
	void testVerifierQuantiteSuffisante() {
		Aliment aliment = new Aliment("oeuf","SANS", 6);
		assertTrue(aliment.verifierQuantiteSuffisante(4));
		assertTrue(aliment.verifierQuantiteSuffisante(6));
		assertFalse(aliment.verifierQuantiteSuffisante(7));
	}

}
