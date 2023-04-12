package boundary;

import java.io.IOException;
import java.util.Scanner;

public class Clavier {
	private Scanner scanner = new Scanner(System.in);
	
	public String saisieTexte(String question) {
		System.out.println(question);
		String reponse ="";
		try {
			reponse = scanner.next();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reponse;
	}
	
	public int saisieInt(String question) {
		System.out.println(question);
		int reponse = scanner.nextInt();
		return reponse;
	}
	
	public double saisieDouble(String question) {
		System.out.println(question);
		double reponse = scanner.nextDouble();
		return reponse;
	}
}
