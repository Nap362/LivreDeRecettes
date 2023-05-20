package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import elements.LivreRecette;
import recettes.Recette;

class ControlCreerRecetteTest {
	LivreRecette<Recette> livre;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		Recette[] recettes = new Recette[10];
		livre = new LivreRecette<>(recettes, "Les recettes");
	}

	@Test
	void testControlCreerRecette() {
		ControlCreerRecette controlCreerRecette = new ControlCreerRecette(livre);
		assertNotNull(controlCreerRecette, "Constructeur ne renvoie pas null");
	}

	@Test
	void testCreerViande() {
		ControlCreerRecette controlCreerRecette = new ControlCreerRecette(livre);
		controlCreerRecette.creerViande("Boeuf bourgignon", 120, "BOEUF");
		assertEquals(livre.getNbRecettes(), 1);
	}

	@Test
	void testCreerPoisson() {
		ControlCreerRecette controlCreerRecette = new ControlCreerRecette(livre);
		controlCreerRecette.creerPoisson("Poisson au four", 45, "CABILLAUD");
		assertEquals(livre.getNbRecettes(), 1);
	}

	@Test
	void testCreerVegetarien() {
		ControlCreerRecette controlCreerRecette = new ControlCreerRecette(livre);
		controlCreerRecette.creerVegetarien("Salade de tomates", 20, true);
		assertEquals(livre.getNbRecettes(), 1);
	}

	@Test
	void testCreerDessert() {
		ControlCreerRecette controlCreerRecette = new ControlCreerRecette(livre);
		controlCreerRecette.creerDessert("Gateau au chocolat", 45);
		assertEquals(livre.getNbRecettes(), 1);
	}

	@Test
	void testAjouterAliment() {
		ControlCreerRecette controlCreerRecette = new ControlCreerRecette(livre);
		controlCreerRecette.ajouterAliment("chocolat", "G", 200);
		//Pas de vérification
		
	}

	@Test
	void testAjouterInstruction() {
		ControlCreerRecette controlCreerRecette = new ControlCreerRecette(livre);
		controlCreerRecette.creerDessert("Gateau au chocolat", 45);
		controlCreerRecette.ajouterInstruction("Faire fondre le chocolat");
		//Pas de vérification
	}

}
