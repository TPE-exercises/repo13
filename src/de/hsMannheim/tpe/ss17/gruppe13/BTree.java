package de.hsMannheim.tpe.ss17.gruppe13;

import java.io.IOException;

public interface BTree {

	boolean insert(Integer o);

	boolean insert(String filename) throws IOException;

	boolean contains(Integer o);

	int size();

	int height();

	Integer getMax();

	Integer getMin();

	boolean isEmpty();

	void addAll(BTree otherTree);

}
