package myproj;
import java.util.Scanner;

public class Tower_of_hanoi {
	
	private static Scanner s;

	public static void towerHanoi(int num,char from,char to,char with){

		if(num>=1){
			towerHanoi(num-1,from,with,to);
			System.out.println(from+"->"+to);
			towerHanoi(num-1,with,to,from);
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER NO. OF PEGS");
		int num=s.nextInt();
		towerHanoi(num,'A','B','C');
	}

}
