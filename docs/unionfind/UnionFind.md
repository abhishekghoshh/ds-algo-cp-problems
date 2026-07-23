# Union-Find / Disjoint Set

## Problem Link
- (No specific problem link — algorithm implementation)

## Solution Link
- (Referenced in Graph MST problems: Kruskal's Algorithm)

## Applications

Union-Find is used in:
- **Kruskal's minimum spanning tree algorithm**
- **Grid percolation**
- **Network connectivity**
- **Least common ancestor in trees**
- **Image processing**

## Code

```java
package com.algo.unionfind;

public class UnionFind {
    private final int size;           // total number of elements
    private final int[] sz;           // size of each component (union by size)
    private final int[] parent;       // parent[i] = parent of i; root if parent[i] == i
    private int components;           // number of disjoint components

    public UnionFind(int size) {
        if (size <= 0) throw new IllegalArgumentException("Size <= 0 is not allowed");
        this.size = components = size;
        sz = new int[size];
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;  // link to itself (self root)
            sz[i] = 1;      // each component is size 1
        }
    }

    /**
     * Find which component 'p' belongs to.
     * Uses path compression for amortized O(α(n)) time.
     */
    public int find(int p) {
        // Find the root
        int root = p;
        while (root != parent[root])
            root = parent[root];

        // Path compression: set all nodes on path to point directly to root
        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        return root;
    }

    // Check if p and q are in the same component
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Return the size of the component p belongs to
    public int componentSize(int p) {
        return sz[find(p)];
    }

    public int size()     { return size; }
    public int components() { return components; }

    /**
     * Unify components containing p and q.
     * Uses union by size: smaller tree attached to larger tree.
     */
    public void unify(int p, int q) {
        if (connected(p, q)) return; // already in same component

        int root1 = find(p);
        int root2 = find(q);

        // Merge smaller component into larger one
        if (sz[root1] > sz[root2]) {
            sz[root1] += sz[root2];
            parent[root2] = root1;
            sz[root2] = 0;
        } else {
            sz[root2] += sz[root1];
            parent[root1] = root2;
            sz[root1] = 0;
        }
        components--;
    }
}
```

## Key Operations

| Operation | Time Complexity | Description |
|-----------|----------------|-------------|
| `find(p)` | O(α(n)) amortized | Find root of component with path compression |
| `unify(p, q)` | O(α(n)) amortized | Merge two components (union by size) |
| `connected(p, q)` | O(α(n)) amortized | Check if same component |

α(n) is the **inverse Ackermann function** — grows extremely slowly (≤ 5 for any practical input).

## Core Optimizations

1. **Path Compression**: During `find()`, make every node on the path point directly to the root. Flattens the tree.

2. **Union by Size**: Always attach the smaller tree under the larger tree's root. Keeps tree depth logarithmic.

## Usage Example

```java
UnionFind uf = new UnionFind(10);

uf.unify(0, 1);  // component {0,1}
uf.unify(1, 2);  // component {0,1,2}
uf.unify(3, 4);  // component {3,4}

uf.connected(0, 2);  // true  (0-1-2 connected)
uf.connected(0, 3);  // false (different components)

uf.componentSize(0); // 3  (nodes 0,1,2)
uf.components();     // 7  (10 nodes, 3 connected = 7 components)
```
