package boundary;

import control.ControlAfficherListeAliments;

public class BoundaryAfficherListeAliments {
	private ControlAfficherListeAliments control;
	
	public BoundaryAfficherListeAliments(ControlAfficherListeAliments control) {
		this.control = control;
	}
	
	public void afficherListe() {
		System.out.println(control.afficherListe());
	}
}
