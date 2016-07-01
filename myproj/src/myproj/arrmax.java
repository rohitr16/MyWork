package myproj;

import java.util.Scanner;

public class arrmax {

	private static Scanner s;

	public static int[] createArr(int size){
		int arr[]=new int[size];
		s=new Scanner (System.in);
		for(int i=0;i<size;i++){
			arr[i]=s.nextInt();	
		}
		return arr;
	}

	

	public static int arrMax(int[] input){
		int max=Integer.MIN_VALUE;

		for(int i=0;i<input.length;i++){
			if(max<input[i])
				max=input[i];
		}
		return max;
	}

	public static int searchArr(int[] input,int element){
		int index=0;
		for(int i=0;i<input.length;i++){
			if(element==input[i]){
				index=i;
				return index;
			}
		}
		return -1;		
	}

	public static int[] reverseArr(int[] input){
		int[] rev=new int[input.length];
		int n=input.length-1;
		for(int i=0;i<input.length;i++){
			rev[i]=input[n-i];
		}
		return rev;
	}

	public static int binarySch(int[] input,int bin){

		int low=0;
		int high=input.length-1;
		int mid=0;		
		while(low<=high){
			mid=low+(high-low)/2;
			if(bin==input[mid]){
				return mid;
			}
			else{
				if(bin<input[mid]){
					high=mid-1;
				}
				else
					low=mid+1;
			}
		}
		return -1;
	}

	public static void bubbleSort(int[] input){

		boolean flag=false;
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input.length-i-1;j++){
				if(input[j]>input[j+1]){
					int temp=input[j];
					input[j]=input[j+1];
					input[j+1]=temp;
					flag=true;
				}

			}
			if(!flag){
				break;
			}

		}

	}

	public static void selSort(int[] input){
		int min=Integer.MAX_VALUE;
		int flag=0;
		for(int i=0;i<input.length;i++){
			min=Integer.MAX_VALUE;
			int t=0;
			for(int j=i;j<input.length;j++){
				if(min>input[j]){
					min=input[j];
					t=j;
					flag=1;
				}
			}
			if(flag==1){
				input[t]=input[i];
				input[i]=min;
			}
		}
	}

	public static void insSort(int[] input){

		int hole =0;
		int num=0;
		for(int i=0;i<input.length;i++){
			hole=i;
			num=input[i];
			while(hole>0&&num<input[hole-1]){
				input[hole]=input[hole-1];
				hole--;
			}
			input[hole]=num;
		}
	}

	public static int[] dec2bin(){
		s=new Scanner(System.in);
		System.out.println("ENTER DECIMAL NO.:");
		int dec=s.nextInt();
		int i=0,n=1;
		for( i=1;i<Integer.MAX_VALUE;i++){
			n=2*n;
			if(n>dec){
				break;
			}
		}
		int[] bin=new int[i];
		for(i=0;dec!=1;i++){
			bin[bin.length-1-i]=dec%2;
			dec/=2;
		}
		bin[0]=dec;
		return bin;

	}

	public static void sumsep(int[] input){
		int sump=0,sumn=0;
		for(int i=0;i<input.length;i++){
			if(input[i]>=0)
				sump+=input[i];
			else
				sumn+=input[i];

		}
		System.out.println(sump+" "+sumn);

	}

	public static  int[] arrIntsec(int[] input1,int[] input2){

		int n=0;
		if(input1.length<input2.length)
			n=input1.length;
		else
			n=input2.length;
		int intsec[]=new int[n];
		int ret[]=new int[input2.length];
		int ret1[]=new int[input1.length];
		int k=0;
		for(int i=0;i<input1.length;i++){
			for(int j=0;j<input2.length;j++){
				if(input1[i]==input2[j]&&ret[j]==0&&ret1[i]==0){
					intsec[k++]=input1[i];
					ret[j]=1;
					ret1[i]=1;
				}
			}
		}
		int sec[]=new int[k];
		for(int i=0;i<k;i++){
			sec[i]=intsec[i];
		}

		return sec;
	}

	public static void findPair(int input[],int x){

		int i=0;
		int j=input.length-1;
		while(i<j){
			if(input[i]+input[j]<x){
				i++;
			}
			else if(input[i]+input[j]>x){
				j--;
			}
			else if(input[i]+input[j]==x){
				System.out.println(input[i]+" "+input[j]);
				i++;
				j--;
			}
		}	
	}

	public static void findTrip(int input[],int x){

		for(int i=0;i<input.length;i++){
			int j=i+1;
			int k=input.length-1;
			while(j<k){
				if(input[i]+input[j]+input[k]<x){
					j++;
				}
				else if(input[i]+input[j]+input[k]>x){
					k--;
				}
				else if(input[i]+input[j]+input[k]==x){
					System.out.println(input[i]+" "+input[j]+" "+input[k]);
					j++;
					k--;
				}
			}	
		}
	}

	public static int[] arrSum(int[] input1,int[] input2){
		int n=0;
		if(input1.length<=input2.length)
			n=input2.length;
		else
			n=input1.length;
		int[] sum=new int[n+1];

		int k=n;
		int carry=0;
		int j=0,i=0;
		for( i=input1.length-1,j=input2.length-1;i>=0||j>=0;i--,j--){
			if(i>=0&&j>=0){
				sum[k--]=(input1[i]+input2[j]+carry)%10;
				carry=(input1[i]+input2[j]+carry)/10;
			}
			else if(i>=0&&j<0){
				sum[k--]=(input1[i]+carry)%10;
				carry=(input1[i]+carry)/10;
			}
			else{
				sum[k--]=(input2[j]+carry)%10;
				carry=(input2[j]+carry)/10;
			}

		}
		sum[k--]=carry;

		return sum;
	}

	public static int duplicate(int input[]){
		int dup=0;
		int[] arr=new int[input.length];
		for(int i=0;i<arr.length;i++){
			arr[input[i]]++;
		}
		for(int i=0;i<arr.length;i++){
			if(arr[i]==2)
				dup=i;
		}
		return dup;
	}

	public static void sortBin(int[] inp){
		int start=0;
		int end=inp.length-1;
		while(start<end){

			if(inp[start]==0){
				start++;
			}
			else if(inp[end]==1){
				end--;
			}
			else if(inp[start]==1&&inp[end]==0){
				inp[start]=0;
				inp[end]=1;
				start++;
				end--;
			}
		}
	}

	public static void sortTri(int[] inp){

		int start=0;
		int mid=0;
		int end=inp.length-1;
		while(mid<=end){
			if(inp[mid]==1){
				mid++;
			}
			else if(inp[mid]==0){
				int tmp=inp[mid];
				inp[mid]=inp[start];
				inp[start]=tmp;
				start++;
				mid++;			
			}
			else if(inp[mid]==2){
				int tmp=inp[mid];
				inp[mid]=inp[end];
				inp[end]=tmp;
				end--;	
			}
		}
	}


	public static void waveArr(int[] inp){

		for(int i=0;i<inp.length;i++){
			int hole=i;
			int val=inp[i];
			while(hole>0&&val>inp[hole-1]){
				inp[hole]=inp[hole-1];
				hole--;
			}
			inp[hole]=val;
		}

		for(int i=1;i<inp.length-1;i+=2){
			int tmp=inp[i];
			inp[i]=inp[i+1];
			inp[i+1]=tmp;
		}

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER SIZE:");
		int size=s.nextInt();
//		int[] input=new int[size];
//		for(int i=0;i<size;i++){
//			input[i]=size-i;
//		}
				int[] input=createArr(size);
		//		int size1=s.nextInt();
		//		int[] input2=createArr(size1);
		//		int max=arrMax(input);
		//		System.out.println("MAXIMUM VAL:"+max);
		//		System.out.println("ENTER THE ELEMENT TO SEARCH:");
		//		int ele=s.nextInt();
		//		int index=searchArr(input,ele);
		//		int ele=s.nextInt();
		//		int r=binarySch(input,ele);
		//		System.out.println(r);
		//		System.out.println(index);
		//		int[] rev =reverseArr(input);
		//		printArr(rev);
		//		bubbleSort(input);
		//		System.out.println("BUBBLE SORT:");
		//		System.out.println("SELECTION SORT:");
		//		selSort(input);
		//		int[] input=dec2bin();
		//      sumsep(input);
		//		input=arrIntsec(input,input2);
				int x=s.nextInt();
		//		findPair(input,x);
		//      int sum[]=arrSum(input,input2);
		//	    printArr(sum);
		//		int dup=duplicate(input);
		//		System.out.println(dup);
		//		long starttime=System.currentTimeMillis();
		//				insSort(input);
		//		long endtime=System.currentTimeMillis();
		//		System.out.println(endtime-starttime);
		//		sortBin(input);
		//		sortTri(input);
				findTrip(input,x);
		//		waveArr(input);
		//		printArr(input);



	}

}
