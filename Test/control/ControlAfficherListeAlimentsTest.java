package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elements.Aliment;
import elements.ListeAliments;

class ControlAfficherListeAlimentsTest {
	private ListeAliments liste;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		liste = new ListeAliments(20);
	}

	@Test
	void testControlAfficherListeAliments() {
		ControlAfficherListeAliments controlAfficherListeAliments = new ControlAfficherListeAliments(liste);
		assertNotNull(controlAfficherListeAliments, "Constructeur ne renvoie pas null");
	}

	@Test
	void testAfficherListe() {
		ControlAfficherListeAliments controlAfficherListeAliments = new ControlAfficherListeAliments(liste);
		Aliment aliment1 = new Aliment("sucre", "G", 100);
		Aliment aliment2 = new Aliment("lait", "L", 0.55555);
		liste.ajouter(aliment1);
		assertEquals(controlAfficherListeAliments.afficherListe(), " (1) sucre : 100 g\n");
		liste.ajouter(aliment2);
		assertNotEquals(controlAfficherListeAliments.afficherListe(), " (1) sucre : 100 g\n");
		assertEquals(controlAfficherListeAliments.afficherListe(), " (1) sucre : 100 g\n (2) lait : 0.6 L\n");
		assertNotEquals(controlAfficherListeAliments.afficherListe(), " (1) sucre : 100 G\n (2) lait : 0.6 L\n");
		assertNotEquals(controlAfficherListeAliments.afficherListe(), " (1) sucre : 100.0 g\n (2) lait : 55555 L\n");
		
	}

}
