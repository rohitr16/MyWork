package myproj;

import java.util.Scanner;

public class palin_substring {

	public static Scanner s;

	public static int palinSub(String str){
		int count =0;
		for(int i=1;i<=str.length();i++){
			for(int j=0;j<=str.length()-i;j++){
				if(palin(str.substring(j,j+i)))
					count++;
			}
		}
		return count;
	}

	public static boolean palin(String str){

		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(str.length()-i-1)){
				return false;
			}
		}
		return true;
	}

	public static int palinSun(String str,boolean[][] palin){
		int count =0;

		for(int i=0;i<str.length();i++){
			palin[i][i]=true;
			count++;
		}
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				palin[i][i+1]=true;
				count++;
			}
		}

		for(int k=3;k<str.length();k++){
			for(int i=0;i<str.length()-k+1;i++){
				int j=k+i-1;
				if(palin[i+1][j-1]&&str.charAt(i)==str.charAt(j)){
					palin[i][j]=true;
					count++;
				}
			}
		}

		return count;
	}

	public static void palinSub1(String str){

		int count=0;
		int k=-1,j=-1;
		for(int l=1;l<=2;l++){
			for(int i=0;i<str.length();i++){
				if(l==1){
					count++;
					j=i-1;
					k=i+1;
				}
				else{
					if(i<str.length()-1&&str.charAt(i)==str.charAt(i+1)){
						count++;
						j=i-1;
						k=i+2;
					}

				}
				while(j>=0&&k<str.length()){
					if(str.charAt(j)==str.charAt(k)){
						count++;
						j--;
						k++;
					}
					else 
						break;
				}
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		//		System.out.println("ENTER STRING:");
		//		String str=s.next();
		//		boolean[][] palin=new boolean[str.length()+1][str.length()+1];
		//		for(int i=0;i<str.length();i++){
		//			for(int j=0;j<str.length();j++){
		//				palin[i][j]=false;
		//			}
		//		}
		//		int count = palinSun(str,palin);
		//		System.out.println(count);
		palinSub1("abcdcba");
	}
}
