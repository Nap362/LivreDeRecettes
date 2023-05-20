package boundary;

import control.ControlAjouterAliment;

public class BoundaryAjouterAliment {
	private Clavier clavier = new Clavier();
	private ControlAjouterAliment control;

	public BoundaryAjouterAliment(ControlAjouterAliment control) {
		this.control = control;
	}
	
	public void ajouterAliment() {
		System.out.println("\tAjout d'un aliment :\n");
		String nom = clavier.saisieTexte("Nom :\n");
		String unite = clavier.saisieTexte("G | MG | L | CL | ML | PINCEE | CAS | CAC | SACHET | SANS\nUnite :\n");
		double quantite = clavier.saisieDouble("Quantite :\n");
		control.ajouterAliment(nom, unite, quantite);
	}
	
	
}
