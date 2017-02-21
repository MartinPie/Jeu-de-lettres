package BRUN_MARTIN.Jeu_de_lettres;

import java.util.List;
import java.util.Scanner;

public class LetterConsole {
	Scanner scanner;
	List<Player> players;
	Bag letterBag = Bag.getInstance();
	Printer printer = new Printer();

	/***
	 * Ecran de départ affichant les possibilités
	 */
	public LetterConsole() {
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
				default:
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

		String word;
		boolean endgame;
		endgame = false;

		printer.countdown();

		do {
			for (Player p : this.players) {

				System.out.println("\nLe joueur " + p.getPseudo() + " tire deux lettres");
				Bag.getInstance().add(2);

				do {
					Bag.getInstance().showLetters();
					for (Player player : this.players) {
						System.out.println("\nMots de " + player.getPseudo() + ":");
						player.showWords();
					}

					printer.instruction();
					
					word = this.scanner.next();
					char[] charArray = word.toCharArray();
					for (char c : charArray) {
						System.out.print("[" + c + "] ");
					}

					/* TODO: VERIFIER SI LE MOT EST DANS LE DICO */

				} while (!"/end".equals(word));

			}
		} while (!endgame);

	}

	public void firstRound() {
		for (Player p : this.players) {
			System.out.println("\nLe joueur " + p.getPseudo() + " tire une lettre lettres");
			Bag.getInstance().add(1);
		}
	}

	public static void main(String[] args) {
		new LetterConsole();
	}

}
