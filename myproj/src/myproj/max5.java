package myproj;

import java.util.Scanner;

public class max5 {
	

	private static Scanner s;

	public static void main(String arg[]){
		s = new Scanner(System.in);
		System.out.println("Enter N ");
		int n=s.nextInt();
		System.out.println("Enter N NOS.  one by one ");
		int first = s.nextInt();
		int count=1;
		while(count<n){
			int second =s.nextInt();
			if(first<second)
				first=second;
			    count++;
				
		}
		System.out.println("Greatest no is:"+first);
		
		
	}

}
