package myproj;

import java.util.Scanner;

public class pat1 {

	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER N:");
		int n=s.nextInt();
		System.out.println("ENTER CHOICE:");
		int c=s.nextInt();
		switch(c){
		case 1:

			for(int i=1;i<=n;i++){
				for(int j=1;j<=i;j++){
					if(j==1||j==i)
						System.out.print("1");
					else
						System.out.print("0");
				}
				System.out.println("");
			}
			break;
		case 2:
			for(int i=1;i<=n;i++){
				for(int j=1;j<=i;j++){
					if(j==1||j==i)
						System.out.print("1");
					else
						System.out.print("2");
				}
				System.out.println("");
			}
			break;
		case 3:
			for(int i=1;i<=n;i++){
				for(int j=1;j<=i;j++){
					if(i>1){
						if(j==1||j==i)
							System.out.print(i-1);
						else
							System.out.print("0");
					}
					else
						System.out.print("1");
				}
				System.out.println("");
			}
			break;
		case 4:
			for(int i=1;i<=n;i++){
				for(int j=1;j<=i;j++){

					System.out.print(n-i+1);

				}
				System.out.println("");
			}
			break;
		case 5:

			for(int i=0;i<n;i++){
				int a=1;
				for(int j=0;j<=i;j++){
					System.out.print(a);
					a=a*(i-j)/(j+1);

				}
				System.out.println("");
			}
			break;
		
		}

	}

}
