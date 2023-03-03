package cuisine;

import elements.Recette;
import elements.Type;

public class LivreRecette {
	private static final int NB_MAX_RECETTES = 100;
	private Recette[] recettes = new Recette[NB_MAX_RECETTES];
	private int nbRecettes = 0;
	
	public Recette getRecette(int i) {
		return recettes[i];
	}
	
	public int getNbRecettes() {
		return nbRecettes;
	}

	public void ajouterRecette(Recette recette) {
		if (nbRecettes<NB_MAX_RECETTES) {
			recettes[nbRecettes]=recette;
			nbRecettes++;
		} 
	}
	
	public void supprimerRecette(int rang) {
		nbRecettes--;
		if (rang<nbRecettes) {
			int i = rang - 1;
			while (i < nbRecettes) {
				recettes[i] = recettes[i + 1];
				i++;
			}
		}
		recettes[nbRecettes] = null;
	}
	
	public void afficherListeRecettes() {
		String affichage = "\tVos recettes :\n";
		for (int i=0; i<nbRecettes;i++) {
			affichage += (i+1)+". " + recettes[i].getNom() + "\n";
		}
		System.out.println(affichage);
	}
	
	public int rechercheRecetteNom(String nom) {
		int i=0;
		while (i<nbRecettes && !(recettes[i].getNom().equals(nom))) {
			i++;
		}
		if (i==nbRecettes) {
			return(-1);
		}
		return (i);
	}
	
	public void afficherRecettesType(Type type) {
		int i=0;
		System.out.println(type.toString() + "s :\n");
		while (i<nbRecettes) {
			if (recettes[i].getType()==type) {
				System.out.println(" ~ " + recettes[i].getNom() + "\n");
			}
			i++;
		}
	}

}
