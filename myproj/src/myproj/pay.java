package myproj;
import java.util.Scanner;

public class pay {

	private static Scanner s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER YOUR BASIC & GRADE:");
		float b=s.nextFloat();
		char g=s.next().charAt(0);
		float hra=(float)0.2*b;
		float da=(float)0.5*b;
		float pf=(float)0.11*b;
		float alw=0;
		if(g=='A'||g=='a')
			  alw = 1700;
		if(g=='A'||g=='a')
			  alw = 1500;
		if(g=='A'||g=='a')
			  alw = 1300;
		float t_sal=b+hra+da+alw-pf;
		System.out.println(t_sal);

	}

}
