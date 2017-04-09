package de.hsMannheim.tpe.ss17.gruppe13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Baum implements BTree {

	Node root;

	public Baum() {
		root = null;
	}

	@Override
	public boolean insert(Integer o) {
		if (root == null) {
			root = new Node(o, null);
		} else {
			insert(root, o);
		}
		return true;
	}

	private void insert(Node parent, Integer o) {
		if (parent.wert >= o) {
			if (parent.links == null) {
				parent.links = new Node(o, parent);
			} else {
				insert(parent.links, o);
				if (((BTree) parent.links).height() - ((BTree) parent.rechts).height() == 2) {
					if (o - parent.links.wert < 0) {
						parent = rotateWithLeftChild(parent);
					} else {
						parent = doubleRotateWithRightChild(parent);
					}
				}

			}
		}

		else {
			if (parent.rechts == null) {
				parent.rechts = new Node(o, parent);

			} else {
				insert(parent.rechts, o);
				if ( parent.links.height() - parent.rechts.height() == -2) {
					if (o - parent.rechts.wert < 0) {
						parent = rotateWithRightChild(parent);
					} else {
						parent = doubleRotateWithLeftChild(parent);
					}
				}
			}
		}

	}

	private Node doubleRotateWithLeftChild(Node k1) {
		k1.rechts = rotateWithLeftChild(k1.rechts);
		return rotateWithRightChild(k1);
	}

	private Node doubleRotateWithRightChild(Node k3) {
		k3.links = rotateWithRightChild(k3.links);
		return rotateWithLeftChild(k3);
	}

	private Node rotateWithRightChild(Node k1) {
		Node k2 = k1.rechts;
		k1.rechts = k2.links;
		k2.links = k1;
		return k2;
	}

	private Node rotateWithLeftChild(Node k2) {
		Node k1 = k2.links;
		k2.links = k1.rechts;
		k1.rechts = k2;
		return k1;

	}

	@Override
	public boolean insert(String filename) throws IOException {
		FileReader fr = new FileReader("filename");
		BufferedReader br = new BufferedReader(fr);
		String zeile = "";

		while (zeile != null) {
			zeile = br.readLine();
			int casInt = Integer.parseInt(zeile);
			insert(casInt);

		}
		return true;

	}

	@Override
	public boolean contains(Integer o) {
		if (root.wert == o) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		if (root == null) {
			return 0;
		} else {
			return 1 + size(root.links) + size(root.rechts);
		}
	}

	private int size(Node parent) {
		if (parent == null) {
			return 0;
		} else {
			return 1 + size(parent.links) + size(parent.rechts);
		}
	}

	@Override
	public int height() {

		int left = 0;
		int right = 0;

		if (root.links != null) {
			left = height(root.links) + 1;
		}
		if (root.rechts != null) {
			right = height(root.rechts) + 1;
		}
		return Math.max(left, right);

	}

	private int height(Node parent) {
		int left = 0;
		int right = 0;

		if (parent.links != null) {
			left = height(parent.links) + 1;
		}
		if (parent.rechts != null) {
			right = height(parent.rechts) + 1;
		}
		return Math.max(left, right);

	}

	@Override
	public Integer getMax() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void addAll(BTree otherTree) {
		// TODO Auto-generated method stub

	}

	public String toString() {
		if (root == null) {
			return "leerer Baum";
		} else {
			return toString(root.links) + ";" + root.wert + " ; " + toString(root.rechts);
		}
	}

	private String toString(Node parent) {
		if (parent == null) {
			return "";
		} else {
			return toString(parent.links) + ";" + parent.wert + " ; " + toString(parent.rechts);
		}
	}

}
