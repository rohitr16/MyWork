package dataStructure;


public class BinarySearchTree {

	int size=0;
	int data;
	BinarySearchTree left;
	BinarySearchTree right;
	BinarySearchTree root=null;

	public BinarySearchTree insert(BinarySearchTree root,int data){

		BinarySearchTree newNode=new BinarySearchTree();
		newNode.data=data;

		if(root==null){
			root=newNode;
			size++;
			return root;
		}

		if(root.left==null&&root.data>data){
			root.left=newNode;
			size++;
			return root;
		}
		if(root.right==null&&root.data<data){
			root.right=newNode;
			size++;
			return root;
		}

		if(root.data>data)
			insert(root.left, data);

		if(root.data<data)
			insert(root.right, data);

		return root;
	}

	public BinarySearchTree FindLeftmost(BinarySearchTree root){

		if(root.left==null&&root.right==null){
			return root;
		}

		return FindLeftmost(root.left);

	}

	public BinarySearchTree remove(BinarySearchTree root,int data){

		if(root==null){
			return  null;
		}

		if(root.data==data&&root.left==null&&root.right==null){
			root=null;
			return  root;
		}
		if(root.data==data&&(root.left==null&&root.right!=null||root.left!=null&&root.right==null)){

			if(root.left!=null)
				root=root.left;

			else
				root=root.right;
			return root;
		}

		if(root.data==data&&root.left!=null&root.right!=null){

			BinarySearchTree temp=FindLeftmost(root.right);
			root.data=temp.data;

			root.right=remove(root.right, root.data);

			return root;
		}

		if(root.data>data)
			root.left=remove(root.left, data);
		else
			root.right=remove(root.right, data);

		return root;

	}

	public BinarySearchTree search(BinarySearchTree root,int data){

		if(root==null){
			return null;
		}

		if(root.data==data){
			return root;
		}

		if(root.data>data){
			return search(root.left, data);
		}

		return search(root.right, data);
	}

	public int size(){

		return size;
	}

	public boolean isEmpty(){

		if(root==null){
			return true;
		}

		return false;
	}

}
