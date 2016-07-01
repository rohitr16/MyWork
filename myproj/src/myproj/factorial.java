package myproj;

import java.math.BigInteger;
import java.util.Scanner;

public class factorial {

	private static Scanner s;

	public static int trailZero(int num){
		int numZero=0;
		int n=5;
		while((num/n)!=0){
			numZero+=num/(n);
			n*=5;
		}
		return numZero;
	}

	public static void fact(int n){

		int fac[]=new int[10000];
		fac[0]=1;
		int maxn=0;

		for(int i=2;i<=n;i++){

			int carry=0;
			for(int j=0;j<=maxn;j++){
				
				int num=(fac[j]*i+carry);
				fac[j]=num%10;
				carry=num/10;
				
			}
			while(carry>0){
				maxn++;
				fac[maxn]=carry%10;
				carry/=10;
				
			}
		}

		for(int i=maxn;i>=0;i--){
			System.out.print(fac[i]);
		}

		return ;
	}

	public static String factBig(int n){
		BigInteger fac=new BigInteger("1");
		for(int i=1;i<=n;i++){
			fac=fac.multiply(new BigInteger(i+""));
		}	
		return fac.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER NO:");
		int num=s.nextInt();
		//		int numZero=trailZero(num);
		//		System.out.println(numZero);
		String str=factBig(num);
		System.out.println(str);
		
		fact(num);

	}

}
