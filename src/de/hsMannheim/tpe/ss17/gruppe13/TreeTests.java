package de.hsMannheim.tpe.ss17.gruppe13;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTests {

	Baum myTree = new Baum();

	@Test
	public void insertTest() {

		try {
			myTree.insert(2);
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void insertTestFail() {
		try {
			myTree.insert("test");
		}

		catch (Exception e) {
			System.out.println("String are not allowed as parameter");
		}

	}

}
