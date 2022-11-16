package recettes;

public class ListeDesRecettes {
	private static final int NB_MAX_RECETTES = 100;
	private Recette[] recettes = new Recette[NB_MAX_RECETTES];
	private int nbRecettes = 0;
	
	public void ajouterRecette(Recette recette) {
		recettes[nbRecettes]=recette;
		nbRecettes++;
	}

}
