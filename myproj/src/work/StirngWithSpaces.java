package work;

public class StirngWithSpaces {

	public static void printStringPer(String str,int i,int n){

		if(i>=n){
			System.out.println(str);
			return;
		}

		printStringPer(str,i+1,n);

		if(i<str.length()-1){

			str=str.substring(0,i+1)+" "+str.substring(i+1);	
			printStringPer(str,i+2,n);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="ABCD";
		int n=2*str.length()-3;
		String out="";
		printStringPer(str, 0,n);


	}

}
