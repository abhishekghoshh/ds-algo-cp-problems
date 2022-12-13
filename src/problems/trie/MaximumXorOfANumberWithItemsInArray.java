package problems.trie;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * 
 * 
 */
public class MaximumXorOfANumberWithItemsInArray {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// using trie approach
	private static void type2() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int num = 325;
		int xor = 0;
		Trie trie = new Trie();
		for (int item : nums) {
			trie.insert(item);
		}

	}

	public static class Trie {
		private static final int BIT_SIZE = 31;
		private Node head;

		public Trie() {
			head = new Node();
		}

		public void insert(int n) {
			Node node = head;
			for (int i = 31; i >= 0; i--) {
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
			int mask = 1 << BIT_SIZE;
			for (int i = BIT_SIZE; i >= 0; i--) {
				// it will check set bit at ith position
				int bit = (num & mask) == 0 ? 0 : 1;
				// 1-bit is equal to ~1 or the inverse of bit
				// we can maximize the xor if the reverse bit is present
				if (!node.isNull(1 - bit)) {
					node = node.set(1 - bit);
					// set the i'th bit in maxXor
					maxXor = maxXor | mask;
				} else {
					node = node.get(bit);
				}
				mask = mask >> 1;
			}
			return maxXor;
		}

		public int getMaxXor2(int num) {
			Node node = head;
			int maxNum = 0;
			for (int i = 31; i >= 0; i--) {
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
	// time complexity O(n)
	private static void type1() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int num = 325;
		int xor = 0;
		for (int item : nums) {
			xor = Math.max((item ^ num), xor);
		}
		System.out.println(xor);
	}

}
