package test;
import java.util.List;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import resources.Player;


public class PlayerTest  extends TestCase{

	public PlayerTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */

	@Test
	public void testNewPlayer()
	{
		Player player = new Player("roger",false);
		assertNotNull(player);
	}
	@Test
	public void testAddWord(String word) {
		Player player = new Player("roger",true);
		int beforeAdd = player.getWordList().size();
		player.getWordList().add("test");
		int AfterAdd = player.getWordList().size();
		assertEquals(beforeAdd+1, AfterAdd);
	}
	@Test
	public void testDeleteWord(String word) {
		Player player = new Player("roger",true);
		player.getWordList().add("test");
		int beforeRemove= player.getWordList().size();
		player.getWordList().remove("test");
		int AfterRemove = player.getWordList().size();
		assertEquals(beforeRemove-1, AfterRemove);
		
	}
	@Test
	public void testIsWinnerOK() {
		Player player = new Player("roger",true);
		player.getWordList().add("test");
		player.getWordList().add("test");
		player.getWordList().add("test");
		player.getWordList().add("test");
		player.getWordList().add("test");
		player.getWordList().add("test");
		player.getWordList().add("test");
		player.getWordList().add("test");
		player.getWordList().add("test");
		player.getWordList().add("test");
		boolean winner = player.isWinner();
		assertTrue(winner);
	}
	@Test	
	public void testIsWinnerNO() {
		Player player = new Player("roger",true);
		player.getWordList().add("test");
		boolean winner = player.isWinner();
		assertEquals(false,winner);
	}
	@Test	
	public void testIsAi() {
		Player player = new Player("roger",true);
		boolean isAI = player.isAi();
		assertTrue(isAI);
	}
	
	@Test
	public void testSetAi() {
		Player player = new Player("roger",false);
		player.setAi(true);
		boolean isAI = player.isAi();
		assertTrue(isAI);
	}
}
