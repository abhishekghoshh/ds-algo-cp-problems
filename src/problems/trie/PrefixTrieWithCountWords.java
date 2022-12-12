package problems.trie;
/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/implement-trie_1387095?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=K5pcpkEMCN0&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=2
 * 
 * 
 * https://takeuforward.org/data-structure/implement-trie-ii/
 */

public class PrefixTrieWithCountWords {
	public static void main(String[] args) {
		PrefixTrieWithCountWords trie = new PrefixTrieWithCountWords();
		trie.insert("samsung");
		trie.insert("samsung");
		System.out.println(trie.countWordsEqualTo("samsung"));
		System.out.println(trie.countWordsStartingWith("samsung"));
		trie.erase("samsung");
		System.out.println(trie.countWordsEqualTo("samsung"));
		System.out.println(trie.countWordsStartingWith("sams"));

	}

	private static final int ALPHABET_SIZE = 26;
	private Node head;

	public PrefixTrieWithCountWords() {
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
			node.incrementCountPreffix();
		}
		node.incrementEndsWith();
	}

	public int countWordsEqualTo(String word) {
		if (null == word || word.isBlank())
			return 0;
		Node node = head;
		char[] arr = word.toLowerCase().toCharArray();
		for (char ch : arr) {
			if (node.isNull(ch)) {
				return 0;
			}
			node = node.get(ch);
		}
		return node.getEndsWith();
	}

	public int countWordsStartingWith(String word) {
		if (null == word || word.isBlank())
			return 0;
		Node node = head;
		char[] arr = word.toLowerCase().toCharArray();
		for (char ch : arr) {
			if (node.isNull(ch)) {
				return 0;
			}
			node = node.get(ch);
		}
		return node.getCountPreffix();
	}

	public void erase(String word) {
		if (null == word || word.isBlank())
			return;
		Node node = head;
		char[] arr = word.toLowerCase().toCharArray();
		// we will only erase an word if it is present
		erase(node, arr, 0);
	}

	private boolean erase(Node node, char[] arr, int i) {
		if (i == arr.length) {
			// at the last if there is any word which is ending
			// then only we will delete endsWith variable and return true
			if (node.getEndsWith() > 0) {
				node.decrementEndsWith();
				return true;
			} else {
				return false;
			}
		}
		char ch = arr[i];
		// as we are not deleting the links so we have to check if the count prefix is
		// greater than 0 or not
		if (!node.isNull(ch) && node.get(ch).getCountPreffix() > 0) {
			// erase will only return true if the there is the word found
			if (erase(node.get(ch), arr, i + 1)) {
				// if the word is found then we will decrement count prefix and return true
				node.get(ch).decrementCountPreffix();
				return true;
			}
		}
		return false;
	}

	public class Node {
		private Node[] nodes;
		private int countPreffix = 0;
		private int endsWith = 0;

		Node() {
			this.nodes = new Node[ALPHABET_SIZE];
		}

		public void incrementCountPreffix() {
			this.countPreffix++;
		}

		public void decrementCountPreffix() {
			this.countPreffix--;
		}

		public int getCountPreffix() {
			return countPreffix;
		}

		public void incrementEndsWith() {
			this.endsWith++;
		}

		public void decrementEndsWith() {
			this.endsWith--;
		}

		public int getEndsWith() {
			return endsWith;
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
