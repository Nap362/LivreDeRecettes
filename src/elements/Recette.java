package elements;


public class Recette extends Element {
	private static final int INGERDIENTS_MAX = 20;
	private String nom;
	private Type type;
	private int personnes;
	private int temps;
	private ListeAliments ingredients = new ListeAliments(INGERDIENTS_MAX);
	private ListeInstructions listeInstructions = new ListeInstructions();

	public Recette(String nom, Type type, int personnes, int temps) {
		super(nom);
		this.type = type;
		this.personnes = personnes;
		this.temps = temps;
	}

	public Type getType() {
		return type;
	}

	public int getTemps() {
		return temps;
	}

	public void setPersonnes(int personnes) {
		this.personnes = personnes;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}
	
	@Override
	public String afficherDansListe() {
		return nom;
	}

	private class ListeInstructions implements OperationsListe<String>{
		private static final int INSTRUCTIONS_MAX = 20;
		private int nbrInstructions = 0;
		private String[] instructions = new String[INSTRUCTIONS_MAX];

		@Override
		public void ajouter(String instruction) {
			if (nbrInstructions < INSTRUCTIONS_MAX) {
				instructions[nbrInstructions] = instruction;
				nbrInstructions++;
			}
		}
		
		@Override
		public void supprimer(int indice) {
			nbrInstructions--;
			if (indice < nbrInstructions) {
				for (int i = indice; i < nbrInstructions; i++) {
					instructions[i] = instructions[i + 1];
				}
			}
			instructions[nbrInstructions] = null;
		}
		
		@Override
		public void inserer(String instruction, int indice) {
			for (int i = indice; i < nbrInstructions; i++) {
				instructions[i + 1] = instructions[i];
				i++;
			}
			instructions[indice] = instruction;
			nbrInstructions++;
		}
		
		@Override
		public String afficherListe() {
			StringBuilder texte = new StringBuilder();
			texte.append("Instructions :\n");
			for (int i = 0; i < nbrInstructions; i++) {
				texte.append((i + 1) + ". " + instructions[i] + "\n");
			}
			return texte.toString();
		}
	}

	private String afficherTemps() {
		StringBuilder tempsTexte = new StringBuilder();
		if (temps >= 60) {
			tempsTexte.append(temps / 60 + "h");
			if (temps % 60 < 10) {
				tempsTexte.append("0");
			}
			tempsTexte.append(temps % 60);
		}
		else {
			tempsTexte.append(temps + " min");
		}
		return tempsTexte.toString();
	}

	public String afficher() {
		StringBuilder affichage = new StringBuilder();
		affichage.append("\t" + nom + " :\n" + "Pour " + personnes + " personnes\n" + "Temps de réalisation : "
				+ afficherTemps() + "\n");
		affichage.append("Ingrédients : \n" + ingredients.afficherListe());
		affichage.append("\nRéalisation :\n" + listeInstructions.afficherListe());
		return affichage.toString();
	}
	
	public String afficherNombrePersonnes(int nbrPersonnes) {
		StringBuilder affichage = new StringBuilder();
		affichage.append("\t" + nom + " :\n" + "Pour " + nbrPersonnes + " personnes\n" + "Temps de réalisation : "
				+ afficherTemps() + "\n");
		double facteur = nbrPersonnes/personnes;
		affichage.append("Ingrédients : \n" + ingredients.afficherListeQuantite(facteur));
		affichage.append("\nRéalisation :\n" + listeInstructions.afficherListe());
		return affichage.toString();
	}
	
	public boolean recetteRealisable(ListeAliments placard) {
		return placard.tousIngredientsDisponibles(ingredients);
	}
	
	public boolean recetteContientAuMoinsUnIngredient(String[] AlimentsRecherches) {
		return ingredients.contientAuMoinsUnIngredient(AlimentsRecherches);
	}

}
