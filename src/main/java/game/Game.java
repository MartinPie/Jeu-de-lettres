package game;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import resources.Jar;
import resources.Player;

public class Game {
	Scanner scanner;
	List<Player> players;
	Jar letterJar = Jar.getInstance();
	Printer printer = new Printer();

	/***
	 * Ecran de départ affichant les possibilités
	 */
	public Game() {
		this.scanner = new Scanner(System.in);
		printer.welcome();
		String rep;
		do {
			printer.menu();
			rep = this.scanner.next();
			try {
				switch (rep) {
				case "h":
					printer.printHelp();
					break;
				case "play":
					this.localGame();
					break;
				case "rules":
					printer.rules();
					break;
				case "q":
					break;
				default:
					System.out.println("Unknow Command");
					break;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		} while (!rep.equals("q"));
		printer.goodbye();
	}

	/***
	 * Jeu local
	 */
	public void localGame() {
		this.players = Player.createPlayer();
		try {
			this.firstRound();
			this.game();
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}

	/***
	 * Jeu principal
	 * 
	 * @throws InterruptedException
	 */
	public void game() throws InterruptedException {

		String rep;
		boolean endgame;
		endgame = false;

		printer.countdown();

		do {
			for (Player p : this.players) {
				if (!endgame) {
					System.out.println("\nPlayer " + p.getPseudo() + " draw two letters");
					Jar.getInstance().add(2);
				}
				do {
					Jar.getInstance().showLetters();
					for (Player player : this.players) {
						System.out.println(
								"\n" + (players.indexOf(player) + 1) + " - " + player.getPseudo() + "'s words :");
						player.showWords();
					}
					System.out.println(p.getPseudo() + "'s turn");

					if (!p.isAi()) {
						rep = playerTurn(p);
					} else {
						rep = iaTurn(p);
					}
					if (p.isWinner()) {
						endgame = true;
						System.out.println(p.getPseudo() + " wins");
						break;
					}
				} while (!"end".equals(rep) && !endgame);
			}
		} while (!endgame);
	}

	public void firstRound() {

		for (Player p : this.players) {
			System.out.println("\nPlayer " + p.getPseudo() + " draw a letter");
			p.setOrder(Character.getNumericValue(Jar.getInstance().addOne()));
		}
		Collections.sort(this.players);
	}

	public static void main(String[] args) {
		new Game();
	}

	public boolean makeWord(Player player) {
		String word;

		System.out.println("Enter your word");
		word = this.scanner.next().trim();
		
		word = Jar.getInstance().replaceAll(word);
		
		if (word != "" && Jar.getInstance().draw(word,word, player.isAi())) {
			player.addWord(word);
			return true;
		}

		return false;
	}

	public boolean makeWordAI(Player player) {
		String word = Jar.getInstance().getIAWord();
		if (word != "" && Jar.getInstance().draw(word,word, player.isAi())) {
			System.out.println(player.getPseudo() + " ajoute le mot :" + word);
			player.addWord(word);
			return true;
		}
		return false;
	}

	public boolean stealWord(Player player) {
		int rep;
		Player player2;
		String stolenWord;
		String word;
		String stolenWordCopy;
		String wordCopy;

		System.out.println("Who do you want to steal?(Enter the player number)");
		rep = this.scanner.nextInt();

		player2 = players.get(rep - 1);

		player2.showWords();

		System.out.println("Which word do you want to steal?(Enter the word number)");
		rep = this.scanner.nextInt();

		stolenWord = player2.getWordList().get(rep - 1);

		System.out.println("Enter your word");
		word = this.scanner.next().trim();
		
		word = Jar.getInstance().replaceAll(word); 

		stolenWordCopy = stolenWord;
		wordCopy = word;

		for (char c : stolenWord.toCharArray()) {
			int index = wordCopy.indexOf(c);

			if (index != -1) {
				wordCopy = wordCopy.substring(0, index) + wordCopy.substring(index + 1, wordCopy.length());
				stolenWordCopy = stolenWordCopy.substring(0, index)
						+ stolenWordCopy.substring(index + 1, stolenWordCopy.length());
			} else {
				System.out.println("You have to use all letters of the stolen word");
				return false;
			}
		}

		if (wordCopy != "" && Jar.getInstance().draw(wordCopy,word, player.isAi())) {
			player.addWord(word);
			player2.deleteWord(stolenWord);
			return true;
		}
		return false;
	}

	public String playerTurn(Player p) {

		printer.menu();
		String rep = this.scanner.next();
		try {
			switch (rep) {
			case "steal":
				if (stealWord(p) && !p.isWinner()) {
					System.out.println("\nPlayer " + p.getPseudo() + " draw one letter");
					Jar.getInstance().addOne();
				}
				break;
			case "make":
				if (makeWord(p) && !p.isWinner()) {
					System.out.println("\nPlayer " + p.getPseudo() + " draw one letter");
					Jar.getInstance().addOne();
				}
				break;
			case "h":
				printer.printHelp2();
				break;
			case "end":
				break;
			default:
				System.out.println("Unknow Command");
				break;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return rep;
	}

	public String iaTurn(Player p) {
		while(makeWordAI(p) && !p.isWinner()) {
			System.out.println("\nPlayer " + p.getPseudo() + " draw one letter");
			Jar.getInstance().addOne();
		}
		return "end";
	}
}