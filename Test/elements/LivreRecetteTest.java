package elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import recettes.Dessert;
import recettes.Poisson;
import recettes.Recette;
import recettes.Vegetarien;
import recettes.Viande;

class LivreRecetteTest {

	@Test
	void testLivreRecette() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		assertNotNull(livreRecettes, "Constructeur ne renvoie pas null");
	}

	@Test
	void testGetRecette() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		Viande viande = new Viande("Steak", 20, "BOEUF");
		Poisson poisson = new Poisson("Poisson au four", 40, "SAUMON");
		Vegetarien vege = new Vegetarien("Légumes", 20, true);
		Dessert dessert = new Dessert("Gateau", 35);
		livreRecettes.ajouter(viande);
		livreRecettes.ajouter(poisson);
		livreRecettes.ajouter(vege);
		livreRecettes.ajouter(dessert);
		assertEquals(livreRecettes.getRecette(0), viande);
		assertEquals(livreRecettes.getRecette(1), poisson);
		assertEquals(livreRecettes.getRecette(2), vege);
		assertEquals(livreRecettes.getRecette(3), dessert);
	}

	@Test
	void testGetNbRecettes() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		assertEquals(livreRecettes.getNbRecettes(), 0);
		Viande viande = new Viande("Steak", 20, "BOEUF");
		Poisson poisson = new Poisson("Poisson au four", 40, "SAUMON");
		Vegetarien vege = new Vegetarien("Légumes", 20, true);
		Dessert dessert = new Dessert("Gateau", 35);
		livreRecettes.ajouter(viande);
		livreRecettes.ajouter(poisson);
		livreRecettes.ajouter(vege);
		livreRecettes.ajouter(dessert);
		assertEquals(livreRecettes.getNbRecettes(), 4);
	}

	@Test
	void testAjouter() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		assertEquals(livreRecettes.getNbRecettes(), 0);
		Viande viande = new Viande("Steak", 20, "BOEUF");
		Poisson poisson = new Poisson("Poisson au four", 40, "SAUMON");
		Vegetarien vege = new Vegetarien("Légumes", 20, true);
		Dessert dessert = new Dessert("Gateau", 35);
		livreRecettes.ajouter(viande);
		livreRecettes.ajouter(poisson);
		livreRecettes.ajouter(vege);
		livreRecettes.ajouter(dessert);
		assertEquals(livreRecettes.rechercherNom(viande.getNom()), 0);
		assertEquals(livreRecettes.rechercherNom(poisson.getNom()), 1);
		assertEquals(livreRecettes.rechercherNom(vege.getNom()), 2);
		assertEquals(livreRecettes.rechercherNom(dessert.getNom()), 3);

	}

	@Test
	void testSupprimer() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		assertEquals(livreRecettes.getNbRecettes(), 0);
		Viande viande = new Viande("Steak", 20, "BOEUF");
		Poisson poisson = new Poisson("Poisson au four", 40, "SAUMON");
		Vegetarien vege = new Vegetarien("Légumes", 20, true);
		Dessert dessert = new Dessert("Gateau", 35);
		livreRecettes.ajouter(viande);
		livreRecettes.ajouter(poisson);
		livreRecettes.ajouter(vege);
		livreRecettes.ajouter(dessert);
		assertEquals(livreRecettes.getNbRecettes(), 4);
		livreRecettes.supprimer(0);
		livreRecettes.supprimer(2);
		assertEquals(livreRecettes.getNbRecettes(), 2);
	}

	@Test
	void testAfficherListe() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		assertEquals(livreRecettes.getNbRecettes(), 0);
		Viande viande = new Viande("Steak", 20, "BOEUF");
		Poisson poisson = new Poisson("Poisson au four", 40, "SAUMON");
		Vegetarien vege = new Vegetarien("Légumes", 20, true);
		Dessert dessert = new Dessert("Gateau", 35);
		livreRecettes.ajouter(viande);
		livreRecettes.ajouter(poisson);
		livreRecettes.ajouter(vege);
		livreRecettes.ajouter(dessert);
		StringBuilder affichage = new StringBuilder();
		affichage.append("\tLivre de recettes :\n");
		affichage.append("1. Steak\n");
		affichage.append("2. Poisson au four\n");
		affichage.append("3. Légumes\n");
		affichage.append("4. Gateau\n");
		assertEquals(livreRecettes.afficherListe(), affichage.toString());
	}

	@Test
	void testRechercherNom() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		assertEquals(livreRecettes.getNbRecettes(), 0);
		Viande viande = new Viande("Steak", 20, "BOEUF");
		Poisson poisson = new Poisson("Poisson au four", 40, "SAUMON");
		Vegetarien vege = new Vegetarien("Légumes", 20, true);
		Dessert dessert = new Dessert("Gateau", 35);
		livreRecettes.ajouter(viande);
		livreRecettes.ajouter(poisson);
		livreRecettes.ajouter(vege);
		livreRecettes.ajouter(dessert);
		assertEquals(livreRecettes.rechercherNom(livreRecettes.getRecette(0).getNom()), 0);
		assertEquals(livreRecettes.rechercherNom("Tarte"), -1);
	}
	
	@Test
	void testFiltrerTemps() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		assertEquals(livreRecettes.getNbRecettes(), 0);
		Viande viande = new Viande("Steak", 20, "BOEUF");
		ListeAliments liste1 = new ListeAliments();
		liste1.ajouter(new Aliment("steak", "G", 150));
		viande.setListeIngredients(liste1);
		Poisson poisson = new Poisson("Poisson au four", 40, "SAUMON");
		ListeAliments liste2 = new ListeAliments();
		liste2.ajouter(new Aliment("saumon", "G", 200));
		liste2.ajouter(new Aliment("oignon", "SANS", 0.5));
		poisson.setListeIngredients(liste2);
		
		livreRecettes.ajouter(viande);
		livreRecettes.ajouter(poisson);
		String affichage = "> 1. Steak";
		assertEquals(livreRecettes.filtrerTemps(25), affichage);
		
	}
	
	@Test
	void testFiltrerType() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		assertEquals(livreRecettes.getNbRecettes(), 0);
		Viande viande = new Viande("Steak", 20, "BOEUF");
		Poisson poisson = new Poisson("Poisson au four", 40, "SAUMON");
		
		livreRecettes.ajouter(viande);
		livreRecettes.ajouter(poisson);
		String affichage = "> 1. Poisson au four\n";
		assertEquals(livreRecettes.filtrerType("Poisson"), affichage);
		
	}

	@Test
	void testFiltrerEviterIngredients() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		assertEquals(livreRecettes.getNbRecettes(), 0);
		Viande viande = new Viande("Steak", 20, "BOEUF");
		ListeAliments liste1 = new ListeAliments();
		liste1.ajouter(new Aliment("steak", "G", 150));
		viande.setListeIngredients(liste1);
		Poisson poisson = new Poisson("Poisson au four", 40, "SAUMON");
		ListeAliments liste2 = new ListeAliments();
		liste2.ajouter(new Aliment("saumon", "G", 200));
		liste2.ajouter(new Aliment("oignon", "SANS", 0.5));
		poisson.setListeIngredients(liste2);
		
		livreRecettes.ajouter(viande);
		livreRecettes.ajouter(poisson);
		String[] eviter = {"saumon", "creme fraiche"};
		String affichage = "> 1. Steak";
		assertEquals(livreRecettes.filtrerEviterIngredients(eviter), affichage);
		
	}

	@Test
	void testFiltrerRecettesRealisables() {
		LivreRecette<Recette> livreRecettes = new LivreRecette<>("Livre de recettes");
		assertEquals(livreRecettes.getNbRecettes(), 0);
		Viande viande = new Viande("Steak", 20, "BOEUF");
		ListeAliments liste1 = new ListeAliments();
		liste1.ajouter(new Aliment("steak", "G", 150));
		viande.setListeIngredients(liste1);
		Poisson poisson = new Poisson("Poisson au four", 40, "SAUMON");
		ListeAliments liste2 = new ListeAliments();
		liste2.ajouter(new Aliment("saumon", "G", 200));
		liste2.ajouter(new Aliment("oignon", "SANS", 0.5));
		poisson.setListeIngredients(liste2);
		
		livreRecettes.ajouter(viande);
		livreRecettes.ajouter(poisson);
		ListeAliments placard = new ListeAliments();
		placard.ajouter(new Aliment("oignon", "SANS", 2));
		placard.ajouter(new Aliment("saumon", "G", 200));
		String affichage = "> 1. Poisson au four";
		assertEquals(livreRecettes.filtrerRecettesRealisables(placard), affichage);
	}

}
