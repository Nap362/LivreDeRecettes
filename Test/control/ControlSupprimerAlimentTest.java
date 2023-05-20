package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elements.Aliment;
import elements.ListeAliments;

class ControlSupprimerAlimentTest {
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
	void testControlSupprimerAliment() {
		ControlSupprimerAliment controlSupprimerAliment = new ControlSupprimerAliment(liste);
		assertNotNull(controlSupprimerAliment, "Constructeur ne renvoie pas null");
	}

	@Test
	void testSupprimerAliment() {
		ControlSupprimerAliment controlSupprimerAliment = new ControlSupprimerAliment(liste);
		controlSupprimerAliment.supprimerAliment(0);
		assertEquals(liste.rechercherAliment(aliment.getNom()), -1); // Aliment n'est plus présent dans la liste
	}

}
