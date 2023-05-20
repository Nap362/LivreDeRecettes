package boundary;


import control.ControlCreerRecette;

public class BoundaryCreerRecette {
	private Clavier clavier = new Clavier();
	private ControlCreerRecette controlCreerRecette;

	public BoundaryCreerRecette(ControlCreerRecette controlCreerRecette) {
		this.controlCreerRecette = controlCreerRecette;
	}

	public void creerRecette() {
		String nom = clavier.saisieTexte("Nom de la recette :\n");
		int temps = clavier.saisieInt("Temps de préparation (en minutes) :\n");
		int nbrPersonnes = clavier.saisieInt("Nombre de personnes :\n");
		int type = clavier.saisieInt("Type de recette :\n1 - Viande | 2 - Poisson | 3 - Vegetarien | 4 - Dessert\n");
		boolean valide = false;
		while (!valide) {
			switch (type) {
			case 1:
				valide = true;
				String typeViande = clavier.saisieTexte(
						"Type de viande\nAGNEAU | BOEUF | CANARD | DINDE | GIBIER | LAPIN | MOUTON | PINTADE | PORC | POULET | VEAU\n");
				controlCreerRecette.creerViande(nom, temps, typeViande);
				break;
			case 2:
				valide = true;
				String typePoisson = clavier.saisieTexte(
						"Type de poisson\nBAR | CABILLAUD | DORADE | EGLEFIN | HARENG | LIMANDE | MAQUEREAU | MERLAN | MERLU | SAR | SAUMON | SOLE | TRUITE | TURBOT\nCRABE | CREVETTE | ECREVISSE | GAMBAS | HOMARD | LANGOUSTE | LANGOUSITNE | TOURTEAU\nBIGORNEAU | BULOT | CLAM | COQUE | STJACQUE | COUTEAU | HUITRE | MOULE | PALOURDE | PETONCLE | TELLINE\n");
				controlCreerRecette.creerPoisson(nom, temps, typePoisson);
				break;
			case 3:
				valide = true;
				int intVegan = clavier.saisieInt("Convient au vegan ? \n1- Oui | 2 - Non\n");
				boolean vegan = false;
				if (intVegan == 1) {
					vegan = true;
				}
				controlCreerRecette.creerVegetarien(nom, temps, vegan);
				break;
			case 4:
				valide = true;
				controlCreerRecette.creerDessert(nom, temps);
			default:
				System.out.println("Incorrect\n");
				break;
			}
		}
		int continuer = 1;
		System.out.println("Ajout des ingrédients :\n");
		do{
			ajouterAliment(nbrPersonnes);
			continuer = clavier.saisieInt("Voulez-vous ajouter un autre ingrédient ?\n 1 - Oui | 0 - Non\n");
		}while (continuer==1); 
		System.out.println("Ajout des instructions :\n");
		continuer = 1;
		int indice = 1;
		do{
			ajouterInstruction(indice);
			indice++;
			continuer = clavier.saisieInt("Voulez-vous ajouter une autre instrcution ?\n 1 - Oui | 0 - Non\n");
		}while (continuer==1); 
		
	}
	
	// Pas possible d'utiliser BoundaryAjouterAliment car on ne peut initialiser la liste d'aliment que dans ControlCreerRecette
	public void ajouterAliment(int nbrPersonnes) {
		String nom = clavier.saisieTexte("Nom :\n");
		String unite = clavier.saisieTexte("G | MG | L | CL | ML | PINCEE | CAS | CAC | SACHET | SANS\nUnite :\n");
		double quantite = clavier.saisieDouble("Quantite :\n");
		controlCreerRecette.ajouterAliment(nom, unite, quantite/nbrPersonnes);
	}
	
	public void ajouterInstruction(int indice) {
		String instruction = clavier.saisieTexte(indice + " :");
		controlCreerRecette.ajouterInstruction(instruction);
	}

}
