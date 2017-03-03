package test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

import game.Parser;

import java.util.Set;

import org.junit.*;

public class ParserTest  extends TestCase{

	public ParserTest(String testName) {
		super(testName);
	}

	
	@Test
	public void testParserGoodPath() {
	    String path = System.getProperty("user.dir") + "/src/main/resources/dico.txt";
	    Parser parser = new Parser();
	    Set<String> words = parser.parseWords(path);
		assertNotNull(words);
	}
	
	@Test
	public void testParserbadPath() {
	    String path = System.getProperty("user.dir") + "/src/main/resources/anywhere/lost/dico.txt";
	    Parser parser = new Parser();
	    try {
	    	 Set<String> words = parser.parseWords(path);
	      }catch(IllegalArgumentException e){
	    	  assert(e.getMessage().contains("E:\\Jeu-de-lettres\\src\\main\\resources\\anywhere\\lost\\dico.txt (Le chemin d’accès spécifié est introuvable)"));
	    		
	      }
	   
	}
	

	
}
