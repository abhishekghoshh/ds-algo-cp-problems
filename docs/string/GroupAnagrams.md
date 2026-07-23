# GroupAnagrams

**Topic:** `string`  
**Tags:** String, Array, Hashing

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/group-anagrams/description/)
- [📄 NeetCode](https://neetcode.io/problems/anagram-groups)

## 📝 Problem Statement

for the anagrams sorted string will be same

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

most optimized approach here we will use primes in order to create the hash we do not need the save anything in the array we will create a hash function from the characters of the array we will map the characters to the first 26 prime numbers creating the key now add the pair into the map

```java
	private static void type3() {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> groupAnagrams = groupAnagrams3(strs);
		System.out.println(groupAnagrams);
	}

	private static List<List<String>> groupAnagrams3(String[] strs) {
		Map<Long, List<String>> map = new HashMap<>();
		for (String str : strs) {
			// creating the key
			long hash = createHash(str);
			// now add the pair into the map
			if (!map.containsKey(hash))
				map.put(hash, new ArrayList<>());
			map.get(hash).add(str);
		}
		return new ArrayList<>(map.values());
	}

	private static long createHash(String s) {
		long answer = 1L;
		for (char ch : s.toCharArray())
			answer = (answer * primes[ch - 'a']) % MOD;
		return answer;
	}
```

### Approach 2

same as previous but here we will not use sorting we will create freq array for all the string then a custom hash from the frequency of the characters creating the key now add the pair into the map

```java
	private static void type2() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> ans = groupAnagrams2(strs);
		System.out.println(ans);
	}

	private static List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			// creating the key
			int[] freq = new int[26];
			for (char ch : str.toCharArray()) freq[ch - 'a']++;
			String key = createKey(freq);
			// now add the pair into the map
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}

	private static String createKey(int[] freq) {
		StringBuilder sb = new StringBuilder();
		for (int f : freq) sb.append(f);
		return sb.toString();
	}
```

### Approach 1: 🔨 Brute Force

brute force approach make a key value pair of [sorted string, original string] for the anagrams sorted string will be same create the sorted string now add the pair into the map

```java
	private static void type1() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> ans = groupAnagrams1(strs);
		System.out.println(ans);
	}

	private static List<List<String>> groupAnagrams1(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			// create the sorted string
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);
			// now add the pair into the map
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}

}
```
