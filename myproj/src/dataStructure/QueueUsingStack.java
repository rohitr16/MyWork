package dataStructure;

public class QueueUsingStack{

	StackArray stack=new StackArray();
	StackArray auxStack=new StackArray();
	
	public void EnqueueT(int data)throws StackEmptyException, StackFullException {
		
	
			while(stack.top!=-1){
				auxStack.push(stack.pop());
			}
			stack.push(data);
			while(auxStack.top!=-1){
				stack.push(auxStack.pop());
			}
	
	}
	
	public int DequeueT() throws StackEmptyException{
		
     	return stack.pop();
		
	}
	
	public void Enqueue(int data)throws StackEmptyException,StackFullException{
		
		stack.push(data);
			
	}
	
	public int Dequeue() throws StackFullException, StackEmptyException{
		
		while(stack.top!=0){
			auxStack.push(stack.pop());
		}
		int data=stack.pop();
		
		while(auxStack.top!=-1){
			stack.push(auxStack.pop());
		}
		
		return data;
	}
	

}
