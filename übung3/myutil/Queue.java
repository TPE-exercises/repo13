package myutil;

public interface Queue {
	/**
	 * if queue is full for the first time, size gets doubled, else overflow exception
	 * @param element to enter
	 * @return Queue with element
	 *  @throws OverflowException 
	 */
	public void push(Object element) throws OverflowException;;
	
	/**
	 * Removes first element of queue
	 * @return first element
	 */
	public Object pop() throws UnderflowException;
	
	/**
	 * @return first element of Queue
	 */
	public Object front();
	
	
	/**
	 * @return true, if Queue is empty
	 * @return false, if Queue isn't empty
	 */
	public boolean isEmpty();
	
	
	/**
	 * 
	 * @return size of queue
	 */
	public int size();


}
