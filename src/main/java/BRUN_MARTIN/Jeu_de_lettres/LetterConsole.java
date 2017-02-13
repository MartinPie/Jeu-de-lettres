package BRUN_MARTIN.Jeu_de_lettres;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.IOException;

public class LetterConsole 
{
	Scanner scanner;
	LinkedList<Player> players;
	

	public LetterConsole() {
		this.scanner = new Scanner(System.in);
		System.out.println("--- Welcome to Letter Farming Simulator 2017 ---");
		String rep;
		do {
			System.out.println("What do you want to do ? (h for help)");
			rep = this.scanner.next();
			try {
				switch (rep) {
				case "h" :
					this.printHelp();
					break;
				case "local" :
					this.localGame();
					break;
				case "rules" :
					this.rules();
					break;
				default :
					break;
				}
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				System.err.println();
			}	
			
		} while (!rep.equals("q"));
		System.out.println("See you next times!!!");
	}
	
	public void printHelp () {
		System.out.println("h : Print this help");
		System.out.println("local  : start the game in local");
		System.out.println("online  : start the game on the internet");
		System.out.println("rules  : Game's rules. Only available in french");
		System.out.println("q : Quit");
		System.out.println();
	}
	
	public void localGame()
	{
		System.out.println("Local game");
		this.players = this.createPlayer();
		try {
			this.game();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LinkedList<Player> createPlayer()
	{
		LinkedList<Player> players = new LinkedList<Player>();
		System.out.println("Number of players?");
		int nbPlayer = this.scanner.nextInt();
		for(int i=0; i<nbPlayer; i++)
		{
			System.out.println("Choose your pseudonyme");
			Player player = new Player(this.scanner.next());
			players.add(player);
		}
		return players;
	}
	
	public void game() throws InterruptedException {		
		System.out.println("Start of the Game");
		Thread.sleep(1000);
		System.out.println("3");
		Thread.sleep(1000);
		System.out.println("2");
		Thread.sleep(1000);
		System.out.println("1");
		Thread.sleep(1000);
		System.out.println("Go!!!!");
		boolean endgame;
		endgame=false;
		do
		{
			for(Player p:this.players) {
				
				System.out.println("Le joueur "+p.getPseudo()+" tire une lettre");
			}			
		}
		while(endgame == false);

		
	}
	
	public void rules()
	{
		/* TODO READ A FILE INSTEAD OF PRINTLN MARTIN IT'S FOR YOU!!!!!*/
		System.out.println("Objectif du jeux :Le premier joueur ayant 10 mots gagne la partie");
		System.out.println("Déroulement du jeux :");
		System.out.println("");
		System.out.println("Chacun des joueurs tire une lettre aléatoire d'un sac, et les mettent au milieu dans le pot commun");
		System.out.println("Le joueur qui a tiré la lettre la plus petite lettre dans l'alphabet commence");
		System.out.println("Chaque fois que c'est le début du tour d'un joueur il tire deux lettres aléatoires qu'il rajoute au pot commun");
		System.out.println("Chaque fois qu'un joueur fait un mot il tire une lettre aléatoire qu'il rajoute au pot commun");
		System.out.println("Quand le joueur ne trouve plus de mot il passe et le joueur suivant commence son tour (par tirer 2 lettres qu'il rajoute au pot commun)");
		System.out.println("Comment faire un mot ?");
		System.out.println("");
		System.out.println("En utilisant uniquement les lettres du pot commun");
		System.out.println("En prenant un mot de ces adversaires (toutes les lettres du mot) et en lui rajoutant des lettres du pot commun");
		System.out.println("En rallongeant un de ces mots avec des lettres du pot commun ou en utilisant un autre mot (toutes les lettres)");
		System.out.println("Attention, seul les noms communs sont autorisés");
		System.out.println("Pour faciliter :");
		System.out.println("");
		System.out.println("les lettres possibles sont uniquement les 26 de l'alphabet (ex : é <-> e)");
		System.out.println("les mots composés sont considérés comme deux mots");
		System.out.println();
	}
	
	public static void main(String[] args) {		
		LetterConsole console = new LetterConsole();
	}
}
