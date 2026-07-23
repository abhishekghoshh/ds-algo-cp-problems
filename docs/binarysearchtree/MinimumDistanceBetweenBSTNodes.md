# MinimumDistanceBetweenBSTNodes

**Topic:** `binarysearchtree`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/)
- [📄 LeetCode](https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=joxx4hTYwcw)

## 📝 Problem Statement

Find the minimum absolute difference between two BST node values.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

if we do an inorder traversal we will get the sorted list and in a sorted list we will get the minimum difference only by checking num[i-1] and nums[i] so we will carry 2 variables prev and max

```java
    private static void type1() {
        TNode root = TNode.withObjectNodes(1, 0, 48, null, null, 12, 49);
        int ans = minDiffInBST(root);
        System.out.println(ans);
    }


    static int prev = -1, min = Integer.MAX_VALUE;

    public static int minDiffInBST(TNode root) {
        traverse(root);
        return min;
    }

    private static void traverse(TNode root) {
        if (null == root) return;
        traverse(root.left);
        if (prev != -1) {
            min = Math.min(min, (root.val - prev));
        }
        prev = root.val;
        traverse(root.right);
    }
}
```
