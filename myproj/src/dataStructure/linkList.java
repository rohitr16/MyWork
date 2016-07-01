package dataStructure;

import java.util.Scanner;
public class linkList {
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
	
	public static Node<Integer> delList(Node<Integer> head,int k){
		if(head==null)
			return head;
		Node<Integer> temp=head;
		if(head.next==null){
			return null;
		}
		if(k==1){
			head=head.next;
		}
		else{
			while(k!=2){
				k--;
				temp=temp.next;	
			}
			temp.next=temp.next.next;
		}
		
		return head;
	}
	
	public static Node<Integer> insertList(Node<Integer> head,int k){
		
		Node<Integer> newNode=new Node<Integer>();
		int data=s.nextInt();
		newNode.data=data;
		
		if(head==null){
			head=newNode;
		}
		
		if(k==1){
			newNode.next=head;
			head=newNode;
			return head;
		}
		
		Node<Integer> tmp=head;
		while(k!=2){
			tmp=tmp.next;
			k--;
		}
		
		if(tmp.next==null){
			tmp.next=newNode;
			return head;
		}
		newNode.next=tmp.next;
		tmp.next=newNode;
		
		return head;
		
	}
	
	public static Node<Integer> revList(Node<Integer> head){
		
		Node<Integer> prev=null;
		Node<Integer> next=head.next;
		
		if(head.next==null){
			return head;
		}
		
		while(head!=null){
			next=head.next;
			head.next=prev;
			prev=head;
			head=next;
		}
		head=prev;
		
		return head;
	}
	
	public static Node<Integer> revLsitRecur(Node<Integer> current ,Node<Integer> prev,Node<Integer> next){
		
		if(current.next==null){
			current.next=prev;
			return current;
		}
		
		current.next=prev;
		return revLsitRecur(next, current, next.next);	
	}
	
	public static void printRev(Node<Integer> head){
		
		if(head.next==null){
			System.out.print(head.data+"->");
			return;
		}
		
		printRev(head.next);
		System.out.print(head.data+"->");
		
		
	}
	
	public static Node<Integer> makeListRecur(Node<Integer> head,int k){
		
		if(k==1){
			int data=s.nextInt();
			Node<Integer> newNode=new Node<Integer>();
			newNode.data=data;
			newNode.next=head;
			return newNode;
		}			
		head.next= makeListRecur(head.next,k-1);
		return head;
	}
	
	public static Node<Integer> delListRecur(Node<Integer> head,int k){
		
		if(k==1){
			return head.next;
		}
		head.next=delListRecur(head.next, k-1);
		return head;
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
	
	public static Node<Integer> findNode(Node<Integer> head,int data){
		
		if(head==null){
			return null;
		}
		
		if(head.data==data){
			return head;
		}
		
		return findNode(head.next,data);
		
	}
	

	public static Node<Integer> bubbleSort(Node<Integer> head){
		
		Node<Integer> prev=head;
		Node<Integer> current=head;
		
		int length=listLength(head);
		
		for(int i=0;i<length-1;i++){
			
			prev=head;
			current=head;
			
			for(int j=0;j<length-i-1;j++){
				
				if(current==head&&current.data>current.next.data){
					prev=current.next;
					current.next=current.next.next;
					prev.next=current;
					head=prev;
					current=head;
				}
				if(current.data>current.next.data){
					prev.next=current.next;
					current.next=current.next.next;
					prev.next.next=current;
					current=prev.next;
				}
				
				if(current==head){
				current=current.next;
				}
				else{
					current=current.next;
					prev=prev.next;
				}
			}
		}
		
		return head;
		
	}
	
	public static Node<Integer> remDup(Node <Integer> head){
		
		Node<Integer> current=head;
		Node<Integer> next=head.next;
		
		
		while(current.next!=null){
			
			while(next!=null&&current.data==next.data){
				next=next.next;
			}
			current.next=next;
			if(current.next!=null){
			current=current.next;
			next=current.next;
			}
		}
		
		return head;
	}
	
	public static Node<Integer>  mergeLL(Node<Integer> head_1,Node<Integer> head_2){
		
		Node<Integer> head=(head_1.data>head_2.data)?head_2:head_1;
		if(head_1.data<head_2.data){
			head_1=head_1.next;
		}
		else if(head_1.data>head_2.data){
			head_2=head_2.next;
		}
		else{
			head_1=head_1.next;
			head_2=head_2.next;
		}
		Node<Integer> temp=head;
		
		while(head_1!=null&&head_2!=null){
			
			if(head_1.data<head_2.data){
				temp.next=head_1;
				temp=temp.next;
				head_1=head_1.next;
			}
			else if(head_1.data>head_2.data){
				temp.next=head_2;
				temp=temp.next;
				head_2=head_2.next;
			}
			else if(head_1.data==head_2.data){
				temp.next=head_1;
				temp=temp.next;
				head_1=head_1.next;
				head_2=head_2.next;	
			}
			
		}
		while(head_1!=null){
			temp.next=head_1;
			temp=temp.next;
			head_1=head_1.next;
		}
		while(head_2!=null){
			temp.next=head_2;
			temp=temp.next;
			head_2=head_2.next;
		}
		
		return head;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		s=new Scanner(System.in);
		int num=s.nextInt();
		int num2=s.nextInt();
		Node<Integer> head_1=makeList(num);
		Node<Integer> head_2=makeList(num2);
		printList(head_1);
		System.out.println();
		printList(head_2);
//		Node<Integer> head=makeList(num);
//		printList(head);
		
//		System.out.println();
//		printRev(head);
		
//		System.out.println();
//		delList(head, 3);
		
//		System.out.println();
//		printList(head);
		
//		System.out.println();
//		int length=listLength(head);
//		System.out.println(length);
		
//		head=insertList(head, 6);
//		printList(head);
		
//		head=revList(head);
		
//		head=revLsitRecur(head, null, head.next);
//		printList(head);
		
//		head=makeListRecur(head, 6);
//		printList(head);
		
//		System.out.println();
//		head=delListRecur(head, 1);
//		printList(head);
		
//		head=findMid(head);
//		System.out.println(head.data+"->");
		
//		head=findNode(head, 3);
//		if(head!=null)
//			System.out.println(head.data+"->");
//		else
//			System.out.println("NOT FOUNT");
		
//		head=bubbleSort(head);
//		printList(head);
		
//		head=remDup(head);
//		printList(head);
		
		System.out.println();
		Node<Integer> head=mergeLL(head_1,head_2);
		printList(head);
		
	}

}
