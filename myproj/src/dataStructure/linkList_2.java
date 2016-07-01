package dataStructure;

import java.util.Scanner;

public class linkList_2 {

	private static Scanner s;

	public static Node<Integer> makeList(int num){
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

	public static void printList(Node<Integer> head){

		if(head==null){
			return;
		}

		Node<Integer> tmp=head;

		while(tmp!=null){
			System.out.print(tmp.data+"->");
			tmp=tmp.next;
		}

	}

	public static int listLength(Node<Integer> head){
		int length=0;

		Node<Integer> tmp=head;

		while(tmp!=null){
			tmp=tmp.next;
			length++;
		}

		return length;

	}

	public static Node<Integer> findMid(Node<Integer> head){

		Node<Integer> slow=head;
		Node<Integer> fast=head.next;
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}

		return slow;

	}

	public static Node<Integer> revLsitRecur(Node<Integer> current ,Node<Integer> prev,Node<Integer> next,Node<Integer> mid){

		if(current.next==mid){
			current.next=prev;
			return current;
		}

		current.next=prev;
		return revLsitRecur(next, current, next.next,mid);	
	}

	public static Node<Integer> rotateList(Node<Integer> head,int k){

		int length=listLength(head);
		Node<Integer> last=head;
		Node<Integer> next=head;

		for(int i=0;i<length-k-1;i++){
			last=last.next;
		}
		while(next.next!=null){
			next=next.next;
		}

		next.next=head;
		head=last.next;
		last.next=null;		

		return head;
	}

	public static boolean palinList(Node<Integer> head){

		if(listLength(head)==1)
			return true;

		Node<Integer> last=head;
		Node<Integer> first=head;
		Node<Integer> mid=head;
		mid=findMid(head);
		last=mid.next;
		if(listLength(head)%2==0){
			mid=mid.next;
			last=mid;
		}

		head=revLsitRecur(head, mid, head.next,mid);

		first=head;

		while(first!=mid){
			if(first.data!=last.data)
				return false;
			last=last.next;
			first=first.next;
		}

		return true;
	}

	public static Node<Integer> swap(Node<Integer> head,Node<Integer> first,Node<Integer> second){

		if(first==second)
			return head;

		Node<Integer> prevFirst=null;
		Node<Integer> prevSecond=null;
		Node<Integer> temp=head;

		while(temp!=first){
			prevFirst=temp;
			temp=temp.next;
		}

		while(temp!=second){
			prevSecond=temp;
			temp=temp.next;
		}
		if(prevFirst!=null)
			prevFirst.next=second;
		temp=second.next;
		second.next=first.next;
		prevSecond.next=first;
		first.next=temp;

		if(head==first){
			head=second;
		}	

		return head;
	}

	public static Node<Integer> sepOddEven(Node<Integer> head){

		Node<Integer> last=head;
		Node<Integer> current=head;
		Node<Integer> prev=null;
		int i=1;
		int countOdd=0;

		while(last.next!=null){
			if(last.data%2!=0){
				countOdd++;
			}
			last=last.next;
		}
		if(last.data%2!=0)
			countOdd++;

		if(countOdd==0){
			return head;
		}

		while(i<=(listLength(head)-countOdd))
		{
			if(current.data%2==0){
				if(current==head){
					head=head.next;
					last.next=current;
					current.next=null;
					last=current;
					current=head;
				}
				else{
					prev.next=current.next;
					last.next=current;
					current.next=null;
					last=current;
					current=prev;
				}
				i++;
			}
			if(current.data%2!=0){
				prev=current;
				current=current.next;
			}
		}
		return head;
	}

	public static Node<Integer> revRecur(Node<Integer> head,Node<Integer> stop){

		if(head==null||head.next==stop){
			return head;
		}

		Node<Integer> tail=head.next;
		Node<Integer> newHead=revRecur(head.next,stop);
		tail.next=head;
		head.next=null;

		return newHead;
	}

	public static Node<Integer> kReverse(Node<Integer> head,int k){
		//7 3 4 5 2 6 1 9
		Node<Integer> last=head;
		Node<Integer> temp=null;
		Node<Integer> prevLast=null; 
		boolean flag=true;
		while(last!=null){
			int i=k;
			temp=last;
			while(i>0&&last!=null){
				last=last.next;
				i--;
			}
			if(flag){	
				head=revRecur(temp,last);
				flag=false;
			}
			if(prevLast!=null)
				prevLast.next=revRecur(temp, last);

			temp.next=last;
			prevLast=temp;

		}

		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		int num=s.nextInt();
		Node<Integer> head=makeList(num);
		printList(head);
		System.out.println();

		//		head=rotateList(head, 5);
		//		printList(head);

		//		System.out.println(palinList(head));

		//	    head=swap(head, head, head.next.next.next.next);

		//		head=sepOddEven(head);
		//		printList(head);

		head=kReverse(head, 3);
		printList(head);
	}

}
