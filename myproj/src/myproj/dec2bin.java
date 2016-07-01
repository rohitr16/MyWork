package myproj;
import java.util.Scanner;

public class dec2bin {
	private static Scanner s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER YOUR CHOICE:");
		int ch=s.nextInt();
		System.out.println("ENTER DECIMAL OR BIN NO.");
		int num=s.nextInt();
		int bin=0;
		int dec=0;
		int n=1;
		if(ch==1){
			
			while(num!=1){	
				bin+=(num%2)*n;
				n=n*10;
				num/=2;
			}
			bin+=num*n;
			System.out.println(bin);
		}
		if(ch==2){
			for(int i=0;num!=0;i++){
				n=num%10;
				dec+=n*(Math.pow(2,i));
				num/=10;
			}
			System.out.println(dec);
		}

	}

}
