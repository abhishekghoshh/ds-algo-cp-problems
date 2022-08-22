package problems.trie;

import java.util.ArrayList;
import java.util.List;

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
				if (hasNoChildren(trieNode, position)) {
					return false;
				}
				trieNode = trieNode.children[position];
			}
			return trieNode.isEndOfWord;
		}
		return false;
	}

	public List<String> prefixSearch(String word) {
		List<String> words = new ArrayList<>();
		if (null != word && !word.isBlank()) {
			TrieNode trieNode = this.trieNode;
			for (int i = 0; i < word.length(); i++) {
				int position = getAsciiValue(Character.toLowerCase(word.charAt(i)));
				if (hasNoChildren(trieNode, position)) {
					return words;
				}
				trieNode = trieNode.children[position];
			}
			prefixSearch(words, trieNode, new StringBuilder(word));
		}
		return words;
	}

	private void prefixSearch(List<String> words, TrieNode trieNode, StringBuilder word) {
		if (null != trieNode) {
			if (trieNode.isEndOfWord) {
				words.add(word.toString());
			}
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				if (hasChildren(trieNode, i)) {
					prefixSearch(words, trieNode.children[i], word.append((char) (97 + i)));
					word.deleteCharAt(word.length() - 1);
				}
			}
		}
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
		trie.insert("Abhishikta");
		trie.insert("Nasim");
		System.out.println(trie.search("Abhishek"));
		System.out.println(trie.search("Abhi"));
		System.out.println(trie.search("Buddhu"));
		System.out.println(trie.search("Nasim"));
		System.out.println(trie.prefixSearch("ab"));

	}
}
