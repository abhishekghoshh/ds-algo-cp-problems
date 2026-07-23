# InvertBinaryTree

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/invert-binary-tree/description/)
- [📄 NeetCode](https://neetcode.io/problems/invert-a-binary-tree)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/mirror-tree/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=OnSn2XEQ4MY)
- [📄 takeUforward](https://takeuforward.org/data-structure/check-for-symmetrical-binary-tree/)

## 📝 Problem Statement

Invert a binary tree (mirror it).

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

changing the left and right child now recursively call on the left and right child

```java
    private static void type1() {
        TNode root = TNode.withCount(15);
        root = invertTree(root);
        PrintUtl.print(root);
    }

    public static TNode invertTree(TNode root) {
        if (null == root) return null;
        TNode left = root.left, right = root.right;
        // changing the left and right child
        root.left = right;
        root.right = left;
        // now recursively call on the left and right child
        invertTree(left);
        invertTree(right);
        return root;
    }
}
```
