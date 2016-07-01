package myproj;


import java.util.Scanner;

public class root {
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s= new Scanner(System.in);
		System.out.println("ENTER THE TWO INTEGERS:");
		int a=s.nextInt();
		int b=s.nextInt();
		char ch=s.next().charAt(0);
		if(ch=='+')
			System.out.println(a+b);
		else if(ch=='-')
			System.out.println(a-b);
		else if(ch=='/')
			System.out.println(a/b);
		else if(ch=='%')
			System.out.println(a%b);
		else if(ch=='*')
			System.out.println(a*b);
		else
			System.out.println("ENTERED INVALID OPERATION");
		

	}

}
