package nfo.nfa031;

import java.util.Random;
import java.util.Scanner;

public class Eval {

	private static Scanner reader = new Scanner(System.in);
	private static String jeu = "";
	private static String joueur = "";
	private static boolean finJeu = false;

	private static int choisirUneValeurAuHasardEntre1Et4() {
		Random random = new Random();
		int choosenToucheNumber = random.nextInt(4);
		return choosenToucheNumber;
	}

	private static String attendreEtLireChaineSaisieAuClavier() {
		System.out.println("Your proposal (use space for delimiter):");
		return reader.nextLine();
	}

	private static void afficheBienvenue(String prenom) {
		System.out.println("Bienvenue " + prenom);
	}

	private static String memoriser(int valeur, String sequence) {
		return sequence.equals("") ? sequence + valeur : sequence + " " + valeur;
	}

	private static boolean comparer() {
		return jeu.equals(joueur);
	}

	private static void reset() {
		joueur = "";
		for (int clear = 0; clear < 100; clear++) {
			System.out.println("\n");
		}
	}

	private static void lancer() {
		afficheBienvenue("Nat");
		while (!finJeu) {
			int valJeu = choisirUneValeurAuHasardEntre1Et4();
			jeu = memoriser(valJeu, jeu);
			System.out.println(valJeu);
			joueur = attendreEtLireChaineSaisieAuClavier();
			finJeu = !comparer();
			reset();
		}
		System.out.println("Perdu !");
		reader.close();
	}

	public static void main(String[] args) {
		lancer();
	}

}
