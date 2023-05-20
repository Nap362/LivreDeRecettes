package recettes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DessertTest {

	@Test
	void testDessert() {
		Dessert dessert = new Dessert("Tarte au pomme", 45);
		assertNotNull(dessert, "Constructeur ne renvoie pas null");
	}

}
