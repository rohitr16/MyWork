package dataStructure2;

public class Trie {

	TrieNode root;

	public Trie(){

		root=new TrieNode('\0');
	}
	

	public void addWord(String word){

		addWord(root,word);
	}

	private void addWord(TrieNode root,String word){

		if(word.length()==0){
			root.isTerminal=true;
			return;
		}

		TrieNode child=root.children.get(word.charAt(0));
		
		if(child==null){
		
			child=new TrieNode(word.charAt(0));
			root.children.put(word.charAt(0), child);
		}
		
		addWord(child,word.substring(1));
	}
	
	
	public void removeWord(String word){
		
		remove(root,word);
	}
	
	private void remove(TrieNode root,String word){	
		
		if(word.length()==0){
			root.isTerminal=false;
			return;
		}
		
		TrieNode child=root.children.get(word.charAt(0));
		
		if(child==null){
			return;
		}
		
		remove(child, word.substring(1));
		if(!child.isTerminal&&child.children.size()==0){
			root.children.remove(word.charAt(0));
		}
	}
	
	public boolean findWord(String word){
		
		if(find(root,word)){
			return true;
		}
		return false;
	}
	
	private boolean find(TrieNode root,String word){
		
		if(word.length()==0){
			if(root.isTerminal){
				return true;
			}
			return false;
		}
		
		TrieNode child=root.children.get(word.charAt(0));
		if(child==null){
			return false;
		}
		
		return  find(child, word.substring(1));
	}
	
}
