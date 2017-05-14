package comparable;

public class MyString implements Comparable<MyString> {

	private String string;
	
	MyString(String string){
		this.string=string;
	}
	
	public String getString(){
		return this.string;
	}

	/**
	 * @return 0  this==o; -1 this<o; 1 this>o
	 */
	@Override
	public int compareTo(MyString o) {		
		
		return this.string.compareTo(o.getString());
	}

	public String toString(){
		return this.string;
	}
}
