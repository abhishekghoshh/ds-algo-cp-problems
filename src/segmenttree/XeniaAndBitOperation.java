package segmenttree;

/*
 * Problem link :
 * https://codeforces.com/problemset/problem/339/D
 * 
 * Solution link :
 * 
 * 
 */
public class XeniaAndBitOperation {

	public static void main(String[] args) {
		type1();
	}

	// Let's consider an example. Suppose that sequence a = (1, 2, 3, 4). Then let's
	// write down all the transformations (1, 2, 3, 4) → (1 or 2 = 3, 3 or 4 = 7) →
	// (3 xor 7 = 4). The result is v = 4.
	private static void type1() {
		int[] arr = { 1, 2, 3, 4 };
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.get());

	}

	public static class SegmentTree {
		int n;
		int[] tree;
		int arrSize;
		double height;

		public SegmentTree(int[] arr) {
			arrSize = arr.length;
			n = 4 * arrSize;
			tree = new int[n];
			height = Math.log(arrSize) / Math.log(2);
			// the start will be from or operation then xor
			// do depending on the height we have to calculate
			if (height % 2 == 0)
				build(arr, tree, 0, arr.length - 1, 0, false);
			else
				build(arr, tree, 0, arr.length - 1, 0, true);
		}

		// every time we will toggle the flag
		private void build(int[] arr, int[] tree, int left, int right, int index, boolean flag) {
			if (left == right) {
				tree[index] = arr[left];
			} else {
				int mid = (left + right) / 2;
				build(arr, tree, left, mid, 2 * index + 1, !flag);
				build(arr, tree, mid + 1, right, 2 * index + 2, !flag);
				// if the flag is true then we will do or else xor
				if (flag)
					tree[index] = tree[2 * index + 1] | tree[2 * index + 2];
				else
					tree[index] = tree[2 * index + 1] ^ tree[2 * index + 2];
			}
		}

		public int get() {
			return tree[0];
		}

		public void update(int i, int num) {
			if (height % 2 == 0)
				update(tree, i, num, 0, n - 1, 0, false);
			else
				update(tree, i, num, 0, n - 1, 0, true);
		}

		private void update(int[] tree, int i, int num, int low, int high, int index, boolean flag) {
			if (low == high) {
				tree[index] = num;
			} else {
				int mid = low + (high - low) / 2;
				if (i <= mid) {
					update(tree, i, num, low, mid, 2 * index + 1, !flag);
				} else {
					update(tree, i, num, mid + 1, high, 2 * index + 2, !flag);
				}
				if (flag)
					tree[index] = tree[2 * index + 1] | tree[2 * index + 2];
				else
					tree[index] = tree[2 * index + 1] ^ tree[2 * index + 2];
			}

		}

	}

}
