package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elements.ListeAliments;

class ControlAjouterAlimentTest {
	private ListeAliments liste;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		liste = new ListeAliments();
	}

	@Test
	void testControlAjouterAlimentTest() {
		ControlAjouterAliment controlAjouterAliment = new ControlAjouterAliment(liste);
		assertNotNull(controlAjouterAliment, "Constructeur ne renvoie pas null");
	}

	@Test
	void testAjouterAliment() {
		ControlAjouterAliment controlAjouterAliment = new ControlAjouterAliment(liste);
		controlAjouterAliment.ajouterAliment("farine", "G", 200);
		//Pas de vérification
	}

}
