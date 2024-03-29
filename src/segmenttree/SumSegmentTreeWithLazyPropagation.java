package segmenttree;

public class SumSegmentTreeWithLazyPropagation {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] arr = { 1, 3, 1, 2, 5 };
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.sum(0, arr.length - 1));
		System.out.println(segmentTree.sum(0, 2));
	}

	public static class SegmentTree {
		int n;
		int[] tree;
		int[] lazy;
		int arrSize;

		public SegmentTree(int[] arr) {
			arrSize = arr.length;
			n = 4 * arrSize;
			tree = new int[n];
			lazy = new int[n];
			build(arr, tree, 0, arr.length - 1, 0);
		}

		private void build(int[] arr, int[] tree, int left, int right, int index) {
			if (left == right) {
				tree[index] = arr[left];
			} else {
				int mid = (left + right) / 2;
				build(arr, tree, left, mid, 2 * index + 1);
				build(arr, tree, mid + 1, right, 2 * index + 2);
				tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
			}
		}

		public int sum(int left, int right) {
			return sum(tree, 0, arrSize - 1, left, right, 0);
		}

		private int sum(int[] tree, int low, int high, int left, int right, int index) {
			// update the previous remaining update and propagate that
			// later we can do the current operation
			if (lazy[index] != 0) {
				// high-low+1 will give the count of the range for which the node is responsible
				tree[index] += (high - low + 1) * lazy[index];
				// if low!=high then it has children so we can propagate the addition down
				if (low != high) {
					lazy[2 * index + 1] += lazy[index];
					lazy[2 * index + 2] += lazy[index];
				}
				lazy[index] = 0;
			}

			// our main query operation
			if (low > right || high < left) {
				return 0;
			} else if (low >= left && high <= right) {
				return tree[index];
			} else {
				int mid = low + (high - low) / 2;
				int leftSum = sum(tree, low, mid, left, right, 2 * index + 1);
				int rightSum = sum(tree, mid + 1, high, left, right, 2 * index + 2);
				return leftSum + rightSum;
			}
		}

		public void update(int i, int num) {
			update(tree, i, num, 0, n - 1, 0);
		}

		private void update(int[] tree, int i, int num, int low, int high, int index) {
			if (low == high) {
				tree[index] = num;
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
		public void update(int left, int right, int addition) {
			updateAndPropagrate(tree, 0, arrSize - 1, left, right, 0, addition);
		}

		public void updateAndPropagrate(int[] tree, int low, int high, int left, int right, int index, int addition) {
			// update the previous remaining update and propagate that
			// later we can update the current update
			if (lazy[index] != 0) {
				// high-low+1 will give the count of the range for which the node is responsible
				tree[index] += (high - low + 1) * lazy[index];
				// if low!=high then it has children so we can propagate the addition down
				if (low != high) {
					lazy[2 * index + 1] += lazy[index];
					lazy[2 * index + 2] += lazy[index];
				}
				lazy[index] = 0;
			}

			// actual addition for current addition
			// no overlap
			if (low > right || high < left) {
				return;
			} else if (low >= left && high <= right) {
				// complete overlap
				// update the current node by the count*addition
				tree[index] += (high - low + 1) * addition;
				// if the node is responsible for more than one node
				// so can propagate the addition
				if (low != high) {
					lazy[2 * index + 1] += addition;
					lazy[2 * index + 2] += addition;
				}
				return;
			} else {
				int mid = low + (high - low) / 2;
				updateAndPropagrate(tree, low, mid, left, right, 2 * index + 1, addition);
				updateAndPropagrate(tree, mid + 1, high, left, right, 2 * index + 2, addition);
				tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
			}
		}
	}

}
