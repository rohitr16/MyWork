package Dynamicpgmng;

public class LeastEditDistance {
	
	public static int leastDist(String s,String t){
		
	int	dpArray[][]=new int[s.length()+1][t.length()+1];
	
	for(int i=0;i<dpArray.length;i++){
		for(int j=0;j<dpArray[i].length;j++){
			dpArray[i][j]=-1;
		}
	}
	return leastDistRe(s, t,dpArray);
		
	}
	
	public static int leastDistRe(String s,String t,int[][] dpArray){
		
		int m=s.length();
		int n=t.length();
		
		if(s.length()==0&&t.length()==0){
			dpArray[m][n]=0;
			return dpArray[m][n];
		}
		if(s.length()==0||t.length()==0){
			if(s.length()!=0){
				dpArray[m][n]=s.length();
				return dpArray[m][n];
			}
			else{
				dpArray[m][n]=t.length();
				return dpArray[m][n];
			}
		}
		
		if(dpArray[m][n]!=-1){
			return dpArray[m][n];
		}
		
		if(s.charAt(0)==t.charAt(0)){		
		
			dpArray[m][n]=leastDistRe(s.substring(1), t.substring(1), dpArray);
		}
		
		else{
			
			dpArray[m][n]=1+Math.min(leastDistRe(s, t.substring(1), dpArray),Math.min(leastDistRe(s.substring(1), t, dpArray), leastDistRe(s.substring(1), t.substring(1), dpArray)));
		}
		
		return dpArray[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(leastDist("b", "acd"));
		

	}

}
