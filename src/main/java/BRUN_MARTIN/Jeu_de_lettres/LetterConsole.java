package BRUN_MARTIN.Jeu_de_lettres;

import java.util.List;
import java.util.Scanner;

public class LetterConsole {
	Scanner scanner;
	List<Player> players;
	Jar letterJar = Jar.getInstance();
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

		String rep;
		boolean endgame;
		endgame = false;

		printer.countdown();

		do {
			for (Player p : this.players) {

				System.out.println("\nPlayer" + p.getPseudo() + " draw two letters");
				Jar.getInstance().add(2);

				do {
					Jar.getInstance().showLetters();
					for (Player player : this.players) {
						System.out.println("\n" + player.getPseudo() + "'s words :");
						player.showWords();
					}
					printer.instruction();

					rep = this.scanner.next();
					try {
						switch (rep) {
						case "steal":
							stealWord();
							break;
						case "make":
							makeWord();
							break;
						default:
							break;
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				} while (!"end".equals(rep));
				if (p.isWinner()) {
					endgame = true;
					System.out.println(p.getPseudo() + " win");
					break;
				}
			}
		} while (!endgame);
	}

	public void firstRound() {
		for (Player p : this.players) {
			System.out.println("\nPlayer " + p.getPseudo() + " draw a letter");
			Jar.getInstance().add(1);
		}
		// TODO: savoir qui commence
	}

	public static void main(String[] args) {
		new LetterConsole();
	}

	public void makeWord() {
		// TODO: makeword function
	}

	public void stealWord() {
		// TODO: steal function
		// mettre fonction tirer carte si ca marche sinon nan ( ou alors
		// renvoyer boolean si ca marche et exporter au cran du dessus
	}

}
