package control;

import elements.ListeAliments;

public class ControlModifierAliment {
	private ListeAliments liste;

	public ControlModifierAliment(ListeAliments liste) {
		this.liste = liste;
	}
	
	public void modifierNom(String aliment, String nouveauNom) {
		liste.modifierNom(aliment, nouveauNom);
	}
	
	public void modifierQuantite(String aliment, double nouvelleQuantite) {
		liste.modifierQuantite(aliment, nouvelleQuantite);
	}
}
