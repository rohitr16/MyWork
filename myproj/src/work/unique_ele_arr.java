package work;

public class unique_ele_arr {
	
	static int size=32;
	static int n=3;
	
	public static int getUniqueDupTwice(int[] inp){
		
		int result=0;
		int sum=0;
		
		for(int i=0;i<size;i++){
			
			sum=0;
			int a=1<<i;
			for(int j=0;j<inp.length;j++){			
				if((a & inp[j])!=0){
					sum++;
				}		
			}
			if(sum%n!=0)
				result|=a;
		}
		return result;
	}
	
	public static int getUnique(int[] inp){
		
		int ones=0;
		int twos=0;
		int common_bit;
		
		for(int i=0;i<inp.length;i++){
			
			//2nd,5th,8th time bits
			twos|=(ones&inp[i]);
			//1st,4th,7th time bits
			ones^=inp[i];
			//eliminate bit coming 3rd,6th,9th time i.e common bits of ones and twos
			common_bit=~(ones&twos);
			
			ones&=common_bit;
			twos&=common_bit;
		}
		
		return ones;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inp={3,3,3,2,2,2,4};
		System.out.println(getUniqueDupTwice(inp));
		System.out.println(getUnique(inp));
		System.out.println((char)0);

	}

}
