package myproj;

import java.util.Scanner;

public class armstrong {
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s = new Scanner(System.in);
		System.out.println("ENTER N TO CHECK WHETHER IT ARMSTRONG OR NOT: ");
		int n=s.nextInt();
		int p = n;
		int num=0;
		while(p!=0){
			int rem=p%10;
			num +=Math.pow(rem,3);
			p/=10;
		}
		if(num==n)
			System.out.println("YES");
		else
			System.out.println("NO");
			
		
	}	

}
