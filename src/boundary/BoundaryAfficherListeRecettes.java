package boundary;

import control.ControlAfficherListeRecettes;

public class BoundaryAfficherListeRecettes {
	private ControlAfficherListeRecettes control;
	
	public BoundaryAfficherListeRecettes(ControlAfficherListeRecettes control) {
		this.control = control;
	}
	
	public void afficherRecettes() {
		String affichage = control.afficherListeRecettes();
		System.out.println(affichage);
	}
}
