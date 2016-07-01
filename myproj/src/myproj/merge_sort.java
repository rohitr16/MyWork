package myproj;
import java.util.Scanner;

public class merge_sort {

	private static Scanner s;
	
	public static void quickSort(int[] input,int start,int end){
		
		if(start<end){
			int pivot=quick(input,start,end);
			quickSort(input, start, pivot-1);
			quickSort(input, pivot+1, end);
			
		}
	}
	
	public static int quick(int[] input,int start,int end){
		
		int val=input[start];
		int index=end;
		
		for(int i=end;i>start;i--){
			if(val<=input[i]){
				int tmp=input[index];
				input[index]=input[i];
				input[i]=tmp;
				index--;
			}	
		}
		input[start]=input[index];
		input[index]=val;
		return index;
	}

	public static void mergeSort(int[] input,int[] aux,int start,int end){

		if(start<end){
			int mid=(start+end)/2;
			mergeSort(input,aux,start,mid);
			mergeSort(input,aux,mid+1,end);
			merge(input,aux,start,mid,end);	
		}
	}

	public static void merge(int[] input,int[] aux,int start,int mid,int end){

		for(int i=start;i<=end;i++){
			aux[i]=input[i];
		}

		int left=start;
		int right=mid+1;
		int current=start;

		while(left<=mid&&right<=end){

			if(input[left]<input[right]){
				input[current]=aux[left];
				left++;
			}
			else{
				input[current]=aux[right];
				right++;
			}
			current++;
		}
		
		while(left<=mid){
			input[current]=aux[left];
			current++;
			left++;
		}
		while(right<=end){
			input[current]=aux[right];
			current++;
			right++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		s=new Scanner (System.in);
		System.out.println("ENTER THE SIZE OF ARRAY:");
		int size=s.nextInt();
		int[] input=new int[size];
		for(int i=0;i<size;i++){
			input[i]=s.nextInt();
		}
	//	int[] aux=new int[size];
		//mergeSort(input,aux,0,input.length-1);
		quickSort(input, 0, input.length-1);
		for(int i=0;i<input.length;i++){
			System.out.print(input[i]+" ");
		}
	}

}
