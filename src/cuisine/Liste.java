package cuisine;

public class Liste<T> implements OperationListe<T> {
	private int nbrMaxElements;
	protected int nbrElements = 0;
	protected T[] elements;
	
	public Liste(T[] liste,int nbrMaxElements) {
		elements = liste;
		this.nbrMaxElements = nbrMaxElements;
	}

	@Override
	public void ajouter(T element) {
		if (nbrElements < nbrMaxElements) {
			elements[nbrElements] = element;
			nbrElements++;
		}
		
	}

	@Override
	public void supprimer(String nom) {
		nbrElements--;
		int indice = Integer.parseInt(nom) - 1;
		if (indice < nbrElements) {
			for (int i = indice; i<nbrElements; i++) {
				elements[i] = elements[i + 1];
			}
		}
		elements[nbrElements] = null;
		
	}

	@Override
	public String afficherListe() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
