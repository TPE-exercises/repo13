package myutil;

public interface Stack {
	/**
	 * @return size of stack
	 */
	public int size();
	/**
	 * push object on stack
	 * @param element will be put on stack
	 */
	public void push(Object element) throws OverflowException;
	/**
	 * return object from top of stack
	 */
	public Object peak();
	
	/**
	 * removes object in stack
	 */
	public Object pop()throws UnderflowException;
	/**
	 * checks if stack is empty
	 * @return true if stack is empty
	 * @return false if stack isn't empty
	 */
	public boolean isEmpty();

}
