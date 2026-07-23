# B-Tree

## Description

B-Tree implementation with search functionality. B-Trees are self-balancing tree data structures that maintain sorted data and allow searches, sequential access, insertions, and deletions in logarithmic time.

## Solution Link
- [Programiz - B-Tree](https://www.programiz.com/dsa/b-tree)

## Code

```java
package com.ds.balancedbinarytree;

public class BTree {
    private Node root;
    private final int t;  // minimum degree

    public class Node {
        int n = 0;                              // current number of keys
        int[] key = new int[2 * t - 1];        // max keys = 2t - 1
        Node[] child = new Node[2 * t];        // max children = 2t
        boolean leaf = true;

        public int Find(int k) {
            for (int i = 0; i < this.n; i++)
                if (this.key[i] == k) return i;
            return -1;
        }
    }

    public BTree(int t) {
        this.t = t;
        root = new Node();
        root.n = 0;
        root.leaf = true;
    }

    // Search key recursively
    private Node Search(Node x, int key) {
        int i = 0;
        if (x == null) return x;
        for (i = 0; i < x.n; i++) {
            if (key < x.key[i]) break;
            if (key == x.key[i]) return x;
        }
        if (x.leaf) return null;
        else return Search(x.child[i], key);
    }
}
```

## B-Tree Properties

For a B-Tree of order `t` (minimum degree):
- Every node has at most `2t - 1` keys and `2t` children
- Every node (except root) has at least `t - 1` keys and `t` children
- All leaves are at the same level
- Height is O(log_t n)

## Applications

- Database indexing (most databases use B+ Trees, a variant)
- File systems (NTFS, HFS+, ext4)
- Key-value stores
