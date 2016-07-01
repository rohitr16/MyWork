package myproj;

import java.util.Scanner;



public class prime2tn {
	
	public static void printprime(int n){
		int j=0;
		int flag=0;
		for(int i=2;i<=n;i++){
			flag=0;
			j=2;
			while(j<=i/2){
				if(i%j==0){
					flag=1;
				}
				j++;
			}
			if(flag==0){
				System.out.println(i);
			}
		}
		
	}
	
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		s = new Scanner(System.in);
		System.out.println("ENTER N ");
		int n=s.nextInt();
		printprime(n);
		

	}

}
