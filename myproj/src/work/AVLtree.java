package work;

public class AVLtree {

	public AVLTreeNode root=null;



	public int getHeight(AVLTreeNode root){

		if(root==null){
			return 0;
		}
		return root.height;
	}

	public int getBalance(AVLTreeNode root){

		if(root==null){
			return 0;
		}

		return getHeight(root.left)-getHeight(root.right);
	}

	public AVLTreeNode rightRotate(AVLTreeNode y){

		AVLTreeNode x=y.left;
		AVLTreeNode T1=x.right;

		x.right=y;
		y.left=T1;

		y.height=Math.max(y.left.height,y.right.height)+1;
		x.height=Math.max(x.left.height, x.right.height)+1;

		return x;
	}

	public AVLTreeNode leftRotate(AVLTreeNode y){

		AVLTreeNode x=y.right;
		AVLTreeNode T1=x.left;

		x.left=y;
		y.right=T1;

		y.height=Math.max(getHeight(y.left),getHeight(y.right))+1;
		x.height=Math.max(getHeight(x.left),getHeight(x.right))+1;

		return x;
	}

	public AVLTreeNode insert(AVLTreeNode root,int key){

		if(root==null){
			AVLTreeNode newNode=new AVLTreeNode(key);
			root=newNode;
			return root;
		}

		if(key<root.key){
			root.left=insert(root.left, key);
		}
		else if(key>root.key){
			root.right=insert(root.right, key);
		}

		int balance=getBalance(root);

		root.height=Math.max(getHeight(root.left), getHeight(root.right))+1;

		if(balance>1 && key<root.left.key){
			//left left right rotate
			return rightRotate(root);
		}
		if(balance<-1 && key>root.right.key){
			//right right left rotate
			return leftRotate(root);
		}
		if(balance>1 && key>root.left.key){
			//left right 
			root.left=leftRotate(root.left);
			return rightRotate(root);

		}
		if(balance<-1 && key<root.right.key){
			//right left
			root.right=rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}

	public int minValueNode(AVLTreeNode root){

		AVLTreeNode current=root;

		while(current.left!=null){			
			current=current.left;
		}

		return current.key;		
	}

	//DELETE
	public AVLTreeNode delete(AVLTreeNode root,int key){

		if(root==null){
			return root;
		}

		if(key<root.key){
			root.left=delete(root.left, key);
		}
		else if(key>root.key){
			root.right=delete(root.right, key);
		}
		else{
			if(root.left==null && root.right==null){
				root=null;
			}
			else{
				if(root.left==null){
					root=root.right;
				}
				else if(root.right==null){
					root=root.left;
				}
				else{
					root.key=minValueNode(root.right);
					root.right=delete(root.right, root.key);
				}
			}				
		}

		if(root==null){
			return root;
		}
		int balance=getBalance(root);

		root.height=Math.max(getHeight(root.left), getHeight(root.right))+1;

		if(balance>1 && getBalance(root.left)>=0){
			return rightRotate(root);
		}

		if(balance<-1 && getBalance(root.right)<=0){
			return leftRotate(root);
		}

		if(balance>1 && getBalance(root.left)<0){
			root.left=leftRotate(root.left);
			return rightRotate(root);
		}

		if(balance<-1 && getBalance(root.right)>0){
			root.right=rightRotate(root.right);
			return leftRotate(root);
		}

		return root;		
	}

	public void printTree(AVLTreeNode root){

		if(root==null){
			return;
		}
		System.out.print(root.key+":");
		if(root.left!=null){
			System.out.print(root.left.key+",");
		}
		if(root.right!=null){
			System.out.print(root.right.key);
		}
		System.out.println();
		
		printTree(root.left);
		printTree(root.right);

	}
}
