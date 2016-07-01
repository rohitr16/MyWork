package dataStructure;

public class TreeMax<T> {
	
	
	TreeNode<T> max;
	TreeNode<T> secondMax;
	
	public TreeMax(T data){
		max=new TreeNode<T>(data);
		secondMax=new TreeNode<T>(data);
	}
	

}
