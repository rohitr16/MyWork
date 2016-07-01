package myproj;

import java.util.Scanner;

public class countLess {
	
	private static Scanner s;
	
	public static int countNum(int num){
		
		int size=(int)Math.log10(num)+1;
		int count=size-1;
		int[] dig=new int[size];
		int[] sortDig=new int[size];
		while(num>0){
			dig[count]=num%10;
			sortDig[count]=num%10;
			num/=10;
			count--;
		}
		count=0;
		for(int i=0;i<size;i++){
			int j=i;
			int val=sortDig[i];
			while(j>0&&val>sortDig[j-1]){
				sortDig[j]=sortDig[j-1];
				j--;
			}
			sortDig[j]=val;
		}
		
		for(int i=0;i<dig.length;i++){
			
			for(int j=0;j<sortDig.length;j++)
			if(sortDig[i]>dig[i]){
				count+=fact(sortDig.length);
			}
		}
		return count;
	}
	
	public static int fact(int num){
		if(num==1)
			return 1;
		return num*fact(num-1);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER THE NUMBER:");
		int num=s.nextInt();
		int count=countNum(num);
		System.out.println(count);
		

	}

}
