package boundary;

import control.ControlSupprimerAliment;

public class BoundarySupprimerAliment {
	private Clavier clavier = new Clavier();
	private ControlSupprimerAliment control;

	public BoundarySupprimerAliment(ControlSupprimerAliment control) {
		this.control = control;
	}

	public void supprimerAliment() {
		System.out.println("\tSuppression d'un aliment :\n");
		String aliment = clavier.saisieTexte("Aliment :\n");
		control.supprimerAliment(aliment);
	}
}
