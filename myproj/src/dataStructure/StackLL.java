package dataStructure;

public class StackLL <T>{
	
	public Node<T> top=null;
	private int size=0;
	
	public int size(){
		return size;
	}
	
	public void push(T data){
		
		Node<T> newNode=new Node<T>();
		size++;
		newNode.data=data;
		if(top==null){
			top=newNode;
			return;
		}
		newNode.next=top;
		top=newNode;
	}
	
	public T pop(){
		
		T data=top.data;
		top=top.next;
		size--;
		return data;
	}

}
