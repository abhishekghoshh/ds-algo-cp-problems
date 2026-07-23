# DisjointSetImplementation

**Topic:** `graph` | **File:** `com/problems/graph/DisjointSetImplementation.java`

## Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/disjoint-set-union-find/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=aBxjDBC4M1U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=46)
- [📄 takeUforward](https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

This is a better approach Disjoint set using size It will also use Path compression along the way It uses a recursive approach to find and do the union method

```java
private static void type2() {
		DisjointSet disjointSet = new DisjointSetBySize(7);
		// union rank means adding one edge
		disjointSet.union(1, 2);
		disjointSet.union(2, 3);
		disjointSet.union(4, 5);
		disjointSet.union(6, 7);
		disjointSet.union(5, 6);

		// if 3 and 7 are in the same component or not
		checkIfSame(disjointSet.find(3), disjointSet.find(7));
		// adding 3 and 7 into the same component
		disjointSet.union(3, 7);
		// if 3 and 7 are in the same component or not
		checkIfSame(disjointSet.find(3), disjointSet.find(7));
	}
```

### Approach 1 — Brute Force

First, we will create two arrays if storing parent node and the size of the node initially all the node will be its parent node, and size will be 1 find the parent of the component in which the node belongs if the node is itself parent, then it is the ultimate parent of the component recursively, we will find the ultimate parent path compression by setting the ultimate parent if they remove the next line then all node will just connect to its upper parent we will unify the u's component and v's component if parent of the both nodes is same, then we will return we will set the bigger size component as the ultimate parent Disjoint set using rank It will also use Path compression along the way It uses a recursive approach to find and do the union method

```java
private static void type1() {
		DisjointSet disjointSet = new DisjointSetByRank(7);
		// union rank means adding one edge
		disjointSet.union(1, 2);
		disjointSet.union(2, 3);
		disjointSet.union(4, 5);
		disjointSet.union(6, 7);
		disjointSet.union(5, 6);

		// if 3 and 7 are in the same component or not
		checkIfSame(disjointSet.find(3), disjointSet.find(7));
		// adding 3 and 7 into the same component
		disjointSet.union(3, 7);
		// if 3 and 7 are in the same component or not
		checkIfSame(disjointSet.find(3), disjointSet.find(7));
	}
	public static void checkIfSame(int p1, int p2) {
		if (p1 == p2) System.out.println("Same");
		else System.out.println("Not Same");
	}
```
