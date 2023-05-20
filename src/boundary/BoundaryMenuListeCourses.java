package boundary;

import control.ControlFaireCourses;

public class BoundaryMenuListeCourses {
	private Clavier clavier = new Clavier();
	private BoundaryAjouterAliment boundaryAjouterAliment;
	private BoundarySupprimerAliment boundarySupprimerAliment;
	private BoundaryModifierAliment boundaryModifierAliment;
	private ControlFaireCourses controlFaireCourses;

	public BoundaryMenuListeCourses(BoundaryAjouterAliment boundaryAjouterAliment,
			BoundarySupprimerAliment boundarySupprimerAliment, BoundaryModifierAliment boundaryModifierAliment, ControlFaireCourses controlFaireCourses) {
		this.boundaryAjouterAliment = boundaryAjouterAliment;
		this.boundaryModifierAliment = boundaryModifierAliment;
		this.boundarySupprimerAliment = boundarySupprimerAliment;
		this.controlFaireCourses = controlFaireCourses;
	}

	public void menuListeCourses() {
		int choix;
		StringBuilder question = new StringBuilder();
		question.append("Que voulez-vous faire ?\n");
		question.append("1 - Ajouter un aliment\n");
		question.append("2 - Supprimer un aliment\n");
		question.append("3 - Modifier un aliment\n");
		question.append("4 - Faire les courses\n");
		question.append("5 - Retour au menu principal\n");
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
				controlFaireCourses.faireCourses();
				System.out.println("Votre placard a été mis a jour.\nLa liste de course est vide.\n");
				break;
			}
			case 5: {
				System.out.println("Retour au menu principal");
				break;
			}
			default:
				System.out.println("Vous devez saisir un chiffre entre 1 et 5\n");
				break;
			}
		} while (choix != 5);
	}
}
