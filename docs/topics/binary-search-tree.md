# Binary Search Tree

## Overview

**19 files** covering BST properties, operations (insert, delete, search), traversal, validation, and advanced BST problems.

## BST Properties

- Left subtree values < node value
- Right subtree values > node value
- Inorder traversal gives sorted order
- Search/insert/delete: O(log n) average, O(n) worst

## Problem Categories

### Basic Operations

| Problem | Approach |
|---------|----------|
| Search in BST | Binary search on tree |
| Min/Max Element | Go leftmost/rightmost |
| Ceil in BST | Find smallest value ≥ target |
| Floor in BST | Find largest value ≤ target |
| Insert into BST | Recursive insert at leaf |
| Delete Node in BST | Three cases: leaf, one child, two children |

```java
// Delete Node: Three cases
Node delete(Node root, int key) {
    if (root == null) return null;
    if (key < root.val) root.left = delete(root.left, key);
    else if (key > root.val) root.right = delete(root.right, key);
    else {
        // Case 1: No child or one child
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        // Case 2: Two children - find inorder successor
        Node minRight = findMin(root.right);
        root.val = minRight.val;
        root.right = delete(root.right, minRight.val);
    }
    return root;
}
```

### BST Traversal & Iteration

| Problem | Approach |
|---------|----------|
| Convert Sorted Array to BST | Recursive: pick middle as root |
| Construct BST from Preorder | Use bounds (min, max) recursively |
| BST Iterator | Controlled inorder using stack |
| Two Sum in BST | Inorder traversal + two-pointer or BST iterator |

### BST Validation & Properties

| Problem | Approach |
|---------|----------|
| Validate BST | Recursive with min/max bounds |
| Kth Smallest/Largest | Inorder traversal with counter |
| Min Distance Between BST Nodes | Inorder + compare adjacent |
| LCA in BST | Exploit BST property: find split point |
| Inorder Successor/Predecessor | BST search + min/max in subtree |

### Advanced BST Problems

| Problem | Approach |
|---------|----------|
| Recover BST (2 nodes swapped) | Inorder, find violations, swap |
| Largest BST in Binary Tree | Post-order: check BST + track size, min, max |
| Maximum Sum BST | Post-order: validate BST + track sum |
| Merge Two BSTs | Inorder of both + merge sorted arrays + build balanced |
| Convert Normal BST to Balanced | Inorder + build from sorted array |

```java
// Validate BST with range check:
boolean isValidBST(Node node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return isValidBST(node.left, min, node.val)
        && isValidBST(node.right, node.val, max);
}
```
