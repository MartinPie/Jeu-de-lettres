package resources;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import game.Parser;

public class Dictionary {

	Set<String> words;
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

	public String getBestWord(List<Character> list){
		Iterator<String> test = words.iterator();
		while (test.hasNext()) {
			String word = test.next();
			
			if (word.length() <= list.size())
			{
		
				List<Character> wordList = new ArrayList<Character>();
				
				for(char elt : word.toCharArray()){
					wordList.add(elt);
				}
				
				if(list.containsAll(wordList))
				{
					return word;
				}
			}
		}
		return "";
	}
	

	
	public boolean exist(String word) {

		if (words.contains(word)) {
			
			return true;
		}
		return false;
	}

}