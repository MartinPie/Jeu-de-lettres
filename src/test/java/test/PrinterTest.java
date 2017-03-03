package test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.*;
import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PrinterTest  extends TestCase{

	public PrinterTest(String testName) {
		super(testName);
	}


	/**
	 * Rigourous Test :-)
	 */
	public void PrinterTest() {
	}

	
	@Test
	public final void testWelcome() {
		
	    PrintStream out = System.out;
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(baos));
	    System.out.println("--- Welcome to Letter Farming Simulator 2017 ---\n\n");
	    System.setOut(out);
	    String output = new String(baos.toByteArray());
	    assertTrue(output.contains("--- Welcome to Letter Farming Simulator 2017 ---\n\n"));
	}
	
	@Test
	public void testMenu() {
		    PrintStream out = System.out;
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    System.setOut(new PrintStream(baos));
		    System.out.println("What do you want to do ? (h for help)");
		    System.setOut(out);
		    String output = new String(baos.toByteArray());
		    assertTrue(output.contains("What do you want to do ? (h for help)"));
	}
	@Test
	public void testGoodbye() {
		 	PrintStream out = System.out;
		    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    System.setOut(new PrintStream(baos));
		    System.out.println("See you next time!!!");
		    System.setOut(out);
		    String output = new String(baos.toByteArray());
		    assertTrue(output.contains("See you next time!!!"));
	}

	

}
