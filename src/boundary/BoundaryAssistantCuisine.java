package boundary;

public class BoundaryAssistantCuisine {
	private Clavier clavier;
	private BoundaryCreerRecette boundaryCreerRecette;
	
	public void menu() {
		System.out.println("Bienvenue dans votre assistant de cuisine !\n");
		System.out.println(" 1. Voir mes recettes\n 2. Créer une recette\n 3. Faire une liste de course\n 4. Voir mon placard\n 5. Sortir\n");
		int choix = clavier.saisieInt("Que voulez-vous faire ?");
		switch (choix) {
		case 1: {
			// TODO boundary voir recettes
			break;
		}
		case 2: {
			boundaryCreerRecette.creerRecette();
			break;
		}
		case 3: {
			//TODO boundary creer liste
			break;
		}
		case 4: {
			//TODO voir liste aliments
			break;
		}
		case 5: {
			return;
		}
		default:
			choix = clavier.saisieInt("Commande incorrecte. Veuillez réessayer :");
			break;
		}
	}
}
