package myproj;
import java.util.Scanner;

public class rev {
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		System.out.println("ENTER THE NO TO FIND REV:");
		int n=s.nextInt();
		int rev=0;
		while(n!=0){
			rev=rev*10+n%10;	
			n/=10;
			
		}
		System.out.println(rev);

	}

}
