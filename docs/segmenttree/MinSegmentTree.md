# MinSegmentTree

**Topic:** `segmenttree` | **File:** `com/problems/segmenttree/MinSegmentTree.java`

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
		int[] arr = { 3, 6, 1, 2, 5, 8, 6, 2, 8, 4, 5, 2, 0 };
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.min(0, 9));
		System.out.println(segmentTree.min(2, 5));
		segmentTree.update(3, 0);
		System.out.println(segmentTree.min(2, 5));
	}
```
