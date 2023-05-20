package boundary;

import control.ControlVoirRecette;

public class BoundaryVoirRecette {
	private Clavier clavier = new Clavier();
	private ControlVoirRecette control;
	
	public BoundaryVoirRecette(ControlVoirRecette control) {
		this.control = control;
	}
	
	public void voirRecette() {
		int indice = clavier.saisieInt("Quelle recette voulez-vous voir ?");
		int nbrPersonnes = clavier.saisieInt("Pour combien de personnes ?");
		System.out.println(control.voirRecette(indice, nbrPersonnes));
	}
}
