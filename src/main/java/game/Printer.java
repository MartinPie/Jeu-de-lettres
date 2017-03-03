package game;

public class Printer {

	public void welcome() {
		System.out.println("--- Welcome to Letter Farming Simulator 2017 ---\n\n");
	}

	public void menu() {
		System.out.println("What do you want to do ? (h for help)");
	}

	public void goodbye() {
		System.out.println("See you next time!!!");
	}

	public void printHelp() {
		System.out.println("\nh : Print this help");
		System.out.println("play  : start the game in local");
		System.out.println("rules  : Game's rules. Only available in french");
		System.out.println("q : Quit");
		System.out.println();
	}

	public void printHelp2() {
		System.out.println("\nh : Print this help");
		System.out.println("steal : steal a word or complete yours");
		System.out.println("make : make a word ");
		System.out.println("end : end the turn");
		System.out.println();
	}

	public void rules() {
		System.out.println("\nObjectif du jeux :Le premier joueur ayant 10 mots gagne la partie");
		System.out.println("Déroulement du jeux :\n");
		System.out.println(
				"Chacun des joueurs tire une lettre aléatoire d'un sac, et les mettent au milieu dans le pot commun");
		System.out.println("Le joueur qui a tiré la lettre la plus petite lettre dans l'alphabet commence");
		System.out.println(
				"Chaque fois que c'est le début du tour d'un joueur il tire deux lettres aléatoires qu'il rajoute au pot commun");
		System.out.println(
				"Chaque fois qu'un joueur fait un mot il tire une lettre aléatoire qu'il rajoute au pot commun");
		System.out.println(
				"Quand le joueur ne trouve plus de mot il passe et le joueur suivant commence son tour (par tirer 2 lettres qu'il rajoute au pot commun)");
		System.out.println("Comment faire un mot ?\n");
		System.out.println("En utilisant uniquement les lettres du pot commun");
		System.out.println(
				"En prenant un mot de ces adversaires (toutes les lettres du mot) et en lui rajoutant des lettres du pot commun");
		System.out.println(
				"En rallongeant un de ces mots avec des lettres du pot commun ou en utilisant un autre mot (toutes les lettres)");
		System.out.println("Attention, seul les noms communs sont autorisés");
		System.out.println("Pour faciliter :\n");
		System.out.println("les lettres possibles sont uniquement les 26 de l'alphabet (ex : é <-> e)");
		System.out.println("les mots composés sont considérés comme deux mots\n");
	}

	public void countdown() throws InterruptedException {
		System.out.println("\nStart of the Game");
		Thread.sleep(1000);
		System.out.println("3");
		Thread.sleep(1000);
		System.out.println("2");
		Thread.sleep(1000);
		System.out.println("1");
		Thread.sleep(1000);
		System.out.println("Go!!!!");
	}

}
