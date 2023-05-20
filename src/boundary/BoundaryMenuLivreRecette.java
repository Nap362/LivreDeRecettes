package boundary;

public class BoundaryMenuLivreRecette {
	private Clavier clavier = new Clavier();
	private BoundaryVoirRecette boundaryVoirRecette;
	private BoundarySupprimerRecette boundarySupprimerRecette;
	private BoundaryFiltrerRecettes boundaryFiltrerRecettes;

	public BoundaryMenuLivreRecette(BoundaryVoirRecette boundaryVoirRecette,
			BoundarySupprimerRecette boundarySupprimerRecette, BoundaryFiltrerRecettes boundaryFiltrerRecettes) {
		this.boundaryVoirRecette = boundaryVoirRecette;
		this.boundarySupprimerRecette = boundarySupprimerRecette;
		this.boundaryFiltrerRecettes = boundaryFiltrerRecettes;
	}

	public void menuLivreRecette() {
		int choix;
		StringBuilder question = new StringBuilder();
		question.append("Que voulez-vous faire ?\n");
		question.append("1 - Voir une recette\n");
		question.append("2 - Supprimer une recette\n");
		question.append("3 - Filtrer les recettes par type\n");
		question.append("4 - Filtrer les recettes par temps de préparation\n");
		question.append("5 - Filtrer les recettes que vous pouvez réaliser avec le contenu de votre placard\n");
		question.append("6 - Filtrer les recettes qui ne contiennent pas certains aliments\n");
		question.append("7 - Retour au menu principal\n");
		do {
			choix = clavier.saisieInt(question.toString());
			switch (choix) {
			case 1: {
				boundaryVoirRecette.voirRecette();
				break;
			}
			case 2: {
				boundarySupprimerRecette.supprimerRecette();
				break;
			}
			case 3: {
				boundaryFiltrerRecettes.filtrerType();
				break;
			}
			case 4: {
				boundaryFiltrerRecettes.filtrerTemps();
				break;
			}
			case 5: {
				boundaryFiltrerRecettes.filtrerRealisable();
				break;
			}
			case 6: {
				boundaryFiltrerRecettes.filtrerAlimentsAEviter();
				break;
			}
			case 7: {
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
