package myproj;
import java.util.Scanner;		

public class sqrt {

	private static Scanner s;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		System.out.println("ENTER THE NUM:");
		int num=s.nextInt();
		System.out.println("ENTER CHOICE:");
		int ch=s.nextInt();
		double i=1;
		double stepSize=0;
		if(ch==1){
			while(i*i<=num){
				i++;
			}
			i--;
			System.out.println(i);
		}
		if(ch==2){
			System.out.println("ENTER PRECISION N:");
			int n=s.nextInt();
			int j=0;
			while(j<=n){

				stepSize=Math.pow(10, -j);

				while(i*i<=num){

					i+=stepSize;
				}
				i=i-stepSize;	
				j++;	
			}
			stepSize=Math.pow(10, n);
			i=Math.round(i*stepSize)/stepSize;
			System.out.println(i);		
		}		
	}
}
