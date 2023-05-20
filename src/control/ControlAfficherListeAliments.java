package control;

import elements.ListeAliments;

public class ControlAfficherListeAliments {
	private ListeAliments liste;
	
	public ControlAfficherListeAliments(ListeAliments liste) {
		this.liste = liste;
	}
	
	public String afficherListe() {
		return liste.afficherListe();
	}
}
