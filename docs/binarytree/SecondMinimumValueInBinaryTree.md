# SecondMinimumValueInBinaryTree

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/)

## 📝 Problem Statement

Find the second minimum value in a special binary tree.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

this brute force but it is still efficient we are setting it Long max as the upper range of root value can be (2^31 - 1) checking the current values

```java
    private static void type1() {
        TNode root = new TNode(8)
                .left(new TNode(5))
                .right(new TNode(6));
        int ans = findSecondMinimumValue(root);
        System.out.println(ans);
    }

    // we are setting it Long max as the upper range of root value can be (2^31 - 1)
    static long first = Long.MAX_VALUE, second = Long.MAX_VALUE;

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
}
```
