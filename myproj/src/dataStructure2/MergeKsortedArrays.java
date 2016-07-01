package dataStructure2;

import java.util.*;

public class MergeKsortedArrays {
	
	private static Scanner s;

	public static ArrayList<Integer> mergeKsortedArrays(ArrayList<ArrayList<Integer>> input,int k){

		ArrayList<Integer> out=new ArrayList<>();
		Heap<Integer> heap=new Heap<>();

		for(int i=0;i<k;i++){
			heap.insert(input.get(i).get(0), i);	
		}



		while(!heap.isEmpty()){

			out.add(heap.MinPriority());
			int index=heap.MinValue();
			heap.removeMin();
			input.get(index).remove(0);
			if(input.get(index).size()>0){
				heap.insert(input.get(index).get(0),index);
			}	
		}
		return out;
	}

	public static void main(String[] args) {

		//2 4 6 8 10 1 2 5 7 9 3 6 11 15
		s=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> input=new ArrayList<>();
		
		System.out.println("ENTER NO OF ARRAYLISTS TO MERGE:");
		int k=s.nextInt();
		for(int i=0;i<k;i++){
			ArrayList<Integer> temp=new ArrayList<>();
			int length=s.nextInt();
			for(int j=0;j<length;j++){
				temp.add(s.nextInt());
			}
			input.add(temp);
		}
		
		ArrayList<Integer> out=mergeKsortedArrays(input, k);
		
		for(int ele:out){
			System.out.println(ele);
		}
	}

}
