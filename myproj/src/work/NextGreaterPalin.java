package work;

import java.util.HashMap;

public class NextGreaterPalin {

	public static String nextGreaterPalin(String str){

		int count=0;

		for(int i=0;i<str.length();i++){	
			if(str.charAt(i)=='9'){
				count++;
			}
		}
		if(count==str.length()){//999
			String newStr="";

			for(int i=0;i<str.length()+1;i++){
				if(i==0||i==str.length()){
					newStr=newStr+"1";
				}
				else{
					newStr=newStr+"0";
				}
			}
			return newStr;
		}

		int i,j;
		if(str.length()%2==0){
			i=str.length()/2-1;
			j=i+1;
		}
		else{
			i=str.length()/2-1;
			j=str.length()/2+1;
		}

		while(i>=0&&j<str.length()){
			if(str.charAt(i)==str.charAt(j)){
				i--;
				j++;
			}
			else{
				break;
			}
		}

		if(i<0){//1331||13931
			if(str.length()%2==0){
				i=str.length()/2-1;
				j=i+1;
				int carry;
				int temp=str.charAt(i)-48;
				carry=(temp+1)/10;
				temp=(temp+1)%10;
				str=str.substring(0, i)+temp+temp+str.substring(j+1,str.length());
				i--;
				j++;
				if(carry>0){
					while(i>=0&&carry>0){
						temp=str.charAt(i)-48;
						temp=(temp+carry);
						carry=temp/10;
						temp=temp%10;
						str=str.substring(0,i)+temp+str.substring(i+1, j)+temp+str.substring(j+1,str.length());
						i--;
						j++;
					}

				}
			}
			else{
				i=str.length()/2-1;
				j=str.length()/2+1;
				int carry;
				int temp=str.charAt(i+1)-48;
				carry=(temp+1)/10;
				temp=(temp+1)%10;
				str=str.substring(0, i+1)+temp+str.substring(j,str.length());
				if(carry>0){
					while(i>=0&&carry>0){
						temp=str.charAt(i)-48;
						temp=(temp+carry);
						carry=temp/10;
						temp=temp%10;
						str=str.substring(0,i)+temp+str.substring(i+1, j)+temp+str.substring(j+1,str.length());
						i--;
						j++;
					}
				}
			}
			return str;
		}

		if(i>=0&&j<str.length()&&(int)str.charAt(i)>(int)str.charAt(j)){//1325||14236
			int k=i;
			if(str.length()%2==0){
				while(k>=0){
					str=str.substring(0,i+1)+str.charAt(k);
					i++;
					k--;
				}
			}
			else{
				while(k>=0){
					str=str.substring(0,i+2)+str.charAt(k);
					i++;
					k--;
				}

			}
			return str;
		}
//1234||12946
		if(str.length()%2==0){
			i=str.length()/2-1;
			j=i+1;
			int carry;
			int temp=str.charAt(i)-48;
			carry=(temp+1)/10;
			temp=(temp+1)%10;
			str=str.substring(0, i)+temp+temp+str.substring(j+1,str.length());
			i--;
			j++;
			if(carry>0){
				while(i>=0&&carry>0){
					temp=str.charAt(i)-48;
					temp=(temp+carry);
					carry=(temp)/10;
					temp=temp%10;
					str=str.substring(0,i)+temp+str.substring(i+1, j)+temp+str.substring(j+1,str.length());
					i--;
					j++;
				}
			}
			int k=str.length()/2-1;
			i=k;
			while(k>=0){
				str=str.substring(0,i+1)+str.charAt(k);
				i++;
				k--;
			}
		}
		else{
			i=str.length()/2-1;
			j=str.length()/2+1;
			int carry;
			int temp=str.charAt(i+1)-48;
			carry=(temp+1)/10;
			temp=(temp+1)%10;
			str=str.substring(0, i+1)+temp+str.substring(j,str.length());
			if(carry>0){
				while(i>=0&&carry>0){
					temp=str.charAt(i)-48;
					temp=(temp+carry);
					carry=temp/10;
					temp=temp%10;
					str=str.substring(0,i)+temp+str.substring(i+1, j)+temp+str.substring(j+1,str.length());
					i--;
					j++;
				}
			}
			int k=str.length()/2-1;
			i=k;
			while(k>=0){
				str=str.substring(0,i+2)+str.charAt(k);
				i++;
				k--;
			}
		}
		return str;

	}
	
	public static int sum0SubArray(int[] input){
	
		HashMap<Integer, Integer> map=new HashMap<>();
		int sum=0;
		int maxLength=0;
		for(int i=0;i<input.length;i++){
			
			sum+=input[i];
			if(input[i]==0||maxLength==0){
				maxLength=1;
			}
			
			if(map.containsKey(sum)){
				int k=map.get(sum);
				maxLength=i-k;
			}
			else{
				map.put(sum, i);
			}
		}
		
		return maxLength;
		
	}
	
	public static int findAnsX(String str){
		
		int ansX=0;
		int sum=0;
		int y=0;
		int i;
		
		for(i=0;i<str.length();i++){
			if(str.charAt(i)=='+'){
				break;
			}
		   y=y*10+(str.charAt(i)-48);
		}
		while(str.charAt(i)!='='){
			i++;
		}
		for(i=i+1;i<str.length();i++){
			
			sum=sum*10+(str.charAt(i)-48);
		}
		
		System.out.println(y+" "+sum);
		ansX=sum-y;
		
		return ansX;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nextGreaterPalin("1245"));
		int[] input={15, -2, 2, -8, 1, 7, 10, 23};
		System.out.println(sum0SubArray(input));
		System.out.println(findAnsX("13+x=3722"));


	}

}
