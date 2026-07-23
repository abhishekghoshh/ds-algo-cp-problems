# SerejaAndBrackets

**Topic:** `segmenttree` | **File:** `com/problems/segmenttree/SerejaAndBrackets.java`

## Problem Links

- [https://codeforces.com/problemset/problem/380/C](https://codeforces.com/problemset/problem/380/C)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
		String str = "())(())(())(";
		char[] arr = str.toCharArray();
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.full(0, 1));
		System.out.println(segmentTree.full(7, str.length() - 1));
		System.out.println(segmentTree.full(0, str.length() - 1));
	}
```
