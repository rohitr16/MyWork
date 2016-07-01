package myproj;

import java.util.Scanner;

public class powerlgn {
	private static Scanner s;

	public static int powlg(int x,int n){
		if(n==0){
			return 1;
		}
		int out=powlg(x,n/2);
		if(n%2==0){
			return out*out;
		}
		return out*out*x;
	}

	public static int countGreater(String str){
		if(str.length()==0){		
			return 0; 
		}
		int count= countGreater(str.substring(1));
		for(int i=0;i<str.length();i++){
			if(str.charAt(0)<str.charAt(i))
				count+=fact(str.length()-1);
		}
		return count;	
	}

	public static int dupcountGreater(String str){
		if(str.length()==0){		
			return 0; 
		}
		int count= dupcountGreater(str.substring(1));
		int[] dec=new int[10];
		for(int i=0;i<str.length();i++){
			if(str.charAt(0)<str.charAt(i)){
				dec=dupdec(str);
				int tmp=fact(str.length()-1);
				for(int k=0;k<dec.length;k++){
					if(dec[k]>1)
						tmp=tmp/fact(dec[k]);
				}
				count+=tmp;
			}

		}
		return count;	
	}
	public static int[] dupdec(String str){
		int[] dec=new int[10];
		for(int i=0;i<dec.length;i++){
			dec[i]++;
		}
		for(int i=0;i<str.length()-1;i++){
			if(dec[str.charAt(i)-48]==1){
				for(int j=i+1;j<str.length();j++){
					if(str.charAt(i)==str.charAt(j))
						dec[str.charAt(i)-48]++;
				}
			}
		}
		return dec;
	}

	public static int fact(int n){
		if(n==1){
			return 1;
		}
		return n*fact(n-1);
	}
	
	public static String SubNoRep(String str){
		
		for(int i=str.length();i>0;i--){
			for(int j=0;j<=str.length()-i;j++){
			   if(checkDupStr(str.substring(j, j+i)))
				  return str.substring(j, j+i);	
			}
		}	
		return str;
	}
	
	public static boolean checkDupStr(String str){
		
		int[] ascii=new int[256];
		for(int i=0;i<str.length();i++){
			ascii[str.charAt(i)]++;
		}
		for(int i=0;i<ascii.length;i++){
			if(ascii[i]>1){
				return false;
			}
		}
		return true;	
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		//		System.out.println("ENTER X & N:");
		//		int x=s.nextInt();
		//		int n=s.nextInt();
		//		int out=powlg(x, n);
		//		System.out.println(out);
		//int out=dupcountGreater("12444");
		//System.out.println(out);
		String str=SubNoRep("aaaa");
		System.out.println(str);

	}

}
