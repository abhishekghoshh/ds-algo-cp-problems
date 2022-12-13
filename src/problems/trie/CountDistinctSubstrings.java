package problems.trie;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/count-distinct-substrings_985292?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos
 * https://www.codingninjas.com/codestudio/problems/number-of-distinct-substring_1465938?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=RV0QeTyHZxo&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=4
 * 
 * https://takeuforward.org/data-structure/number-of-distinct-substrings-in-a-string-using-trie/
 * 
 */
public class CountDistinctSubstrings {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// modified trie approach
	// time complexity O(n^2)
	private static void type2() {
		String str = "abab";
		char[] arr = str.toCharArray();
		int n = arr.length;
		int count = 0;
		Node root = new Node();
		for (int i = 0; i < n; i++) {
			Node node = root;
			for (int j = i; j < n; j++) {
				char ch = arr[j];
				// we are adding 1 to count every time we have encountered one new children
				// which is null, children is null means by adding the character we can make a
				// new substring
				if (node.isNull(ch)) {
					node.put(ch, new Node());
					count++;
				}
				node = node.get(ch);
			}
		}
		// +1 for the empty substring
		count++;
		System.out.println(count);
	}

	public static class Node {
		Node links[] = new Node[26];

		boolean isNull(char ch) {
			return links[ch - 'a'] == null;
		}

		Node get(char ch) {
			return links[ch - 'a'];
		}

		void put(char ch, Node node) {
			links[ch - 'a'] = node;
		}
	};

	// using trie
	// time complexity is O(n^3)
	private static void type1() {
		String str = "abab";
		char[] arr = str.toCharArray();
		int count = 0;
		Trie trie = new Trie();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				// we are adding the s.substring(i,j)
				if (trie.insert(arr, i, j))
					count++;
			}
		}
		// +1 for the empty substring
		count++;
		System.out.println(count);
	}

	public static class Trie {
		private static final int ALPHABET_SIZE = 26;
		private Node head;

		public Trie() {
			head = new Node();
		}

		public boolean insert(char[] arr, int start, int end) {
			Node node = head;
			for (int i = start; i <= end; i++) {
				char ch = arr[i];
				if (node.isNull(ch)) {
					node = node.set(ch);
				} else {
					node = node.get(ch);
				}
			}
			// if the end is already set that means the word is not unique
			if (node.isEnd())
				return false;
			// word is unique so we can set the end
			// and return true
			node.setEnd();
			return true;
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

}
