package control;

import elements.ListeAliments;

public class ControlSupprimerAliment {
	private ListeAliments liste;
	
	public ControlSupprimerAliment(ListeAliments liste) {
		this.liste = liste;
	}
	
	public void supprimerAliment(String nomAliment) {
		liste.supprimer(nomAliment);
	}
}
