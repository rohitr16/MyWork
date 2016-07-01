package oops;

import java.util.HashMap;
import java.util.Hashtable;

public class PatternMatching {

	public static boolean matchPattern(String str,String patern){

		for(int i=0;i<=str.length()-patern.length();i++){

			if(str.charAt(i)==patern.charAt(0)){
				int j=0;
				for(j=1;j<patern.length();j++){
					if(str.charAt(i+j)!=patern.charAt(j)){
						break;
					}
				}
				if(j==patern.length()){
					return true;
				}
			}
		}
		return false;
	}

	public static boolean BoyerMoore(String str,String pattern){

		HashMap<Character, Integer> map=new HashMap<>();

		for(int i=0;i<pattern.length();i++){
			map.put(pattern.charAt(i), i);
		}

		for(int i=pattern.length()-1;i<str.length();){

			int j=0;

			while(j<pattern.length()){
				if(str.charAt(i-j)!=pattern.charAt(pattern.length()-1-j)){
					break;
				}
				j++;
			}
			if(j==pattern.length()){
				System.out.println(i-j+1);
				return true;

			}
			else{
				if(!map.containsKey(str.charAt(i-j))){
					i+=pattern.length()-j;

				}
				else{
					int lastIndex=map.get(str.charAt(i-j));

					if(lastIndex>pattern.length()-1-j){
						i++;
					}
					else{
						i+=pattern.length()-lastIndex-1-j;

					}
				}	
			}	
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//"aasdcdashsa", "assecd"
		System.out.println(matchPattern("ahsaghjckkhkjdfade", "fade"));
		System.out.println(BoyerMoore("ahdfaaede", "ede"));

	}

}
