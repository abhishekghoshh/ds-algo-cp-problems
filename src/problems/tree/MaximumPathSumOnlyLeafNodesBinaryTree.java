package problems.tree;

public class MaximumPathSumOnlyLeafNodesBinaryTree {

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
		value(root, holder);
		return holder.value;
	}

	private static int value(TreeNode root, Holder holder) {
		if (null == root) {
			return 0;
		}
		int leftValue = value(root.left, holder);
		int rightValue = value(root.right, holder);

		// if its a part of ans
		int value = root.val + Math.max(leftValue, rightValue);

		// if its the ans
		int tempPathSum = root.val + leftValue + rightValue;
		if (tempPathSum > holder.value) {
			holder.value = tempPathSum;
		}

		return value;
	}
}
