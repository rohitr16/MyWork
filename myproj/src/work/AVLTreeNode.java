package work;

public class AVLTreeNode {
	
	public int  key;
	public int height;
	public AVLTreeNode left;
	public AVLTreeNode right;
	
	public AVLTreeNode(int key) {
		this.key=key;
		this.height=1;
	}

}
