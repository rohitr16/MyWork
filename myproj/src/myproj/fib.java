package myproj;

import java.util.Scanner;

public class fib {

	private static Scanner s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s = new Scanner(System.in);
		System.out.println("ENTER N ");
		int n=s.nextInt();
		int first =0;
		int second = 1;
		int term =0;
		System.out.println(first);
		System.out.println(second);
		while(term<n){
			
			term=first+second;
			System.out.println(term);
			first=second;
			second=term;
		
		}
		

	}

}
