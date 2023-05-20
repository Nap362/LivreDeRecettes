package boundary;


public class BoundaryMenuPlacard {
	private Clavier clavier = new Clavier();
	private BoundaryAjouterAliment boundaryAjouterAliment;
	private BoundarySupprimerAliment boundarySupprimerAliment;
	private BoundaryModifierAliment boundaryModifierAliment;

	public BoundaryMenuPlacard(BoundaryAjouterAliment boundaryAjouterAliment,
			BoundarySupprimerAliment boundarySupprimerAliment, BoundaryModifierAliment boundaryModifierAliment) {
		this.boundaryAjouterAliment = boundaryAjouterAliment;
		this.boundaryModifierAliment = boundaryModifierAliment;
		this.boundarySupprimerAliment = boundarySupprimerAliment;
	}
	
	public void menuPlacard() {
		int choix;
		StringBuilder question = new StringBuilder();
		question.append("Que voulez-vous faire ?\n");
		question.append("1 - Ajouter un aliment\n");
		question.append("2 - Supprimer un aliment\n");
		question.append("3 - Modifier un aliment\n");
		question.append("4 - Retour au menu principal\n");
		do {
			choix = clavier.saisieInt(question.toString());
			switch (choix) {
			case 1: {
				boundaryAjouterAliment.ajouterAliment();
				break;
			}
			case 2: {
				boundarySupprimerAliment.supprimerAliment();
				break;
			}
			case 3: {
				boundaryModifierAliment.modifierAliment();
				break;
			}
			case 4: {
				System.out.println("Retour au menu principal\n");
				break;
			}
			default:
				System.out.println("Vous devez saisir un chiffre entre 1 et 5\n");
				break;
			}
		} while (choix != 4);
	}
}
