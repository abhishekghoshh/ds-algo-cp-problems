# MinSegmentTreeWithLazyPropagation

**Topic:** `segmenttree` | **File:** `com/problems/segmenttree/MinSegmentTreeWithLazyPropagation.java`

## Approaches

Implementation:

### Implementation

Check the lazy sum propagation for better understanding

```java
private static void type1() {
		// for range minimum query
		// instead of tree[index] += (high - low + 1) * val;
		// the tree[index] will be updated by val only
		// tree[index] += val;
		int[] arr = { 1, 3, 1, 2, 5 };
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.min(0, arr.length - 1));
		System.out.println(segmentTree.min(0, 2));
	}
```
