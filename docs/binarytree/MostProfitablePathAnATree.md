# MostProfitablePathAnATree

**Topic:** `binarytree` | **File:** `com/problems/binarytree/MostProfitablePathAnATree.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/most-profitable-path-in-a-tree/description/)

## Approaches

Implementation:

### Implementation

Incomplete we will do the dfs with the backtracking

```java
private static void type1() {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int bob = 3;
        int[] amount = {-2, 4, 2, -4, 6};
        int ans = mostProfitablePath1(edges, bob, amount);
        System.out.println(ans);
    }
    public static int mostProfitablePath1(int[][] edges, int bob, int[] amount) {
        int alice = 0;
        int n = edges.length + 1;
        // first, we will convert the edges into an adjacency list
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n - 1; i++) {
            int start = edges[i][0], end = edges[i][1];
            if (adj[start] == null) adj[start] = new ArrayList<>();
            adj[start].add(end);
            if (adj[end] == null) adj[end] = new ArrayList<>();
            adj[end].add(start);
        }
        boolean[] visited1 = new boolean[n], visited2 = new boolean[n];
        visited1[alice] = visited2[bob] = true;
        return traverse1(alice, bob, visited1, visited2, adj, amount);
    }
```
