package myproj;

public class N_queen {

	public static void printArr(int[][] bool){

		for(int i=0;i<bool.length;i++){
			for (int j=0;j<bool[i].length;j++){
				System.out.print(bool[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static boolean isSafe(int[][] bool,int row ,int col){

		for(int i=0;i<col;i++){
			if(bool[row][i]==1)
				return false;
		}
		for(int i=col+1;i<bool.length;i++){
			if(bool[row][i]==1)
				return false;
		}
		for(int i=row,j=col;i>=0&&j>=0;i--,j--){
			if(bool[i][j]==1)
				return false;
		}
		for(int i=row,j=col;i<bool.length&&j>=0;i++,j--){
			if(bool[i][j]==1)
				return false;
		}

		return true;

	}

	public static boolean solveprob(int[][] bool,int col){

		if(col>=bool.length)
			return true;		

		for(int i=0;i<bool.length;i++){		

			if(isSafe(bool,i,col)){
				
				bool[i][col]=1;

				if(solveprob(bool, col+1)){
					return true;
				}
				bool[i][col]=0;
			}	
		}

		return false;
	}

	public static void solve(){
		int[][] bool=new int[8][8];
		for(int i=0;i<bool.length;i++){
			for (int j=0;j<bool[i].length;j++){
				bool[i][j]=0;
			}
		}
		if(solveprob(bool,0)==false){
			System.out.println("NO SOLUTION");
		}
		else
			printArr(bool);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solve();

	}

}
