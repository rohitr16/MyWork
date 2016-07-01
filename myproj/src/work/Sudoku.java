package work;


public class Sudoku {
	
	private static int N=9;

	public static boolean SolveSudoku(int[][] board){

		int row=0;
		int col=0;
		boolean flag=true;

		for(row=0;row<N;row++){
			for(col=0;col<N;col++){
				if(board[row][col]==0){
					flag=false;;
					break;
				}
			}
			if(!flag){
				break;
			}
		}
		
		if(row==N&&col==N){
			return true;
		}
		

		for(int i=1;i<=9;i++){

			if(isSafe(board,row,col,i)){

				board[row][col]=i;

				if(SolveSudoku(board)){
					return true;
				}

				board[row][col]=0;
			}
		}

		return false;

	}

	private static boolean isSafe(int[][] board, int row, int col,int num) {
		
		for(int i=0;i<N;i++){
			if(board[i][col]==num){
				return false;
			}
		}

		for(int i=0;i<N;i++){
			if(board[row][i]==num){
				return false;
			}
		}

		int rowStart=(row/3)*3;
		int colStart=(col/3)*3;

		for(int i=rowStart;i<rowStart+3;i++){
			for(int j=colStart;j<colStart+3;j++){
				if(board[rowStart][colStart]==num){
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board={{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0,0}};

		if(SolveSudoku(board)){
			for(int row=0;row<board.length;row++){
				for(int col=0;col<board[row].length;col++){
					System.out.print("| "+board[row][col]+" |");
				}
				System.out.println();
			}
		}
		else{
			System.out.println("NO SOLUTION");
		}
	}

}
