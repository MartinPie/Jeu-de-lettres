package BRUN_MARTIN.Jeu_de_lettres;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Player implements Comparable<Player> {

	private int order;
	private String pseudo;
	private List<String> wordList;
	private static Scanner scanner;

	public Player(String pseudo) {
		this.setPseudo(pseudo);
		this.order = 0;
		this.wordList = new ArrayList<String>();
	}

	/***
	 * Création de joueurs
	 * 
	 * @return la liste des joueurs
	 */
	public static LinkedList<Player> createPlayer() {
		scanner = new Scanner(System.in);
		LinkedList<Player> players = new LinkedList<Player>();
		System.out.println("\nNumber of players?");
		int nbPlayer = scanner.nextInt();

		for (int i = 1; i <= nbPlayer; i++) {
			System.out.println("\nPlayer " + i + ": Choose your pseudonyme");
			Player player = new Player(scanner.next());
			players.add(player);
		}
		return players;
	}

	public void showWords() {
		for (int i = 0; i < wordList.size(); i++) {
			System.out.println("\t" + (i + 1) + " - " + wordList.get(i));
		}
	}

	public void addWord(String word) {
		wordList.add(word);
	}

	public void deleteWord(String word) {
		wordList.remove(word);
	}

	public boolean isWinner() {
		if (wordList.size() > 9) {
			return true;
		}
		return false;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public List<String> getWordList() {
		return wordList;
	}

	public void setWordList(List<String> wordList) {
		this.wordList = wordList;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int compareTo(Player comparatedPlayer) {
		int order = ((Player) comparatedPlayer).getOrder();

		return this.getOrder() - order;
	}

}
