package work;

public class mergeSortedArrays {
	
	public static int CountNumArrays(int[] input_1,int[] input_2){
		
		
		int i=0;
		int j=0;
		int count=0;
		int input1End=0;
		int input2End=0;
		
		while(i<input_1.length&&j<input_2.length){
			
			if(input_1[i]<input_2[j]){
				input1End+=1+input2End;
				i++;
				
			}
			else{
				input2End+=1+input1End;
				j++;
			}	
		}
		
		while(i<input_1.length){
			i++;
			input1End+=1+input2End;
		}
		
		while(j<input_2.length){
			j++;
			input2End+=1+input1End;
		}
		
		count=input1End+input2End+1;
		
		return count;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input_1={1,3,5,7};
		int[] input_2={2,4,6,8};
		System.out.println(CountNumArrays(input_1, input_2));

	}

}
