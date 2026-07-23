# MaximumElementInBinarySearchTree

**Topic:** `binarysearchtree`  

## 📝 Problem Statement

for a valid BST the max will be in the right most node

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

iterative way

```java
    private static void type2() {
        TNode root = TNode.makeBST(10001);
        TNode max = getMax2(root);
        System.out.println(max.data);
    }

    private static TNode getMax2(TNode root) {
        while (root.right != null)
            root = root.right;
        return root;
    }
```

### Approach 1: 🔨 Brute Force

recursive way

```java
    private static void type1() {
        TNode root = TNode.makeBST(10001);
        TNode max = getMax1(root);
        System.out.println(max.data);
    }

    private static TNode getMax1(TNode root) {
        if (root.right == null) return root;
        return getMax1(root.right);
    }
}
```
