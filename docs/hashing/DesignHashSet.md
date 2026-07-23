# DesignHashSet

**Topic:** `hashing` | **File:** `com/problems/hashing/DesignHashSet.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/design-hashset/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=VymjPQUXjL8)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

We can create a actual implementation of hash set using a bucket of nodes of size 100 and every node will point to a balanced binary search tree which have actual values, and we will use a good hashing function so that all the element will be spread properly

```java
private static void type2() {
    }
```

### Approach 1 — Brute Force

Brute force approach as we know the range that we will be given we have created an array beforehand, but it is a waste of space

```java
private static void type1() {
        MyHashSet1 set = new MyHashSet1();
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
    }
```
