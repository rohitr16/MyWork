package myproj;

import java.util.Scanner;

public class patternciti {
	
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s = new Scanner(System.in);
		System.out.println("ENTER N ");
		int n=s.nextInt();
		int l=1;
		int m=1;
		
		for(int i=1;i<=n;i++){
			m=2*i-2;
			l=i;
			
			for(int k=n-i;k>=1;k--){
				System.out.print(" ");
			}
			
			for(int j=1;j<=2*i-1;j++){
				if(j<=i){
					System.out.print(l);
					l++;
				}
				else{
					System.out.print(m);
					m--;
				}
				
			}
			System.out.print("\n");
			
			
			
		}

	}

}
