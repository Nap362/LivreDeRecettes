package boundary;

import control.ControlModifierAliment;

public class BoundaryModifierAliment {
	private Clavier clavier = new Clavier();
	private ControlModifierAliment control;
	
	public BoundaryModifierAliment(ControlModifierAliment control) {
		this.control = control;
	}
	
	public void modifierAliment() {
		System.out.println("\tModification d'un aliment\n");
		String aliment = clavier.saisieTexte("Nom de l'aliment :\n");
		StringBuilder question = new StringBuilder();
		question.append("Que voulez-vous modifier ?\n");
		question.append("1 - Modifier le nom\n");
		question.append("2 - Modifier la quantité\n");
		question.append("3 - Terminé\n");
		int choix;
		do {
			choix = clavier.saisieInt(question.toString());
			switch (choix) {
			case 1: {
				modifierNom(aliment);
				break;
			}
			case 2: {
				modifierQuantite(aliment);
				break;		
			}
			case 3: {
				break;
			}
			default:
				System.out.println("Vous devez choisir un nombre entre 1 et 3.\n");
			}
		}while (choix!=3);
	}
	
	private void modifierNom(String aliment) {
		String nouveauNom = clavier.saisieTexte("Nouveau nom :\n");
		control.modifierNom(aliment, nouveauNom);
	}
	
	private void modifierQuantite(String aliment) {
		double nouvelleQuantite = clavier.saisieDouble("Nouvelle quantité :\n");
		control.modifierQuantite(aliment, nouvelleQuantite);
	}
}
