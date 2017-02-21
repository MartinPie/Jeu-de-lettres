package BRUN_MARTIN.Jeu_de_lettres;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Parser {
	
	public Set<Word> parseWords(String path){
		Set<Word> words = new HashSet<Word>();
		File text = new File(path);
		Scanner scnr;
		
		try {
			scnr = new Scanner(text);

			while (scnr.hasNextLine()) {
				Word word = new Word(scnr.nextLine());
				words.add(word);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		return words;
	}

}
