package myproj;
import java.util.Scanner;

public class charcheck {

	private static Scanner s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER THE CHAR TO CHECK:");
		char ch=s.next().charAt(0);
		int a=ch;
		if(a>=65&&a<=90)
			System.out.println("UPPER CASE LETTER");
		else if(a>=97&&a<=122)
			System.out.println("LOWER CASE LETTER");
		else
			System.out.println("INVALID CHARACTER");

	}

}
