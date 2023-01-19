package trie;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/complete-string_2687860?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=AWnBa91lThI&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=3
 * 
 */
public class CompleteString {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		String[] arr = { "n", "ni", "nin", "ninj", "ninja" };
		Trie trie = new Trie();
		for (String word : arr) {
			trie.insert(word);
		}
		String answer = "";
		for (String word : arr) {
			// either the word length is bigger
			// or lexicographically lesser than the previous answer
			if ((word.length() > answer.length() || (word.length() == answer.length() && word.compareTo(answer) < 0))
					&& trie.checkCompleteString(word)) {
				answer = word;
			}
		}
		System.out.println(answer);
	}

	private static class Trie {
		private static final int ALPHABET_SIZE = 26;
		private Node head;

		public Trie() {
			head = new Node();
		}

		public boolean checkCompleteString(String word) {
			if (null == word || word.isBlank())
				return false;
			Node node = head;
			char[] arr = word.toLowerCase().toCharArray();
			for (char ch : arr) {
				if (node.isNull(ch) || !node.get(ch).isEnd()) {
					return false;
				}
				node = node.get(ch);
			}
			return node.isEnd();
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

	// brute force approach
	private static void type1() {

	}

}
