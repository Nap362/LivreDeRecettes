package boundary;

import control.ControlSupprimerRecette;

public class BoundarySupprimerRecette {
	private Clavier clavier = new Clavier();
	private ControlSupprimerRecette control;
	
	public BoundarySupprimerRecette(ControlSupprimerRecette control) {
		this.control = control;
	}
	
	public void supprimerRecette() {
		int indice = clavier.saisieInt("Quelle recette voulez-vous supprimer ?");
		control.supprimerRecette(indice);
	}
}
