package work;
import java.util.Scanner;

import dataStructure.Node;

public class LinkedListuSE {

	private static Scanner s;

	public static Node<Integer> makeList(int num){
		s=new Scanner(System.in);
		Node<Integer> newNode=new Node<Integer>();
		Node<Integer> head=null;
		Node<Integer> tail=null;
		int data=s.nextInt();
		newNode.data=data;
		if(head==null){
			head=newNode;
			tail=newNode;
		}
		for(int i=0;i<num-1;i++){
			data=s.nextInt();
			newNode=new Node<Integer>();
			newNode.data=data;
			tail.next=newNode;
			tail=tail.next;
		}

		return head;
	}

	public static Node<Integer> reverseList(Node<Integer> head){

		if(head.next==null||head==null){
			return head;
		}

		Node<Integer> tail=head.next;
		Node<Integer> newNode=reverseList(head.next);
		head.next=null;
		tail.next=head;

		return newNode;
	}

	public static Node<Integer> rearrangeList(Node<Integer> head,int listLength){

		if(head==null){
			return null;
		}

		Node<Integer> mid=head;
		int midLength=listLength/2;;

		for(int i=0;i<midLength-1;i++){
			mid=mid.next;
		}

		Node<Integer> headMid=reverseList(mid.next);
		mid.next=null;
		mid=headMid;

		Node<Integer> next=head.next;
		Node<Integer> current=head;
		Node<Integer> midNext=mid.next;

		int i=0;
		while(i<listLength/2){
			current.next=mid;
			if(next!=null)
				mid.next=next;
			else
				mid.next=midNext;
			mid=midNext;
			if(midNext!=null)
				midNext=midNext.next;
			current=next;
			if(next!=null)
				next=next.next;
			i++;
		}


		return head;
	}

	public static void main(String[] args) {
		// 1 2 3 4 5 6 7 8
		int num=9;
		Node<Integer> head=makeList(num);
		head=rearrangeList(head, num);

		Node<Integer> temp=head;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}



	}

}
