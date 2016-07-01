package dataStructure;

public class StackUsingQueue {

	queue newQueue=new queue();
	queue auxQueue=new queue();
	int size=0;

	public void push(int data){

		if(newQueue.rear==null){	
		newQueue.Enqueue(data);
		size++;
		}
		
		else{
			while(newQueue.front!=null){
				auxQueue.Enqueue(newQueue.Dequeue());
			}

			newQueue.Enqueue(data);
			size++;

			while(auxQueue.front!=null){
				newQueue.Enqueue(auxQueue.Dequeue());
			}
		}

	}

	public int popOptimal(){

		int data=newQueue.Dequeue();
		size--;
		return data;
	}



	public void pushOptimal(int data){

		newQueue.Enqueue(data);
		size++;
	}

	public int pop(){
		while(newQueue.front!=newQueue.rear){
			auxQueue.Enqueue(newQueue.Dequeue());
		}

		int data=newQueue.Dequeue();
		size--;

		while(auxQueue.rear!=null){
			newQueue.Enqueue(auxQueue.Dequeue());
		}

		return data;
	}



}
