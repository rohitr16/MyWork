package myproj;
import java.util.Scanner;

public class array2d {

	private static Scanner s;

	public static int[][] create2D(int rows,int cols){

		int[][] arr2d=new int[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				arr2d[i][j]=s.nextInt();

			}
		}
		return arr2d;

	}

	public static void print2d(int[][] inp){


		for(int i=0;i<inp.length;i++){
			for(int j=0;j<inp[0].length;j++){
				System.out.print(inp[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	public static void wave(int[][] inp){
		int i=0;
		int j=0;
		int n=inp.length;
		for( j=0;j<inp[0].length;j++){

			if(j%2==0)
				i=0;
			else
				i=n-1;
			while(i<inp.length&&i>=0){
				System.out.print(inp[i][j]+" ");
				if(j%2==0)
					i++;
				else
					i--;
			}
			System.out.println();

		}

	}

	public static void spiral(int[][] inp){

		int k=0;
		int l=inp.length-1;
		int n=inp[0].length-1;
		int m=0;
		while(k<=n&&m<=l){
			for(int j=k;j<=n;j++){
				System.out.print(inp[m][j]+" ");
			}
			m++;
			for(int i=m;i<=l;i++){
				System.out.print(inp[i][n]+" ");			
			}
			n--;
			if(k<n){
				for(int j=n;j>=k;j--){
					System.out.print(inp[l][j]+" ");
				}
				l--;
			}
			if(l>0){
				for(int i=l;i>=m;i--){
					System.out.print(inp[i][k]+" ");
				}
				k++;
			}
		System.out.println();	
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER ROWS & COLS:");
		int rows=s.nextInt();
		int cols=s.nextInt();
		int inp[][]=create2D(rows,cols);
		//		wave(inp);
		spiral(inp);


	}

}
