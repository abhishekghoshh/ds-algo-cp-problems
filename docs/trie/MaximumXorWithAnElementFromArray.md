# MaximumXorWithAnElementFromArray

**Topic:** `trie`  
**Tags:** Bit Manipulation, Tries

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/max-xor-queries_1382020)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=7)
- [📄 takeUforward](https://takeuforward.org/trie/maximum-xor-queries-trie/)

## 📝 Problem Statement

You are given an array nums consisting of non-negative integers. You are also

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

check this solution later and add comments Purely for leetcode, inspired from previous types root and query.x

```java
	private static void type3() {
		int[] nums = {5, 2, 4, 6, 6, 3};
		int[][] queries = {{12, 4}, {8, 1}, {6, 3}};

		Arrays.sort(nums);
		int[] ans = new int[queries.length];
		Arrays.fill(ans, -1);
		List<Query> queryList = new ArrayList<>();
		for (int i = 0; i < queries.length; i++) {
			int x = queries[i][0], m = queries[i][1];
			queryList.add(new Query(x, m, i));
		}
		Collections.sort(queryList);
		TrieNode root = new TrieNode();
		int i = 0;
		for (Query query : queryList) {
			while (i < nums.length && nums[i] <= query.m) {
				insert(root, nums[i]);
				i++;
			}
			// root and query.x
			ans[query.idx] = get(root, query.x);
		}
		print(ans);
	}

	private static class TrieNode {
		public TrieNode left, right;
	}

	private static class Query implements Comparable<Query> {
		public int x, m, idx;

		public Query(int x, int m, int idx) {
			this.x = x;
			this.m = m;
			this.idx = idx;
		}

		@Override
		public int compareTo(Query query) {
			return this.m - query.m;
		}
	}

	private static int get(TrieNode root, int x) {
		int ans = 0;
		for (int i = 30 - 1; i >= 0; i--) {
			if ((x & (1 << i)) != 0) {
				if (root.left != null) {
					root = root.left;
					ans = ans | (1 << i);
				} else if (root.right != null) {
					root = root.right;
				} else {
					return -1;
				}
			} else {
				if (root.right != null) {
					root = root.right;
					ans = ans | (1 << i);
				} else if (root.left != null) {
					root = root.left;
				} else {
					return -1;
				}
			}
		}
		return ans;
	}

	private static void insert(TrieNode root, int val) {
		for (int i = 30 - 1; i >= 0; i--) {
			if ((val & (1 << i)) != 0) {
				if (root.right == null) {
					root.right = new TrieNode();
				}
				root = root.right;
			} else {
				if (root.left == null) {
					root.left = new TrieNode();
				}
				root = root.left;
			}
		}
	}
```

### Approach 2

purely for leetcode 3 for storing number , maximum and the index

```java
	private static void type2() {
		int[] nums = {5, 2, 4, 6, 6, 3};
		int[][] queries = {{12, 4}, {8, 1}, {6, 3}};

		int n = queries.length;
		int[] answer = new int[n];
		Trie trie = new Trie();

		// 3 for storing number , maximum and the index
		int[][] points = new int[n][3];
		for (int i = 0; i < n; i++)
			points[i] = new int[] { queries[i][0], queries[i][1], i };

		Arrays.sort(nums);
		Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
		int i = 0;
		for (int[] point : points) {
			while (i < nums.length && nums[i] <= point[1]) {
				trie.insert(nums[i]);
				i++;
			}
			answer[point[2]] = i != 0 ? trie.getMaxXor(point[0]) : -1;
		}
		print(answer);
	}
```

### Approach 1: 🔨 Brute Force

don't create inner static class it is just for local not for competition it will take for time

```java
	private static void type1() {
		int[] nums = {5, 2, 4, 6, 6, 3};
		int[][] queries = {{12, 4}, {8, 1}, {6, 3}};

		int n = queries.length;
		int[] answer = new int[n];
		Trie trie = new Trie();
		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			points[i] = new Point(queries[i][0], queries[i][1], i);
		}
		Arrays.sort(nums);
		Arrays.sort(points, Comparator.comparingInt(p -> p.max));
		int i = 0;
		for (Point point : points) {
			while (i < nums.length && nums[i] <= point.max) {
				trie.insert(nums[i]);
				i++;
			}
			answer[point.index] = i != 0 ? trie.getMaxXor(point.num) : -1;
		}
		print(answer);
	}

	// don't create inner static class
	// it is just for local not for competition
	// it will take for time
	public static class Trie {
		private final int bitSize = 31;
		private final Node head = new Node();

		public void insert(int n) {
			Node node = head;
			int mask = 1 << bitSize;
			for (int i = bitSize; i >= 0; i--) {
				int bit = (n & mask) == 0 ? 0 : 1;
				if (node.nodes[bit] == null)
					node.nodes[bit] = new Node();
				node = node.nodes[bit];
				mask = mask >>> 1;
			}
		}

		public int getMaxXor(int num) {
			Node node = head;
			int maxXor = 0;
			int mask = 1 << bitSize;
			for (int i = bitSize; i >= 0; i--) {
				int bit = (num & mask) == 0 ? 0 : 1;
				if (node.nodes[1 - bit] != null) {
					node = node.nodes[1 - bit];
					maxXor = maxXor | mask;
				} else {
					node = node.nodes[bit];
				}
				mask = mask >>> 1;
			}
			return maxXor;
		}

		public static class Node {
			public final Node[] nodes = new Node[2];
		}
	}

	public static class Point {
		int num;
		int max;
		int index;
		int xor;

		public Point(int num, int max, int index) {
			this.num = num;
			this.max = max;
			this.index = index;
			this.xor = -1;
		}
	}

}
```
