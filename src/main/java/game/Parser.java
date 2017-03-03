package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Parser {

	public Set<String> parseWords(String path) {
		Set<String> words = new HashSet<String>();
		File text = new File(path);
		Scanner scnr;

		try {
			scnr = new Scanner(text);

			while (scnr.hasNextLine()) {
				words.add(scnr.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

		return words;
	}

}
