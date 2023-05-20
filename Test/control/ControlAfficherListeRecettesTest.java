package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import elements.LivreRecette;
import recettes.Dessert;
import recettes.Poisson;
import recettes.Recette;
import recettes.Vegetarien;
import recettes.Viande;

class ControlAfficherListeRecettesTest {
	private LivreRecette<Recette> livreRecettes;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		Recette[] recettes = new Recette[10];
		livreRecettes = new LivreRecette<>(recettes, "Livre de recettes test");
	}

	@Test
	void testControlAfficherListeRecettes() {
		ControlAfficherListeRecettes controlAfficherListeRecettes = new ControlAfficherListeRecettes(livreRecettes);
		assertNotNull(controlAfficherListeRecettes, "Constructeur ne renvoie pas null");
	}

	@Test
	void testAfficherListeRecettes() {
		ControlAfficherListeRecettes controlAfficherListeRecettes = new ControlAfficherListeRecettes(livreRecettes);
		Viande viande = new Viande("Boeuf bourgignon", 180, "BOEUF");
		Poisson poisson = new Poisson("Saumon au four", 40, "SAUMON");
		Vegetarien vegetarien = new Vegetarien("Ratatouille", 120, true);
		Dessert dessert = new Dessert("Meringues", 100);
		assertEquals(controlAfficherListeRecettes.afficherListeRecettes(), "\tLivre de recettes test :\n");
		livreRecettes.ajouter(viande);
		assertEquals(controlAfficherListeRecettes.afficherListeRecettes(),
				"\tLivre de recettes test :\n1. Boeuf bourgignon\n");
		livreRecettes.ajouter(poisson);
		livreRecettes.ajouter(vegetarien);
		livreRecettes.ajouter(dessert);
		assertEquals(controlAfficherListeRecettes.afficherListeRecettes(),
				"\tLivre de recettes test :\n1. Boeuf bourgignon\n2. Saumon au four\n3. Ratatouille\n4. Meringues\n");
		assertNotEquals(controlAfficherListeRecettes.afficherListeRecettes(),
				"1. Boeuf bourgignon\n2.Saumon au four\n3. Ratatouille\n4. Meringues\n");
	}

}
