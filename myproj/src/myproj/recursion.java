package myproj;
import java.util.Scanner;

public class recursion {

	private static Scanner s;
	public static String st="";
	//public static int min=Integer.MAX_VALUE;
	public static int inum=-1;

	public static int pow(int x,int n){
		if(n==1)
			return x;
		return x*pow(x,n-1);	
	}

	public static int printWrd(int n){

		if(n<10){
			st=st+dig2wrd(n)+" ";
			return 0;
		}
		printWrd(n/10);

		return printWrd(n%10);

	}
	public static String dig2wrd(int num){

		String str="";
		switch(num){
		case 1:str="One";
		break;

		case 2:str="Two";
		break;
		case 3:str="Three";
		break;
		case 4:str="Four";
		break;
		case 5:str="Five";
		break;
		case 6:str="Six";
		break;
		case 7:str="Seven";
		break;
		case 8:str="Eight";
		break;
		case 9:str="Nine";
		break;
		case 0:str="Zero";
		break;

		}
		return str;

	}

	public static boolean sortArr(int[] inp,int index){

		if(index==inp.length-1){
			return true;
		}
		if(inp[index]<inp[index+1]){
			return sortArr(inp,index+1);
		}

		return false;
	}

	public static int minArr(int[] inp,int index,int min){

		if(index==inp.length){
			return min;
		}

		if(min>inp[index]){
			min=inp[index];
		}

		return minArr(inp,index+1,min);

	}


	public static boolean find7(int[] inp,int index,int n){

		if(index==inp.length){
			return false;
		}
		if(inp[index]==n){
			return true;
		}
		return find7(inp,index+1,n);

	}

	public static int find7Is(int[] inp,int index,int n){

		if(index==inp.length){
			return -1;
		}
		if(inp[index]==n){
			return index;
		}
		return find7Is(inp,index+1,n);

	}

	//	public static int find7Il(int[] inp,int index,int n){
	//
	//		if(index==inp.length){
	//			return inum;
	//		}
	//		if(inp[index]==n){
	//			inum=index;
	//		}
	//		return find7Il(inp,index+1,n);
	//
	//	}

	public static int find7Il(int[] inp,int index,int n){

		if(index==inp.length){
			return index;
		}
		if(inp[index]==n){
			find7Il(inp,index+1,n);
			return index;
		}
		return find7Il(inp,index+1,n);

	}

	public static void bubbleSort(int[] input,int index){

		if(index==input.length-1)
			return;

		for(int i=0;i<input.length-index-1;i++){
			if(input[i]>input[i+1]){
				int tmp=input[i];
				input[i]=input[i+1];
				input[i+1]=tmp;
			}	
		}
		bubbleSort(input, index+1);	
	}

	public static void insSort(int[] input,int index){

		if(index==input.length)
			return;
		int i=index;
		int val=input[index];
		while(i>0&&val<input[i-1]){
			input[i]=input[i-1];
			i--;
		}
		input[i]=val;
		insSort(input, index+1);
	}
	
	public static int i=0;

	public static int[] all7(int[] inp,int index,int n,int[] ind7){

		if(index==inp.length){
			return ind7;
		}
		if(inp[index]==n){
			ind7[i]=index;
			i++;
		}

		return all7(inp,index+1,n,ind7);


	}

	public static int mul(int m,int n){

		if(n==1){
			return m;
		}
		return m+mul(m,n-1);


	}

	public static int numZero(int num,int count){

		if(num%10==0)
			count++;
		if(num/10==0)
			return count;

		return numZero(num/10,count);

	}

	public static double geoSum(double n){

		if(n==0)
			return 1.0;

		return (double)(1/Math.pow(2, n))+geoSum(n-1);

	}

	public static boolean palin(String str,int index){

		if(index==str.length()/2)
			return true;

		if(str.charAt(index)==str.charAt(str.length()-1-index))
			return palin(str,index+1);

		return false;
	}

	public static String pi2num(String str,int index){

		if(index==str.length())
			return str;

		if(str.charAt(index)=='p'&&str.charAt(index+1)=='i'){
			str=str.substring(0, index)+"3.14"+str.substring(index+2,str.length());

		}	
		return pi2num(str,index+1);

	}

	public static String noX(String str,int index){

		if(index==str.length())
			return str;

		if(str.charAt(index)=='x'){
			str=str.substring(0, index)+str.substring(index+1, str.length());
			return noX(str,index);
		}

		return noX(str,index+1);
	}

	public static int str2int(String str,int index,int value){

		if(index==str.length())
			return value;

		value=value*10+str.charAt(index)-48;

		return str2int(str,index+1,value);
	}

	public static int sumDig(int num,int sum){

		if(num==0)
			return sum;
		sum+=num%10;

		return sumDig(num/10,sum);
	}

	public static boolean revStr(String s1,String s2,int index){

		if(index==s1.length()){
			return true;
		}

		if(s1.length()==s2.length()&&s1.charAt(index)==s2.charAt(s2.length()-index-1)){
			return revStr(s1,s2,index+1);
		}

		return false;
	}

	public static String pairStar(String str,int index){

		if(index==str.length()-1)
			return str;

		if(str.charAt(index)==str.charAt(index+1)){
			str=str.substring(0, index+1)+"*"+str.substring(index+1, str.length());	
		}

		return pairStar(str,index+1);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		//		System.out.println("ENTER X & N:");
		//		int x=s.nextInt();
		//		int n=s.nextInt();
		//		n=pow(x,n);
		//		System.out.println(n);
		//		System.out.println("ENTER THE NO:");
		//		int num=s.nextInt();
		//		printWrd(num);
		//		System.out.println(st);
		System.out.println("ENTER SIZE:");
		int size=s.nextInt();
		int[] input=new int[size];
		for(int i=0;i<size;i++){
			input[i]=s.nextInt();
		}
		//		boolean ch=sortArr(input,0);
		//		System.out.println(ch);
		//		int min=minArr(input,0,input[0]);
		//		System.out.println(min);
		//		boolean ch=find7(input,0,7);
		//		System.out.println(ch);
		//		int ch=find7Is(input,0,7);
		//		System.out.println(ch);
		//		int ch=find7Il(input,0,7);
		//		System.out.println(ch);
		//		int arr[]=new int[input.length];
		//		 arr=all7(input,0,7,arr);
		//		 for(int i=0;i<arr.length;i++){
		//			 if(arr[i]!=0){
		//				 System.out.print(arr[i]+" ");
		//			 }
		//		 }
		//		int product=mul(9,7);
		//		System.out.println(product);
		//		int zero=numZero(9010,0);
		//		System.out.println(zero);
		//		double sum=geoSum(1);
		//		System.out.println(sum);
		//		boolean t=palin("aaa",0);
		//		System.out.println(t);
		//		String str=pi2num("ppi",0);
		//		System.out.println(str);
		//		String str=noX("xax",0);
		//		System.out.println(str);
		//		int num=str2int("1232",0,0);
		//		System.out.println(num);
		//		int sum=sumDig(1000,0);
		//		System.out.println(sum);
		//		boolean b=revStr("d","d",0);
		//		System.out.println(b);
		//		String str=pairStar("hello",0);
		//		System.out.println(str);
		//bubbleSort(input, 0);
		insSort(input,0);
		for(int i=0;i<input.length;i++){
			System.out.print(input[i]+" ");
		}


	}

}