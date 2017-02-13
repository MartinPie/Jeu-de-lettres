package BRUN_MARTIN.Jeu_de_lettres;
import java.io.Serializable;
import java.util.LinkedList;


public class Player implements Serializable {
	
	private static int currentId = 0;
	private int id;
	private String pseudo;

	public Player(String pseudo) {
		Player.currentId++;
		this.id = Player.currentId;
		this.setPseudo(pseudo);
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
}
