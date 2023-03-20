package boundary;

import java.util.Scanner;

import control.ControlCreerListeAliments;

public class BoundaryCreerListeAliments {
	private ControlCreerListeAliments controlCreerListeAliments;
	private Scanner scanner = new Scanner(System.in);
	
	public BoundaryCreerListeAliments(ControlCreerListeAliments controlCreerListeAliments) {
		this.controlCreerListeAliments = controlCreerListeAliments;
	}
	
	public void creerListeAliments() {
		//TODO interface utilisateur créer recette
	}
}
