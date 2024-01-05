package main;

import java.io.IOException;

public class MainRuntime {

	public static void main(String[] args) {
	    try {
			Runtime.getRuntime().exec("C:/Users/Ninon/Desktop/Cours/workspace/2023-24-sema-ilu3-projet-Nap362/LivreDeRecette/ocaml/main.exe aff 'oeuf,3.,SANS' 3");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Program executed.");
	}

}
