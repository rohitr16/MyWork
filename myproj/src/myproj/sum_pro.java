package myproj;
import java.util.Scanner;

public class sum_pro {
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER N & YOUR CHOICE(1 OR 2)");
		int n=s.nextInt();
		int ch=s.nextInt();
		int p=1;
		if(ch==1)
			System.out.println((n*(n+1))/2);
		if(ch==2){
			for(int i=1;i<=n;i++)
				p=p*i;
			System.out.println(p);
		}

	}

}
