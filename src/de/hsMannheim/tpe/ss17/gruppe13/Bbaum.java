package de.hsMannheim.tpe.ss17.gruppe13;

import static gdi.MakeItSimple.closeInputFile;
import static gdi.MakeItSimple.isEndOfInputFile;
import static gdi.MakeItSimple.isFilePresent;
import static gdi.MakeItSimple.openInputFile;
import static gdi.MakeItSimple.print;
import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readInt;

import gdi.MakeItSimple.GDIException;

public class Bbaum {

	private int order;
	private Bbaumknoten root;

	public Bbaum(int order) {
		if (order <= 0) {
			throw new GDIException("Ordnung muss positiv sein.");
		} else {
			this.order = order;
		}
	}

	
	public int getOrder() {
		return this.order;
	}

	/**
	 * Fügt Element in Baum ein. True wird zurückgegeben, wenn erfolgeich
	 * eingefügt.
	 */
	public boolean insert(Object o) {

		if (o == null || contains(o)) {
			return false;
		}

		if (root == null) {
			// Baum leer
			root = new Bbaumknoten(order);
			root.insert(o);
		} else {
			// Baum nicht leer
			Bbaumknoten newRoot = new Bbaumknoten(order);
			insertrek(o, root, newRoot);

			if (!newRoot.isEmpty()) {
				root = newRoot;
			}

		}

		return true;
	}

	private void insertrek(Object o, Bbaumknoten currentNode, Bbaumknoten previousNode) {
		if (currentNode.isLeaf()) {
			currentNode.insert(o);
		} else {
			insertrek(o, currentNode.getNextNodeToSearch(o), currentNode);
		}

		if (currentNode.isOverFilled()) {
			currentNode.split(previousNode);
		}
	}

	public boolean insert(Integer o) {
		return insert((Object) o);
	}

	

	public boolean contains(Integer o) {
		return contains((Object) o);
	}

	public boolean contains(Object o) {
		if (o == null) {
			return false;
		}

		Bbaumknoten currentNode = root;

		while (currentNode != null) {
			if (currentNode.contains(o)) {
				return true;
			} else {
				currentNode = currentNode.getNextNodeToSearch(o);
			}
		}

		return false;
	}

	public int size() {
		if (root == null) {
			return 0;
		} else {
			return root.size();
		}
	}

	public int height() {
		if (root == null) {
			return 0;
		} else {
			return hight(root, 0);
		}
	}

	private int hight(Bbaumknoten currentNode, int currentHeight) {
		if (currentNode.isLeaf()) {
			return currentHeight + 1;
		} else {
			return hight(currentNode.getMinNext(), currentHeight + 1);
		}
	}

	public Integer getMax() {
		if (root == null) {
			throw new GDIException(" leer ");
		} else {
			return (Integer) root.getMax();
		}
	}

	public Integer getMin() {
		if (root == null) {
			throw new GDIException(" leer ");
		} else {
			return (Integer) root.getMin();
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void printInorder() {
		println(toStringInorder(root));
	}

	private String toStringInorder(Bbaumknoten node) {
		if (node == null) {
			return new String();
		}
		if (node.isLeaf()) {
			return node.toString();
		} else {
			String string = new String();
			Object[] values = node.getValues();
			Bbaumknoten[] next = node.getNext();
			boolean hasEnded = false;
			int lastElement = 0;

			for (int i = 0; i < values.length && !hasEnded; i++) {
				if (values[i] == null) {
					hasEnded = true;
					lastElement = i;
				} else {
					if (i != 0) {
						string += ", ";
					}
					string += toStringInorder(next[i]);
					string += ", ";
					string += values[i];
				}
			}
			string += toStringInorder(next[lastElement]);

			return string;
		}
	}

	public void printPostorder() {
		println(toStringPostorder(root));
	}

	private String toStringPostorder(Bbaumknoten node) {
		if (node == null) {
			return "";
		}
		if (node.isLeaf()) {
			return node.toString();
		} else {
			String string = "";

			Bbaumknoten[] next = node.getNext();
			for (int i = 0; (i < next.length && next[i] != null); i++) {
				if (i > 0) {
					string += ", ";
				}
				string += toStringPostorder(next[i]);
			}

			string += node.toString();

			return string;
		}
	}

	public void printPreorder() {
		println(toStringPreorder(root));
	}

	private String toStringPreorder(Bbaumknoten node) {
		if (node == null) {
			return "";
		}
		if (node.isLeaf()) {
			return node.toString();
		} else {
			String string = "";

			string += node.toString();

			Bbaumknoten[] next = node.getNext();
			for (int i = 0; (i < next.length && next[i] != null); i++) {
				if (i > 0) {
					string += ", ";
				}
				string += toStringPreorder(next[i]);
			}

			return string;
		}
	}

	public void printLevelorder() {
		println(toStringLevelorder());
	}

	private String toStringLevelorder() {
		String elements = "";

		java.util.Queue<Bbaumknoten> queue = new java.util.LinkedList<Bbaumknoten>();
		

		queue.add(root);

		while (!queue.isEmpty()) {
			Bbaumknoten node = queue.remove();

			if (node != null) {
				elements += node + " ";
				Bbaumknoten[] next = node.getNext();
				for (Bbaumknoten currentNext : next) {
					queue.add(currentNext);

				}
			}
		}
		return elements;
	}

	
	public Bbaum clone() {
		Bbaum clone = new Bbaum(order);

		clone.root = root.cloneDeep();

		return clone;
	}

	
	public String toString() {
		return toStringLevelorder();
	}

	public Object[] values() {
		return root.getAll();
	}

	public void addAll(Bbaum otherTree) {
		if (otherTree == null) {
			throw new GDIException(" nicht möglich ");
		}
		Object[] otherValues = otherTree.values();

		for (Object o : otherValues) {
			insert(o);
		}
	}


}