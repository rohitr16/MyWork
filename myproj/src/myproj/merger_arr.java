package myproj;
import java.util.Scanner;

public class merger_arr {

	private static Scanner s;

	public static int[] mergeArr(int[] input1,int[] input2){

		int size=input1.length+input2.length;
		int[] merge=new int[size];
		int i=0,j=0,k=0;
		while(i<input1.length&&j<input2.length){

			if(input1[i]<input2[j]){
				merge[k]=input1[i];
				i++;
				k++;
			}
			else if(input1[i]>input2[j]){
				merge[k]=input2[j];
				j++;
				k++;
			}
			else if(input1[i]==input2[j]){
				merge[k]=input1[i];
				k++;
				merge[k]=input2[j];
				k++;
				i++;
				j++;
			}
		}	
		if(i<input1.length){
			while(i<input1.length){
				merge[k]=input1[i];
				k++;
				i++;
			}	
		}
		 if(j<input2.length-1){
			while(j<input2.length){
				merge[k]=input2[j];
				k++;
				j++;
			}
		}
		return merge;


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		s=new Scanner (System.in);
		System.out.println("ENTER SIZE:");
		int size1=s.nextInt();
		int size2=s.nextInt();
		int[] input1=new int[size1];
		int[] input2=new int[size2];
		for(int i=0;i<size1;i++){
			input1[i]=s.nextInt();
		}
		for(int i=0;i<size2;i++){
			input2[i]=s.nextInt();
		}
		int out[]=mergeArr(input1,input2);
		for(int i=0;i<out.length;i++){
			System.out.print(out[i]+" ");
		}

	}

}
