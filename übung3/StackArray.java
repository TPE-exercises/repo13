import myutil.*;

public class StackArray implements Stack,ADT {
	static int ixd =0;
	static int exceptionflag=0;

	private Object [] values;
	
	
	StackArray(int size){
		this.values=new Object[size];
	}
	

	@Override
	public void push(Object element) throws OverflowException {
		try{
			if(values[values.length -1] == null){
				for(int i = 0; i < values.length; i++){
					if(values[i] == null){
						values[i] = element;
						break;
					}
				}
			}
			else{
				throw new OverflowException("Stack is full element can't be pushed: "+element,element);
			}
			
		}
		catch(OverflowException ex){
			if(exceptionflag == 0){
				doublesSize(element);
				this.exceptionflag++;
			}
			else{
				throw ex;
			}
		}
		
		
	}

	private Object[] doublesSize(Object element) {
		Object[] doubled = new Object[(this.values.length * 2)];
		
		for(int i = 0; i < this.values.length; i++){
			doubled[i] = values[i];
		}
		
		doubled[this.values.length] = element;
		this.values = doubled;
		return this.values;
		
	}


	@Override
	public Object peak() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object pop() throws UnderflowException{
		if(this.isEmpty()==true){
			throw new UnderflowException("");
		}
		else{
			Object ret = values[values.length-1];
			for(int i = 1; i < values.length; i++){
				if(values[i] == null){
					ret = values[i-1];
					values[i-1] = null;
					return ret;
				}
			}
			values[values.length-1] = null;
			return ret;
		}
	}
 
	
	@Override
	public int size() {
		for(int i = 0; i < values.length; i++){
			if(values[i]==null){
				return i;
			}
		}
		return values.length;
	}
	

	@Override
	public boolean isEmpty() {
		if(values[0]==null){
			return true;
		}
		else
			return false;
	}


	@Override
	public Object front() {
		// TODO Auto-generated method stub
		return null;
	}

}
