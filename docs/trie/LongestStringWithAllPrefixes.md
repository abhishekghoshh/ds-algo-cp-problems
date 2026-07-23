# LongestStringWithAllPrefixes

**Topic:** `trie`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/complete-string_2687860)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/longest-common-prefix_2090383)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=AWnBa91lThI&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=3)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

either the word length is bigger or lexicographically lesser than the previous answer

```java
	private static void type3() {
		String[] arr = {"n", "ni", "nin", "ninj", "ninja"};
		Trie3 trie = new Trie3();
		for (String word : arr) {
			trie.insert(word);
		}
		String answer = "";
		for (String word : arr) {
			// either the word length is bigger
			// or lexicographically lesser than the previous answer
			if ((word.length() > answer.length() ||
					(word.length() == answer.length()
							&& word.compareTo(answer) < 0))
					&& trie.checkCompleteString(word)) {
				answer = word;
			}
		}
		if (answer.isEmpty()) answer = "None";
		System.out.println(answer);
	}

	private static class Trie3 {
		private final Node head;

		public Trie3() {
			head = new Node();
		}

		public boolean checkCompleteString(String word) {
			Node node = head;
			char[] arr = word.toCharArray();
			for (char ch : arr) {
				int pos = ch - 'a';
				if (node.nodes[pos] == null || !node.nodes[pos].isEnd)
					return false;
				node = node.nodes[pos];
			}
			return node.isEnd;
		}

		public void insert(String word) {
			Node node = head;
			char[] arr = word.toLowerCase().toCharArray();
			for (char ch : arr) {
				int pos = ch - 'a';
				if (node.nodes[pos] == null)
					node.nodes[pos] = new Node();
				node = node.nodes[pos];
			}
			node.isEnd = true;
		}

		public static class Node {
			private final Node[] nodes = new Node[26];
			private boolean isEnd = false;
		}
	}
```

### Approach 2

either the word length is bigger or lexicographically lesser than the previous answer

```java
	private static void type2() {
		String[] arr = { "n", "ni", "nin", "ninj", "ninja" };
		Trie2 trie = new Trie2();
		for (String word : arr) {
			trie.insert(word);
		}
		String answer = "";
		for (String word : arr) {
			// either the word length is bigger
			// or lexicographically lesser than the previous answer
			if ((word.length() > answer.length() ||
					(word.length() == answer.length()
							&& word.compareTo(answer) < 0))
					&& trie.checkCompleteString(word)) {
				answer = word;
			}
		}
		System.out.println(answer);
	}

	private static class Trie2 {
		private static final int ALPHABET_SIZE = 26;
		private final Node head;

		public Trie2() {
			head = new Node();
		}

		public boolean checkCompleteString(String word) {
			Node node = head;
			char[] arr = word.toLowerCase().toCharArray();
			for (char ch : arr) {
				if (node.isNull(ch) || !node.get(ch).isEnd())
					return false;
				node = node.get(ch);
			}
			return node.isEnd();
		}

		public void insert(String word) {
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

		public static class Node {
			private final Node[] nodes;
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
```

### Approach 1: 🔨 Brute Force

complete brute force approach either the word length is bigger or lexicographically lesser than the previous answer

```java
	private static void type1() {
		String[] arr = {"n", "ni", "nin", "ninj", "ninja"};
		Set<String> set = new HashSet<>(Arrays.asList(arr));
		String answer = "";
		for (String word : arr) {
			// either the word length is bigger
			// or lexicographically lesser than the previous answer
			for (int i = 0; i < word.length(); i++) {
				String prefix = word.substring(0, i + 1);

			}

		}
		if (answer.isEmpty()) answer = "None";
		System.out.println(answer);
	}

}
```
