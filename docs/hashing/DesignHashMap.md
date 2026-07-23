# DesignHashMap

**Topic:** `hashing` | **File:** `com/problems/hashing/DesignHashMap.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/design-hashmap/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=cNWsgbKwwoU)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

We can create a actual implementation of hash set using a bucket of nodes of size 100 and every node will point to a balanced binary search tree which have the key,values pair and we will use a good hashing function for the key so that all the element will be spread properly

```java
private static void type2() {
    }
```

### Approach 1 — Brute Force

Brute force approach as we know the range that we will be given we have created an array beforehand, but it is a waste of space

```java
private static void type1() {
        MyHashMap1 map = new MyHashMap1();
        map.put(1,101);
        System.out.println(map.get(1));
        map.remove(1);
        System.out.println(map.get(1));
    }
```
