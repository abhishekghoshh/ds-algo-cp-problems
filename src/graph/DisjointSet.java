package graph;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/disjoint-set-union-find/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=aBxjDBC4M1U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=46
 * 
 * https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/
 */
public class DisjointSet {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		DisjointSetBySize disjointSet = new DisjointSetBySize(7);
		// union rank means adding one edge
		disjointSet.union(1, 2);
		disjointSet.union(2, 3);
		disjointSet.union(4, 5);
		disjointSet.union(6, 7);
		disjointSet.union(5, 6);

		// if 3 and 7 same or not
		if (disjointSet.find(3) == disjointSet.find(7)) {
			System.out.println("Same");
		} else
			System.out.println("Not Same");

		disjointSet.union(3, 7);
		if (disjointSet.find(3) == disjointSet.find(7)) {
			System.out.println("Same");
		} else
			System.out.println("Not Same");
	}

	static class DisjointSetBySize {
		int[] parent = null;
		int[] size = null;

		public DisjointSetBySize(int n) {
			parent = new int[n + 1];
			size = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				parent[i] = i;
				size[i] = 1;
			}
		}

		public int find(int node) {
			if (node == parent[node]) {
				return node;
			}
			int baseParent = find(parent[node]);
			// path compression by setting the ultimate parent
			// if the remove the next line then all node will just connect to its upper
			// parent
			parent[node] = baseParent;
			return parent[node];
		}

		public void union(int u, int v) {
			int baseParentU = find(u);
			int baseParentV = find(v);
			if (baseParentU == baseParentV)
				return;
			if (size[baseParentU] < size[baseParentV]) {
				parent[baseParentU] = baseParentV;
				size[baseParentV] = size[baseParentV] + size[baseParentU];
			} else {
				parent[baseParentV] = baseParentU;
				size[baseParentU] = size[baseParentU] + size[baseParentV];
			}
		}
	}

	private static void type1() {
		DisjointSetByRank disjointSet = new DisjointSetByRank(7);
		// union rank means adding one edge
		disjointSet.union(1, 2);
		disjointSet.union(2, 3);
		disjointSet.union(4, 5);
		disjointSet.union(6, 7);
		disjointSet.union(5, 6);

		// if 3 and 7 same or not
		if (disjointSet.find(3) == disjointSet.find(7)) {
			System.out.println("Same");
		} else
			System.out.println("Not Same");

		disjointSet.union(3, 7);
		if (disjointSet.find(3) == disjointSet.find(7)) {
			System.out.println("Same");
		} else
			System.out.println("Not Same");
	}

	static class DisjointSetByRank {

		int[] rank = null;
		int[] parent = null;

		public DisjointSetByRank(int n) {
			rank = new int[n + 1];
			parent = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				rank[i] = 0;
				parent[i] = i;
			}
		}

		public int find(int node) {
			if (node == parent[node]) {
				return node;
			}
			int baseParent = find(parent[node]);
			parent[node] = baseParent;
			return parent[node];
		}

		public void union(int u, int v) {
			int baseParentU = find(u);
			int baseParentV = find(v);
			if (baseParentU == baseParentV)
				return;
			if (rank[baseParentU] < rank[baseParentV]) {
				parent[baseParentU] = baseParentV;
				rank[baseParentV]++;
			} else {
				parent[baseParentV] = baseParentU;
				rank[baseParentU]++;
			}
		}

	}

}
