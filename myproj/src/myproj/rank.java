package myproj;

import java.util.Scanner;
import java.math.*;


public class rank {

	private static Scanner s;

	public static int base26ToDec(String str){

		int a=str.length();
		int b;
		int rank=0;
		int c=0;
		int val=0;
		for(int i=a-1;i>=0;i--){
			b=str.charAt(i);
			if(b<=90){
				val=b-64;
				rank+=val*Math.pow(26, c);
				c++;
			}
			else{
				val=b-96;
				rank+=val*Math.pow(26, c);
				c++;	
			}
		}
		return rank;	
	}

	public static char[] dec2base26(int inp){

		int size=(int)(Math.log10(inp)/Math.log10(26))+1;
		char[] str=new char[size];
		int rem=0;
		int k=size-1;

		while(inp>26){
			if(inp%26==0){
				rem=inp%26;
				if(rem==0){
					rem=26;
				}
				str[k--]=(char)(rem+64);
				inp=(inp/26==1)?inp/26:inp/26-1;
			}
			else{	
				rem=inp%26;
				str[k--]=(char)(rem+64);
				inp/=26;
			}	
		}
		str[k]=(char)(inp+64);

		return str;
	}

	
	public static void main(String[] args) {
		s=new Scanner(System.in);
		System.out.println("ENTER YOUR CHOICE:");
		int choice=s.nextInt();
		if(choice==1){
			System.out.println("ENTER THE ALBHABETS:");
			String ch= s.next();
			int rank=base26ToDec(ch);	
			System.out.println(rank);
		}
		else{
			System.out.println("ENTER NO.");
			int inp=s.nextInt();
			char[] str=dec2base26(inp);
			for(int i=0;i<str.length;i++){
				if(str[i]!='\0')
					System.out.print(str[i]);
			}	
		}
	}

}
