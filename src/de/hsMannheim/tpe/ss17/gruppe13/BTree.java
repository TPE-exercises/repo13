package de.hsMannheim.tpe.ss17.gruppe13;

import java.io.IOException;

public interface BTree {

	
	/**
	 * Insert number of Integer o in tree
	 * @param o
	 * @return
	 */
	boolean insert(Integer o);

	/**
	 * inserts element from file in tree
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	boolean insert(String filename) throws IOException;

	/**
	 * Check if o is in tree; 
	 * @param o
	 * @return
	 */
	boolean contains(Integer o);

	/**
	 * get size of tree
	 * @return
	 */
	int size();

	/**
	 * get height of tree
	 * @return
	 */
	int height();

	/**
	 * get max value in tree
	 * @return
	 */
	Integer getMax();

	/**
	 * get min value in tree
	 * @return
	 */
	Integer getMin();

	/**
	 * check if tree is empty
	 * @return
	 */
	boolean isEmpty();

	/**
	 * copy values of tree in new tree 
	 * @param otherTree
	 */
	void addAll(BTree otherTree);

}
