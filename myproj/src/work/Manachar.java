package work;

public class Manachar {
	
	public static void ManacharAlgo(String str){
		
		int N=2*str.length()+1;
		int L[]=new int[N];
		L[0]=0;
		L[1]=1;
		int C=1;
		int R=2;
		int iM=0;
		int diff;
		int maxLen=0;
		int maxCenter=0;
		
		for(int i=2;i<N;i++){
			
			iM=2*C-i;
			diff=R-i;
			L[i]=0;
			
			if(diff>0){
				L[i]=Math.min(L[iM], diff);
			}
			
			
			 while ( ((i + L[i]) < N && (i - L[i]) > 0) && 
			            ( ((i + L[i] + 1) % 2 == 0) ||
			            (((i + L[i]+1) < N && (i - L[i]-1) > 0)&&str.charAt((i + L[i] + 1)/2) == str.charAt((i - L[i] - 1)/2) ))){
				
				L[i]++;
				
			}
			
			if(L[i]>maxLen){
				maxLen=L[i];
				maxCenter=i;
			}
			
			if(i+L[i]>R){
				
				C=i;
				R=i+L[i];
			}	
		}
		
		int start=(maxCenter-maxLen)/2;
		int end=start+maxLen;
		
		System.out.println(str.substring(start, end));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ManacharAlgo("forgeeksskeegfor");

	}

}
