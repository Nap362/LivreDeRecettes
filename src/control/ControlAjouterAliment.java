package control;

import elements.Aliment;
import elements.ListeAliments;

public class ControlAjouterAliment {
	private ListeAliments liste;

	public ControlAjouterAliment(ListeAliments liste) {
		this.liste = liste;
	}

	public void ajouterAliment(String nom, String unite, double quantite) {
		Aliment aliment = new Aliment(nom, unite, quantite);
		liste.ajouter(aliment);
	}
}
