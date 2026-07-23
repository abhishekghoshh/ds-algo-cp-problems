# SymmetricTree

**Topic:** `binarytree`  

## 📝 Problem Statement

Given the root of a binary tree, check whether it is a mirror of itself (symmetric around its center).

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/symmetric-tree/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/630426)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/symmetric-tree_981177)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=nKggNAiEpBE&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=26)
- [▶ YouTube](https://www.youtube.com/watch?v=Mao9uzxwvmc)
- [📄 takeUforward](https://takeuforward.org/data-structure/check-for-symmetrical-binary-tree/)

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

if we consider left subtree and right subtree different tree then from the diagram we can visualize that left.left should be equal to right.right and left.right should be equal to right.left we will create a recurrence relation from the conditions if both are null, then it is symmetric if either is null, then it is not symmetric if both is non-null, then first we will check the values of the node as we are checking the symmetric, so we will now check cris-cross

```java
    private static void type1() {
        TNode root = TNode.withNodes(1, 2, 2, 3, 4, 4, 3);
        boolean isSymmetric = isSymmetric(root);
        System.out.println(isSymmetric);
    }

    private static boolean isSymmetric(TNode root) {
        if (null == root) return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TNode root1, TNode root2) {
        // if both are null, then it is symmetric
        if (null == root1 && null == root2) return true;
        // if either is null, then it is not symmetric
        if (null == root1 || null == root2) return false;
        // if both is non-null, then first we will check the values of the node
        // as we are checking the symmetric, so we will now check cris-cross
        return (root1.data == root2.data)
                && isSymmetric(root1.left, root2.right)
                && isSymmetric(root1.right, root2.left);
    }
}
```
