package work;
import java.util.Scanner;

public class pattern_matching {
	
	private static Scanner s;
	
	public static boolean wildCardPattern(String strw,String str){
		
		
		if(strw.length()==0&&str.length()==0){
			return true;
		}
		
		
		if(strw.length()!=0&&(strw.charAt(0)=='*'&&strw.length()>1&&str.length()==0)){
			return false;
		}
		
		if(strw.length()!=0&&str.length()!=0&&(strw.charAt(0)=='?'||strw.charAt(0)==str.charAt(0))){
			return wildCardPattern(strw.substring(1), str.substring(1));
		}
		
		if(strw.length()!=0&&strw.charAt(0)=='*'){
			return wildCardPattern(strw.substring(1), str)||wildCardPattern(strw, str.substring(1));
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		System.out.println(wildCardPattern("*g*k", "geek"));
	}

}
