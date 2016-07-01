package work;




/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;



public class dpHAA {
	
	
	public static int max(int a,int b){
		
		if(a>=b){
			return a;
		}
		return b;
	}
	
    public static void main(String args[] ) throws Exception {
       

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        
       
        
        while(t>0){
        	
        
        	line=br.readLine();
        	 
			String[] strs = line.trim().split("\\s+");
			
    		int n = Integer.parseInt(strs[0]);
    		int k = Integer.parseInt(strs[1]);
		
        	
        	line=br.readLine();
        	String[] strs1 = line.trim().split("\\s+");
        	
        	int[] inp=new int[n];
        	
        	 
        	
        	for(int i=0;i<n;i++){
        		
        		inp[i]=Integer.parseInt(strs1[i]);;
        	}
        	
        	int[] table=new int[n];
        	
        	if(inp[0]>=0){
        	table[0]=inp[0];
        	}
        	else{
        		table[0]=0;
        	}
        	
        	for(int i=1;i<n;i++){
        	
        	  if(i<=k){
            	table[i]=max(table[i-1],inp[i]);
        	  }
        	
        	  else{
        		 table[i]=max(table[i-k-1]+inp[i],table[i-1]);
        	  }
        		
       	   }
        
         System.out.println(table[n-1]);	
        	
        	--t;
        	
        }
       
        
        

       
    }
}
