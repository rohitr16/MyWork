package myproj;

import dataStructure2.Heap;

public class K_sorted_Array {

	public static void kSortedArray(int[] input,int k){

		Heap<Integer> heap=new Heap<>();
		
		for(int i=0;i<input.length;i+=k){	

			for(int j=i;j<i+k;j++)
				heap.insert(input[j],input[j]);
			for(int j=i;j<i+k;j++){
				input[j]=heap.MinValue();
				heap.removeMin();

			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={2,3,1,6,5,4};
		kSortedArray(input, 3);
		for(int i=0;i<input.length;i++){
			System.out.println(input[i]);
		}

	}

}
