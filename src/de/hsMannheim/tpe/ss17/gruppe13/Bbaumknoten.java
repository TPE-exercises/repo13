package de.hsMannheim.tpe.ss17.gruppe13;

import gdi.MakeItSimple.GDIException;

public class Bbaumknoten {
	
	private Object[] values;
	private Bbaumknoten[] next;
	private int order;

	
	public Bbaumknoten(int order) {
		if(order <= 0) {
			throw new GDIException("Ordnung muss positiv sein");
		}
		values = new Object[(order * 2) + 1];
		next = new Bbaumknoten[(order * 2) + 2];
		this.order = order;
	}
	
	
	public boolean isOverFilled() {
		return values[values.length - 1] != null;
	}
	
	
	public boolean isLeaf() {
		return next[0] == null;
	}
	
	
	public boolean isEmpty() {
		return values[0] == null;
	}
	
	
	public String toString() {
		String value = "[";
		int nr = 0;
		
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null) {
				if(nr != 0) {
					value += " ";
				}
				value += values[i].toString();
				nr++;
			}
		}
		
		value += "]";
		
		return value;
	}
	
	public Object getMin() {
		if(next[0] == null){
			return values[0];
		}
		else {
			return next[0].getMin();
		}
	}
	
	
	public Object getMax() {
		for(int i = next.length - 1; i >= 0; i--) {
			if(next[i] != null) {
				return next[i].getMax();
			}
		}
		
		for(int i = values.length - 1; i >= 0; i--) {
			if(values[i] != null) {
				return values[i];
			}
		}
		
		return null;
	}
	
	
	public int size() {
		int size = 0;
		for(Object value : values) {
			if(value != null) {
				size++;
			}
		}
		
		for(Bbaumknoten node : next) {
			if(node != null) {
				size += node.size();
			}
		}
		
		return size;
	}
	

	public Bbaumknoten getMinNext() {
		return next[0];
	}
	
	
	public Object[] getValues() {
		return values;
	}
	
	
	public Object[] getAll() {
		Object[] all = new Object[0];
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null) {
				Object[] val = new Object[1];
				val[0] = values[i];
				all = mergeArrays(all, val);
			}
		}
		
		for(int i = 0; i < next.length; i++) {
			if(next[i] != null) {
				Object[] nextArray = next[i].getAll();
				all = mergeArrays(all, nextArray);
			}
		}
		
		return all;
	}
	
	
	public Bbaumknoten cloneDeep() {
		Bbaumknoten clone = new Bbaumknoten(order);
		clone.values = this.values;
		for(int i = 0; i < next.length; i++) {
			if(next[i] != null) {
				clone.next[i] = next[i].cloneDeep();
			}
		}
		
		return clone;
	}
	
	
	private Object[] mergeArrays(Object[] a1, Object[] a2) {
		Object[] merged = new Object[a1.length + a2.length];
		
		for(int i = 0; i < a1.length; i++) {
			merged[i] = a1[i];
		}
		for(int i = a1.length, j = 0; j < a2.length; i++, j++) {
			merged[i] = a2[j];
		}
		
		return merged;
	}
	

	public Bbaumknoten[] getNext() {
		return next;
	}
	
	
	public boolean contains(Object obj) {
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null && values[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void insert(Object o, Bbaumknoten rightPart, Bbaumknoten leftPart) {
		if(values[values.length - 1] != null) {
			throw new GDIException(" Knoten schon gefüllt");
		}
		
		for(int i =  values.length - 1; i >= 0; i--) {
			
			if(values[i] != null) {
				if((Integer)values[i] > (Integer)o) {
					values[i + 1] = values[i];
					next[i + 2] = next[i + 1];
				}
				else if(values[i].equals(o)) {
					throw new GDIException("Double-Werte nicht erlaubt");
				}
				else {
					values[i + 1] = o;
					next[i + 2] = rightPart;
					return;
				}
			}
			
		}
		values[0] = o;
		next[1] = rightPart;
		if(leftPart != null) {
			next[0] = leftPart;
		}
		return;
	}
	
	
	public void insert(Object o) {	
		insert(o, null, null);
	}
	

	public Bbaumknoten getNextNodeToSearch(Object o) {
		Bbaumknoten nextNode = next[values.length - 1];
		boolean found = false;
		
		for(int i = 0; i < values.length - 1; i++) {
			if(values[i] == null || (Integer)o < (Integer)values[i]) {
				if(!found) {
					nextNode = next[i];
					found = true;
				}
			}
		}
		
		return nextNode;
	}
	
	
	public void split(Bbaumknoten parent) {
		Bbaumknoten rightNode = new Bbaumknoten((values.length - 1) / 2);
		
		int middlePosition = values.length / 2;
		
		for(int i = middlePosition + 1; i < values.length; i++) {
			rightNode.insert(values[i], next[i + 1], null);
		}
		rightNode.next[0] = next[middlePosition + 1];
		
		parent.insert(values[middlePosition], rightNode, this);
		
		
		
		for(int i = middlePosition; i < values.length; i++) {
			values[i] = null;
		}
		for(int i = middlePosition + 1; i < next.length; i++) {
			next[i] = null;
		}
		
		
	}

	
}


