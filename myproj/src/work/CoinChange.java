package work;

public class CoinChange {
	
	public static int coinChange(int[] coins,int n){
		
		int[][] table=new int[n+1][coins.length];
		
			for(int j=0;j<table[0].length;j++){	
				table[0][j]=1;
			}
			
			for(int i=1;i<table.length;i++){
				for(int j=0;j<table[i].length;j++){
					
					int x=(i-coins[j]>=0)?table[i-coins[j]][j]:0;
					
					int y=(j>=1)?table[i][j-1]:0;
					
					table[i][j]=x+y;
				}
			}
			
		
		
		return table[n][coins.length-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] coins={2,3,5,6};
//		System.out.println(coinChange(coins, 10));
//		char[] ch=new char[2];
//		if(ch[0]=='\0'){
//			System.out.println("HO HA");
//		}
		AVLtree tree=new AVLtree();
		AVLTreeNode root=tree.insert(null, 9);
        root = tree.insert(root, 5);
        root = tree.insert(root, 10);
        root = tree.insert(root, 0);
        root = tree.insert(root, 6);
        root = tree.insert(root, 11);
        root = tree.insert(root, -1);
        root = tree.insert(root, 1);
        root = tree.insert(root, 2);
		
		tree.printTree(root);
		root=tree.delete(root, 10);
		tree.printTree(root);

	}

}
