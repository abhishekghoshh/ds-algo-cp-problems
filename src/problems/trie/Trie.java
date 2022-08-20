package problems.trie;

public class Trie {
	private static final int ALPHABET_SIZE = 26;
	private TrieNode trieNode;

	private Trie() {
		trieNode = new TrieNode();
	}

	public void insert(String word) {
		if (null != word && !word.isBlank()) {
			TrieNode trieNode = this.trieNode;
			for (int i = 0; i < word.length(); i++) {
				int position = getAsciiValue(Character.toLowerCase(word.charAt(i)));
				if (hasNoChildren(trieNode, position)) {
					trieNode.children[position] = new TrieNode();
				}
				trieNode = trieNode.children[position];
			}
			trieNode.isEndOfWord = true;
		}
	}

	public boolean search(String word) {
		if (null != word && !word.isBlank()) {
			TrieNode trieNode = this.trieNode;
			for (int i = 0; i < word.length(); i++) {
				int position = getAsciiValue(Character.toLowerCase(word.charAt(i)));
				if (hasChildren(trieNode, position)) {
					trieNode = trieNode.children[position];
				} else {
					return false;
				}
			}
			return trieNode.isEndOfWord;
		}
		return false;
	}

	private boolean hasNoChildren(TrieNode trieNode, int position) {
		return trieNode.children[position] == null;
	}

	private boolean hasChildren(TrieNode trieNode, int position) {
		return trieNode.children[position] != null;
	}

	private int getAsciiValue(char ch) {
		return ch - 'a';
	}

	private class TrieNode {
		TrieNode[] children;
		boolean isEndOfWord;

		TrieNode() {
			this.children = new TrieNode[ALPHABET_SIZE];
			this.isEndOfWord = false;
		}

	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("Abhishek");
		trie.insert("Nasim");
		System.out.println(trie.search("Abhishek"));
		System.out.println(trie.search("Abhi"));
		System.out.println(trie.search("Buddhu"));
		System.out.println(trie.search("Nasim"));

	}
}
