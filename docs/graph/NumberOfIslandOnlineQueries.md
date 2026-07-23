# NumberOfIslandOnlineQueries

**Topic:** `graph`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/number-of-islands-ii/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/number-of-islands/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Rn6B-Q4SNyA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn)
- [📄 takeUforward](https://takeuforward.org/graph/number-of-islands-ii-online-queries-dsu-g-51/)

## 📝 Problem Statement

it can also happen that after adding this 1 more than 1 component will be connected

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

so this is n x m size matrix, and we will be adding one point at time our answer will be number of island presents on that specific time after adding one point, we will check all its 4 side neighbors, if those cells are 1 then we will add this current 1 to the existing components, it can also happen that after adding this 1 more than 1 component will be connected we will create a n X m matrix to store the points from the queries we will create rank and parent arrays for Disjoint set we will traverse all the queries and add the points and connect the component one by one we will get row and column from the query, but we will convert to a unique node number the cell is already 1 means it is a duplicate query we will set the cell as 1 currently this cell will be a single node component, so we will add 1 to the component size now we will check all its 4 side neighbors checking if the neighbor is a valid cell, and it is having value as 1 as they are adjacent nodes, so they should be in same components, so if they have different parent we will unify them, also decrease the number of components src == parent[src] means parent of the node

```java
	private static void type1() {
		int n = 4, m = 5;
		int[][] queries = {
				{0, 0},
				{0, 0},
				{1, 1},
				{1, 0},
				{0, 1},
				{0, 3},
				{1, 3},
				{0, 4},
				{3, 2},
				{2, 2},
				{1, 2},
				{0, 2}
		};
		List<Integer> answer = numOfIslands(n, m, queries);
		System.out.println(answer);
	}

	public static List<Integer> numOfIslands(int n, int m, int[][] queries) {
		// we will create a n X m matrix to store the points from the queries
		int[][] matrix = new int[n][m];
		int N = m * n;
		// we will create rank and parent arrays for Disjoint set
		int[] rank = new int[N];
		int[] parent = new int[N];
		for (int i = 0; i < N; i++) {
			rank[i] = 0;
			parent[i] = i;
		}

		int numberOfIsland = 0;
		int[][] deltas = {
				{0, 1},
				{1, 0},
				{0, -1},
				{-1, 0}
		};
		List<Integer> answer = new ArrayList<>();
		// we will traverse all the queries and add the points and connect the component one by one
		for (int[] query : queries) {
			// we will get row and column from the query, but we will convert to a unique node number
			int r = query[0], c = query[1];
			int nodeNo = r * m + c;
			// the cell is already 1 means it is a duplicate query
			if (matrix[r][c] == 1) continue;
			// we will set the cell as 1
			matrix[r][c] = 1;
			// currently this cell will be a single node component, so we will add 1 to the component size
			numberOfIsland++;
			// now we will check all its 4 side neighbors
			for (int[] delta : deltas) {
				int x = r + delta[0];
				int y = c + delta[1];
				// checking if the neighbor is a valid cell, and it is having value as 1
				if (isInBounds(x, y, n, m) && matrix[x][y] == 1) {
					int neighbourNodeNo = x * m + y;
					// as they are adjacent nodes, so they should be in same components,
					// so if they have different parent we will unify them, also decrease the number of components
					if (find(parent, nodeNo) != find(parent, neighbourNodeNo)) {
						numberOfIsland--;
						union(parent, rank, nodeNo, neighbourNodeNo);
					}
				}
			}
			answer.add(numberOfIsland);
		}
		return answer;
	}

	private static boolean isInBounds(int x, int y, int n, int m) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	private static void union(int[] parent, int[] rank, int u, int v) {
		int baseParentU = find(parent, u);
		int baseParentV = find(parent, v);
		if (rank[baseParentU] < rank[baseParentV]) {
			parent[baseParentU] = baseParentV;
			rank[baseParentV]++;
		} else {
			parent[baseParentV] = baseParentU;
			rank[baseParentU]++;
		}
	}

	private static int find(int[] parent, int node) {
		// src == parent[src] means parent of the node
		if (node == parent[node]) return node;
		int baseParent = find(parent, parent[node]);
		parent[node] = baseParent;
		return baseParent;
	}

}
```
