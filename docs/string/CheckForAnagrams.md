# CheckForAnagrams

**Topic:** `string` | **File:** `com/problems/string/CheckForAnagrams.java`

**Tags:** Array, String, Hashing

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/valid-anagram/description/)
- [📄 NeetCode](https://neetcode.io/problems/is-anagram)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/1172164)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/anagram-pairs_626517)

## Solution Links

- [📄 takeUforward](https://takeuforward.org/data-structure/check-if-two-strings-are-anagrams-of-each-other/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Same as previous here we are using the freq array as map

```java
private static void type2() {
		String s = "anagram";
		String t = "nagaram";
		boolean isAnagram = isAnagram2(s, t);
		System.out.println(isAnagram);
	}
	private static boolean isAnagram2(String s, String t) {
		if (s.length() != t.length()) return false;
		char[] arr1 = s.toCharArray();
		char[] arr2 = t.toCharArray();
		int[] freq = new int[26];
		for (int i = 0; i < arr1.length; i++) {
			// adding freq to the map
			freq[arr1[i] - 'a']++;
			// decreasing frequency to the map
			freq[arr2[i] - 'a']--;
		}
		for (int f : freq) {
			if (f != 0) return false;
		}
		return true;
	}
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
		String s = "anagram";
		String t = "nagaram";
		boolean isAnagram = isAnagram1(s, t);
		System.out.println(isAnagram);
	}
	private static boolean isAnagram1(String s, String t) {
		if (s.length() != t.length()) return false;
		Map<Character, Integer> freq = new HashMap<>();
		// adding freq to the map
		for (char ch : s.toCharArray())
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
		// decreasing frequency to the map
		for (char ch : t.toCharArray())
			freq.put(ch, freq.getOrDefault(ch, 0) - 1);
		// checking if any character has any value other than 0
		for (Map.Entry<Character, Integer> entry : freq.entrySet())
			if (entry.getValue() != 0) return false;
		return true;
	}
```
