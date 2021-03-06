package resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jar {

	private List<Character> letters;
	private Random r;

	private Jar() {
		letters = new ArrayList<Character>();
		r = new Random();
	}

	/** Instance unique */
	private static Jar INSTANCE = null;

	public static Jar getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Jar();
		}
		return INSTANCE;
	}

	public void add(int nbLetters) {
		for (int i = 0; i < nbLetters; i++) {
			addOne();
		}
	}

	public char addOne() {
		char letter;

		letter = (char) (r.nextInt(26) + 'a');
		letters.add(letter);
		System.out.println("Drawed letter : " + letter);

		return letter;
	}

	public boolean draw(String word,String entireWord, boolean ai) {
		List<Character> tempJar = new ArrayList<Character>();
		for (Character letter : word.toCharArray()) {
			if (letters.contains(letter)) {
				tempJar.add(letter);
				letters.remove(letter);
			} else {
				System.out.println("The jar don't contains the letter " + letter);
				this.letters.addAll(tempJar);
				return false;
			}
		}

		if (!Dictionary.getInstance().exist(entireWord) && !ai) {
			System.out.println("This word doesn't exists");
			this.letters.addAll(tempJar);
			return false;
		}

		return true;
	}

	public void showLetters() {
		System.out.println("\nAvailable letters: ");
		for (int i = 0; i < letters.size(); i++) {
			System.out.print(letters.get(i) + " ");
		}
		System.out.println("");
	}
	
	public List<Character> getJarLetter()
	{
		return this.letters;
	}
	
	public String getIAWord()
	{
		return Dictionary.getInstance().getBestWord(this.getJarLetter());
	}
	
	public String replaceAll(String word){
		
		word = word.toLowerCase();
		word = word.replaceAll("[èéêë]","e");
		word = word.replaceAll("[àáâãäå]","a");
		word = word.replaceAll("[òóôõöø]","o");
		word = word.replaceAll("[ìíîï]","i");
		word = word.replaceAll("[ùúûü]","u");
		word = word.replaceAll("[ÿ]","y");
		word = word.replaceAll("[ç]","c");
		word = word.replaceAll("[Ç]","C");
		word = word.replaceAll("[°]","-");
		word = word.replaceAll("[Ñ]","N");
		word = word.replaceAll("[ÙÚÛÜ]","U");
		word = word.replaceAll("[ÌÍÎÏ]","I");
		word = word.replaceAll("[ÈÉÊË]","E");
		word = word.replaceAll("[ÒÓÔÕÖØ]","O");
		word = word.replaceAll("[ÀÁÂÃÄÅ]","A");
		
		return word;
	}
}