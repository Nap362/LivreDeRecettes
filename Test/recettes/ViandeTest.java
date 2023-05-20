package recettes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ViandeTest {

	@Test
	void testViande() {
		Viande viande = new Viande("Steak", 30, "BOEUF");
		assertNotNull(viande, "Constructeur ne renvoie pas null");
	}

	@Test
	void testGetType() {
		Viande viande = new Viande("Steak", 30, "BOEUF");
		assertEquals(viande.getType(), "BOEUF");
	}

}
