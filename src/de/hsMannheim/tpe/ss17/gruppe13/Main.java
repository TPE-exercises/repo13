package de.hsMannheim.tpe.ss17.gruppe13;

public class Main {

	public static void main(String[] args) {
	
		
		Bbaum btree = new Bbaum(2);
		
		Bbaum btree2= new Bbaum(2);
		
		btree.insert(19);
		btree.insert(12);
		btree.insert(16);
		btree.insert(22);
		btree.insert(25);
		btree.insert(10);
		btree.insert(11);
		btree.insert(13);
		btree.insert(14);
		btree.insert(15);
		btree.insert(17);
		btree.insert(18);
		btree.insert(20);
		btree.insert(21);
		btree.insert(23);
		btree.insert(24);
		btree.insert(26);
		btree.insert(27);
		
		
		System.out.println(btree.size());
		System.out.println(btree.isEmpty());
		System.out.println(btree.getMax());
		System.out.println(btree.getMin());
		System.out.println(btree.contains(27));
	    System.out.println(btree.height());
	    
	    
	    
	    
	    
	    btree.printInorder();
	    btree.printLevelorder();
	    btree.printPostorder();
	    btree.printPreorder();
	    
	    btree.addAll(btree2);
	    
	    System.out.println(btree.clone());

	    
	    
	    
	}

}
