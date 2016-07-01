package dataStructure2;

public class k_largest {
	
	public static int[] KLargestElements(int[] input,int k){
		
		int[] out=new int[k];
		Heap<Integer> heap=new Heap<>();
		
		for(int i=0;i<k;i++){
			heap.insert(input[i], input[i]);
		}
		
		for(int i=3;i<input.length;i++){
			
			if(input[i]>heap.MinValue()){
				heap.removeMin();
				heap.insert(input[i], input[i]);
			}
		}
		
		for(int i=0;i<k;i++){
			out[i]=heap.MinValue();
			heap.removeMin();
		}
		
		return out;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input={3,5,1,2,7,11,8,9,36,13};
		int[] out=KLargestElements(input, 3);
		for(int ele:out){
			System.out.println(ele);
		}

	}

}
