package Dynamicpgmng;

public class MatrixMulti {

	public static int matrixChainMul(int[] input){

		int[][] matrix=new int[input.length][input.length];

		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				if(i==j){
					matrix[i][j]=0;
				}
				else{
					matrix[i][j]=-1;
				}
			}
		}
		return matrixChain( input,matrix); 
	}

	public static int matrixChain(int[] input,int[][] matrix){

		int minCount=Integer.MIN_VALUE;

		for(int l=2;l<input.length;l++){

			for(int i=0;i<input.length-l;i++){
				
				int j=l+i-1;
				int product=0;
				
				if(matrix[i][j]!=-1){
					
					break;
				}
				for(int k=i;k<=j;k++){
					
					product=matrix[i][k]+matrix[k+1][j]+input[i]*input[k]*input[j];	

					if(product<minCount){
						
						product=minCount;
					}
				}
				
				matrix[i][j]=minCount;		
			}
		}
		
		return minCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input={5,10,15,20};
		matrixChainMul(input);


	}

}
