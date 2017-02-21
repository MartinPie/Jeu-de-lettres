package BRUN_MARTIN.Jeu_de_lettres;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {

	private List<Character> letters;
	private Random r;

	private Bag() {
		letters = new ArrayList<Character>();
		r = new Random();
	}

	/** Instance unique */
	private static Bag INSTANCE = null;

	public static Bag getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Bag();
		}
		return INSTANCE;
	}

	public void add(int nbLetters) {
		char letter;
		
		for (int i = 0; i < nbLetters; i++) {
			 letter = (char) (r.nextInt(26) + 'a');
			letters.add(letter);
			System.out.println("\nLettre tirée : " + letter);
		}
	}
	
	//TODO: classe tirer cartes
	public void draw(char letter){
		
	}
	
	public boolean isInBag(char letter){
		if(letters.contains(letter)){
			return true;
		}
		return false;
	}
	
	public void showLetters(){
		System.out.println("\nLettres disponibles : ");
		for (int i = 0; i < letters.size(); i++) {
			System.out.print(letters.get(i) +" ");
		}
		System.out.println("");
	}
	
}