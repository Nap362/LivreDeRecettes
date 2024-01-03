package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elements.Aliment;
import elements.ListeAliments;

class ControlFaireCoursesTest {
	private ListeAliments listeCourses;
	private ListeAliments placard;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		listeCourses = new ListeAliments();
		placard = new ListeAliments();
	}

	@Test
	void testControlFaireCoursesTest() {
		ControlFaireCourses controlFaireCourses = new ControlFaireCourses(placard, listeCourses);
		assertNotNull(controlFaireCourses, "Constructeur ne renvoie pas null");
	}

	@Test
	void testFaireCourses() {
		ControlFaireCourses controlFaireCourses = new ControlFaireCourses(placard, listeCourses);
		Aliment pomme = new Aliment("pomme", "G", 300);
		Aliment sucre1 = new Aliment("sucre", "G", 150);
		Aliment sucre2 = new Aliment("sucre", "G", 1000);
		Aliment oeuf = new Aliment("oeuf", "SANS", 3);
		placard.ajouter(sucre1);
		placard.ajouter(oeuf);
		listeCourses.ajouter(sucre2);
		listeCourses.ajouter(pomme);
		controlFaireCourses.faireCourses();
		assertEquals(placard.rechercherAliment(pomme.getNom()), pomme);
		assertEquals(placard.getQuantiteAliment(sucre1.getNom()), 1150);
		assertNull(listeCourses.rechercherAliment(pomme.getNom()));
	}

}
