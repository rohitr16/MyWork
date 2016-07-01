package myproj;

import java.util.Scanner;

public class recur_2 {

	private static Scanner s;

	public static int binarySch(int[] input,int x,int low,int high){
		if(low>high)
			return -1;
		int mid=(low+high)/2;
		if(input[mid]==x)
			return mid;
		if(input[mid]>x)
			return binarySch(input, x, low, mid-1);	
		return binarySch(input,x,mid+1,high);	
	}

	public static void numPadprint(String str,String[] out){

		if(str.length()==0){		
			return;
		}
		numPadprint(str.substring(1),out);
		String st=numpad2str(str.charAt(0));
		int count=0;
		int k=0;
		while(out[k]!=null){
			count++;
			k++;
		}
		String outSmall[]=new String[count];
		for(int i=0,j=0;i<outSmall.length;j++){
			outSmall[i]=out[j];
			i++;
		}
		k=0;
		for(int i=0;i<st.length();i++){
			for(int j=0;j<outSmall.length;j++){
				out[k]=st.charAt(i)+outSmall[j];
				if(outSmall.length>=st.length()*st.length())
					System.out.println(out[k]);
				k++;
			}	
		}	
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

	public static boolean grammer(String str,int index){
		if(index==str.length())
			return true;
		if(str.charAt(0)!='a'){
			return false;
		}
		if(str.charAt(index)=='a'){
			return grammer(str, index+1);
		}
		if(str.charAt(index)=='b'&&str.charAt(index-1)!='b'){
			if(index+1<str.length()&&str.charAt(index+1)=='b'){
				return grammer(str,index+2);
			}	
		}
		return false;
	}

	public static int childStair(int num){
		if(num==1||num==0){
			return 1;
		}
		int count=0;
		for(int i=1;i<=num&&i<=3;i++){
			count+=childStair(num-i);
		}
		return count;

	}

	public static void printnumPad(String str,String out){
		if(str.length()==0){
			System.out.println(out);
			return;
		}
		String st=numpad2str(str.charAt(0));
		for(int i=0;i<st.length();i++){
			printnumPad(str.substring(1), out+st.charAt(i));
		}
	}

	public static void subSeq(String str,String out){
		if(str.length()==0){
			System.out.println(out);
			return;
		}
		subSeq(str.substring(1), out+str.charAt(0));
		subSeq(str.substring(1), out);
	}

	public static void stringPer(String str,int beg,int end){
		if(beg==end){
			System.out.println(str);
			return;
		}

			for(int i=beg;i<=end;i++){
				str=swap(str,beg,i);
				stringPer(str, beg+1, end);
				str=swap(str,beg,i);
			}
	
	}
	
	public static String[] stringPerSt(String str){
		
		if(str.length()==0){
			String[] out=new String[1];
			out[0]="";
			return out;
		}
		
		String[] temp=stringPerSt(str.substring(1));
		String[] out=new String[temp.length*str.length()];
		
		int k=0;
		for(int i=0;i<temp.length;i++){
			String currentStr=temp[i];
			for(int j=0;j<=currentStr.length();j++){
				out[k++]=currentStr.substring(0,j)+str.charAt(0)+currentStr.substring(j); 
			}
		}
		
		return out;
		
	}
	
	public static String[] stringPerm2(String str){
		
		if(str.length()==0){
			String[] out=new String[1];
			out[0]="";
			return out;
		}
		int k=0;
		String[] out=new String[fact(str.length())];
		
		for(int i=0;i<str.length();i++){
			String[] temp=stringPerm2(str.substring(0,i)+str.substring(i+1));
			for(int j=0;j<temp.length;j++){
				out[k++]=str.charAt(i)+temp[j];
			}
		}
		
		return out;
		
	}
	
	public static int fact(int n){
		
		if(n==0){
			return 1;
		}
		
		return n*fact(n-1);
	}

	public static String swap(String str,int beg,int end){

		char[] ch=str.toCharArray();
		char tmp=ch[beg];
		ch[beg]=ch[end];
		ch[end]=tmp;
		String st="";
		for(int i=0;i<ch.length;i++){
			st=st+ch[i];
		}

		return st;
	}

	public static void permArray(int[] input,int[] out){
		if(input.length==0){
			printArr(out);
			return;
		}
		int[] newInp=new int[input.length-1];
		for(int i=0;i<input.length-1;i++){
			newInp[i]=input[i+1];
		}
		int newOut[]=new int[out.length+1];
		for(int i=0;i<out.length;i++){
			newOut[i]=out[i];
		}
		newOut[out.length]=input[0];
		permArray(newInp,newOut);
		permArray(newInp,out);

	}

	public static int[][] permArr(int[] input){
		if(input.length==0){
			int[][] out=new int[1][0];
			return out;
		}
		int[] newInp=new int[input.length-1];
		for(int i=0;i<input.length-1;i++){
			newInp[i]=input[i+1];
		}

		int[][] smallOut=permArr(newInp);
		int[][] out=new int[2*(smallOut.length)][];
		for(int i=0;i<smallOut.length;i++){
			out[i]=new int[smallOut[i].length+1];
			out[i][0]=input[0];
			for(int j=0;j<smallOut[i].length;j++){
				out[i][j+1]=smallOut[i][j];
			}
		}
		for(int i=smallOut.length;i<2*smallOut.length;i++){
			out[i]=new int[smallOut[i-smallOut.length].length];
			for(int j=0;j<out[i].length;j++){
				out[i][j]=smallOut[i-smallOut.length][j];
			}
		}
		return out;
	}

	public static void alphaCode(String str,String out){
		if(str.length()==0){
			System.out.println(out);
			return;
		}
		String newOut=out;
		out=out+(char)(str.charAt(0)+48);
		alphaCode(str.substring(1), out);
		if(str.length()>=2&&((str.charAt(0)-48)*10+str.charAt(1)-48)<=26){		
		newOut=newOut+(char)((str.charAt(0)-48)*10+str.charAt(1)+48);
		alphaCode(str.substring(2),newOut);
		}	
	}
	public static void printArr(int[] input ){
		for(int i=0;i<input.length;i++){

			System.out.print(input[i]+" ");
		}
		System.out.println("");

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
//		System.out.println("ENTER THE NUM:");
//		int size=s.nextInt();
//		int[] input=new int[size];
//		for(int i=0;i<input.length;i++){
//		input[i]=s.nextInt();
//		}
		//		int x=binarySch(input, 7, 0, input.length-1);
		//		System.out.println(x);
		//		String[] out=new String[30];
		//		out[0]="";
		//		numPadprint("235",out);
		//		subSeq("abcd","");
		//		boolean bl=grammer("bb",0);
		//		System.out.println(bl);
		//		int count=childStair(2);
		//		System.out.println(count);
		//		printnumPad("234", "");
		//	    stringPer("ABCD",0,3);
//		int[] out=new int[0];
//		permArray(input, out);
//		int k=s.nextInt();
//		int[][] out=permArr(input);
//		for(int i=0;i<out.length;i++){
//			int sum=0;
//			for(int j=0;j<out[i].length;j++){
//				System.out.print(out[i][j]+" ");
//				sum+=out[i][j];
//			}
//			if(sum==k){
//				for(int j=0;j<out[i].length;j++){
//					System.out.print(out[i][j]+" ");	
//					}
//				System.out.println();
//			}
//			
//		}
		//alphaCode("1123", "");
		
//		String[] out=stringPerSt("abc");
		String[] out=stringPerm2("abc");
		
		for(int i=0;i<out.length;i++){
			System.out.println(out[i]);
		}
		
	}	
}
