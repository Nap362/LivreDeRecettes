package main;

import boundary.BoundaryMenuPrincipalAssistantCuisine;
import boundary.BoundaryModifierAliment;
import boundary.BoundarySupprimerAliment;
import boundary.BoundarySupprimerRecette;
import boundary.BoundaryVoirRecette;
import boundary.BoundaryAfficherListeAliments;
import boundary.BoundaryAfficherListeRecettes;
import boundary.BoundaryAjouterAliment;
import boundary.BoundaryCreerRecette;
import boundary.BoundaryFiltrerRecettes;
import boundary.BoundaryMenuListeCourses;
import boundary.BoundaryMenuLivreRecette;
import boundary.BoundaryMenuPlacard;
import control.ControlAfficherListeAliments;
import control.ControlAfficherListeRecettes;
import control.ControlAjouterAliment;
import control.ControlCreerRecette;
import control.ControlFaireCourses;
import control.ControlFiltrerRecettes;
import control.ControlModifierAliment;
import control.ControlSupprimerAliment;
import control.ControlSupprimerRecette;
import control.ControlVoirRecette;
import elements.ListeAliments;
import elements.LivreRecette;
import recettes.Recette;

public class Main {
	private static BoundaryMenuPrincipalAssistantCuisine assistant;

	public static void main(String[] args) {
		LivreRecette<Recette> livreRecette = new LivreRecette<>("Mes recettes");
		ControlCreerRecette controlCreerRecette = new ControlCreerRecette(livreRecette);
		BoundaryCreerRecette boundaryCreerRecette = new BoundaryCreerRecette(controlCreerRecette);
		ControlAfficherListeRecettes controlAfficherListeRecettes = new ControlAfficherListeRecettes(livreRecette);
		BoundaryAfficherListeRecettes boundaryAfficherListeRecettes = new BoundaryAfficherListeRecettes(
				controlAfficherListeRecettes);
		ControlSupprimerRecette controlSupprimerRecette = new ControlSupprimerRecette(livreRecette);
		BoundarySupprimerRecette boundarySupprimerRecette = new BoundarySupprimerRecette(controlSupprimerRecette);
		ControlVoirRecette controlVoirRecette = new ControlVoirRecette(livreRecette);
		BoundaryVoirRecette boundaryVoirRecette = new BoundaryVoirRecette(controlVoirRecette);

		ListeAliments placard = new ListeAliments();
		ControlAfficherListeAliments controlAfficherPlacard = new ControlAfficherListeAliments(placard);
		BoundaryAfficherListeAliments boundaryAfficherListeAlimentsPlacard = new BoundaryAfficherListeAliments(
				controlAfficherPlacard);
		ControlAjouterAliment controlAjouterAlimentPlacard = new ControlAjouterAliment(placard);
		BoundaryAjouterAliment boundaryAjouterAlimentPlacard = new BoundaryAjouterAliment(controlAjouterAlimentPlacard);
		ControlSupprimerAliment controlSupprimerAlimentPlacard = new ControlSupprimerAliment(placard);
		BoundarySupprimerAliment boundarySupprimerAlimentPlacard = new BoundarySupprimerAliment(
				controlSupprimerAlimentPlacard);
		ControlModifierAliment controlModifierAlimentPlacard = new ControlModifierAliment(placard);
		BoundaryModifierAliment boundaryModifierAlimentPlacard = new BoundaryModifierAliment(
				controlModifierAlimentPlacard);
		BoundaryMenuPlacard boundaryMenuPlacard = new BoundaryMenuPlacard(boundaryAjouterAlimentPlacard,
				boundarySupprimerAlimentPlacard, boundaryModifierAlimentPlacard);
		ControlFiltrerRecettes controlFiltrerRecettes = new ControlFiltrerRecettes(livreRecette, placard);
		BoundaryFiltrerRecettes boundaryFiltrerRecettes = new BoundaryFiltrerRecettes(controlFiltrerRecettes);
		BoundaryMenuLivreRecette boundaryMenuLivreRecette = new BoundaryMenuLivreRecette(boundaryVoirRecette,
				boundarySupprimerRecette, boundaryFiltrerRecettes);

		ListeAliments listeCourses = new ListeAliments();
		ControlAfficherListeAliments controlAfficherListeCourses = new ControlAfficherListeAliments(listeCourses);
		BoundaryAfficherListeAliments boundaryAfficherListeAlimentsListeCourses = new BoundaryAfficherListeAliments(
				controlAfficherListeCourses);
		ControlAjouterAliment controlAjouterAlimentListeCourses = new ControlAjouterAliment(listeCourses);
		BoundaryAjouterAliment boundaryAjouterAlimentListeCourses = new BoundaryAjouterAliment(
				controlAjouterAlimentListeCourses);
		ControlSupprimerAliment controlSupprimerAlimentListeCourses = new ControlSupprimerAliment(listeCourses);
		BoundarySupprimerAliment boundarySupprimerAlimentListeCourses = new BoundarySupprimerAliment(
				controlSupprimerAlimentListeCourses);
		ControlModifierAliment controlModifierAlimentListeCourses = new ControlModifierAliment(listeCourses);
		BoundaryModifierAliment boundaryModifierAlimentListeCourses = new BoundaryModifierAliment(
				controlModifierAlimentListeCourses);
		ControlFaireCourses controlFaireCourses = new ControlFaireCourses(placard, listeCourses);
		BoundaryMenuListeCourses boundaryMenuListeCourses = new BoundaryMenuListeCourses(
				boundaryAjouterAlimentListeCourses, boundarySupprimerAlimentListeCourses,
				boundaryModifierAlimentListeCourses, controlFaireCourses);

		assistant = new BoundaryMenuPrincipalAssistantCuisine(boundaryCreerRecette, boundaryAfficherListeRecettes,
				boundaryAfficherListeAlimentsListeCourses, boundaryAfficherListeAlimentsPlacard,
				boundaryMenuListeCourses, boundaryMenuLivreRecette, boundaryMenuPlacard);
		assistant.menuPrincipal();
	}

}
