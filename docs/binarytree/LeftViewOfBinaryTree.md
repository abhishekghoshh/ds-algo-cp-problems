# LeftViewOfBinaryTree

**Topic:** `binarytree` | **File:** `com/problems/binarytree/LeftViewOfBinaryTree.java`

## Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/920519)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/left-view-of-binary-tree_625707)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=25)
- [📄 takeUforward](https://takeuforward.org/data-structure/right-left-view-of-binary-tree/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Iterative way we will go level wise

```java
private static void type2() {
        TNode root = TNode.withCount(15);
        List<Integer> leftView = leftViewTraversal(root);
        System.out.println(leftView);
    }
```

### Approach 1 — Brute Force

Current size of the level if the level is equal to the leftView size, then we will add the node data into the leftView and we know this will be the left most child by default first we will add the left child then right child we will add one level using dfs / recursion

```java
private static void type1() {
        TNode root = TNode.withCount(15);
        List<Integer> leftView = new ArrayList<>();
        leftViewTraversal(root, leftView, 0);
        System.out.println(leftView);
    }
    private static void leftViewTraversal(TNode root, List<Integer> leftView, int level) {
        if (null == root) return;
        // if the level exceed the leftview list size, that means we have found another bottom level
        // and by default, it is the left most child
        if (leftView.size() == level) leftView.add(root.data);
        leftViewTraversal(root.left, leftView, level + 1);
        leftViewTraversal(root.right, leftView, level + 1);
    }
```
