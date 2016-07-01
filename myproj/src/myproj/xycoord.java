package myproj;
import java.util.Scanner;

public class xycoord {
	
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		System.out.println("ENTER X & Y:");
		int x=s.nextInt();
		int y=s.nextInt();
		int num=0;
		if(x==y||x==y+2){
		if(x%2==0&&y%2==0)
		   num=x+y;
		else
			num=x+y-1;
		
		System.out.println(num);
		}
		else
			System.out.println("INVALID COORDS");
			
		
			
	}

}
