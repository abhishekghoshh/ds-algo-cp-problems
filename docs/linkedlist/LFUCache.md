# LFUCache

**Topic:** `linkedlist` | **File:** `com/problems/linkedlist/LFUCache.java`

**Tags:** Linked List. Hashing

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/lfu-cache/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/lfucache_3114758)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=0PSB9y8ehbk&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=79)
- [▶ YouTube](https://www.youtube.com/watch?v=bLEIHn-DgoA)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

Check this later one more time accepted in leetcode TODO check the solution later here we are using node and doubly linked list

```java
private static void type4() {

	}
```

### Approach 3

Accepted in leetcode TODO check the solution later here we are using node and doubly linked list

```java
private static void type3() {

	}
```

### Approach 2

Solve it in leetcode this solution has some problem same as type 1 this is specifically for leetcode, here we are specifying the types

```java
private static void type2() {

	}
```

### Approach 1 — Brute Force

This solution has some problem here we will use 2 map one for

```java
private static void type1() {
		Cache<Integer, String> cache = new Cache<>(3);
		cache.put(1, "Abhishek");
		cache.put(2, "Nasim Molla");
		System.out.println(cache);
		cache.put(3, "Bishal Mukherjee");
		System.out.println(cache);
		cache.put(1, "Abhishek Ghosh");
		System.out.println(cache);
		System.out.println(cache.get(2));
		System.out.println(cache);
		cache.put(4, "Abhishek Pal");
		cache.put(4, "Abhishek Pal");
		cache.put(1, "Abhishek Ghosh");
		System.out.println(cache);
	}
```
