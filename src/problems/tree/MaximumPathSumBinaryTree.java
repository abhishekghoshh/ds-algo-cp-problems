package problems.tree;

public class MaximumPathSumBinaryTree {

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(-2);
		root.left.right = new TreeNode(-1);
		System.out.println(maxPathSum(root));
	}

	static class Holder {
		public int value = Integer.MIN_VALUE;
	}

	public static int maxPathSum(TreeNode root) {
		Holder holder = new Holder();
		maxPath(root, holder);
		return holder.value;
	}

	private static int maxPath(TreeNode root, Holder holder) {
		if (null == root) {
			return 0;
		}
		int left = maxPath(root.left, holder);
		int right = maxPath(root.right, holder);

		int maxChildValue = Math.max(left, right); // max between left path and right path
		int maxPath = root.val + (maxChildValue > 0 ? maxChildValue : 0); // if maxChildValue is negative then we will
																			// discard it

		int tempPathSum = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
		if (tempPathSum > holder.value) {
			holder.value = tempPathSum;
		}

		return maxPath;
	}
}
