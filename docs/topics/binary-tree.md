# Binary Tree

## Overview

**44 files** covering tree traversals (recursive, iterative, Morris), views (top, bottom, left, right), construction from traversals, path problems, and serialization.

## Prerequisites

### TreeNode (`com/ds/binarytree/TNode.java`)

```java
public class TNode {
    public int data, val;     // value accessible as both data and val
    public TNode left, right, next;  // left, right children + next pointer
    
    // Factory methods:
    TNode.withNodes(1, 2, 3, NULL, 4, 5);         // build from level order
    TNode.withObjectNodes(1, null, 3);             // with nulls
    TNode.withCount(7);                             // 1..7 in level order
    TNode.makeBST(10);                              // balanced BST [1..10]
    TNode.imbalancedBST(10);                        // random unbalanced BST
    
    // Search:
    node.search(5);          // DFS search in any tree
    node.searchBST(5);       // Binary search in BST
}
```

### BinarySearchTree (`com/ds/binarytree/BinarySearchTree.java`)

```java
public class BST<T extends Comparable<T>> {
    public boolean add(T elem)     // O(log n) avg, O(n) worst
    public boolean remove(T elem)  // O(log n) avg, O(n) worst
    public boolean contains(T elem)  // O(log n)
    public int height()            // O(n)
    
    // Traversal iterators:
    traverse(PRE_ORDER)   // Stack-based iterative
    traverse(IN_ORDER)    // Stack-based iterative
    traverse(POST_ORDER)  // Two-stack approach
    traverse(LEVEL_ORDER) // Queue-based BFS
}
```

## Problem Categories

### Traversals

```java
// Recursive Inorder:
void inorder(Node root) {
    if (root == null) return;
    inorder(root.left);
    visit(root);
    inorder(root.right);
}

// Iterative Inorder:
Stack<Node> stack = new Stack<>();
Node curr = root;
while (curr != null || !stack.isEmpty()) {
    while (curr != null) { stack.push(curr); curr = curr.left; }
    curr = stack.pop(); visit(curr); curr = curr.right;
}

// Level Order (BFS):
Queue<Node> q = new LinkedList<>();
q.offer(root);
while (!q.isEmpty()) {
    Node node = q.poll();
    visit(node);
    if (node.left != null) q.offer(node.left);
    if (node.right != null) q.offer(node.right);
}
```

| Traversal | Approach |
|-----------|----------|
| **Inorder** | Recursive / Iterative using stack |
| **Preorder** | Recursive / Iterative using stack |
| **Postorder** | Recursive / Two-stack iterative |
| **Level Order** | Queue-based BFS |
| **Zigzag Level Order** | BFS with level parity + flag |
| **Vertical Order Traversal** | BFS with column indexing + sorting |
| **One Pass All 3 Traversals** | Single stack with state tracking |
| **Boundary Traversal** | Left boundary + leaves + right boundary (reverse) |

### Morris Traversal (O(1) Space)

```java
// Morris Inorder: Thread the rightmost node of left subtree
Node curr = root;
while (curr != null) {
    if (curr.left == null) {
        visit(curr);
        curr = curr.right;
    } else {
        Node prev = findPredecessor(curr);
        if (prev.right == null) {
            prev.right = curr;   // create thread
            curr = curr.left;
        } else {
            prev.right = null;   // remove thread
            visit(curr);
            curr = curr.right;
        }
    }
}
```

### Views of Binary Tree

| View | Technique |
|------|-----------|
| **Top View** | BFS with horizontal distance, keep first occurrence |
| **Bottom View** | BFS with horizontal distance, keep last occurrence |
| **Left View** | Level order → first node per level (or DFS depth-first) |
| **Right View** | Level order → last node per level (or DFS depth-first) |

### Tree Properties

| Problem | Approach |
|---------|----------|
| **Height / Max Depth** | `1 + max(height(left), height(right))` |
| **Balanced Tree Check** | Height check with flag: height diff ≤ 1 |
| **Diameter** | Max of: left diam, right diam, left height + right height |
| **Symmetric Tree** | Mirror check: `isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)` |
| **Identical Trees** | Recursive structural and value equality |
| **Subtree Check** | DFS to match each potential root + identical tree check |
| **Invert Tree** | Swap left and right recursively |

### Path Problems

| Problem | Technique |
|---------|-----------|
| **Path Sum** | DFS tracking remaining sum to leaf |
| **Path Sum II** | DFS with path list, add when leaf matches |
| **Max Path Sum (any→any)** | Post-order: compute max path through node, update global max |
| **Max Path Sum (leaf→leaf)** | Similar, but need path through both children |
| **Root to Node Path** | DFS with backtracking |
| **Lowest Common Ancestor** | Recursive: if one node found in each subtree, current is LCA |
| **Nodes at Distance K** | Convert to graph + BFS, or track parent map |
| **Minimum Time to Burn Tree** | Similar to distance K + track max distance |
| **Count Complete Tree Nodes** | Check left/right heights, if equal → formula, else recurse |

### Construction from Traversals

```java
// From Inorder + Preorder:
// First element of preorder = root
// Find root in inorder → elements left = left subtree, right = right subtree
// Recurse with appropriate subarrays

// From Inorder + Postorder:
// Last element of postorder = root
// Same approach as above
```

### Serialization

```java
// Serialize: Preorder traversal, use placeholder for null
// Deserialize: Read preorder, recurse (null → return, value → create node)

String serialize(Node root) {
    if (root == null) return "null,";
    return root.val + "," + serialize(root.left) + serialize(root.right);
}
```

### Other Tree Problems

| Problem | Technique |
|---------|-----------|
| **Flatten to LinkedList** | Morris-like or stack-based preorder linking |
| **Merge Two Trees** | Sum overlapping nodes recursively |
| **Range Sum BST** | DFS with range filtering |
| **Leaf-Similar Trees** | Collect leaf sequences, compare |
| **Evaluate Boolean Tree** | Post-order evaluation of bool expressions |
| **Children Sum Property** | Recursive check or modification |
| **Populate Next Pointers** | Level-order linking (BFS or recursive) |
| **Second Minimum Value** | DFS finding second distinct minimum |
| **Most Profitable Path** | Two-pass DFS |
