package boundary;

import java.util.Scanner;

import control.ControlCreerRecette;

public class BoundaryCreerRecette {
	private ControlCreerRecette controlCreerRecette;
	private Scanner scanner = new Scanner(System.in);
	
	public BoundaryCreerRecette(ControlCreerRecette controlCreerRecette) {
		this.controlCreerRecette = controlCreerRecette;
	}
	
	public void creerRecette() {
		//TODO interface utilisateur créer recette
	}

}
