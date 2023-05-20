package recettes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PoissonTest {

	@Test
	void testPoisson() {
		Poisson poisson = new Poisson("Poisson en papillotle", 70, "EGLEFIN");
		assertNotNull(poisson, "Constructeur ne renvoie pas null");
	}

	@Test
	void testGetPoisson() {
		Poisson poisson = new Poisson("Poisson en papillotle", 70, "EGLEFIN");
		assertEquals(poisson.getPoisson(), "EGLEFIN");
	}

}
