package problems.trie;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
 * https://www.codingninjas.com/codestudio/problems/max-xor-queries_1382020?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=7
 * 
 */
public class MaximumXORwithAnElementFromArrayWithQuery {

	// You are given an array nums consisting of non-negative integers. You are also
	// given a queries array, where queries[i] = [xi, mi].
	// The answer to the ith query is the maximum bitwise XOR value of xi and any
	// element of nums that does not exceed mi. In other words, the answer is
	// max(nums[j] XOR xi) for all j such that nums[j] <= mi. If all elements in
	// nums are larger than mi, then the answer is -1.
	// Return an integer array answer where answer.length == queries.length and
	// answer[i] is the answer to the ith query.
	public static void main(String[] args) {
		type1();
		type2();
	}

	// purely for leetcode
	private static void type2() {
//		int[] nums = { 5, 2, 4, 6, 6, 3 };
//		int[][] queries = { { 12, 4 }, { 8, 1 }, { 6, 3 } };

		int[] nums = { 537623, 4096, 4096, 7351703, 4096, 2790666, 3810100, 3596649, 2771788, 1751995, 1414302,
				22158312, 15941567, 32835966, 4096, 26516532, 3772313, 687681, 4096, 2902600 };
		int[][] queries = { { 17484496, 1000000000 }, { 391935295, 158969 }, { 389948163, 1000000000 },
				{ 530828903, 207846853 }, { 1000000000, 1000000000 }, { 1000000000, 1000000000 },
				{ 276739277, 1000000000 }, { 350541283, 1000000000 }, { 343329183, 1000000000 }, { 382830042, 225644 },
				{ 1000000000, 2302405 }, { 3708384, 1000000000 }, { 330902154, 1000000000 }, { 1000000000, 4024838 },
				{ 527385402, 142642 }, { 312288482, 1000000000 }, { 1000000000, 1000000000 }, { 19929306, 3787993 },
				{ 15768874, 1000000000 }, { 27944430, 172704181 } };

		int n = queries.length;
		int[] answer = new int[n];

		Arrays.sort(nums);
		Trie2 trie = new Trie2();

		// 3 for storing number , maximum and the index
		int[][] points = new int[n][3];
		for (int i = 0; i < n; i++) {
			points[i] = new int[] { queries[i][0], queries[i][1], i };
		}
		Arrays.sort(points, (p1, p2) -> Integer.compare(p1[1], p2[1]));
		int i = 0;
		for (int[] point : points) {
			while (i < nums.length && nums[i] <= point[1]) {
				trie.insert(nums[i]);
				i++;
			}
			if (i != 0)
				answer[point[2]] = trie.getMaxXor(point[0]);
			else
				answer[point[2]] = -1;
		}
		print(answer);
	}

	// don't create inner static class
	// it is just for local not for competition
	// it will take for time
	public static class Trie2 {
		private int bitSize = 31;
		private Node head = new Node();

		public void insert(int n) {
			Node node = head;
			int mask = 1 << bitSize;
			for (int i = bitSize; i >= 0; i--) {
				int bit = (n & mask) == 0 ? 0 : 1;
				if (node.nodes[bit] == null) {
					node.nodes[bit] = new Node();
				}
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

		public class Node {
			Node[] nodes = new Node[2];
		}
	}

	private static void type1() {
//		int[] nums = { 5, 2, 4, 6, 6, 3 };
//		int[][] queries = { { 12, 4 }, { 8, 1 }, { 6, 3 } };

		int[] nums = { 537623, 4096, 4096, 7351703, 4096, 2790666, 3810100, 3596649, 2771788, 1751995, 1414302,
				22158312, 15941567, 32835966, 4096, 26516532, 3772313, 687681, 4096, 2902600 };
		int[][] queries = { { 17484496, 1000000000 }, { 391935295, 158969 }, { 389948163, 1000000000 },
				{ 530828903, 207846853 }, { 1000000000, 1000000000 }, { 1000000000, 1000000000 },
				{ 276739277, 1000000000 }, { 350541283, 1000000000 }, { 343329183, 1000000000 }, { 382830042, 225644 },
				{ 1000000000, 2302405 }, { 3708384, 1000000000 }, { 330902154, 1000000000 }, { 1000000000, 4024838 },
				{ 527385402, 142642 }, { 312288482, 1000000000 }, { 1000000000, 1000000000 }, { 19929306, 3787993 },
				{ 15768874, 1000000000 }, { 27944430, 172704181 } };

		int n = queries.length;
		int[] answer = new int[n];

		Arrays.sort(nums);
		Trie trie = new Trie();

		Point[] points = new Point[n];
		for (int i = 0; i < n; i++) {
			points[i] = new Point(queries[i][0], queries[i][1], i);
		}
		Arrays.sort(points, (p1, p2) -> Integer.compare(p1.max, p2.max));
		int i = 0;
		for (Point point : points) {
			while (i < nums.length && nums[i] <= point.max) {
				trie.insert(nums[i]);
				i++;
			}
			if (i != 0)
				answer[point.index] = trie.getMaxXor(point.num);
			else
				answer[point.index] = -1;
		}
		print(answer);
	}

	private static void print(int[] nums) {
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static class Trie {
		private int bitSize = 31;
		private Node head = new Node();

		public void insert(int n) {
			Node node = head;
			int mask = 1 << bitSize;
			for (int i = bitSize; i >= 0; i--) {
				int bit = (n & mask) == 0 ? 0 : 1;
				if (node.isNull(bit)) {
					node = node.set(bit);
				} else {
					node = node.get(bit);
				}
				mask = mask >>> 1;
			}
		}

		public int getMaxXor(int num) {
			Node node = head;
			int maxXor = 0;
			int mask = 1 << bitSize;
			for (int i = bitSize; i >= 0; i--) {
				int bit = (num & mask) == 0 ? 0 : 1;
				if (!node.isNull(1 - bit)) {
					node = node.get(1 - bit);
					maxXor = maxXor | mask;
				} else {
					node = node.get(bit);
				}
				mask = mask >>> 1;
			}
			return maxXor;
		}

		public class Node {
			private Node[] nodes;

			Node() {
				this.nodes = new Node[2];
			}

			public Node get(int pos) {
				return nodes[pos];
			}

			public boolean isNull(int pos) {
				return null == nodes[pos];
			}

			public Node set(int pos) {
				Node node = new Node();
				nodes[pos] = node;
				return node;
			}
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
