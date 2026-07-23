# LRUCache

**Topic:** `linkedlist` | **File:** `com/problems/linkedlist/LRUCache.java`

**Tags:** Linked List. Hashing

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/lru-cache/description/)
- [📄 NeetCode](https://neetcode.io/problems/lru-cache)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/670276)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=xDEuM5qa0zg&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=77)
- [▶ YouTube](https://www.youtube.com/watch?v=7ABFKPK2hD4)
- [📄 takeUforward](https://takeuforward.org/data-structure/implement-lru-cache/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

This is purely for leetcode same as type2 here we will use an array instead of hashmap as the keys will be starting from the 0 to n

```java
private static void type3() {

	}
```

### Approach 2

This is purely for leetcode same as type1 here will not use any generic

```java
private static void type2() {

	}
```

### Approach 1 — Brute Force

Check leetcode submission for a better solution

```java
private static void type1() {
		LRUCache1<Integer, Integer> cache = new LRUCache1<>(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache);
		System.out.println(cache.get(1));
		System.out.println(cache);
		cache.put(3, 3);
		System.out.println(cache);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache);
		System.out.println(cache.get(1));
	}
```
