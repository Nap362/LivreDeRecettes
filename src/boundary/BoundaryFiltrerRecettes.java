package boundary;

import control.ControlFiltrerRecettes;

public class BoundaryFiltrerRecettes {
	private Clavier clavier = new Clavier();
	private ControlFiltrerRecettes control;
	
	public BoundaryFiltrerRecettes(ControlFiltrerRecettes control) {
		this.control = control;
	}
	
	public void filtrerType() {
		String type = clavier.saisieTexte("Type de recettes recherché :\n Viande | Poisson | Vegetarien | Dessert\n");
		System.out.println(control.filtrerType(type));
	}
	
	public void filtrerTemps() {
		int temps = clavier.saisieInt("Temps de réalisation maximal (en min) :\n");
		System.out.println(control.filtrerTemps(temps));
	}
	
	public void filtrerRealisable() {
		System.out.println(control.filtrerRealisable());
	}
	
	public void filtrerAlimentsAEviter() {
		int nbrAliments = clavier.saisieInt("Nombre d'aliments que vous voulez éviter :\n");
		String[] alimentsAEviter = new String[nbrAliments];
		for(int i=0; i<nbrAliments; i++) {
			alimentsAEviter[i]=clavier.saisieTexte("Aliment à éviter (1 seul) :\n");
		}
		System.out.println(control.filtrerAlimentsAEviter(alimentsAEviter));
	}
}
