# LargestSubstringWithKUniqueCharacters

**Topic:** `slidingwindow`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/longest-substring-with-at-most-k-distinct-characters_2221410)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1)
- [📄 LeetCode](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10)

## 📝 Problem Statement

You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.
Note : If no such substring exists, return -1.&nbsp;
Examples:
Input:

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

optimize approach but, same as using a hashmap

```java
	private static void type3() {
		String s = "aabacbebebe";
		int k = 2;
		int max = -1;
		char[] arr = s.toCharArray();
		int n = arr.length;
		int[] freq = new int[26];
		int left = 0, types = 0;
		for (int right = 0; right < n; right++) {
			int chIndex = arr[right] - 'a';
			freq[chIndex]++;
			if (freq[chIndex] == 1) types++;
			while (left < n && types > k) {
				int itemToRemove = arr[left++] - 'a';
				freq[itemToRemove]--;
				if (freq[itemToRemove] == 0) types--;
			}
			if (types == k) max = Math.max(max, right - left + 1);
		}
		System.out.println(max);
	}
```

### Approach 2

sliding window

```java
	private static void type2() {
		String s = "aabacbebebe";
		int k = 2;
		int max = -1;
		char[] arr = s.toCharArray();
		int n = arr.length;
		Map<Character, Integer> freq = new HashMap<>();
		int left = 0, types = 0;
		for (int right = 0; right < n; right++) {
			char ch = arr[right];
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
			if (freq.get(ch) == 1) types++;
			while (left < n && types > k) {
				char charToRemove = arr[left++];
				freq.put(charToRemove, freq.get(charToRemove) - 1);
				if (freq.get(charToRemove) == 0) types--;
			}
			if (types == k) max = Math.max(max, right - left + 1);
		}
		System.out.println(max);
	}
```

### Approach 1: 🔨 Brute Force

brute force

```java
	private static void type1() {

	}

}
```
