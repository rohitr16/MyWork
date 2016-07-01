package dataStructure;

import java.util.Scanner;
import java.util.ArrayList;

public class TreeUse {

	private static Scanner s;


	public static TreeNode<Integer> takeInput(){
		s=new Scanner(System.in);
		System.out.println("Enter root data:");
		int data=s.nextInt();
		TreeNode<Integer> root=new TreeNode<Integer>(data);
		QueueLL<TreeNode<Integer>> newQueue=new QueueLL<TreeNode<Integer>>();
		newQueue.Enqueue(root);
		while(newQueue.front!=null){
			TreeNode<Integer> parent=newQueue.Dequeue();
			System.out.println("ENTER NO OF CHILD OF "+parent.data);
			int numChild=s.nextInt();
			for(int i=0;i<numChild;i++){
				System.out.println("ENTER THE "+i+" child of "+parent.data);
				data=s.nextInt();
				TreeNode<Integer> child=new TreeNode<Integer>(data);
				parent.children.add(child);
				newQueue.Enqueue(child);
			}

		}

		return root;

	}

	public static void printNode(TreeNode<Integer> root){

		if(root==null){
			return;
		}

		String printer=root.data+":";

		for(int i=0;i<root.children.size();i++){
			printer+=root.children.get(i).data+",";
		}
		System.out.println(printer);
		for(int i=0;i<root.children.size();i++){
			printNode(root.children.get(i));
		}	

	}

	public static void printNodeQ(TreeNode<Integer> root){

		QueueLL<TreeNode<Integer>> newQueue=new QueueLL<TreeNode<Integer>>();

		newQueue.Enqueue(root);	
		while(newQueue.rear!=null){
			TreeNode<Integer> parent=newQueue.Dequeue();
			String printer=parent.data+":";

			for(int i=0;i<parent.children.size();i++){
				newQueue.Enqueue(parent.children.get(i));
				printer+=parent.children.get(i).data+",";
			}
			System.out.println(printer);
		}
	}

	public static int numNodes(TreeNode<Integer> root){

		int sum=0;

		QueueLL<TreeNode<Integer>> newQueue=new QueueLL<TreeNode<Integer>>();
		newQueue.Enqueue(root);
		while(newQueue.rear!=null){
			TreeNode<Integer> parent=newQueue.Dequeue();
			sum++;
			for(int i=0;i<parent.children.size();i++){
				newQueue.Enqueue(parent.children.get(i));
			}
		}
		return sum;		
	}

	public static TreeNode<Integer> maxNode(TreeNode<Integer> root){

		int max=0;
		QueueLL<TreeNode<Integer>> newQueue=new QueueLL<TreeNode<Integer>>();
		TreeNode<Integer> node=null;
		newQueue.Enqueue(root);
		while(newQueue.rear!=null){
			TreeNode<Integer> parent=newQueue.Dequeue();
			if(max<parent.data){
				max=parent.data;
				node=parent;
			}
			for(int i=0;i<parent.children.size();i++){
				newQueue.Enqueue(parent.children.get(i));
			}
		}

		return node;	
	}

	public static int sumNode(TreeNode<Integer> root){

		int sum=0;

		QueueLL<TreeNode<Integer>> newQueue=new QueueLL<TreeNode<Integer>>();
		newQueue.Enqueue(root);
		while(newQueue.rear!=null){
			TreeNode<Integer> parent=newQueue.Dequeue();
			sum+=parent.data;
			for(int i=0;i<parent.children.size();i++){
				newQueue.Enqueue(parent.children.get(i));
			}
		}
		return sum;	

	}

	public static int sumNoderecur(TreeNode<Integer> root){

		if(root==null){
			return 0;
		}
		int sum=0;
		for(int i=0;i<root.children.size();i++){
			sum+=sumNoderecur(root.children.get(i));
		}	
		return root.data+sum;

	}


	public static ArrayList<Integer> greaterNode(TreeNode<Integer> root,int x){

		if(root==null){
			ArrayList<Integer> tempArr=new ArrayList<>();
			return tempArr;
		}

		ArrayList<Integer> out=new ArrayList<>();
		for(int i=0;i<root.children.size();i++){
			ArrayList<Integer> tempArr=greaterNode(root.children.get(i),x);
			for(int j=0;j<tempArr.size();j++){
				out.add(tempArr.get(j));
			}	
		}
		if(root.data>x){
			out.add(root.data);
		}
		return out;	
	}

	public static ArrayList<Integer> greaterNodeQ(TreeNode<Integer> root,int x){

		ArrayList<Integer> out=new ArrayList<>();

		QueueLL<TreeNode<Integer>> newQueue=new QueueLL<TreeNode<Integer>>();
		newQueue.Enqueue(root);
		while(newQueue.rear!=null){
			TreeNode<Integer> parent=newQueue.Dequeue();
			if(parent.data>x)
				out.add(parent.data);
			for(int i=0;i<parent.children.size();i++){
				newQueue.Enqueue(parent.children.get(i));
			}
		}
		return out;
	}

	public static TreeNode<Integer> sumMax(TreeNode<Integer> root){

		if(root==null){
			return null;
		}

		TreeNode<Integer> out=root;
		int sum=root.data;
		for(int i=0;i<root.children.size();i++){
			sum+=root.children.get(i).data;
		}
		for(int i=0;i<root.children.size();i++){
			TreeNode<Integer> temp=sumMax(root.children.get(i));
			int sumTemp=temp.data;
			for(int j=0;j<temp.children.size();j++){
				sumTemp+=temp.children.get(j).data;
			}
			if(sum<sumTemp){
				out=temp;
			}	
		}
		return out;
	}

	public static int MaxDepth(TreeNode<Integer> root){

		if(root==null){
			return 0;
		}

		int MaxDepth=0;
		for(int i=0;i<root.children.size();i++){
			int depth=MaxDepth(root.children.get(i));
			if(depth>MaxDepth){
				MaxDepth=depth+1;
			}
		}	
		return MaxDepth;
	}

	public static void  printDepthkNode(TreeNode<Integer> root,int k){

		if(k==0){
			System.out.print(root.data+" ");
			return;
		}

		for(int i=0;i<root.children.size();i++){
			printDepthkNode(root.children.get(i),k-1);
		}
	}	
	
	public static int sumAll(TreeNode<Integer> root){
		
		if(root==null){
			return 0;
		}
		
		int sum=0;
		sum+=root.data;
		for(int i=0;i<root.children.size();i++){
			int tempSum=sumAll(root.children.get(i));
			sum+=tempSum;
		}
		return sum;
	}
	
	public static boolean compTree(TreeNode<Integer> root_1,TreeNode<Integer> root_2){
		
		if(root_1==null||root_2==null){
			return false;
		}
		
		if(root_1.children.size()!=root_2.children.size()||root_1.data!=root_2.data){
			return false;
		}
		
		for(int i=0,j=0;i<root_1.children.size()&&j<root_2.children.size();i++,j++){
			boolean tempOut=compTree(root_1.children.get(i), root_2.children.get(j));
			if(!tempOut)
				return false;
		}	
		return true;
	}
	
	public static void data2Depth(TreeNode<Integer> root,int k){
		
		if(root==null){
			return ;
		}
		
		root.data=k;
		for(int i=0;i<root.children.size();i++){
			data2Depth(root.children.get(i), k+1);
		}
	}
	
	public static int numLeafNode(TreeNode<Integer> root){
		
		if(root==null){
			return 0;
		}
		int count=0;
		if(root.children.size()==0)
			count++;
		for(int i=0;i<root.children.size();i++){
			int tempCount=numLeafNode(root.children.get(i));		
			count+=tempCount;
			
		}
		
		return count;
	}
	
	public static TreeNode<Integer> nextLargerNode(TreeNode<Integer> root,int n){
		
		if(root==null){
			return null;
		}
		
		TreeNode<Integer> out=new TreeNode<Integer>(Integer.MAX_VALUE);
		if(root.data>n){
			out=root;
		}
		for(int i=0;i<root.children.size();i++){
			TreeNode<Integer> temp=nextLargerNode(root.children.get(i), n);		
			if(temp.data>n&&temp.data<out.data){
				out=temp;
			}
		}
		if(out.data==Integer.MAX_VALUE)
			out.data=0 ;
		return out;
	}
	
	public static TreeNode<Integer> secondMax(TreeNode<Integer> root){
		
		if(root==null){
			return null;
		}
		
		TreeNode<Integer> Max=new TreeNode<Integer>(0);
		TreeNode<Integer> secondMax=new TreeNode<Integer>(0);
		QueueLL<TreeNode<Integer>> newQueue=new QueueLL<TreeNode<Integer>>();
		newQueue.Enqueue(root);
		while(newQueue.rear!=null){
			TreeNode<Integer> parent=newQueue.Dequeue();
			if(parent.data>Max.data){
				secondMax=Max;
				Max=parent;
			}
			else if(parent.data>secondMax.data){
				secondMax=parent;
			}			
			for(int i=0;i<parent.children.size();i++){
				newQueue.Enqueue(parent.children.get(i));
			}
		}
		return secondMax;
	}
	
	public static TreeMax<Integer> secondMaxrecur(TreeNode<Integer> root){
		
		if(root==null){
			TreeMax<Integer> Node=new TreeMax<>(0);
			return Node;
		}
		
		TreeMax<Integer> Node=new TreeMax<>(0);
		if(root.data>Node.max.data){
			Node.secondMax=Node.max;
			Node.max=root;
		}
		else if(root.data>Node.secondMax.data){
			Node.secondMax=root;
		}
		for(int i=0;i<root.children.size();i++){
			TreeMax<Integer> tempNode=secondMaxrecur(root.children.get(i));
			
	      if(tempNode.max.data>Node.max.data){
	    	  Node.secondMax=Node.max;
				Node.max=tempNode.max;
			}
	      else{
	    	  Node.secondMax=tempNode.max;
	      }
	      if(tempNode.secondMax.data>Node.secondMax.data){
	    	  Node.secondMax=tempNode.secondMax;
	      }	
		}
		
		return Node;
		
		
	}
	
	public static void printPreorder(TreeNode<Integer> root){
		
		StackLL<TreeNode<Integer>> stack=new StackLL<TreeNode<Integer>>();
		stack.push(root);
		
		while(stack.top!=null){
			TreeNode<Integer> parent=stack.pop();
			System.out.println(parent.data);
			for(int i=parent.children.size()-1;i>=0;i--){
				stack.push(parent.children.get(i));
			}
		}
	}

	public static void main(String[] args) {
		
		//1 2 2 3 2 4 5 2 6 7 1 8 0 0 0 0
		//1 2 2 3 0 1 4 0
//		TreeNode<Integer> root_1=takeInput();
//		TreeNode<Integer> root_2=takeInput();
//		System.out.println(compTree(root_1, root_2));
		TreeNode<Integer> root=takeInput();
//		printNodeQ(root);
		
//		System.out.println(numNodes(root));
		
//		System.out.println(maxNode(root).data);
		
//		System.out.println(sumNoderecur(root));
		
//		ArrayList<Integer> out=greaterNode(root, 3);
//		for(int i=0;i<out.size();i++){
//			System.out.print(out.get(i)+" ");
//		}
//		System.out.println();
//		TreeNode<Integer> temp=sumMax(root);
		
//		System.out.println(temp.data);
		
//		System.out.println(MaxDepth(root));
		
//		printDepthkNode(root, 2);
		
//		System.out.println();
//		System.out.println(sumAll(root));
		
//		printNodeQ(root);
//		data2Depth(root, 0);
//		printNodeQ(root);
		
//		System.out.println(numLeafNode(root));
		
//		System.out.println(nextLargerNode(root, 9).data);
		
		System.out.println(secondMax(root).data);
		
//		System.out.println(secondMaxrecur(root).secondMax.data);
		
//		printPreorder(root);

	}

}
