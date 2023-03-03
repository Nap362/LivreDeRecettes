package cuisine;

public interface OperationListe<T1> {
	public void ajouter(T1 element);
	
	public void supprimer(String nom);
	
	public String afficherListe();
}
