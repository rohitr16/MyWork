package oops;

import java.util.Scanner;

public class reverse_Num {
	
	private static Scanner s;
	
	
	public static String revNumpad(String inp,String[] str){
		if(inp.length()==0){
			return ""; 
		}
		String newStr=revNumpad(inp.substring(1), str);
		String out="";
		
		for(int i=0;i<str.length;i++){
			String tmp="";
			for(int j=0;j<str[i].length();j++){
				
				tmp=tmp+i;
				if(inp.charAt(0)==str[i].charAt(j)){
					out=tmp+" "+newStr;
				}
			}
		}
		
		
		return out;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		s=new Scanner(System.in);
		String[] str=new String[10];
		str[0]="";
		str[1]="";
		str[2]="abc";
		str[3]="def";
		str[4]="ghi";
		str[5]="jkl";
		str[6]="mno";
		str[7]="pqrs";
		str[8]="tuv";
		str[9]="wxyz";
		String out=revNumpad("afz", str);
		System.out.println(out);
		
		

	}

}
