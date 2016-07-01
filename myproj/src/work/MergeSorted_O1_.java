package work;

public class MergeSorted_O1_ {
	
	public static void mergeArray(int[] arr1,int[] arr2){
		
		for(int i=arr2.length-1;i>=0;i--){
			int last=arr1[arr1.length-1];
			int j=0;
			for( j=arr1.length-1;j>=0 && arr1[j]>arr2[i];j--){
				
				arr1[j]=arr1[j-1];
			}
			if(j!=arr1.length-1){
				arr1[j+1]=arr2[i];
				arr2[i]=last;
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1={1, 5, 9, 10, 15, 20};
		int[] arr2={2,3,8,13};
		mergeArray(arr1, arr2);
		for(int i=0;i<arr1.length;i++){
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		for(int i=0;i<arr2.length;i++){
			System.out.print(arr2[i]+" ");
		}
 
	}

}
