# MaximumElementInBinarySearchTree

**Topic:** `binarysearchtree` | **File:** `com/problems/binarysearchtree/MaximumElementInBinarySearchTree.java`

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

For a valid BST the max will be in the right most node iterative way

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

### Approach 1 — Brute Force

Recursive way

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
```
