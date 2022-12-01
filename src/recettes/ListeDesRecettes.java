package recettes;

public class ListeDesRecettes {
	private static final int NB_MAX_RECETTES = 100;
	private Recette[] recettes = new Recette[NB_MAX_RECETTES];
	private int nbRecettes = 0;
	
	public void ajouterRecette(Recette recette) {
		if (nbRecettes<NB_MAX_RECETTES) {
			recettes[nbRecettes]=recette;
			nbRecettes++;
		} 
	}
	
	public void supprimerRecette(int rang) {
		if (rang<nbRecettes) {
			nbRecettes--;
			int i = rang - 1;
			while (i < nbRecettes) {
				recettes[i] = recettes[i + 1];
				i++;
			}
			recettes[nbRecettes] = null;
		}
	}
	
	public void afficherListeRecettes() {
		String affichage = "\tVos recettes :\n";
		for (int i=0; i<nbRecettes;i++) {
			affichage += (i+1)+". " + recettes[i].getNom() + "\n";
		}
		System.out.println(affichage);
	}

}
