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
		int indice = clavier.saisieInt("Indice de l'aliment :\n");
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
				modifierNom(indice);
				break;
			}
			case 2: {
				modifierQuantite(indice);
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
	
	private void modifierNom(int indice) {
		String nouveauNom = clavier.saisieTexte("Nouveau nom :\n");
		control.modifierNom(indice, nouveauNom);
	}
	
	private void modifierQuantite(int indice) {
		double nouvelleQuantite = clavier.saisieDouble("Nouvelle quantité :\n");
		control.modifierQuantite(indice, nouvelleQuantite);
	}
}
