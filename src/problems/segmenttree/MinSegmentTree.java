package problems.segmenttree;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * 
 * 
 */
public class MinSegmentTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] arr = { 3, 6, 1, 2, 5, 8, 6, 2, 8, 4, 5, 2, 0 };
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.min(0, 9));
	}

	public static class SegmentTree {
		int n;
		int[] tree;
		int arrSize;

		public SegmentTree(int[] arr) {
			// for any array of size n the length of the tree can be at max 4n
			arrSize = arr.length;
			n = 4 * arrSize;
			tree = new int[n];
			build(arr, tree, 0, arr.length - 1, 0);
		}

		// time complexity is equivalent to the number of nodes visited
		// the size of the tree can be at max 4n
		// so time complexity will be at max O(4n)
		private void build(int[] arr, int[] tree, int left, int right, int index) {
			if (left == right) {
				tree[index] = arr[left];
			} else {
				int mid = (left + right) / 2;
				build(arr, tree, left, mid, 2 * index + 1);
				build(arr, tree, mid + 1, right, 2 * index + 2);
				tree[index] = Math.min(tree[2 * index + 1], tree[2 * index + 2]);
			}
		}

		// for min operation
		// there can be 3 cases
		// partial overlap, no overlap, complete overlap
		// 1.partial overlap of node with the range (L,R)
		// then return min(left,right)
		// 2.no overlap with the range (L,R)
		// then return INT_MAX
		// 3.complete overlap with the range (L,R)
		// then return tree(index)
		public int min(int l, int r) {
			return min(tree, 0, arrSize - 1, l, r, 0);
		}

		// time complexity is approximately O(log(n))
		// for very small range no overlap will be occurring most
		// for very big range complete overlap will be occurring most 
		private int min(int[] tree, int low, int high, int left, int right, int index) {
			// low, high is the segment tree range
			// left right is the array/query range
			// low > right means our query range lies right side of the segment tree
			// high<right means our query range lies left side of the segment tree
			// [left,right][low,high] or [low,high][left,right]
			// no overlap
			if (low > right || high < left) {
				return Integer.MAX_VALUE;
			} else if (low >= left && high <= right) {
				// complete overlap
				// that mean our query range lies in between the tree range
				return tree[index];
			} else {
				// partial overlap
				int mid = low + (high - low) / 2;
				int leftMin = min(tree, low, mid, left, right, 2 * index + 1);
				int rightMin = min(tree, mid + 1, high, left, right, 2 * index + 2);
				return Math.min(leftMin, rightMin);
			}
		}

		public void update(int i, int num) {
			update(tree, i, num, 0, n - 1, 0);
		}

		// time complexity O(log(4n))
		private void update(int[] tree, int i, int num, int low, int high, int index) {
			// we have reached to the point
			// where we need to update
			if (low == high) {
				tree[index] = num;
			} else {
				int mid = low + (high - low) / 2;
				// i lies in the left
				if (i <= mid) {
					update(tree, i, num, low, mid, 2 * index + 1);
				} else {
					// i lies in right
					update(tree, i, num, mid + 1, high, 2 * index + 2);
				}
				// as the child is updated so we need to rerun
				tree[index] = Math.min(tree[2 * index + 1], tree[2 * index + 2]);
			}

		}

	}
}
