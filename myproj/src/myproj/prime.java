package myproj;

import java.util.Scanner;


public class prime {

	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		System.out.println("ENTER THE NUMBER ");
		int n=s.nextInt();
		int i=2;
		int flag =0;
		while(i<=(n/2)){
			if(n%i==0){
				System.out.println("NO is not prime ");
			flag=1;
				break;
			}
			i++;
		}
		if(flag==0){
			System.out.println("No is prime ");
		}

	}

}
