package myproj;

import java.util.Scanner;

public class fah2cel {

	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int celciusValue=0;
		s = new Scanner(System.in);
		System.out.println("Enter minValue ");
		int minFahrenheitValue= s.nextInt();
		System.out.println("Enter minValue ");
		int maxFahrenheitValue= s.nextInt();
		while(minFahrenheitValue<=maxFahrenheitValue){

			celciusValue=(int)((5.0/9)*(minFahrenheitValue-32));
			System.out.println(minFahrenheitValue+" "+celciusValue);
			minFahrenheitValue=minFahrenheitValue+20;

		}
	}

}
