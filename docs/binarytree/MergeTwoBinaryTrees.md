# MergeTwoBinaryTrees

**Topic:** `binarytree` | **File:** `com/problems/binarytree/MergeTwoBinaryTrees.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/merge-two-binary-trees/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=QHH6rIK3dDQ)

## Approaches

Implementation:

### Implementation

Simple recursive approach

```java
private static void type1() {
        TNode root1 = TNode.withCount(10);
        TNode root2 = TNode.withCount(5);
        TNode root = mergeTrees(root1, root2);
        PrintUtl.levelOrder(root);
    }
    public static TNode mergeTrees(TNode root1, TNode root2) {
        // if both of the root is null then we will return null
        if (null == root1 && null == root2)
            return null;
        // if one of the root is null then we will return the other node
        if (null == root1 || null == root2)
            return (null == root1) ? root2 : root1;

        // at this point we will have both of the non-null nodes,
        // and we will recursively call for the left and right subtree
        TNode node = new TNode(root1.data + root2.data);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }
```
