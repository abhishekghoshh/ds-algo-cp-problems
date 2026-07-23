# LongestStringWithAllPrefixes

**Topic:** `trie` | **File:** `com/problems/trie/LongestStringWithAllPrefixes.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/complete-string_2687860)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/longest-common-prefix_2090383)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=AWnBa91lThI&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=3)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Optimal approach

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
```

### Approach 2

Improved approach

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
```

### Approach 1 — Brute Force

Complete brute force approach

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
```
