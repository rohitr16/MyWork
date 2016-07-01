package myproj;
import java.util.Scanner;

public class even_odd_sum {
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		System.out.println("ENTER THE NUMBER:");
		int n=s.nextInt();
		int a=0;
		int esum=0;
		int osum=0;
		while(n!=0){
			a=n%10;
			if(a%2==0)
				esum+=a;
			else
				osum+=a;
			n/=10;
		}
		System.out.println("EVEN DIGITS SUM:"+esum+"\n"+"OD DIGITS SUM:"+osum);

	}

}
