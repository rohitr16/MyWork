package dataStructure2;

public class TrieUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trie trie=new Trie();
		trie.addWord("NOT");
		trie.addWord("NOTE");
		trie.addWord("DO");
		trie.addWord("DOT");
		trie.addWord("QUE");
		System.out.println(trie.findWord("NOT"));
		trie.removeWord("NOTE");
		System.out.println(trie.findWord("NOT"));
		
	}

}
