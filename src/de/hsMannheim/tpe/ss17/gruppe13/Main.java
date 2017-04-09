package de.hsMannheim.tpe.ss17.gruppe13;

public class Main extends Baum {

	public static void main(String[] args) {
		Baum myBaum = new Baum();
		
		myBaum.insert(2);
		myBaum.insert(0);
		myBaum.insert(6);
		myBaum.insert(9);
		
		
		System.out.println(myBaum.size());
		myBaum.size();
	}

}
