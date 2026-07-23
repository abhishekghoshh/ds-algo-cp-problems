# MaximumPathSumNodesBinaryTreeFromLeafToLeafNode

**Topic:** `binarytree` | **File:** `com/problems/binarytree/MaximumPathSumNodesBinaryTreeFromLeafToLeafNode.java`

## Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/maximum-path-sum/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/maximum-path-sum-between-two-leaves_794950)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ArNyupe-XH0&list=PL_z_8CaSLPWfxJPz2-YKqL9gXWdgrhvdn&index=5)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/)

## Approaches

Implementation:

### Implementation

This is brute force but it is an efficient approach

```java
private static void type1() {
		TNode root = TNode.withNodes(6, -9, -10);
		long ans = findMaxSumPath(root);
		System.out.println(ans);
	}
	public static long findMaxSumPath(TNode root) {
		max = Long.MIN_VALUE;
		traverse(root);
		return max != Long.MIN_VALUE ?
				max : -1;
	}
	private static int traverse(TNode root) {
		// if this is null, then it will return 0
		if (null == root) return 0;
		// if this is a leaf node, then it will return the node value
		if (null == root.left && null == root.right) return root.data;

		// at this point, either of sides must be non-zero
		int left = traverse(root.left);
		int right = traverse(root.right);

		// if both of its left and right children are non-empty, that means
		// it is a proper parent node with at least one child in its both sides.
		// we could check now if the path is the max path or not
		if (null != root.left && null != root.right)
			max = Math.max(max, root.data + left + right);

		// lastly, we will return the max out of left and right
		return root.data + Math.max(left, right);
	}
```
