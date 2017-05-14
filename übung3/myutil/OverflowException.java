package myutil;

public class OverflowException extends Exception {

private Object objectCausedOverflow;
	
	public Object getObjectCausedOverflow(){
		return this.objectCausedOverflow;
	}
	
	public OverflowException(String message, Object objectCausedOverflow){
		super(message);
		this.objectCausedOverflow = objectCausedOverflow;
	}
	
	public String toString(){
		String mes = this.getMessage();
		mes += "\n Object Caused Overflow: " + objectCausedOverflow;
		return mes;
	}


}
