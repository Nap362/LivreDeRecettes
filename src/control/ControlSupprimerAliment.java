package control;

import elements.ListeAliments;

public class ControlSupprimerAliment {
	private ListeAliments liste;
	
	public ControlSupprimerAliment(ListeAliments liste) {
		this.liste = liste;
	}
	
	public void supprimerAliment(int indice) {
		liste.supprimer(indice);
	}
}
