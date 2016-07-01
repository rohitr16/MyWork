package myproj;

import java.util.Scanner;
public class stringp {
	private static Scanner s;

	public static int[] createArr(int size){
		int arr[]=new int[size];
		s=new Scanner (System.in);
		for(int i=0;i<size;i++){
			arr[i]=s.nextInt();	
		}
		return arr;
	}

	public static boolean palin(String str){

		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(str.length()-i-1)){
				return false;
			}
		}
		return true;
	}
	public static int i=0;

	public static String[] subSequence(String str){

		if(str.length()==0){
			String out[]=new String[1];
			out[0]="";
			return out;
		}

		String[] outSmall=subSequence(str.substring(1));
		String out[]=new String[2*outSmall.length];
		for(int i=0;i<outSmall.length;i++){
			out[i]=outSmall[i];
		}
		for(int i=0;i<outSmall.length;i++){
			out[i+outSmall.length]=str.charAt(0)+outSmall[i];
		}

		return out;
	}

	public static String[] numPad(String str){

		if(str.length()==0){		
			String[] out=new String[1];
			out[0]="";
			return out;
		}
		String outSmall[]=numPad(str.substring(1));
		String st=numpad2str(str.charAt(0));
		String[] out=new String[outSmall.length*st.length()];
		int k=0;
		for(int i=0;i<st.length();i++){
			for(int j=0;j<outSmall.length;j++){
				out[k]=st.charAt(i)+outSmall[j];
				k++;
			}	
		}
		return out;
	}

	public static String numpad2str(char num){

		String str="";
		switch(num){

		case '2':return "abc";		
		case '3':return "def";
		case '4':return "ghi";
		case '5':return "jkl";
		case '6':return "mno";
		case '7':return "pqr";
		case '8':return "stuv";
		case '9':return "wxyz";
		default:return "";
		}
		
	}
	public static void substring(String str){

		for(int i=1;i<=str.length();i++){

			for(int j=0;j<str.length()-i+1;j++){

				System.out.print(str.substring(j,j+i)+" ");
			}
			System.out.println("");
		}
	}

	public static char highOccur(String str){
		char ch='\0';
		int max=0;
		int ascii=0;
		int[] occurCount=new int[255];
		for(int i=0;i<str.length();i++){
			occurCount[str.charAt(i)]++;						
		}
		for(int i=0;i<occurCount.length;i++){
			if(max<occurCount[i]){
				max=occurCount[i];
				ascii=i;
			}
		}
		ch=(char)ascii;
		return ch;
	}

	public static String minLenW(String str){
		String word="";
		int minLen=Integer.MAX_VALUE;
		int index=0;
		int count=0;
		int i=0;
		for(i=0;i<str.length();i++){
			count=0;
			while(i<str.length()&&str.charAt(i)!=' '){
				count++;
				i++;
			}
			if(minLen>count){
				minLen=count;
				index=i-count;
			}

		}
		word=str.substring(index, index+minLen);

		return word;
	}

	public static String remDup(String str){

		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				int j=i;
				while(j<str.length()-1&&str.charAt(j)==str.charAt(j+1)){
					j++;
				}
				str=str.substring(0, i+1)+str.substring(j+1, str.length());	
			}
		}
		return str;
	}

	public static String compStr(String str){

		for(int i=0;i<str.length()-1;i++){
			int j=i;
			int count=1;
			if(str.charAt(i)==str.charAt(i+1)){
				while(j<str.length()-1&&str.charAt(j)==str.charAt(j+1)){
					j++;
					count++;
				}
				str=str.substring(0, i+1)+String.valueOf(count)+str.substring(j+1, str.length());
			}
		}
		return str;
	}

	public static void sortStr(String[] str){

		for(int i=0;i<str.length;i++){
			int min=i;
			for(int j=i;j<str.length;j++){
				if(str[min].length()>str[j].length()){
					min=j;
				}
			}
			if(min!=i){
				String tmp=str[min];
				str[min]=str[i];
				str[i]=tmp;
			}	
		}
	}

	public static String revStr(String str){
		String st="";
		for(int i=str.length()-1;i>=0;){
			int j=i;
			while(j>=0&&str.charAt(j)!=' '){
				j--;
			}
			st=st+str.substring(j+1, i+1)+" ";
			i=j-1;	
		}
		st=st.substring(0, st.length()-1);

		return st;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
//		System.out.println("ENTER STRING:");
//		String str=s.next();
		//		System.out.println("ENTER SIZE");
		//		int size=s.nextInt();
		//		String[] str=new String[size];
		//		for(int i=0;i<str.length;i++){
		//			str[i]=s.next();		
		//		}
		//		boolean r=palin(str);
		//		System.out.println(r);
		//		substring(str);
		//		char ch=highOccur(str);
		//		System.out.println(ch);
		//		str=minLenW(str);
		//		System.out.println(str);
		//		str=remDup(str);
		//		System.out.println(str);
		//		str=compStr(str);
		//		System.out.println(str);
		//		sortStr(str);
		//		for(int i=0;i<str.length;i++){
		//			System.out.println(str[i]);
		//		}
		//		str=revStr(str);
		//		System.out.println(str);
//		String[] out=subSequence(str);
//		for(int i=0;i<out.length;i++){
//			System.out.print(out[i]+" ");
//		}
		String[] out=numPad("35");
		for(int i=0;i<out.length;i++){
			System.out.println(out[i]+" ");
		}
	}
	
	
}
