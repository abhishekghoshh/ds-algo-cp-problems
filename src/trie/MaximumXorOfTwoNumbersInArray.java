package trie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Problem link :
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * https://www.codingninjas.com/codestudio/problems/maximum-xor_3119012?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=EIhAwfHubE8&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=6
 * 
 * 
 * https://takeuforward.org/data-structure/maximum-xor-of-two-numbers-in-an-array/
 * 
 */
public class MaximumXorOfTwoNumbersInArray {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// check the top two solution of leetcode
	private static void type5() {

	}

	// TODO check later
	private static void type4() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		Set<Integer> set = new HashSet<>();
		int mask = 0;
		int max = 0;
		for (int r : nums)
			max = max >= r ? max : r;
		int leftmost = 0;
		while (max > 0) {
			leftmost++;
			max = max >> 1;
		}
		for (int i = leftmost; i >= 0; i--) {
			mask |= 1 << i;
			set.clear();
			int tmp = max | (1 << i);
			for (int s : nums) {
				if (set.contains((s & mask) ^ tmp)) {
					max = tmp;
					break;
				}
				set.add(s & mask);
			}
		}
		System.out.println(mask);
	}

	// using trie but optimized
	// rather using 31
	// we will use the bit required for the maximum number
	private static void type3() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int xor = 0;

		int max = Arrays.stream(nums).max().getAsInt();
		int maxBitSizeReqired = 0;
		while (max != 0) {
			max = max / 2;
			maxBitSizeReqired++;
		}

		Trie trie = new Trie(maxBitSizeReqired);
		for (int item : nums) {
			trie.insert(item);
		}
		for (int num : nums)
			xor = Math.max(trie.getMaxXor(num), xor);
		System.out.println(xor);
	}

	// using trie approach
	private static void type2() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int xor = 0;
		Trie trie = new Trie();
		for (int item : nums) {
			trie.insert2(item);
		}
		for (int num : nums)
			xor = Math.max(trie.getMaxXor(num), xor);
		System.out.println(xor);
	}

	public static class Trie {
		private int bitSize = 31;
		private Node head;

		public Trie() {
			head = new Node();
		}

		public Trie(int bitSize) {
			head = new Node();
			this.bitSize = bitSize;
		}

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
				// at the first time mask is 1<<31
				// which is negative
				// so we have to use unsigned shift operator >>>
				// signed shift operator is not useful here
				mask = mask >>> 1;
			}
		}

		public void insert2(int n) {
			Node node = head;
			for (int i = bitSize; i >= 0; i--) {
				int bit = (n >> i) & 1;
				if (node.isNull(bit)) {
					node = node.set(bit);
				} else {
					node = node.get(bit);
				}
			}
		}

		public int getMaxXor(int num) {
			Node node = head;
			int maxXor = 0;
			int mask = 1 << bitSize;
			for (int i = bitSize; i >= 0; i--) {
				// it will check set bit at ith position
				int bit = (num & mask) == 0 ? 0 : 1;
				// 1-bit is equal to ~1 or the inverse of bit
				// we can maximize the xor if the reverse bit is present
				if (!node.isNull(1 - bit)) {
					node = node.get(1 - bit);
					// set the i'th bit in maxXor
					maxXor = maxXor | mask;
				} else {
					node = node.get(bit);
				}
				// at the first time mask is 1<<31
				// which is negative
				// so we have to use unsigned shift operator >>>
				// signed shift operator is not useful here
				mask = mask >>> 1;
			}
			return maxXor;
		}

		public int getMaxXor2(int num) {
			Node node = head;
			int maxNum = 0;
			for (int i = bitSize; i >= 0; i--) {
				int bit = (num >> i) & 1;
				if (!node.isNull(1 - bit)) {
					maxNum = maxNum | (1 << i);
					node = node.get(1 - bit);
				} else {
					node = node.get(bit);
				}
			}
			return maxNum;
		}

		public class Node {
			private Node[] nodes;
			private boolean isEnd;

			Node() {
				this.nodes = new Node[2];
			}

			public boolean isEnd() {
				return this.isEnd;
			}

			public void setEnd() {
				this.isEnd = true;
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

	// brute force approach
	// time complexity O(n^2)
	private static void type1() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				xor = Math.max((nums[i] ^ nums[j]), xor);
			}
		}
		System.out.println(xor);
	}

}
