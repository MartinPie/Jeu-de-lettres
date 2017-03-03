package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import resources.Dictionary;
import resources.Jar;
import resources.Player;

public class JarTest extends TestCase {

	public JarTest(String testName) {
		super(testName);
	}

	public void testJar() {
		Jar letterJar = Jar.getInstance();
		assertNotNull(letterJar);
	}

	public void testAdd() {
		Jar letterJar = Jar.getInstance();
		int sizeB = letterJar.getJarLetter().size();
		letterJar.add(1);
		int sizeA = letterJar.getJarLetter().size();
		assertEquals(sizeB+1, sizeA);
	}

	public void testGetIAWord() {
		Jar letterJar = Jar.getInstance();
		int sizeB = letterJar.getJarLetter().size();
		letterJar.add(20);
		String word =  letterJar.getIAWord();
		assertNotNull(word);
	}

}
