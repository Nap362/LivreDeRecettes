package boundary;

public class BoundaryMenuLivreRecette {
	private Clavier clavier = new Clavier();
	

	public void menuLivreRecette() {
		int choix;
		StringBuilder question = new StringBuilder();
		question.append("Que voulez-vous faire ?\n");
		question.append("1 - Voir une recette\n");
		question.append("2 - Supprimer une recette\n");
		question.append("3 - Filtrer les recettes par type\n");
		question.append("4 - Filtrer les recettes par temps de préparation\n");
		question.append("5 - Filtrer les recettes que vous pouvez réaliser\n");
		question.append("6 - Retour au menu principal\n");
		do {
			choix = clavier.saisieInt(question.toString());
			switch (choix) {
			case 1: {
				//TODO void recette
				break;
			}
			case 2: {
				//TODO supprimer recette
				break;
			}
			case 3: {
				// TODO filtrer type
				break;
			}
			case 4: {
				// TODO filtrer temps
				break;
			}
			case 5: {
				// TODO filtrer realisables
				break;
			}
			case 6: {
				System.out.println("Retour au menu principal\n");
				break;
			}
			default:
				System.out.println("Vous devez saisir un chiffre entre 1 et 7\n");
				break;
			}
		} while (choix != 6);
	}
}
