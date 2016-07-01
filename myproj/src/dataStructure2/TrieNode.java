package dataStructure2;

import java.util.HashMap;

public class TrieNode {
	
	boolean isTerminal;
	char name;
	HashMap<Character, TrieNode> children;
	
	public TrieNode(char name){
		
		this.name=name;
		children=new HashMap<>();
		isTerminal=false;
	}

}
