# BinarySearchTree

## Description

Generic Binary Search Tree with insert, delete, search, and four traversal modes (preorder, inorder, postorder, level-order) as iterators.

## Code

```java
package com.ds.binarytree;

public class BinarySearchTree<T extends Comparable<T>> {
    private int nodeCount = 0;
    private Node root = null;

    private class Node {
        T data;
        Node left, right;
        public Node(Node left, Node right, T elem) {
            this.data = elem; this.left = left; this.right = right;
        }
    }

    public boolean isEmpty() { return size() == 0; }
    public int size() { return nodeCount; }

    // Add - O(log n) avg, O(n) worst
    public boolean add(T elem) {
        if (contains(elem)) return false;
        root = add(root, elem);
        nodeCount++;
        return true;
    }

    private Node add(Node node, T elem) {
        if (node == null) return new Node(null, null, elem);
        if (elem.compareTo(node.data) < 0)
            node.left = add(node.left, elem);
        else
            node.right = add(node.right, elem);
        return node;
    }

    // Remove - three cases: leaf, one child, two children
    private Node remove(Node node, T elem) {
        if (node == null) return null;
        int cmp = elem.compareTo(node.data);
        if (cmp < 0) node.left = remove(node.left, elem);
        else if (cmp > 0) node.right = remove(node.right, elem);
        else {
            // Case 1 & 2: one child or no child
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            // Case 3: two children — replace with inorder successor
            else {
                Node tmp = findMin(node.right);
                node.data = tmp.data;
                node.right = remove(node.right, tmp.data);
            }
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Traversal iterators
    public Iterator<T> traverse(TreeTraversalOrder order) {
        return switch (order) {
            case PRE_ORDER -> preOrderTraversal();
            case IN_ORDER -> inOrderTraversal();
            case POST_ORDER -> postOrderTraversal();
            case LEVEL_ORDER -> levelOrderTraversal();
        };
    }
}

enum TreeTraversalOrder { PRE_ORDER, IN_ORDER, POST_ORDER, LEVEL_ORDER }
```

## Delete Node — Three Cases

1. **No child (leaf)**: Simply return null
2. **One child**: Return the non-null child
3. **Two children**: Find the smallest node in the right subtree (inorder successor), copy its value, and recursively delete that successor

## Traversal Implementations

- **Preorder**: Stack-based (push root, pop, push right then left)
- **Inorder**: Stack-based with left-digging
- **Postorder**: Two-stack approach
- **Level-order**: Queue-based BFS

## Complexity

| Operation | Average | Worst (skewed) |
|-----------|---------|---------------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
