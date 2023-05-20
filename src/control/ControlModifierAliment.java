package control;

import elements.ListeAliments;

public class ControlModifierAliment {
	private ListeAliments liste;

	public ControlModifierAliment(ListeAliments liste) {
		this.liste = liste;
	}
	
	public void modifierNom(int indice, String nouveauNom) {
		liste.modifierNom(indice, nouveauNom);
	}
	
	public void modifierQuantite(int indice, double nouvelleQuantite) {
		liste.modifierQuantite(indice, nouvelleQuantite);
	}
}
