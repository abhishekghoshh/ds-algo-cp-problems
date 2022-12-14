package problems.trie;

import java.util.ArrayList;
import java.util.List;
/*
 * Problem link :
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * https://www.codingninjas.com/codestudio/problems/implement-trie_631356?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=dBGUmUQhjaM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp
 * 
 * https://takeuforward.org/data-structure/implement-trie-1/
 * 
 */

public class Trie {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("Abhishek");
		trie.insert("Abhishikta");
		trie.insert("Nasim");
		System.out.println(trie.search("Abhishek"));
		System.out.println(trie.search("Abhi"));
		System.out.println(trie.search("Buddhu"));
		System.out.println(trie.prefixSearch("Abhi"));
		System.out.println(trie.prefixSearch("Abhishiktaaa"));

	}

	private static final int ALPHABET_SIZE = 26;
	private Node head;

	public Trie() {
		head = new Node();
	}

	public void insert(String word) {
		if (null == word || word.isBlank())
			return;
		Node node = head;
		char[] arr = word.toLowerCase().toCharArray();
		for (char ch : arr) {
			if (node.isNull(ch)) {
				node = node.set(ch);
			} else {
				node = node.get(ch);
			}
		}
		node.setEnd();
	}

	public boolean search(String word) {
		if (null == word || word.isBlank())
			return false;
		Node node = head;
		char[] arr = word.toLowerCase().toCharArray();
		for (char ch : arr) {
			if (node.isNull(ch))
				return false;
			node = node.get(ch);
		}
		return node.isEnd();
	}

	public boolean startsWith(String prefix) {
		if (null == prefix || prefix.isBlank())
			return false;
		Node node = head;
		char[] arr = prefix.toLowerCase().toCharArray();
		for (char ch : arr) {
			if (node.isNull(ch))
				return false;
			node = node.get(ch);
		}
		return true;
	}

	public List<String> prefixSearch(String prefix) {
		List<String> words = new ArrayList<>();
		if (null == prefix || prefix.isBlank())
			return words;
		Node node = this.head;
		char[] arr = prefix.toLowerCase().toCharArray();
		for (char ch : arr) {
			if (node.isNull(ch))
				return words;
			node = node.get(ch);
		}
		return prefixSearch(words, node, new StringBuilder(new String(arr)));
	}

	private List<String> prefixSearch(List<String> words, Node node, StringBuilder word) {
		if (node.isEnd()) {
			words.add(word.toString());
		}
		for (char ch = 'a'; ch <= 'z'; ch++) {
			if (!node.isNull(ch)) {
				word.append(ch);
				prefixSearch(words, node.get(ch), word);
				word.deleteCharAt(word.length() - 1);
			}
		}
		return words;
	}

	// TODO complete this method
	public List<String> prefixSearch(String prefix, int n) {
		List<String> words = new ArrayList<>();
		if (null == prefix || prefix.isBlank())
			return words;
		// implement
		return words;
	}

	public class Node {
		private Node[] nodes;
		private boolean isEnd;

		Node() {
			this.nodes = new Node[ALPHABET_SIZE];
		}

		public boolean isEnd() {
			return this.isEnd;
		}

		public void setEnd() {
			this.isEnd = true;
		}

		public Node get(char ch) {
			return nodes[index(ch)];
		}

		public boolean isNull(char ch) {
			return null == nodes[index(ch)];
		}

		public Node set(char ch) {
			Node node = new Node();
			nodes[index(ch)] = node;
			return node;
		}

		private int index(char ch) {
			return ch - 'a';
		}
	}

}
