package dataStructure;

import java.util.Scanner;

public class queue_implement {
	
	
	public static  void reverseQueue(queue newQueue){
		
		if(newQueue.front==newQueue.rear){
			return ;
		}
		
		int data=newQueue.Dequeue();
		reverseQueue(newQueue);
	    newQueue.Enqueue(data);    
		
	}

	public static void main(String[] args) throws StackEmptyException, StackFullException {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
//		queue newQueue=new queue();
//		System.out.println("Enter Size:");
//		int size=s.nextInt();
		
//		for(int i=0;i<size;i++){
//			int data=s.nextInt();
//			newQueue.Enqueue(data);
//		}
//		
//		reverseQueue(newQueue);
//		Node<Integer> temp=newQueue.front;
//		
//		for(int i=0;i<size;i++){
//			System.out.print(temp.data+"->");
//			temp=temp.next;
//		}
//		System.out.println();
//		System.out.println(newQueue.front.data+" "+newQueue.rear.data);
		
//		StackUsingQueue stack=new StackUsingQueue();
//		
//		for(int i=0;i<size;i++){
//			int data=s.nextInt();
//			stack.push(data);
//		}
//		
//		Node<Integer> temp=stack.newQueue.front;
//		
//		for(int i=0;i<size;i++){
//			System.out.print(temp.data+"->");
//			temp=temp.next;
//		}
//		
//		System.out.println(stack.popOptimal());
		
		QueueUsingStack queue=new QueueUsingStack();
		int n=5;
		while(n>0){
			int data=s.nextInt();
			queue.Enqueue(data);
			n--;
		}
	   while(queue.stack.top!=-1){
		   System.out.println(queue.Dequeue());
	   }
	}

}
