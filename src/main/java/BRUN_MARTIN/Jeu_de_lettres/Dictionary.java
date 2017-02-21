package BRUN_MARTIN.Jeu_de_lettres;

import java.util.Set;

public class Dictionary {

	Set<Word> words;
	private static String path = System.getProperty("user.dir") + "/src/main/resources/dico.txt";
	Parser parser;

	public Dictionary() {
		parser = new Parser();
		this.words = parser.parseWords(path);
	}

	/** Instance unique */
	private static Dictionary INSTANCE = null;

	public static Dictionary getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Dictionary();
		}
		return INSTANCE;
	}

	public boolean exist(String word) {
		if (words.contains(word)) {
			return true;
		}
		return false;
	}

}