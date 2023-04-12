package boundary;

import java.util.Scanner;

import control.ControlAjouterAliment;

public class BoundaryAjouterAliment {
	private ControlAjouterAliment controlAjouterAliment;
	private Clavier clavier;
	
	public BoundaryAjouterAliment(ControlAjouterAliment controlAjouterAliment) {
		this.controlAjouterAliment = controlAjouterAliment;
	}
	
	public void ajouterAliments() {
		
		String nom = clavier.saisieTexte("\nAliment : ");
		String unite = clavier.saisieTexte("\nUnité : ");
		double quantite = clavier.saisieDouble("\nQuantité : ");
		controlAjouterAliment.ajouterAliments(nom, unite, quantite);
		System.out.println("\nAjout de " + quantite + " " + unite + " de " + nom + " à la lite.\n");
	}
}
