package boundary;

public class BoundaryMenuPrincipalAssistantCuisine {
	private Clavier clavier = new Clavier();
	private BoundaryCreerRecette boundaryCreerRecette;
	private BoundaryAfficherListeRecettes boundaryAfficherListeRecettes;
	private BoundaryAfficherListeAliments boundaryAfficherListeCourses;
	private BoundaryAfficherListeAliments boundaryAfficherPlacard;
	private BoundaryMenuListeCourses boundaryMenuListeCourses;
	private BoundaryMenuLivreRecette boundaryMenuLivreRecette;
	private BoundaryMenuPlacard boundaryMenuPlacard;

	public BoundaryMenuPrincipalAssistantCuisine(BoundaryCreerRecette boundaryCreerRecette,
			BoundaryAfficherListeRecettes boundaryAfficherListeRecettes,
			BoundaryAfficherListeAliments boundaryAfficherListeCourses,
			BoundaryAfficherListeAliments boundaryAfficherPlacard, BoundaryMenuListeCourses boundaryMenuListeCourses,
			BoundaryMenuLivreRecette boundaryMenuLivreRecette, BoundaryMenuPlacard boundaryMenuPlacard) {
		this.boundaryCreerRecette = boundaryCreerRecette;
		this.boundaryAfficherListeRecettes = boundaryAfficherListeRecettes;
		this.boundaryAfficherListeCourses = boundaryAfficherListeCourses;
		this.boundaryAfficherPlacard = boundaryAfficherPlacard;
		this.boundaryMenuListeCourses = boundaryMenuListeCourses;
		this.boundaryMenuLivreRecette = boundaryMenuLivreRecette;
		this.boundaryMenuPlacard = boundaryMenuPlacard;
		

	}

	public void menuPrincipal() {
		StringBuilder question = new StringBuilder();
		question.append("Que voulez-vous faire ?\n");
		question.append("1 - Voir mon livre de recettes\n");
		question.append("2 - Créer une nouvelle recette\n");
		question.append("3 - Voir ma liste de courses\n");
		question.append("4 - Voir mon placard\n");
		question.append("5 - Sortir\n");
		int choix;
		do {
			choix = clavier.saisieInt(question.toString());
			switch (choix) {
			case 1: {
				boundaryAfficherListeRecettes.afficherRecettes();
				boundaryMenuLivreRecette.menuLivreRecette();
				break;
			}
			case 2: {
				boundaryCreerRecette.creerRecette();
				break;
			}
			case 3: {
				System.out.println("\tListe de Courses :\n");
				boundaryAfficherListeCourses.afficherListe();
				boundaryMenuListeCourses.menuListeCourses();
				break;
			}
			case 4: {
				System.out.println("\tPlacard :\n");
				boundaryAfficherPlacard.afficherListe();
				boundaryMenuPlacard.menuPlacard();
				break;
			}
			case 5: {
				System.out.println("Sortie de l'application");
				break;
			}
			default:
				System.out.println("Vous devez saisir un chiffre entre 1 et 5\n");
				break;
			}
		} while (choix != 5);
	}

}
