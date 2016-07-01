package work;

import java.util.Scanner;

import dataStructure.BinaryTree;
import dataStructure.QueueLL;
import dataStructure.StackLL;

public class inorderIterative {

	public static BinaryTree<Integer> takeInput(){

		Scanner s=new Scanner(System.in);

		System.out.println("ENTER THE ROOT DATA:");
		int data=s.nextInt();
		BinaryTree<Integer> root=new BinaryTree<Integer>(data);
		QueueLL<BinaryTree<Integer>> queue=new QueueLL<>();
		queue.Enqueue(root);
		while(queue.front!=null){

			BinaryTree<Integer> parent=queue.Dequeue();
			System.out.println("ENTER LEFT CHILD OF " +parent.data);
			int leftData=s.nextInt();
			if(leftData!=-1){
				BinaryTree<Integer> left=new BinaryTree<Integer>(leftData);
				parent.left=left;
				queue.Enqueue(parent.left);
			}
			System.out.println("ENTER RIGHT CHILD OF " +parent.data);
			int rightData=s.nextInt();
			if(rightData!=-1){
				BinaryTree<Integer> right=new BinaryTree<Integer>(rightData);
				parent.right=right;
				queue.Enqueue(parent.right);
			}	
		}	
		return root;
	}

	public static void inorder(BinaryTree<Integer> root){

		StackLL<BinaryTree<Integer>> stack=new StackLL<>();
		stack.push(root);
		BinaryTree<Integer> current =root;

		while(stack.top!=null){

			while(current!=null){
				current=current.left;
				if(current!=null)
					stack.push(current);
			}
			if(current==null){
				current=stack.pop();
				System.out.println(current.data);
				current=current.right;
				if(current!=null){
					stack.push(current);
				}
			}
		}

	}

	public static void morrisTraversal(BinaryTree<Integer> root){

		if(root==null){
			return ;
		}

		BinaryTree<Integer> current=root;

		while(current!=null){

			if(current.left==null){
				System.out.println(current.data);
				current=current.right;
			}
			else{
				BinaryTree<Integer> predessor=current.left;

				while(predessor.right!=null&&predessor.right!=current){
					predessor=predessor.right;
				}

				if(predessor.right==null){
					predessor.right=current;
					current=current.left;
				}
				else{
					predessor.right=null;
					System.out.println(current.data);
					current=current.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		//8 6 10 1 16 7 14 -1 -1 -1 -1 -1 -1 -1 -1
		//1 2 3 4 5 6 7 8 9 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 
		// 1 2 3 4 5 -1 -1 6 -1 -1 7 8 -1 -1 9 -1 -1 -1 -1
		//4 2 5 1 6 3 7 1 2 4 5 3 6 7
		//4 6 9 7 4 9 6 7
		BinaryTree<Integer> root=takeInput();
		inorder(root);
		System.out.println();
		morrisTraversal(root);

	}

}
