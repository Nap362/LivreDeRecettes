package dialog;

import java.awt.EventQueue;

import control.ControlCreerRecette;
import elements.LivreRecette;
import presentation.PresentationJFrameCreerRecette;
import recettes.Recette;

public class DialogCreerRecette {
	private PresentationJFrameCreerRecette presentationJFrameCreerRecette;
	private ControlCreerRecette controlCreerRecette;
	private LivreRecette<Recette> livreRecettes;
	private String type;

	public void initDialog() {
		presentationJFrameCreerRecette = new PresentationJFrameCreerRecette();
		presentationJFrameCreerRecette.initPresentation(this);
		presentationJFrameCreerRecette.setVisible(true);

		Recette[] recettes = new Recette[100];
		livreRecettes = new LivreRecette<>(recettes, "Mes recettes");
		controlCreerRecette = new ControlCreerRecette(livreRecettes);
	}

	public void handlerTypeChoisi(String type) {
		this.type = type;
		switch (type) {
		case "Viande":
			presentationJFrameCreerRecette.enableTypeViande();
			break;
		case "Poisson":
			presentationJFrameCreerRecette.enableTypePoisson();
			break;
		case "Végétarien":
			presentationJFrameCreerRecette.enableVegan();
			break;
		default:
			presentationJFrameCreerRecette.enableDessert();
			break;
		}
		presentationJFrameCreerRecette.enableChampsSuplementaires();
	}
	public void handlerRecetteInitialisee(String nom, String typeViande, String typePoisson, boolean vegan, int temps) {
		switch (type) {
		case "Viande":
			controlCreerRecette.creerViande(nom, temps, typeViande.toUpperCase());
			break;
		case "Poisson":
			controlCreerRecette.creerPoisson(nom, temps, typePoisson.toUpperCase());
			break;
		case "Végétarien":
			controlCreerRecette.creerVegetarien(nom, temps, vegan);
			break;
		default:
			controlCreerRecette.creerDessert(nom, temps);
			break;
		}
		presentationJFrameCreerRecette.enableAjoutIngredients();
	}

	public static void main(String[] args) {
		DialogCreerRecette dialogReservation = new DialogCreerRecette();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialogReservation.initDialog();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
