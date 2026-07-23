# CountDistinctSubstrings

**Topic:** `trie` | **File:** `com/problems/trie/CountDistinctSubstrings.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/count-distinct-substrings_985292)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/number-of-distinct-substring_1465938)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=RV0QeTyHZxo&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=4)
- [📄 takeUforward](https://takeuforward.org/data-structure/number-of-distinct-substrings-in-a-string-using-trie/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Modified trie approach time complexity O(n^2)

**Complexity:** Time: o(n^2)

```java
private static void type2() {
		String str = "abab";
		char[] arr = str.toCharArray();
		int n = arr.length;
		// 1 for the empty substring
		int count = 1;
		// This will be trie root
		Node root = new Node();
		Node node;
		for (int i = 0; i < n; i++) {
			node = root;
			for (int j = i; j < n; j++) {
				int pos = arr[j] - 'a';
				// we are adding 1 to count every time we have encountered one new children
				// which is null, children is null means by adding the character we can make a
				// new substring
				if (node.nodes[pos] == null) {
					node.nodes[pos] = new Node();
					count++;
				}
				node = node.nodes[pos];
			}
		}
		System.out.println(count);
	}
```

### Approach 1 — Brute Force

Using trie time complexity is O(n^3)

```java
private static void type1() {
		String str = "abab";
		char[] arr = str.toCharArray();
		// 1 for the empty substring
		int count = 1;
		Trie trie = new Trie();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				// we are adding the s.substring(i,j)
				if (trie.insert(arr, i, j)) count++;
			}
		}
		System.out.println(count);
	}
```
