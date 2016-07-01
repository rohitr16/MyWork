package dataStructure;

public class MinStack {

	StackLL<Integer> stack=new StackLL<>();
	StackLL<Integer> minStack=new StackLL<>();
	int size=0;

	public void push(int data){

		if(stack.top==null){
			minStack.push(data);
		}
		stack.push(data);
		
		if(minStack.top.data>data){
			minStack.push(data);
		}	
	}

	public int pop(){

		int data=stack.pop();
		if(minStack.top.data==data){
			minStack.pop();
		}
		return data;
	}
	
	public int getMinimum(){
		
		return minStack.top.data;
	}
}
