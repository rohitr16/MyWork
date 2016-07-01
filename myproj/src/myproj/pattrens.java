package myproj;

import java.util.Scanner;

public class pattrens {

	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		System.out.println("ENTER N ");
		int n=s.nextInt();
		int count =1;
		int i=1,j=1;
		while(i<=n){
			while(j<=i){
				System.out.print(count+" ");
				j++;
				count++;
			}
			i++;
			j=1;
			System.out.print("\n");
		}
		

	}

}
