# XeniaAndBitOperation

**Topic:** `segmenttree` | **File:** `com/problems/segmenttree/XeniaAndBitOperation.java`

## Problem Links

- [https://codeforces.com/problemset/problem/339/D](https://codeforces.com/problemset/problem/339/D)

## Approaches

Implementation:

### Implementation

Let's consider an example. Suppose that sequence a = (1, 2, 3, 4). Then let's write down all the transformations (1, 2, 3, 4) → (1 or 2 = 3, 3 or 4 = 7) → (3 xor 7 = 4). The result is v = 4.

```java
private static void type1() {
		int[] arr = { 1, 2, 3, 4 };
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.get());

	}
```
