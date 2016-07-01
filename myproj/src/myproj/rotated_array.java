package myproj;


import java.util.Scanner;

public class rotated_array {
	
	private static Scanner s;
	
	public static int rotatek(int[] input){
		int k=0;
		int i=0;
		
		for( i=0;i<input.length-1;i++){
			if(input[i]>input[i+1]){
				k=i+1;
				break;
			}
		}
		return k;
	}
	
	public static int rotatebin(int[] inp){
		int low=0;
		int high=inp.length-1;
		while(low<=high){
			int mid=(high+low)/2;
			if(mid>0&&inp[mid]<inp[mid-1]){
				return mid;
			}
			 if(inp[mid]>inp[high])
				low=mid+1;
			else
				high=mid-1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner(System.in);
		System.out.println("ENTER THE SIZE OF ARR:");
		int size=s.nextInt();
		int input[]=new int[size];
		for(int i=0;i<size;i++){
			input[i]=s.nextInt();
		}
		int pivot=rotatek(input);
	//	int pivot=rotatebin(input);
		System.out.println(pivot);
	}
}
