# SecondMinimumValueInBinaryTree

**Topic:** `binarytree` | **File:** `com/problems/binarytree/SecondMinimumValueInBinaryTree.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/)

## Approaches

Implementation:

### Implementation

If it was a binary search tree then we could do some optimization we could just search from the right side as that side holds the larger elements this brute force but it is still efficient

```java
private static void type1() {
        TNode root = new TNode(8)
                .left(new TNode(5))
                .right(new TNode(6));
        int ans = findSecondMinimumValue(root);
        System.out.println(ans);
    }
    public static int findSecondMinimumValue(TNode root) {
        traverse(root);
        return second != Long.MAX_VALUE ?
                (int) second : -1;
    }
    public static void traverse(TNode root) {
        if (null != root) {
            traverse(root.left);
            // checking the current values
            int data = root.data;
            if (data < first && data < second) {
                second = first;
                first = data;
            } else if (data > first && data < second) {
                second = data;
            }
            traverse(root.right);
        }
    }
```
