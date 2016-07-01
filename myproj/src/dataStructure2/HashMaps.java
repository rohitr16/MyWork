package dataStructure2;

import java.util.HashMap;
import java.util.ArrayList;

import myproj.charcheck;

public class HashMaps {
	
	public static void printIntersection(int[] input1,int[] input2){
		
		HashMap<Integer, Integer> map=new HashMap<>();
		
		for(int ele:input1){
			if(!map.containsKey(ele))
			map.put(ele,1);
			else{
				int k=map.get(ele);
				k++;
				map.put(ele,k);
			}
		}
		
		for(int ele:input2){
			if(map.containsKey(ele)){
			int k=map.get(ele);
			if(k>0){
				System.out.println(ele);
			}
			k--;
			map.put(ele, k);
			}	
		}
		
	}
	
	public static int[] removeDup(int[] input){
		
		HashMap<Integer, Boolean> map=new HashMap<>();
		
		int size=0;
		for(int ele:input){
			if(!map.containsKey(ele)){
				map.put(ele, true);
				size++;
			}	
		}
		map.clear();
		
		int[] newArr=new int[size];
		int i=0;
		
		for(int ele:input){
			if(!map.containsKey(ele)){
				map.put(ele, true);
				newArr[i++]=ele;
			}	
		}
		return newArr;	
	}
	
	public static void printPairs(int input[],int sum){
		
		HashMap<Integer, Integer> map=new HashMap<>();
		
		
		for(int ele:input){
			if(!map.containsKey(ele))
				map.put(ele, 1);
			else{
				int k=map.get(ele);
				k++;
				if(ele==sum-ele){
					k=fact(k)/fact(k-1);
				}
				map.put(ele,k);
			}
		}
		
		for(int ele:input){
			if(map.containsKey(sum-ele)){
					int k=map.get(sum-ele);
					
					for(int i=0;i<k;i++){
						System.out.println(ele+" "+(sum-ele));
				}
				map.remove(ele);
				}
			}
		
		}
	
	public  static int fact(int n){
		
		if(n==0){
			return 1;
		}
		
		return n*fact(n-1);
	}
	
	public static ArrayList<Character> getUniqueChar(String str){
		
	  ArrayList<Character>  out=new ArrayList<>();
		
		dataStructure2.HashMap<Character, Integer> map=new dataStructure2.HashMap<>();
		
		for(int i=0;i<str.length();i++){
			
			if(map.get(str.charAt(i))==null)
			map.put(str.charAt(i), 1);
			else{
				int k=map.get(str.charAt(i));
				k++;
				map.put(str.charAt(i), k);
			}
		}
		
		for(int i=0;i<str.length();i++){
			
			if(map.get(str.charAt(i))==1){
				out.add(str.charAt(i));
			}
		}	
		return out;
	}
	
	
	public static int MaxFreq(int[] input){
		
		dataStructure2.HashMap<Integer, Integer> map=new dataStructure2.HashMap<>();
		
		for(int ele:input){
			if(map.get(ele)==null)
			map.put(ele, 1);
			else{
				int k=map.get(ele);
				k++;
				map.put(ele, k);
			}
		}
		
		int maxFreq=Integer.MIN_VALUE;
		int max=0;
		for(int ele:input){
			if(maxFreq<map.get(ele)){
				max=ele;
				maxFreq=map.get(ele);
			}	
		}
		return max;
	}
	
	public static ArrayList<Integer> consecIntegers(int[] input){
		
		ArrayList<Integer> out=new ArrayList<>();
		dataStructure2.HashMap<Integer, Integer> map=new dataStructure2.HashMap<Integer, Integer>();
		
		for(int ele:input){
			map.put(ele,0);
		}
		
		int maxLength=0;
		int ans=0;
		for(int ele:input){
			if(map.get(ele+1)!=null&&map.get(ele-1)==null){
				int j=ele+1;
				while(map.get(j)!=null){
					j++;
				}	
				if(maxLength<j-ele){
					maxLength=j-ele;
					ans=ele;
				}
			}
		}
		while(map.get(ans)!=null){
			out.add(ans);
			ans++;
		}
		return out;
	}

	public static void main(String[] args) {

		int[] input={5,7,2,11,4,9,13,10,12};
		int[] input2={3,4,2,7,9,2};
	//	printIntersection(input1, input2);
		
//		int[] out=removeDup(input1);
//		for(int i=0;i<out.length;i++){
//			System.out.println(out[i]);
//		}
		
//		printPairs(input1, 4);
		
//		dataStructure2.HashMap<String, Integer> map=new dataStructure2.HashMap<>();
//		map.put("abcd", 1);
//		System.out.println(map.get("abcd")+" "+map.size());	
//		map.remove("abcd");
//		System.out.println(map.get("abcd")+" "+map.size());
		
//		ArrayList<Character> out=getUniqueChar("abcbdea");
//		for(int i=0;i<out.size();i++){
//			System.out.println(out.get(i));
//		}
		
//		System.out.println(MaxFreq(input2));
		
//		ArrayList<Integer> out=consecIntegers(input);
//		for(int i=0;i<out.size();i++){
//			System.out.print(out.get(i)+" ");
//		}
//		
		String str1="abs";
		String str2="acs";
		if(str1.charAt(0)>=str2.charAt(0)){
			
		}
	}

}
