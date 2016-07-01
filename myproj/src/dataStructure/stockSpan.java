package dataStructure;

import java.util.Scanner;

public class stockSpan {
	
	public static int[] stock(int[] input){
		int[] out=new int[input.length];
		StackLL<Integer> stack=new StackLL<>();
		out[0]=1;
		stack.push(0);
		for(int i=0;i<input.length;i++){
			
			while(stack.top!=null&&input[stack.top.data]<=input[i])
				stack.pop();
			
			if(stack.top==null){
				out[i]=i+1;
			}
			else{
				out[i]=i-stack.top.data;
			}
			stack.push(i);
		}
		
		return out;
	}
	
	public static int[] StockSpan(int[] input){
		int[] stockSpan=new int[input.length];
		StackLL<Integer> stack=new StackLL<>();
		stockSpan[0]=1;
		for(int i=1;i<input.length;i++){
			if(input[i]<input[i-1]){
				stack.push(i-1);
				stockSpan[i]=1;
			}
			if(input[i]>input[i-1]&&input[stack.top.data]>input[i]){
				stockSpan[i]=stockSpan[i-1]+1;
			}
			if(input[stack.top.data]<input[i]){
				
				while((stack.top!=null)&&input[stack.top.data]<=input[i]){
					stack.pop();
				}
				if(stack.top==null)
					stockSpan[i]=i+1;
				else
				stockSpan[i]=i-stack.top.data;
				stack.push(i);
			}
		}
		
		return stockSpan;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//100 80 60 70 60 75 85
		Scanner s=new Scanner(System.in);
		System.out.println("ENTER THE SIZE :");
		int size=s.nextInt();
		int[] stockSpan=new int[size];
		for(int i=0;i<size;i++){
			stockSpan[i]=s.nextInt();
		}
	//	int[] out=StockSpan(stockSpan);
		int[] out=stock(stockSpan);
		for(int i=0;i<size;i++){
			System.out.print(out[i]+" ");
		}

	}

}
