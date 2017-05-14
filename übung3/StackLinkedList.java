import myutil.*;

public class StackLinkedList implements Stack,ADT {
	private int size;
	private LinkedList values;
	private int exceptionFlag = 0;
	
	public StackLinkedList(int size){
		this.size = size;
		values = new LinkedList();
	}
	
	@Override
	public void push(Object element) throws OverflowException {
		try{
			if(this.values.size()>= this.size){
				throw new OverflowException("List is full there is no place for: ", element);
			}
			else{
				this.values.addFirst(element);
			}
		}catch(OverflowException oexc){
			if(exceptionFlag == 0){
				this.size *= 2;
				this.values.addFirst(element);
				this.exceptionFlag++;
			}
			else{
				throw oexc;
			}
		}
		
	}

	@Override
	public Object pop() throws UnderflowException {
		if(this.values.isEmpty()){
			throw new UnderflowException("Stack ist leer.");
		}
		else{
			Object elem = this.values.removeLast();
			return elem;
		}
	}

	@Override
	public Object peak() {
		return this.values.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return this.values.isEmpty();
	}

	@Override
	public int size() {
		return this.values.size();
	}

	@Override
	public Object front() {
		return this.values.getFirst();
	}

}
