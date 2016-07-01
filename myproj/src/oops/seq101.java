package oops;

import java.util.Scanner;

public class seq101 {

	private static Scanner s;

	public static int countSeq(String str){

		int count=0;
		boolean flag=false;

		for(int i=0;i<str.length();i++){

			if(i>0&&str.charAt(i)=='1'&&str.charAt(i-1)=='0'&&flag){
				count++;
			}
			if(str.charAt(i)=='1'){
				flag=true;
			}
			if(str.charAt(i)!='1'&&str.charAt(i)!='0'){
				flag=false;
			}

		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println(countSeq("111111110000001"));

	}

}
