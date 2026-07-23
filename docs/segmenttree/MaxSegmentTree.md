# MaxSegmentTree

**Topic:** `segmenttree` | **File:** `com/problems/segmenttree/MaxSegmentTree.java`

## Approaches

Implementation:

### Implementation

If you understand min segment tree then it is exactly same just in place of min we have to do max

```java
private static void type1() {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.max(0, 9));
		System.out.println(segmentTree.max(2, 5));
		segmentTree.update(3, 7);
		System.out.println(segmentTree.max(2, 5));
	}
```
