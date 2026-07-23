# LongestCommonPrefix

**Topic:** `string` | **File:** `com/problems/string/LongestCommonPrefix.java`

**Tags:** String, Array, trie

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/longest-common-prefix/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/2090383)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/longest-common-prefix_628874)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=0sWShKIJoo4)
- [▶ YouTube](https://www.youtube.com/watch?v=VTr3Nh7BadI)
- [▶ YouTube](https://www.youtube.com/watch?v=bl8ue-dTxgs)
- [▶ YouTube](https://www.youtube.com/watch?v=fhyIORFDD0k)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Using trie method not best approach it will take same time but will take some extra space

```java
private static void type3() {
		String[] strs = { "flower", "flow", "flight" };
	}
```

### Approach 2

Not so optimized here we are sorting the strings by their length first then we are taking the first element as pivot like the last time then checking the remaining string one at a time and update the pivot len accordingly

```java
private static void type2() {
		String[] strs = { "flower", "flow", "flight" };
		String ans = longestCommonPrefix2(strs);
		System.out.println(ans);
	}
	private static String longestCommonPrefix2(String[] strs) {
		int n = strs.length;
		if (n == 1) return strs[0];
		Arrays.sort(strs, Comparator.comparing(String::length));
		char[] pivot = strs[0].toCharArray();
		int len = pivot.length;
		for (int j = 1; j < n; j++) {
			for (int i = 0; i < len; i++) {
				// if the character do not match then we will stop and update len
				if (pivot[i] != strs[j].charAt(i)) {
					len = i;
					break;
				}
			}
		}
		return strs[0].substring(0, len);
	}
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
		String[] strs = { "flower", "flow", "flight" };
		String ans = longestCommonPrefix1(strs);
		System.out.println(ans);
	}
	public static String longestCommonPrefix1(String[] strs) {
		int n = strs.length;
		if (n == 1) return strs[0];
		// we will take the first string as the pivot element
		String pivot = strs[0];
		int i = 0;
		for (char ch : pivot.toCharArray()) {
			// from the remaining string we will check if it matches with the current character or not
			for (int j = 1; j < n; j++) {
				if (i == strs[j].length() || ch != strs[j].charAt(i))
					return pivot.substring(0, i);
			}
			i++;
		}
		return pivot;
	}
```
