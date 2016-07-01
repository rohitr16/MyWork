package myproj;
import java.util.Scanner;

public class xpown {
	private static Scanner s; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		System.out.println("ENTER X & N:");
		int x=s.nextInt();
		int n=s.nextInt();
		for(int i=1;i<n;i++){
			x=x*x;
		}
		System.out.println(x);
	}

}
