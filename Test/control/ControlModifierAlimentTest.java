package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elements.Aliment;
import elements.ListeAliments;

class ControlModifierAlimentTest {
	private Aliment aliment;
	private ListeAliments liste;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		liste= new ListeAliments(10);
		aliment = new Aliment("sucre", "G", 100);
		liste.ajouter(aliment);
	}

	@Test
	void testControlModifierAliment() {
		ControlModifierAliment controlModifierAliment = new ControlModifierAliment(liste);
		assertNotNull(controlModifierAliment, "Constructeur ne renvoie pas null");
	}

	@Test
	void testModifierNom() {
		ControlModifierAliment controlModifierAliment = new ControlModifierAliment(liste);
		controlModifierAliment.modifierNom(0, "sucre de canne");
		assertNotEquals(aliment.getNom(), "sucre");
		assertEquals(aliment.getNom(), "sucre de canne");
	}

	@Test
	void testModifierQuantite() {
		ControlModifierAliment controlModifierAliment = new ControlModifierAliment(liste);
		controlModifierAliment.modifierQuantite(0, 50);
		assertNotEquals(aliment.getQuantite(), 100);
		assertEquals(aliment.getQuantite(), 50);
	}

}
