# LongestDuplicateSubstring

**Topic:** `trie`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/longest-duplicate-substring/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=FQ8hcOOzQMU -> Tech dose)
- [▶ YouTube](https://www.youtube.com/watch?v=dcOSQjhfBcQ -> Pepcoding)
- [https://gist.github.com/SuryaPratapK/bb3a2235634af464a493ee44d2240faf](https://gist.github.com/SuryaPratapK/bb3a2235634af464a493ee44d2240faf)

## 📝 Problem Statement

Find the longest duplicate substring in a string.

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

using Rabin karp's rolling hash algorithm

```java
	private static void type4() {

	}
```

### Approach 3

using trie approach it is giving TLE in leetcode (n-i > len) is an early optimization if we already found a maxLen and all the later starting i can not beat this maxLen the can just break the loop

**Time Complexity:** `O(n^2)`

```java
	private static void type3() {
		String s = "abcd";
		char[] arr = s.toCharArray();
		int n = arr.length;
		Node head = new Node();
		Node node;
		int start = 0, end = -1, len = 0;
		// (n-i > len) is an early optimization
		// if we already found a maxLen and
		// all the later starting i can not beat this maxLen
		// the can just break the loop
		for (int i = 0; i < n && (n - i > len); i++) {
			node = head;
			for (int j = i; j < n; j++) {
				int pos = arr[j] - 'a';
				if (node.nodes[pos] == null)
					node.nodes[pos] = new Node();
				node = node.nodes[pos];
				node.endsWith++;
				if (node.endsWith >= 2 && (j - i + 1) > len) {
					len = j - i + 1;
					end = j;
					start = i;
				}
			}
		}
		String ans = s.substring(start, end + 1);
		System.out.println(ans);
	}

	static class Node {
		final Node[] nodes = new Node[26];
		int endsWith = 0;
	}
```

### Approach 2

using dynamic programming

```java
	private static void type2() {

	}
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
	private static void type1() {

	}

}
```
