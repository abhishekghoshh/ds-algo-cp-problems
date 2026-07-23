# BellmanFord

**Topic:** `graph` | **File:** `com/problems/graph/BellmanFord.java`

## Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=0vVofAhAYjc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=41)
- [📄 takeUforward](https://takeuforward.org/data-structure/bellman-ford-algorithm-g-41/)

## Approaches

Implementation:

### Implementation

Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S. Note: If the Graph contains a negative cycle, then return an array consisting of only -1.

```java
private static void type1() {
		int v = 3;
		List<List<Integer>> edges = List.of(
				List.of(0, 1, 5),
				List.of(1, 0, 3),
				List.of(1, 2, -1),
				List.of(2, 0, 1)
		);
		int s = 2;
		int[] dis = bellmanFord(v, edges, s);
		print(dis);
	}
```
