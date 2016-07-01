package myproj;

import java.util.Scanner;



public class Maximum_path {

	public static int MaximuPath(int arr1[],int arr2[]){

		int i=0;
		int j=0;
		int sum=0;
		int sum1=0,sum2=0;
		boolean flag=false;

		while(i<arr1.length&&j<arr2.length){
			if(arr1[i]==arr2[j]){
				sum+=arr1[i];
				sum+=(sum1>=sum2)?sum1:sum2;
				i++;
				j++;
				sum1=0;
				sum2=0;
				flag=true;
			}
			else if(arr1[i]<arr2[j]){
				sum1+=arr1[i];
				i++;
			}
			else if(arr1[i]>arr2[j]){
				sum2+=arr2[j];			
				j++;
			}
		}
		
		if(!flag){
		
			i=0;
			j=0;
			while(i<arr1.length){
				sum1+=arr1[i];
				i++;
			}
			while(j<arr2.length){
				sum2+=arr2[j];
				j++;
			}
			return (sum1>sum2)?sum1:sum2;
		}

		while(i<arr1.length){
			sum+=arr1[i];
			i++;
		}
		while(j<arr2.length){
			sum+=arr2[j];
			j++;
		}
		
		return sum;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner (System.in);
		System.out.println("SIZE 1:-");
		int size_1=s.nextInt();
		System.out.println("SIZE_2:-");
		int size_2=s.nextInt();

		int arr1[]=new int[size_1];
		int arr2[]=new int[size_2];

		for(int i=0;i<size_1;i++){
			arr1[i]=s.nextInt();
		}
		for(int i=0;i<size_2;i++){
			arr2[i]=s.nextInt();
		}
		System.out.println(MaximuPath(arr1, arr2));
	}

}
