package control;

import elements.Aliment;
import elements.ListeAliments;
import elements.Type;
import elements.Unite;

public class ControlAjouterAliment {
private ListeAliments listeAliments;
	
	public ControlAjouterAliment(ListeAliments listeAliments) {
		this.listeAliments = listeAliments;
	}
	
	public void ajouterAliments(String nom, String uniteString, double quantite) {
		Unite unite = Unite.valueOf(uniteString);
		listeAliments.ajouter(new Aliment(nom, unite, quantite));
	}
}
