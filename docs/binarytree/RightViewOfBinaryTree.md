# RightViewOfBinaryTree

**Topic:** `binarytree` | **File:** `com/problems/binarytree/RightViewOfBinaryTree.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/binary-tree-right-side-view/description/)
- [📄 NeetCode](https://neetcode.io/problems/binary-tree-right-side-view)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/right-view_764605)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/right-view-of-binary-tree/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=25)
- [▶ YouTube](https://www.youtube.com/watch?v=d4zLyf32e3I)
- [📄 takeUforward](https://takeuforward.org/data-structure/right-left-view-of-binary-tree/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Iterative way we will go level wise

```java
private static void type2() {
        TNode root = TNode.withCount(15);
        List<Integer> rightView = rightViewTraversal(root);
        System.out.println(rightView);
    }
```

### Approach 1 — Brute Force

Current size of the level if the level is equal to the rightView size, then we will add the node data into the rightView and we know this will be the right most child by default first we will add the right child then left child we will add one level using dfs / recursion

```java
private static void type1() {
        TNode root = TNode.withCount(15);
        List<Integer> rightView = rightSideView1(root);
        System.out.println(rightView);
    }
    private static List<Integer> rightSideView1(TNode root) {
        List<Integer> rightView = new ArrayList<>();
        rightViewTraversal(root, rightView, 0);
        return rightView;
    }
    private static void rightViewTraversal(TNode root, List<Integer> rightView, int level) {
        if (null == root) return;
        // if the level exceed the rightView list size, that means we have found another bottom level,
        // and by default, it is the left most child
        if (rightView.size() == level) rightView.add(root.data);
        rightViewTraversal(root.right, rightView, level + 1);
        rightViewTraversal(root.left, rightView, level + 1);
    }
```
