package myproj;

import java.util.Scanner;

public class rootseqn {
	
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER THE VALUES OF a,b,c:");
		int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();
		double r1=(-b+Math.sqrt(Math.pow(b,2)-4*a*c))/2*a;
		double r2=(-b-Math.sqrt(Math.pow(b,2)-4*a*c))/2*a;
		if(Math.pow(b,2)==4*a*c)
			System.out.println("EQUAL ROOTS:"+r1);
		else if(Math.pow(b,2)>4*a*c)
			System.out.println("REAL UNEQUAL ROOTS:"+r1+" & "+r2);
		else
			System.out.println("IMAGINARY ROOTS");

	}

}
