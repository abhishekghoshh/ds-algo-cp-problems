# Graph

## Overview

**51 files** covering graph representation, BFS/DFS traversals, cycle detection, topological sort, shortest paths, minimum spanning trees, and strongly connected components.

## Prerequisites

### Union-Find / Disjoint Set (`com/algo/unionfind/UnionFind.java`)

Used in Kruskal's algorithm, grid percolation, and network connectivity:

```java
public class UnionFind {
    private int[] parent;  // parent[i] = parent of i
    private int[] size;    // component size
    private int components;

    // Find with path compression - amortized O(α(n))
    public int find(int p) {
        int root = p;
        while (root != parent[root]) root = parent[root];
        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        return root;
    }

    // Union by size - O(α(n))
    public void unify(int p, int q) {
        int root1 = find(p), root2 = find(q);
        if (root1 == root2) return;
        if (size[root1] > size[root2]) {
            parent[root2] = root1;
            size[root1] += size[root2];
        } else {
            parent[root1] = root2;
            size[root2] += size[root1];
        }
        components--;
    }
}
```

## Graph Representations

The project uses adjacency list representation primarily:

```java
// List<List<List<Integer>>> adjacency list
// outer list: vertices
// middle list: edges from that vertex
// inner list: [destination, weight]

// GraphUtil.java provides builders to convert between:
// adjacency matrix → adjacency list → edge list
```

## Problem Categories

### BFS / DFS Basics

| Problem | Technique |
|---------|-----------|
| **Graph Representation** | Implementing adjacency list/matrix |
| **Clone Graph** | DFS/BFS with HashMap for visited nodes |
| **BFS Traversal** | Queue-based level order |
| **DFS Traversal** | Stack-based or recursive |
| **Graph Valid Tree** | Check connectivity + no cycles (n-1 edges) |
| **Connected Components** | DFS/BFS counting components |
| **Number of Islands** | DFS/BFS on grid, 4-directional |
| **Flood Fill** | DFS/BFS on grid |
| **Rotting Oranges** | Multi-source BFS with level tracking |
| **Surrounded Regions** | DFS from borders, flip inner region |
| **Number of Enclaves** | Multi-source DFS from boundary |
| **Number of Distinct Islands** | DFS with path signature/direction encoding |
| **Pacific Atlantic Water Flow** | Reverse BFS from oceans |
| **0/1 Matrix** | Multi-source BFS from zeros |

### Cycle Detection

| Problem | Detection Method |
|---------|-----------------|
| **Cycle in Undirected Graph** | DFS with parent tracking |
| **Cycle in Directed Graph (DFS)** | Visited + path-visited arrays |
| **Cycle Detection using BFS** | Kahn's algorithm (topological sort check) |
| **Bipartite Graph** | BFS/DFS 2-coloring |

### Topological Sort

```java
// Kahn's Algorithm (BFS-based):
int[] indegree = new int[V];
for each edge (u→v) indegree[v]++;
Queue<Integer> q = new LinkedList<>();
for (int i = 0; i < V; i++) if (indegree[i] == 0) q.add(i);
while (!q.isEmpty()) {
    int node = q.poll();
    result.add(node);
    for (int neighbor : adj[node])
        if (--indegree[neighbor] == 0) q.add(neighbor);
}
```

Problems:
- Topological Sort (DFS & BFS)
- Course Schedule I & II
- Alien Dictionary
- Find Eventual Safe States

### Shortest Path Algorithms

#### Dijkstra's Algorithm

```java
// Time: O(E log V) with PriorityQueue
// For non-negative edge weights

int[] dist = new int[V];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[source] = 0;

PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
pq.offer(new int[]{source, 0});

while (!pq.isEmpty()) {
    int[] curr = pq.poll();
    int u = curr[0], d = curr[1];
    if (d > dist[u]) continue;  // stale entry
    
    for (int[] edge : adj.get(u)) {
        int v = edge[0], w = edge[1];
        if (dist[u] + w < dist[v]) {
            dist[v] = dist[u] + w;
            pq.offer(new int[]{v, dist[v]});
        }
    }
}
```

Applications:
- Network Delay Time
- Cheapest Flights Within K Stops (Dijkstra with k constraints, or Bellman-Ford)
- Path with Minimum Effort
- Shortest Distance in Binary Maze
- Number of Ways to Arrive at Destination
- Swim in Rising Water

#### Bellman-Ford Algorithm

```java
// O(V×E) - Handles negative weights (but not negative cycles)
int[] dist = new int[V];
Arrays.fill(dist, MAX);
dist[src] = 0;

for (int i = 0; i < V-1; i++)  // V-1 relaxation passes
    for (int u = 0; u < V; u++)
        for (int[] edge : adj[u])
            if (dist[u] + w < dist[v])
                dist[v] = dist[u] + w;
```

#### Floyd Warshall

```java
// O(V³) - All-pairs shortest paths
for (int k = 0; k < V; k++)
    for (int i = 0; i < V; i++)
        for (int j = 0; j < V; j++)
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
```

Problem: Find the City With Smallest Number of Neighbors at Threshold Distance

#### Other Shortest Path Variants

| Problem | Technique |
|---------|-----------|
| **Shortest Path in DAG** | Topological sort + relaxation |
| **Shortest Path in Undirected Unit Weights** | Simple BFS |
| **Word Ladder 1 & 2** | BFS on word transformation graph |
| **Minimum Multiplications** | BFS/Dijkstra on multiplication state |

### Minimum Spanning Tree (MST)

| Problem | Algorithm |
|---------|-----------|
| **Prim's Algorithm** | Greedy BFS with priority queue, O(E log V) |
| **Kruskal's Algorithm** | Sort edges + Union-Find, O(E log E) |
| **MST Theory** | N nodes → N-1 edges, minimum total weight |

### Disjoint Set / DSU Applications

| Problem | Approach |
|---------|----------|
| **Disjoint Set Implementation** | Union by rank/size + path compression |
| **Number of Provinces** | Union connected cities, count components |
| **Network Connectivity** | Union edges, check components needed |
| **Accounts Merge** | Union emails under same account |
| **Number of Islands II (Online)** | Dynamic DSU with cell-by-cell addition |
| **Making a Large Island** | Try converting one 0 to 1, compute max using DSU |
| **Most Stones Removed** | Union same row/col stones |

### Advanced Graph Algorithms

| Algorithm | Application |
|-----------|------------|
| **Kosaraju's Algorithm** | Strongly Connected Components (SCC) |
| **Tarjan's Algorithm (Bridges)** | Find critical edges using `tin`/`low` arrays |
| **Articulation Points** | Find critical vertices using `tin`/`low` arrays |

```java
// Tarjan's Bridge finding:
void dfs(int u, int parent) {
    tin[u] = low[u] = timer++;
    for (int v : adj[u]) {
        if (v == parent) continue;
        if (tin[v] != -1) {
            low[u] = Math.min(low[u], tin[v]);
        } else {
            dfs(v, u);
            low[u] = Math.min(low[u], low[v]);
            if (low[v] > tin[u]) // (u,v) is a bridge
                bridges.add(new int[]{u, v});
        }
    }
}
```

### Other Graph Problems

- Frog Position After T Seconds (probabilistic BFS)
- Maximize Number of Target Nodes After Connecting Trees
- Maximize Amount After Two Days of Conversions
- Properties Graph
- Power Grid Maintenance
