# MaximumXorWithAnElementFromArray

**Topic:** `trie` | **File:** `com/problems/trie/MaximumXorWithAnElementFromArray.java`

**Tags:** Bit Manipulation, Tries

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-xor-with-an-element-from-array/)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/max-xor-queries_1382020)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=7)
- [📄 takeUforward](https://takeuforward.org/trie/maximum-xor-queries-trie/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi]. The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1. Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query. Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]] Output: [3,3,7] Explanation: 1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3. 2) 1 XOR 2 = 3. 3) 5 XOR 2 = 7. Input: nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]] Output: [15,-1,5] 1 <= nums.length, queries.length <= 105 queries[i].length == 2 0 <= nums[j], xi, mi <= 109 You are given an array nums consisting of non-negative integers. You are also given a queries array, where queries[i] = [xi, mi]. The answer to the ith query is the maximum bitwise XOR value of xi and any element of nums that does not exceed mi. In other words, the answer is max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in nums are larger than mi, then the answer is -1. Return an integer array answer where answer.length == queries.length and answer[i] is the answer to the ith query. TODO check this solution later and add comments Purely for leetcode, inspired from previous types

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

Purely for leetcode

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

### Approach 1 — Brute Force

Brute force approach

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
```
