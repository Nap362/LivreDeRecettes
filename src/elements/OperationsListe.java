package elements;

public interface OperationsListe<T> {
	
	public void ajouter(T element);
	
	public void supprimer(int indice);
	
	public default void inserer(T element, int indice) {
		this.ajouter(element);
	}
	
	public String afficherListe();
}
