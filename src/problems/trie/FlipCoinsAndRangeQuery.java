package problems.trie;

public class FlipCoinsAndRangeQuery {

	public static void main(String[] args) {
		type1();
	}

	// in update query range of coins will be flipped
	// we will store the number of heads only
	// flip means rangeCount-countOfHead
	// we will use a boolean array
	// if false means no need to flip
	// true means flip
	// even times of flip means no flip
	private static void type1() {

	}

	public static class SegmentTree {
		int n;
		int[] tree;
		boolean[] lazy;
		int arrSize;

		public SegmentTree(int[] arr) {
			arrSize = arr.length;
			n = 4 * arrSize;
			tree = new int[n];
			lazy = new boolean[n];
			build(arr, tree, 0, arr.length - 1, 0);
		}

		private void build(int[] arr, int[] tree, int left, int right, int index) {
			if (left == right) {
				tree[index] = arr[left] % 2;
			} else {
				int mid = (left + right) / 2;
				build(arr, tree, left, mid, 2 * index + 1);
				build(arr, tree, mid + 1, right, 2 * index + 2);
				tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
			}
		}

		public int headCount(int left, int right) {
			return headCount(tree, 0, arrSize - 1, left, right, 0);
		}

		private int headCount(int[] tree, int low, int high, int left, int right, int index) {
			// update the previous remaining update and propagate that
			// later we can do the current operation
			if (lazy[index]) {
				// node count - head coin count
				// flipping the head counts
				tree[index] = (high - low + 1) - tree[index];
				// if low!=high then it has children so we can propagate the addition down
				if (low != high) {
					lazy[2 * index + 1] = !lazy[2 * index + 1];
					lazy[2 * index + 2] = !lazy[2 * index + 2];
				}
				lazy[index] = false;
			}

			// our main query operation
			if (low > right || high < left) {
				return 0;
			} else if (low >= left && high <= right) {
				return tree[index];
			} else {
				int mid = low + (high - low) / 2;
				int leftSum = headCount(tree, low, mid, left, right, 2 * index + 1);
				int rightSum = headCount(tree, mid + 1, high, left, right, 2 * index + 2);
				return leftSum + rightSum;
			}
		}

		public void update(int i, int num) {
			update(tree, i, num, 0, n - 1, 0);
		}

		private void update(int[] tree, int i, int num, int low, int high, int index) {
			if (low == high) {
				// if the we are using modulo if the number is more than 1
				// ideally it should not occur
				tree[index] = num % 2;
			} else {
				int mid = low + (high - low) / 2;
				if (i <= mid)
					update(tree, i, num, low, mid, 2 * index + 1);
				else
					update(tree, i, num, mid + 1, high, 2 * index + 2);
				tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
			}
		}

		// update the node when you visit it
		// propagate the update to downwards
		// only for the complete overlap we will change the node and propagate
		public void updateRange(int left, int right) {
			updateAndPropagrate(tree, 0, arrSize - 1, left, right, 0);
		}

		public void updateAndPropagrate(int[] tree, int low, int high, int left, int right, int index) {
			// update the previous remaining update and propagate that
			// later we can update the current update
			if (lazy[index]) {
				// high-low+1 will give the count of the range for which the node is responsible
				tree[index] = (high - low + 1) - tree[index];
				// if low!=high then it has children so we can propagate the addition down
				if (low != high) {
					lazy[2 * index + 1] = !lazy[2 * index + 1];
					lazy[2 * index + 2] = !lazy[2 * index + 2];
				}
				lazy[index] = false;
			}

			// actual addition for current addition
			// no overlap
			if (low > right || high < left) {
				return;
			} else if (low >= left && high <= right) {
				// complete overlap
				// flip the coins
				// heads will be equal to tails which is node-heads
				tree[index] = (high - low + 1) - tree[index];
				// if the node is responsible for more than one node
				// so can propagate the addition
				if (low != high) {
					lazy[2 * index + 1] = !lazy[2 * index + 1];
					lazy[2 * index + 2] = !lazy[2 * index + 2];
				}
				return;
			} else {
				int mid = low + (high - low) / 2;
				updateAndPropagrate(tree, low, mid, left, right, 2 * index + 1);
				updateAndPropagrate(tree, mid + 1, high, left, right, 2 * index + 2);
				tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
			}
		}
	}
}
