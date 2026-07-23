# KthLargestElementInStream

**Topic:** `heap` | **File:** `com/problems/heap/KthLargestElementInStream.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/kth-largest-element-in-a-stream/description/)
- [📄 NeetCode](https://neetcode.io/problems/kth-largest-integer-in-a-stream)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/kth-largest-element-in-a-stream_800301)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=hOjcdrqMoQ8)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Best approach using min heap we will maintain a min heap of k elements every time we add anything we will also add into the heap

```java
private static void type3() {
        int[] nums = {4, 5, 8, 2};
        KthLargest3 kthLargest = new KthLargest3(3, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
```

### Approach 2

Insertion method from the insertion sort we will maintain a sorted list

```java
private static void type2() {
        int[] nums = {4, 5, 8, 2};
        KthLargest2 kthLargest = new KthLargest2(3, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
        int[] nums = {4, 5, 8, 2};
        KthLargest1 kthLargest = new KthLargest1(3, nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
```
