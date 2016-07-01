package dataStructure;

public class queue {


	Node<Integer> front=null;
	Node<Integer> rear=null;
	int size=0;
	
	public int length(){
		return size;
	}

	public void Enqueue(int data){

		Node<Integer> newNode=new Node<Integer>();
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

	public int Dequeue(){

		int temp=front.data;
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
