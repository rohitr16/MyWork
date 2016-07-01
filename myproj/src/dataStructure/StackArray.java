package dataStructure;

public class StackArray {
	
	private int[] data;
	public  int top; 
	
	public StackArray(){
		data=new int[10];
		top=-1;
	}

	
	public   int size(){
		return top + 1;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public int top() throws StackEmptyException{
		if(isEmpty()){
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return data[top];
	}
	
	public void push(int element) throws StackFullException{
		if(top == data.length -1){
			StackFullException e = new StackFullException();
			throw e;
		}
		data[++top] = element;
	}
	
	public int pop() throws StackEmptyException{
		if(isEmpty()){
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return data[top--];
	}


}
