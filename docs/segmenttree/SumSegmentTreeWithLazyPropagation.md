# SumSegmentTreeWithLazyPropagation

**Topic:** `segmenttree` | **File:** `com/problems/segmenttree/SumSegmentTreeWithLazyPropagation.java`

## Approaches

Implementation:

### Implementation

Lazy segment tree is very useful for the range updates it is quite similar to the normal segment tree while we introduce lazy array for the updates lazy array holds the values that we need to update in the actual index it is quite similar to the path compression technique which is done by union and find we will only update the index if we are touching else we just keep it in the lazy array hoping that it will be updated later once we query or update the index once we update the index we will propagate the update value in the left child and right child to their lazy indices

```java
private static void type1() {
		int[] arr = { 1, 3, 1, 2, 5 };
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.sum(0, arr.length - 1));
		System.out.println(segmentTree.sum(0, 2));
	}
```
