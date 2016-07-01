package dataStructure;

public class QueueLL<T> {
	
public	Node<T> front=null;
public	Node<T> rear=null;
	int size=0;
	
	public int length(){
		return size;
	}

	public boolean isEmpty(){
		return size==0;
	}
	public void Enqueue(T data){

		Node<T> newNode=new Node<T>();
		newNode.data=data;
		size++;

		if(rear==null){
			front=newNode;
			rear=newNode;
		}

		else{
			rear.next=newNode;
			rear=newNode;
		}

	}

	public T Dequeue(){

		T temp=front.data;
		size--;

		if(front==rear){
			front=rear=null;
		}
		else{
			front=front.next;
		}
		return temp;
	}


}
