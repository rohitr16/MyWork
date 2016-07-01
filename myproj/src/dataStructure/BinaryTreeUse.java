package dataStructure;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicIconFactory;

public class BinaryTreeUse {

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

	public static int TreeHeight(BinaryTree<Integer> root){

		if(root==null){
			return 0;
		}

		int height=0;

		int tempL=TreeHeight(root.left);
		int tempR=TreeHeight(root.right);

		if(tempL>tempR){
			height=tempL+1;
		}
		else{
			height=tempR+1;
		}	

		return height;	
	}

	public static BinaryTree<Integer> FindNode(BinaryTree<Integer> root,int data){

		if(root==null){
			return null;
		}

		if(root.data==data){
			return root;
		}

		if(FindNode(root.left, data)!=null){
			return FindNode(root.left, data);
		}
		if(FindNode(root.right, data)!=null){
			return FindNode(root.right, data);
		}	
		return null;
	}

	public static BinaryTree<Integer> FindMirror(BinaryTree<Integer> root){

		if(root==null){
			return null;
		}

		FindMirror(root.left);
		FindMirror(root.right);

		BinaryTree<Integer> temp=root.left;
		root.left=root.right;
		root.right=temp;

		return root;
	}

	public static BinaryTreeReturn FindDiameter(BinaryTree<Integer> root){

		if(root==null){
			BinaryTreeReturn out=new BinaryTreeReturn();
			out.height=0;
			out.diameter=0;
			return out;
		}

		BinaryTreeReturn out=new BinaryTreeReturn();
		BinaryTreeReturn leftD=FindDiameter(root.left);
		BinaryTreeReturn rightD=FindDiameter(root.right);

		out.diameter=Math.max(leftD.height+rightD.height+1, Math.max(leftD.diameter,rightD.diameter));
		out.height=Math.max(leftD.height, rightD.height)+1;	

		return out;

	}

	public static BinaryTree<Integer> constructTree(int[] inorder,int[] preorder){

		if(preorder.length==0){
			return null;
		}

		int data=preorder[0];
		BinaryTree<Integer> root=new BinaryTree<Integer>(data);

		int i=0;
		for(i=0;i<inorder.length;i++){
			if(inorder[i]==data){
				break;
			}
		}

		int[] leftInorder=new int[i];
		int[] rightInorder;
		int size=0;
		if(inorder.length-i-1>0){
			size=inorder.length-i-1;
		}
		rightInorder=new int[size];


		for(int j=0;j<i;j++){
			leftInorder[j]=inorder[j];
		}
		for(int j=0;j<rightInorder.length;j++){
			rightInorder[j]=inorder[j+i+1];
		}

		int[] preorderLeft=new int[leftInorder.length];
		int[] preorderRight=new int[rightInorder.length];
		for(int j=0;j<preorderLeft.length;j++){
			preorderLeft[j]=preorder[j+1];
		}
		for(int j=0;j<preorderRight.length;j++){
			preorderRight[j]=preorder[j+preorderLeft.length+1];
		}	

		root.left=constructTree(leftInorder, preorderLeft);

		root.right=constructTree(rightInorder, preorderRight);

		return root;
	}

	public static int sumTree(BinaryTree<Integer> root){

		if(root==null){
			return 0;
		}

		int sum=root.data;;

		int leftSum=sumTree(root.left);
		int rightSum=sumTree(root.right);

		sum+=leftSum+rightSum;

		return sum;

	}

	public static boolean compTree(BinaryTree<Integer> root_1,BinaryTree<Integer> root_2){

		if(root_1==null&&root_2==null){
			return true;
		}
		if(root_1==null||root_2==null){
			return false;
		}


		if(root_1.data!=root_2.data){
			return false;
		}
		if(root_1.left==null&&root_2.left!=null||root_1.left!=null&&root_2.left==null){
			return false;
		}
		if(root_1.right==null&&root_2.right!=null||root_1.right!=null&&root_2.right==null){
			return false;
		}

		if(!compTree(root_1.left, root_2.left)||!compTree(root_1.right, root_2.right)){
			return false;
		}

		return true;

	}

	public static BalancedTreeeReturn checkBalancedTree(BinaryTree<Integer> root){

		if(root==null){
			BalancedTreeeReturn out=new BalancedTreeeReturn();
			out.checkBalanced=true;
			out.height=0;
			return out;
		}

		BalancedTreeeReturn out=new BalancedTreeeReturn();

		BalancedTreeeReturn leftH=checkBalancedTree(root.left);
		BalancedTreeeReturn rightH=checkBalancedTree(root.right);

		out.height=Math.max(leftH.height, rightH.height)+1;

		if(leftH.checkBalanced&&rightH.checkBalanced&&(Math.abs(leftH.height-rightH.height)<=1)){
			out.checkBalanced=true;
		}
		else{
			out.checkBalanced=false;
		}

		return out;
	}

	@SuppressWarnings("unchecked")
	public static Node<BinaryTree<Integer>>[] AdjacencyList(BinaryTree<Integer> root){

		if(root==null){
			Node<BinaryTree<Integer>> out[]=new Node[0];
			return out;
		}

		Node<BinaryTree<Integer>>[] left=AdjacencyList(root.left);
		Node<BinaryTree<Integer>>[] right=AdjacencyList(root.right);

		int size=Math.max(left.length, right.length);
		Node<BinaryTree<Integer>>[] out=new Node[size+1];
		Node<BinaryTree<Integer>> newNode=new Node<>();
		newNode.data=root;
		out[0]=newNode;
		for(int i=0;i<out.length-1;i++){
			if(i<left.length){
				Node<BinaryTree<Integer>> temp=left[i];
				while(temp.next!=null){
					temp=temp.next;
				}
				if(i<right.length){
					temp.next=right[i];
				}
				out[i+1]=left[i];
			}
			else{
				out[i+1]=right[i];
			}
		}

		return out;

	}

	public static void NoSiblingNode(BinaryTree<Integer> root){

		if(root==null){
			return;
		}

		if(root.left==null&&root.right!=null){
			System.out.println(root.right.data);
		}
		if(root.left!=null&&root.right==null){
			System.out.println(root.left.data);
		}

		NoSiblingNode(root.left);
		NoSiblingNode(root.right);
	}

	public static boolean removeLeafNodes(BinaryTree<Integer> root){

		if(root==null){
			return false;
		}

		boolean left=removeLeafNodes(root.left);
		boolean right=removeLeafNodes(root.right);

		if(root.left==null&&root.right==null){
			return true;
		}

		if(left){
			root.left=null;
		}
		if(right){
			root.right=null;
		}

		return false;

	}

	public static void printLevel(BinaryTree<Integer> root){

		QueueLL<BinaryTree<Integer>> queue=new QueueLL<>();
		queue.Enqueue(root);
		int numDecendents=1;

		while(queue.front!=null){

			int printLength=numDecendents;
			numDecendents=0;

			for(int i=0;i<printLength;i++){
				BinaryTree<Integer> parent=queue.Dequeue();
				System.out.print(parent.data+" ");
				if(parent.left!=null){
					queue.Enqueue(parent.left);
					numDecendents++;
				}
				if(parent.right!=null){
					queue.Enqueue(parent.right);
					numDecendents++;
				}
			}	
			System.out.println();
		}	
	}

	public static  void reverseQueue(QueueLL<BinaryTree<Integer>> newQueue){

		if(newQueue.front==newQueue.rear){
			return ;
		}

		BinaryTree<Integer> data=newQueue.Dequeue();
		reverseQueue(newQueue);
		newQueue.Enqueue(data);    

	}

	public static void printZigzagLevel(BinaryTree<Integer> root){

		QueueLL<BinaryTree<Integer>> queue=new QueueLL<>();
		queue.Enqueue(root);
		int numDecendents=1;
		int Level=1;

		while(queue.front!=null){

			int printLength=numDecendents;
			numDecendents=0;

			reverseQueue(queue);

			for(int i=0;i<printLength;i++){
				BinaryTree<Integer> parent=queue.Dequeue();
				System.out.print(parent.data+" ");
				if(Level%2!=0){
					if(parent.left!=null){
						queue.Enqueue(parent.left);
						numDecendents++;
					}
					if(parent.right!=null){
						queue.Enqueue(parent.right);
						numDecendents++;
					}
				}
				else{
					if(parent.right!=null){
						queue.Enqueue(parent.right);
						numDecendents++;
					}
					if(parent.left!=null){
						queue.Enqueue(parent.left);
						numDecendents++;
					}			
				}
			}
			Level++;
			System.out.println();
		}

	}

	public static void printZigZagStack(BinaryTree<Integer> root){

		StackLL<BinaryTree<Integer>> stack_L=new StackLL<>();
		StackLL<BinaryTree<Integer>> stack_R=new StackLL<>();

		stack_L.push(root);;

		while(stack_L.top!=null||stack_R.top!=null){

			if(stack_L.top!=null){
				while(stack_L.top!=null){
					BinaryTree<Integer> parent=stack_L.pop();
					System.out.print(parent.data+" ");
					if(parent.left!=null)
						stack_R.push(parent.left);
					if(parent.right!=null)
						stack_R.push(parent.right);
				}
			}
			else{
				while(stack_R.top!=null){
					BinaryTree<Integer> parent =stack_R.pop();
					System.out.print(parent.data+" ");
					if(parent.right!=null)
						stack_L.push(parent.right);
					if(parent.left!=null)
						stack_L.push(parent.left);
				}
			}
			System.out.println();
		}
	}

	public static void prettyPrint(BinaryTree<Integer> root){

		int line=TreeHeight(root)+1;

		QueueLL<BinaryTree<Integer>> queue=new QueueLL<>();
		QueueLL<BinaryTree<Integer>> queueChild=new QueueLL<>();

		queue.Enqueue(root);
		queueChild.Enqueue(root);
		int numDecendents=1;

		while(queue.front!=null){

			for(int i=0;i<line;i++){
				System.out.print(" ");
			}
			line--;
			int printLength=numDecendents;
			numDecendents=0;

			for(int i=0;i<printLength;i++){
				BinaryTree<Integer> parent=queue.Dequeue();
				System.out.print(parent.data+"   ");
				if(parent.left!=null){
					queue.Enqueue(parent.left);
					numDecendents++;
				}
				if(parent.right!=null){
					queue.Enqueue(parent.right);
					numDecendents++;
				}
			}

			System.out.println();
			for(int i=0;i<line;i++){
				System.out.print(" ");
			}
			line--;
			for(int i=0;i<printLength;i++){
				BinaryTree<Integer> parent=queueChild.Dequeue();
				if(parent.left!=null){
					System.out.print("/ ");
					queueChild.Enqueue(parent.left);

				}
				if(parent.right!=null){
					System.out.print("\\ ");
					queueChild.Enqueue(parent.right);
				}
			}
			System.out.println();

		}	
	}

	public static BinaryTree<Integer> LCA(BinaryTree<Integer> root,int node_1,int node_2){

		if(root==null){
			return null;
		}

		if(root.data==node_1||root.data==node_2){
			return root;
		}

		BinaryTree<Integer> left=LCA(root.left, node_1, node_2);
		BinaryTree<Integer> right=LCA(root.right, node_1, node_2);

		if(left!=null&&right!=null){
			return root;
		}

		if(left!=null){
			return left;
		}

		return right;

	}

	public static int printKdistance(BinaryTree<Integer> root,BinaryTree<Integer> node,int k){

		if(root==null){
			return -1;
		}

		if(root.data==node.data){

			printDepthK(root.left, k-1);
			printDepthK(root.right, k-1);
			return 0;
		}

		int left=printKdistance(root.left, node, k);

		if(left!=-1){

			if(left+1==k){
				System.out.println(root.data);
			}
			else{	
				printDepthK(root.right, k-left-2);
			}
			return left+1;
		}

		int right=printKdistance(root.right, node, k);

		if(right!=-1){

			if(right+1==k){
				System.out.println(root.data);
			}

			else{
				printDepthK(root.left, k-right-2);
			}
			return right+1;
		}
		return -1;

	}


	public static void printDepthK(BinaryTree<Integer> root,int k){

		if(root==null||k<0){
			return;
		}

		if(k==0){
			System.out.println(root.data);
		}
		printDepthK(root.left, k-1);
		printDepthK(root.right, k-1);
	}

	public static int replaceWithSumRight(BinaryTree<Integer> root){

		if(root==null){
			return 0;
		}

		int sum=replaceWithSumRight(root.right);

		int temp=root.data;
		if(sum!=0)
			root.data=sum;

		sum+=temp;
		sum+=replaceWithSumRight(root.left);

		return sum;
	}

	public static ArrayList<ArrayList<BinaryTree<Integer>>> pathSumk(BinaryTree<Integer> root,int k){

		if(root==null){
			ArrayList<ArrayList<BinaryTree<Integer>>> out=new ArrayList<>();
			return out;
		}

		ArrayList<ArrayList<BinaryTree<Integer>>> out=new ArrayList<>();

		k=k-root.data;
		ArrayList<ArrayList<BinaryTree<Integer>>> left=pathSumk(root.left, k);
		ArrayList<ArrayList<BinaryTree<Integer>>> right=pathSumk(root.right,k);

		if(root.left==null&&root.right==null&&k==0){
			ArrayList<BinaryTree<Integer>> temp=new ArrayList<>();
			temp.add(root);
			out.add(temp);
		}

		for(int i=0;i<left.size();i++){
			out.add(left.get(i));
		}
		for(int i=0;i<right.size();i++){
			out.add(right.get(i));
		}
		if(left.size()!=0||right.size()!=0){
			for(int j=0;j<out.size();j++){
				out.get(j).add(root);
			}
		}
		return out;

	}

	public static void printBoundaryNodes(BinaryTree<Integer> root){

		QueueLL<BinaryTree<Integer>> queue=new QueueLL<>();
		queue.Enqueue(root);
		queue.Enqueue(null);
		System.out.println(root.data);
		while(!queue.isEmpty()){

			BinaryTree<Integer> parent=queue.Dequeue();
			if(parent==null){
				if(queue.front!=null)
				System.out.println(queue.front.data.data);
				queue.Enqueue(null);
			}
			if(parent!=null){
				if(parent.left!=null)
					queue.Enqueue(parent.left);
				if(parent.right!=null)
					queue.Enqueue(parent.right);
			}

		}

	}
	

	public static void main(String[] args) {

		//1 2 3 4 5 6 7 -1 -1 8 9 -1 -1 -1 -1 -1 -1 -1 -1
		//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		//8 3 10 1 6 9 14 -1 -1 -1 -1 -1 -1 -1 -1
		//1 2 3 4 5 6 7 8 9 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 
		// 1 2 3 4 5 -1 -1 6 -1 -1 7 8 -1 -1 9 -1 -1 -1 -1
		//4 2 5 1 6 3 7 1 2 4 5 3 6 7
		//4 6 9 7 4 9 6 7
		Scanner s=new Scanner(System.in);
		BinaryTree<Integer> root=takeInput();
		printTree(root);

		//		BinaryTree<Integer> root_1=takeInput();
		//		BinaryTree<Integer> root_2=takeInput();

		//		System.out.println(TreeHeight(root));
		//		
		//		System.out.println(FindNode(root, 9));
		//		
		//		root=FindMirror(root);
		//		printTree(root);

		//		System.out.println(FindDiameter(root).diameter);

		//		System.out.println("ENTER SIZE OF ARRAY:");
		//		int size=s.nextInt();
		//		int inorder[]=new int[size];
		//		int preorder[]=new int[size];
		//		for(int i=0;i<inorder.length;i++){
		//			inorder[i]=s.nextInt();
		//		}
		//		for(int i=0;i<preorder.length;i++){
		//			preorder[i]=s.nextInt();
		//		}
		//		BinaryTree<Integer> root=constructTree(inorder, preorder);
		//		printTree(root);

		//		System.out.println(sumTree(root));
		//		System.out.println(compTree(root_1, root_2));

		//		System.out.println(checkBalancedTree(root).checkBalanced);

		//		Node<BinaryTree<Integer>>[] out=AdjacencyList(root);
		//		for(int i=0;i<out.length;i++){
		//			Node<BinaryTree<Integer>> head=out[i];
		//
		//			while(head!=null){
		//				System.out.print(head.data.data+"->");
		//				head=head.next;
		//			}
		//			System.out.println();
		//		}

		//		NoSiblingNode(root);

		//		removeLeafNodes(root);
		//		printTree(root);

		//		printLevel(root);

		//		printZigzagLevel(root);

		//		printZigZagStack(root);

		//		prettyPrint(root);

		//		System.out.println(LCA(root, 5, 4).data);

		//		BinaryTree<Integer> node=new BinaryTree<Integer>(4); 

		//		printKdistance(root, node, 2);

		//		replaceWithSumGreater(root);

		//		printTree(root);

//		ArrayList<ArrayList<BinaryTree<Integer>>> out=pathSumk(root, 7);
//
//		for(int i=0;i<out.size();i++){
//			for(int j=0;j<out.get(i).size();j++){
//				System.out.print(out.get(i).get(j).data+"->");
//			}
//			System.out.println();
//		}
		
		printBoundaryNodes(root);


	}

}
