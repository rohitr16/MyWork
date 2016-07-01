package oops;

import java.util.Scanner;

public class gravity {
	
	private static Scanner s;
	
	public static int calDepth(int[] arr,int begin){
		
		int depth=0;
		
		for(int i=begin;i<arr.length-1;i++){
			
			if(arr[i]>arr[i+1]){
				depth++;
				arr[i+1]=arr[i];
			}
			else{
				arr[i+1]=arr[i];
				depth=depth+calDepth(arr, i+1);
				break;
			}		
		}
		return depth;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		int test=s.nextInt();
		
		while(test>0){
			int n=s.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=s.nextInt();
			}			
			int depth=calDepth(arr, 0);
			System.out.println(depth);
			test--;
		}
	}
}
