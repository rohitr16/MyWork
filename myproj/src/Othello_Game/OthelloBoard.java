package Othello_Game;

import java.util.ArrayList;

public class OthelloBoard {

	private char[][] board;
	private ArrayList<String> possibleMoves;
	final char Player1Symbol;
	final char Player2Symbol;
	private static int[] xDir={0,0,1,1,1,-1,-1,-1};
	private static int[] yDir={-1,1,0,1,-1,0,-1,1};
	public final int PLAYER1WINS=1;
	public final int PLAYER2WINS=2;
	public final int INCOMPLETE=3;
	public final int DRAW=4;



	public OthelloBoard(char symbol1,char symbol2){

		this.Player1Symbol=symbol1;
		this.Player2Symbol=symbol2;
		board=new char[8][8];
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				board[i][j]=' ';
			}
		}
		possibleMoves=new ArrayList<>();
		board[3][3]='w';
		board[3][4]='b';
		board[4][3]='b';
		board[4][4]='w';
	}


	public boolean move(char symbol,int x,int y){

		if(board[x][y]!=' '){
			return false;
		}

		char prevSymbol;
		if(symbol=='w'){
			prevSymbol='b';
		}
		else{
			prevSymbol='w';
		}

		boolean MovePossible=false;;
		boolean makeMove=false;
		for(int i=0;i<xDir.length;i++){

			int xStep=xDir[i];
			int yStep=yDir[i];

			int currentX=x+xStep;
			int currentY=y+yStep;
			makeMove=false;

			while(currentX>=0&&currentX<8&&currentY>=0&&currentY<8&&board[currentX][currentY]==prevSymbol){

				currentX+=xStep;
				currentY+=yStep;
				makeMove=true;
			}

			if(makeMove&&currentX>=0&&currentX<8&&currentY>=0&&currentY<8&&board[currentX][currentY]==symbol){
				int j=currentX-xStep;
				int k=currentY-yStep;
				MovePossible=true;
				while(board[j][k]==prevSymbol){
					board[j][k]=symbol;
					j-=xStep;
					k-=yStep;
				}
				board[j][k]=symbol;
			}
		}
		return MovePossible;
	}

	public boolean movePossible(char symbol,int x,int y){

		if(board[x][y]!=' '){
			return false;
		}
		char prevSymbol;
		if(symbol=='w'){
			prevSymbol='b';
		}
		else{
			prevSymbol='w';
		}

		boolean makeMove=false;

		for(int i=0;i<xDir.length;i++){

			makeMove=false;
			int xStep=xDir[i];
			int yStep=yDir[i];

			int currentX=x+xStep;
			int currentY=y+yStep;

			while(currentX>=0&&currentX<8&&currentY>=0&&currentY<8&&board[currentX][currentY]==prevSymbol){

				currentX+=xStep;
				currentY+=yStep;
				makeMove=true;
			}

			if(makeMove&&currentX>=0&&currentX<8&&currentY>=0&&currentY<8&&board[currentX][currentY]==symbol){		
				return true;
			}
		}
		return false;
	}

	public int gameStatus(char symbol){

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(movePossible(symbol,i,j)){
					return INCOMPLETE;
				}
			}
		}
		int countBlack=0;
		int countWhite=0;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(board[i][j]=='b'){
					countBlack++;
				}
				if(board[i][j]=='w'){
					countWhite++;
				}
			}
		}

		if(countBlack>countWhite){
			return PLAYER1WINS;
		}
		if(countBlack<countWhite){
			return PLAYER2WINS;
		}
		return DRAW;	
	}

	public void printBoard(){

		System.out.print(" ");
		for(int k=0;k<33;k++){
			System.out.print("_");
		}
		System.out.println();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(j==board[i].length-1){
					System.out.print(" | "+board[i][j]+" |");
				}
				else{
					System.out.print(" | "+board[i][j]);
				}
			}
			System.out.println();
			System.out.print(" ");
			for(int k=0;k<33;k++){
				System.out.print("_");
			}
			System.out.println();
		}
	}

	public void printPossibleMoves(char symbol){


		possibleMoves=new ArrayList<>();

		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if(movePossible(symbol,i,j)){
					possibleMoves.add(i+","+j);
				}
			}
		}
		if(possibleMoves.size()==0){
			System.out.println("!! NO MOVES POSSIBLE FOR YOU !!");
			return;
		}
		System.out.println();
		System.out.println("POSSIBLE MOVES :");
		System.out.print("| ");
		for(int i=0;i<possibleMoves.size();i++){
			System.out.print(possibleMoves.get(i)+" | ");
		}
		System.out.println();
		System.out.println();
	}

}
