package problems.segmenttree;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * 
 * 
 */
public class MaxSegmentTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SegmentTree segmentTree = new SegmentTree(arr);
		System.out.println(segmentTree.tree);
	}

	public static class SegmentTree {
		int n;
		int[] tree;

		public SegmentTree(int[] arr) {
			n = 4 * arr.length;
			tree = new int[n];
			build(arr, tree, 0, arr.length - 1, 0);
		}

		private void build(int[] arr, int[] tree, int i, int j, int index) {
			if (i == j) {
				tree[index] = arr[i];
			} else {
				int mid = (i + j) / 2;
				build(arr, tree, i, mid, 2 * index + 1);
				build(arr, tree, mid + 1, j, 2 * index + 2);
				tree[index] = Math.max(tree[2 * index + 1], tree[2 * index + 2]);
			}
		}

		public int get(int start, int end) {
			return 0;
		}

	}

}
