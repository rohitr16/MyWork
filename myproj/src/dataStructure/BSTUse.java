package dataStructure;

import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicIconFactory;

import myproj.sum_pro;

public class BSTUse {

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

	public static  void printTree(BinaryTree<Integer> root){

		if(root==null){
			return;
		}

		String out=root.data+":";
		if(root.left!=null){
			out+=root.left.data+",";
		}
		if(root.right!=null){
			out+=root.right.data+"";
		}
		System.out.println(out);

		printTree(root.left);
		printTree(root.right);

	}

	public static  void printTree(BinarySearchTree root){

		if(root==null){
			return;
		}

		String out=root.data+":";
		if(root.left!=null){
			out+=root.left.data+",";
		}
		if(root.right!=null){
			out+=root.right.data+"";
		}
		System.out.println(out);

		printTree(root.left);
		printTree(root.right);

	}

	public static BinaryTree<Integer> FindNode(BinaryTree<Integer> root,int data){

		if(root==null){
			return null;
		}

		BinaryTree<Integer> out;
		if(root.data==data){
			return root;
		}

		if(data<root.data){
			out=FindNode(root.left, data);
		}
		else{
			out=FindNode(root.right, data);
		}

		return out;

	}

	public static void printRange(BinaryTree<Integer> root,int k1,int k2){

		if(root==null){
			return;
		}

		if(root.data>=k1&&root.data<=k2){
			System.out.print(root.data+" ");
		}

		if(root.data>k1&&root.data<k2){
			printRange(root.left, k1, k2);
			printRange(root.right, k1, k2);
		}
		else if(root.data>=k2){
			printRange(root.left, k1, k2);
		}
		else if(root.data<=k1){
			printRange(root.right, k1, k2);
		}	
	}

	public static BSTReturn checkBST(BinaryTree<Integer> root){

		if(root==null){
			BSTReturn out=new BSTReturn();
			out.checkBst=true;
			out.Max=Integer.MIN_VALUE;
			out.Min=Integer.MAX_VALUE;
			return out;
		}

		BSTReturn out=new BSTReturn();

		out.Max=Integer.MIN_VALUE;
		out.Min=Integer.MAX_VALUE;

		if(root.data>out.Max){
			out.Max=root.data;
		}

		if(root.data<out.Min){
			out.Min=root.data;
		}

		if(root.left==null&&root.right==null){
			out.checkBst=true;
			return out;
		}

		BSTReturn left=checkBST(root.left);
		BSTReturn right=checkBST(root.right);

		out.Max=Math.max(left.Max, right.Max);
		out.Min=Math.min(left.Min, right.Min);


		if(root.data>left.Max&&root.data<right.Min&&left.checkBst&&right.checkBst){
			out.checkBst=true;
		}
		else{
			out.checkBst=false;
		}
		return out;	
	}

	public static boolean checkBSTopt(BinaryTree<Integer> root,int start,int end){

		if(root==null){
			return true;
		}

		if(!(root.data>start&&root.data<end)){
			return false;
		}

		return checkBSTopt(root.left, start, root.data)&&checkBSTopt(root.right, root.data, end);	
	}

	public static Node<Integer> BST2sortLL(BinaryTree<Integer> root){

		if(root==null){
			return null;
		}

		Node<Integer> newNode=new Node<Integer>();

		Node<Integer> left=BST2sortLL(root.left);

		Node<Integer> temp=left;
		if(left!=null){
			while(temp.next!=null){
				temp=temp.next;
			}
		}

		newNode.data=root.data;
		if(left!=null)
			temp.next=newNode;

		Node<Integer> right=BST2sortLL(root.right);
		newNode.next=right;

		if(left!=null)
			return left;

		return newNode;

	}

	public static ArrayList<BinaryTree<Integer>> PathNode(BinaryTree<Integer> root,int data){

		if(root==null){
			return null;
		}

		ArrayList<BinaryTree<Integer>> out=new ArrayList<>();

		if(root.data==data){
			out.add(root);
			return out;
		}

		if(root.data>data){
			ArrayList<BinaryTree<Integer>> temp=PathNode(root.left, data);
			if(temp!=null){
				out.add(root);
				for(int i=0;i<temp.size();i++){
					out.add(temp.get(i));
				}
			}
			out=temp;
		}
		else if(root.data<data){		
			ArrayList<BinaryTree<Integer>> temp=PathNode(root.right, data);
			if(temp!=null){
				out.add(root);
				for(int i=0;i<temp.size();i++){
					out.add(temp.get(i));
				}
			}
			out=temp;
		}
		return out;
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

	public static BinarySearchTree InsertDup(BinarySearchTree root){

		if(root==null){
			return null;
		}

		BinarySearchTree newNode=new BinarySearchTree();
		newNode.data=root.data;
		newNode.left=root.left;
		root.left=newNode;

		newNode.left=InsertDup(newNode.left);
		root.right=InsertDup(root.right);

		return root;

	}

	public static ArrayList<BinarySearchTree> BST2array(BinarySearchTree root){

		if(root==null){
			ArrayList<BinarySearchTree> out=new ArrayList<>();
			return out;
		}

		ArrayList<BinarySearchTree> out=new ArrayList<>();

		ArrayList<BinarySearchTree> left=BST2array(root.left);

		for(int i=0;i<left.size();i++){
			out.add(left.get(i));
		}
		out.add(root);

		ArrayList<BinarySearchTree> right=BST2array(root.right);

		for(int i=0;i<right.size();i++){
			out.add(right.get(i));
		}
		return out;	
	}

	public static boolean searchSum(BinarySearchTree root,int sum){

		ArrayList<BinarySearchTree> out=new ArrayList<>();

		out=BST2array(root);

		for(int i=0,j=out.size()-1;i<out.size()&&j>=0&&i!=j;){

			if(sum==out.get(i).data+out.get(j).data){
				return true;
			}

			else if(sum>out.get(i).data+out.get(j).data){
				i++;
			}
			else if(sum<out.get(i).data+out.get(j).data){
				j--;
			}
		}
		return false;
	}

	public static boolean searchSumLogN(BinarySearchTree root,int sum){


		StackLL<BinarySearchTree> s1=new StackLL<>();
		StackLL<BinarySearchTree> s2=new StackLL<>();
		BinarySearchTree current1=root;
		BinarySearchTree current2=root;
		int val1=0;
		int val2=0;

		boolean flag1=true;
		boolean flag2=true;

		while(true){
			while(flag1==true){

				if(current1!=null){
					s1.push(current1);
					current1=current1.left;
				}
				else{
					if(s1.top==null){
						flag1=false;
					}
					else{
						current1=s1.pop();
						val1=current1.data;
						current1=current1.right;
						flag1=false;
					}
				}
			}

			while(flag2==true){

				if(current2!=null){
					s2.push(current2);
					current2=current2.right;
				}
				else{
					if(s2.top==null){
						flag2=false;
					}
					else{
						current2=s2.pop();
						val2=current2.data;
						current2=current2.left;
						flag2=false;
					}
				}
			}

			if(val1+val2==sum&&val1!=val2){
				System.out.println(val1+" "+val2);
				return true;
			}
			else if(val1+val2<sum){
				flag1=true;
			}
			else if(val1+val2>sum){
				flag2=true;
			}
			if(val1>=val2){
				return false;
			}
		}
	}

	public static BinarySearchTree LCA(BinarySearchTree root,int node_1,int node_2){

		if(root==null){
			return null;
		}

		if(root.data==node_1||root.data==node_2){
			return root;
		}

		if(root.data>node_1&&root.data>node_2){
			return LCA(root.left, node_1, node_2);
		}

		if(root.data<node_1&&root.data<node_2){
			return LCA(root.right, node_1, node_2);
		}

		return root;
	}

	public static BinarySearchTree buildBST(int[] input,int start,int end){

		if(start>end){
			return null;
		}

		int mid=(start+end)/2;

		BinarySearchTree root=new BinarySearchTree();
		root.data=input[mid];
		root.left=buildBST(input, start, mid-1);
		root.right=buildBST(input, mid+1, end);

		return root;
	}


	public static BinarySearchTreeReturn LargestBST(BinarySearchTree root){

		if(root==null){
			BinarySearchTreeReturn out=new BinarySearchTreeReturn();
			out.root=null;
			out.check=true;
			return out;
		}

		BinarySearchTreeReturn  out=new BinarySearchTreeReturn();

		BinarySearchTreeReturn left=LargestBST(root.left);
		BinarySearchTreeReturn right=LargestBST(root.right);

		if(root.data>left.max&&root.data<right.min&&left.check&&right.check){
			out.root=root;
			out.check=true;
		}
		else{
			out.check=false;
			if(left.root!=null&&right.root!=null){
				out.root=(left.depth>=right.depth)?left.root:right.root;
			}
			else if(left.root!=null){
				out.root=left.root;
			}
			else
				out.root=right.root;
		}

		out.max=Math.max(root.data, Math.max(left.max, right.max));
		out.min=Math.min(root.data, Math.min(left.min, right.min));
		out.depth=Math.max(left.depth, right.depth)+1;

		return out;	

	}

	public static int replaceSumGreater(BinarySearchTree root,int sumSoFar){

		if(root==null){
			return 0;
		}

		int sumRight=replaceSumGreater(root.right, sumSoFar);

		sumSoFar+=sumRight+root.data;
		int sum=sumRight+root.data;
		root.data=sumSoFar;

		int sumLeft=replaceSumGreater(root.left, sumSoFar);
		sum+=sumLeft;

		return sum;	

	}

	public static void main(String[] args) {

		//8 3 10 1 6 9 14 -1 -1 -1 -1 -1 -1 -1 -1
		//10 8 -1 -1 13 -1 -1

		//		BinaryTree<Integer> root=takeInput();
		//		printTree(root);

		//		System.out.println(FindNode(root, 11));

		//		printRange(root, 9, 11);

		//		System.out.println(checkBST(root).checkBst);

		//		System.out.println(checkBSTopt(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		//		ArrayList<BinaryTree<Integer>> out=PathNode(root, 11);
		//		if(out==null){
		//			System.out.println(out);
		//		}
		//
		//		else{
		//			for(int i=0;i<out.size();i++){
		//				System.out.print(out.get(i).data+"->");
		//			}
		//		}

		//		Node<Integer> head=BST2sortLL(root);
		//		printList(head);


		BinarySearchTree BST=new BinarySearchTree();
		BinarySearchTree rootbst=BST.insert(null, 8);
		BST.insert(rootbst, 10);
		BST.insert(rootbst, 3);
		BST.insert(rootbst, 14);
		BST.insert(rootbst, 1);
		BST.insert(rootbst, 6);
		BST.insert(rootbst, 9);
		//		BST.insert(rootbst, 11);
		//		BST.insert(rootbst, 15);

		//		System.out.println(BST.search(rootbst, 1).data);

		//		printTree(rootbst);

		//		rootbst=BST.remove(rootbst, 3);
		//		
		printTree(rootbst);

		//		rootbst=InsertDup(rootbst);

		//		printTree(rootbst);

		//		System.out.println(searchSum(rootbst, 21));
		//		
		//		System.out.println(LCA(rootbst, 10,9).data);
		//		
		//		int[] input={1,2,3,4,5,6};
		//		BinarySearchTree root=buildBST(input, 0, input.length-1);
		//		printTree(root);
		//		
		//		System.out.println(LargestBST(root).root.data);

//		replaceSumGreater(rootbst, 0);
//		printTree(rootbst);
		
		System.out.println(searchSumLogN(rootbst, 21));



	}

}
