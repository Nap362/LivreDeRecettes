package recettes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VegetarienTest {

	@Test
	void testVegetarien() {
		Vegetarien vege = new Vegetarien("Salade de tomate", 10, true);
		assertNotNull(vege, "Constructeur ne renvoie pas null");
	}

	@Test
	void testConvientVegan() {
		Vegetarien vege = new Vegetarien("Salade de tomate", 10, true);
		Vegetarien vege2 = new Vegetarien("Omelette pomme de terre", 15, false);
		assertTrue(vege.convientVegan());
		assertFalse(vege2.convientVegan());
	}

}
