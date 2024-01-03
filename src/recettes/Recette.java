package recettes;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import elements.ListeAliments;

public abstract class Recette implements Iterable<String>{
	protected String nom;
	protected int temps;
	protected ListeAliments ingredients;
	private final int NOMBRE_INSTRUCTIONS_MAX = 30;
	private String[] instructions = new String[NOMBRE_INSTRUCTIONS_MAX];
	private int nombreInstructions;
	private int nombreOperations = 0;

	public String getNom() {
		return nom;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}
	

	public String afficherDansListe() {
		return nom;
	}

	public void setListeIngredients(ListeAliments ingredients) {
		this.ingredients = ingredients;
	}
	

	@Override
	public Iterator<String> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<String> {
		 private int indiceIterateur = 0;
		 private int nombreOperationsReference = nombreOperations;
		 private boolean nextEffectue = false;
		 
		 private void verificationConcurrence() {
			 if(nombreOperationsReference!=nombreOperations) {
				 throw new ConcurrentModificationException();
			 }
		 }
		 
		 @Override
		 public boolean hasNext() {
			 return indiceIterateur <nombreInstructions;
		 }
		 
		 @Override
		 public String next() {
			 verificationConcurrence();
			 if(hasNext()) {
				 String instruction = instructions[indiceIterateur];
				 nextEffectue =true;
				 indiceIterateur++;
				 return instruction;
			 }else {
				 throw new NoSuchElementException();
			 }
		 }
		 
		 @Override
		 public void remove() {
			 verificationConcurrence();
			 if(nombreInstructions <1 || !nextEffectue) {
				 throw new IllegalStateException();
			 }
			 for (int i = indiceIterateur - 1; i< nombreInstructions; i++) {
				 instructions[i] = instructions[i +1];
			 }
			 nextEffectue = false;
			 indiceIterateur--;
			 nombreInstructions--;
			 nombreOperations ++;
			 nombreOperationsReference++;
		 }
	}

	public void ajouterInstuction(String instruction) {
		if (nombreInstructions<NOMBRE_INSTRUCTIONS_MAX) {
			instructions[nombreInstructions] = instruction;
			nombreInstructions++;
			nombreOperations++;
		}else {
			throw new IndexOutOfBoundsException();
		}
	}

	public void supprimerInstuction(int indice) {
		Iterator<String> iterator = iterator();
		for (int i = 0; i<=indice; i++) {
			iterator.next();
		}
		iterator.remove();
	}

	public void insererInstuction(String instruction, int indice) {
		if(nombreInstructions<NOMBRE_INSTRUCTIONS_MAX) {
			int indiceCourant = -1;
			for(Iterator<String> it = iterator(); it.hasNext();) {
				String instructionCourante = it.next();
				indice++;
				if (indice==indiceCourant) {
					instructions[indiceCourant]=instruction;
					indice++;
					instruction = instructionCourante;
				}
			}
			ajouterInstuction(instruction);
			
		}else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private String afficherInstructions() {
		StringBuilder texte = new StringBuilder();
		texte.append("Instructions :\n");
		int indice = 1;
		for(Iterator<String> it = iterator(); it.hasNext();) {
			String instruction = it.next();
			texte.append(indice + ". " + instruction + "\n");
			indice++;
		}
		return texte.toString();
	}

	private String afficherTemps() {
		StringBuilder tempsTexte = new StringBuilder();
		if (temps >= 60) {
			tempsTexte.append(temps / 60 + "h");
			if (temps % 60 < 10) {
				tempsTexte.append("0");
			}
			tempsTexte.append(temps % 60);
		} else {
			tempsTexte.append(temps + " min");
		}
		return tempsTexte.toString();
	}

	public String afficher(int personnes) {
		StringBuilder affichage = new StringBuilder();
		affichage.append("\t" + nom + " :\n" + "Pour " + personnes + " personnes\n" + "Temps de réalisation : "
				+ afficherTemps() + "\n");
		affichage.append("Ingrédients :\n" + ingredients.afficherListePersonne(personnes));
		affichage.append("\nRéalisation :\n" + afficherInstructions());
		return affichage.toString();
	}

	public boolean recetteRealisable(ListeAliments placard) {
		return placard.tousIngredientsDisponibles(ingredients);
	}

	public boolean recetteContientAuMoinsUnIngredient(String[] AlimentsRecherches) {
		return ingredients.contientAuMoinsUnIngredient(AlimentsRecherches);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Recette) {
			Recette recette = (Recette) obj;
			return recette.nom == nom;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * nom.hashCode();
	}
	
}
