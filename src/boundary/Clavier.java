package boundary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Clavier {
	private Scanner scanner = new Scanner(System.in);
	
	public String saisieTexte(String question) {
		System.out.println(question);
		return scanner.nextLine();
	}
	
	public int saisieInt(String question) {
		System.out.println(question);
		int reponse =-1;
		try {
			reponse = scanner.nextInt();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		scanner.nextLine();
		return reponse;
	}
	
	public double saisieDouble(String question) {
		System.out.println(question);
		double reponse =-1;
		try {
			reponse = scanner.nextDouble();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		scanner.nextLine();
		return reponse;
	}
}
