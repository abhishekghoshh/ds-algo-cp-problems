# SumSegmentTree

**Topic:** `segmenttree` | **File:** `com/problems/segmenttree/SumSegmentTree.java`

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.sum(0, 9));
		System.out.println(segmentTree.sum(2, 5));
		segmentTree.update(3, 7);
		System.out.println(segmentTree.sum(2, 5));
	}
```
