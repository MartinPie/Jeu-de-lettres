package test;
import java.util.List;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import resources.Dictionary;


public class DictionnaryTest  extends TestCase{

	public DictionnaryTest(String testName) {
		super(testName);
	}

	/**
	 * Rigourous Test :-)
	 */
	
	private Dictionary dictionnaire;
	
	//@Before
	public void setDico() {
		dictionnaire = new Dictionary();
	}
	
	@Test
	public void testGetBestWordOK() {
		this.setDico(); 
		List<Character> list = new ArrayList<Character>();
		list.add('b');
		list.add('a');
		list.add('b');
		list.add('a');
		String word = dictionnaire.getBestWord(list);
		assertEquals("baba",word);/* au rhum */
	}
	@Test
	public void testGetBestWordNotOk() {
		this.setDico(); 
		List<Character> list = new ArrayList<Character>();
		list.add('r');
		list.add('f');
		String word = dictionnaire.getBestWord(list);
		assertEquals("",word);
	}
	
	@Test
	public void testGetWorldExist() {
		this.setDico(); 
		boolean exist = dictionnaire.exist("chat");
		assertTrue(exist);
	}
	
	@Test
	public void testGetWorldNotExist() {
		this.setDico(); 
		boolean notExist = dictionnaire.exist("parleamamain");
		assertEquals(false,notExist);
	}
	
	@Test
	public void testGetInstance() {
		this.setDico(); 
		assertNotNull(dictionnaire.getInstance());
	}
	
}
