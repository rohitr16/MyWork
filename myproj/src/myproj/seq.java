package myproj;

import java.util.Scanner;
public class seq {
	
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		System.out.println("ENTER N:");
		int n=s.nextInt();
		System.out.println("ENTER N INTEGERS ONE BY ONE:");
		int a=s.nextInt();
		int b=0;
		int flag=0;
		int i=0;
		for(i=1;i<n;i++){
			b=s.nextInt();
			
			if(a>b&&flag==1){
				break;
			}
			if(a<=b&&flag==0){
				flag=1;
				
			}
			a=b;
		}
		if(i!=n)
			System.out.println("NO");
		else
			System.out.println("YES");

	}

}
