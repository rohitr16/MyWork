package myproj;

import java.util.Scanner;

public class starpat {
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		System.out.println("ENTER N:");
		int n=s.nextInt();
		for(int i=1;i<=n;i++){
			if(i<=n/2+1){
				for(int k=n/2+1-i;k>=0;k--){
					System.out.print(" ");
				}
				for(int j=1;j<=2*i-1;j++){
					System.out.print("*");
				}
				System.out.println("");
			}
			else{
				for(int k=0;k<=i-(n/2+1);k++){
					System.out.print(" ");
				}
				for(int j=1;j<=n-2*(i-(n/2+1));j++){
					System.out.print("*");
				}
				System.out.println("");
			}
		}
		

	}

}
