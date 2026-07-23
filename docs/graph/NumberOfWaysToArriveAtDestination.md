# NumberOfWaysToArriveAtDestination

**Topic:** `graph`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=_-0mx0SmYxA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=40)
- [📄 LeetCode](https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/)

## 📝 Problem Statement

Count the number of shortest paths from source to destination.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

check out other solutions

```java
	private static void type2() {
		// check out other solutions
	}
```

### Approach 1: 🔨 Brute Force

using Dijkstra algorithm but here along with a distance array we will also create another array for storing the ways let's create an adjacency list first we will also add the edges the distance from 0 to 0 is zero we are in source 0 so there is only 1 way to go to 0 we will apply a simple dijkstra algorithm if prevDistance + distance < dist[destination] that means the edge will be now relaxed.

let's say by x ways src of the node can be visited and there is one path from src to destination so destination will also be visited by x ways prevDistance + distance == dist[destination] means the edge will not be relaxed. there was some path already discovered to this node which has the same current distance then we will add that source ways to end ways

```java
	private static void type1() {
		int n = 7;
		int[][] roads = {
				{0, 6, 7},
				{0, 1, 2},
				{1, 2, 3},
				{1, 3, 3},
				{6, 3, 3},
				{3, 5, 1},
				{6, 5, 1},
				{2, 5, 1},
				{0, 4, 5},
				{4, 6, 2}
		};
		int ans = countPaths1(n, roads);
		System.out.println(ans);
	}

	public static int countPaths1(int n, int[][] roads) {
		int pivot = (int) 1e9 + 7;
		// let's create an adjacency list first
		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
		// we will also add the edges
		for (int[] road : roads) {
			adj.get(road[0]).add(new int[]{road[1], road[2]});
			adj.get(road[1]).add(new int[]{road[0], road[2]});
		}

		long[] dist = new long[n];
		Arrays.fill(dist, Long.MAX_VALUE);
		// the distance from 0 to 0 is zero
		dist[0] = 0;

		int[] ways = new int[n];
		// we are in source 0 so there is only 1 way to go to 0
		ways[0] = 1;

		// we will apply a simple dijkstra algorithm
		PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(p -> p[1]));
		minHeap.offer(new long[]{0, 0});

		while (!minHeap.isEmpty()) {
			long[] pair = minHeap.poll();
			int src = (int) pair[0];
			long prevDis = pair[1];
			for (int[] edge : adj.get(src)) {
				int end = edge[0];
				long dis = edge[1];
				// if prevDistance + distance < dist[destination] that means the edge will be now relaxed.
				// let's say by x ways src of the node can be visited and there is one path from src to destination
				// so destination will also be visited by x ways
				if (prevDis + dis < dist[end]) {
					dist[end] = prevDis + dis;
					ways[end] = ways[src]; // assigning the ways of src to the end
					minHeap.offer(new long[]{end, prevDis + dis}); // also adding to the heap
				} else if (prevDis + dis == dist[end]) {
					// prevDistance + distance == dist[destination] means the edge will not be relaxed.
					// there was some path already discovered to this node which has the same current distance
					// then we will add that source ways to end ways
					ways[end] = (ways[end] + ways[src]) % pivot;
				}
			}
		}
		return ways[n - 1];
	}

}
```
