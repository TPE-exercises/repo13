package repo13;

public class Node {

	public Node links;
	public Node rechts;
	public int wert;
	public Node parent;
	
	public Node(Integer i, Node parent){
		this.wert=i;
		this.parent = parent;
		}
}
