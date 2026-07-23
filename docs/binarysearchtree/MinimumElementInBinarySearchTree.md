# MinimumElementInBinarySearchTree

**Topic:** `binarysearchtree`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/minimum-element-in-bst_8160462)

## 📝 Problem Statement

for a valid BST the minimum element is in the leftest node

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

iterative way

```java
    private static void type2() {
        TNode root = TNode.makeBST(10001);
        TNode min = getMin2(root);
        System.out.println(min.data);
    }

    private static TNode getMin2(TNode root) {
        while (root.left != null)
            root = root.left;
        return root;
    }
```

### Approach 1: 🔨 Brute Force

recursive way

```java
    private static void type1() {
        TNode root = TNode.makeBST(10001);
        TNode min = getMin1(root);
        System.out.println(min.data);
    }

    private static TNode getMin1(TNode root) {
        if (root.left == null) return root;
        return getMin1(root.left);
    }
}
```
