package problems.binarytree;

import util.TreeNode;

public class MaximumPathSumOnlyLeafNodesBinaryTree {

	public static void main(String args[]) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(-2);
		root.left.right = new TreeNode<>(-1);
		System.out.println(maxPathSum(root));
	}

	static class Holder {
		public int value = Integer.MIN_VALUE;
	}

	public static int maxPathSum(TreeNode<Integer> root) {
		Holder holder = new Holder();
		maxPath(root, holder);
		return holder.value;
	}

	private static int maxPath(TreeNode<Integer> root, Holder holder) {
		if (null == root) {
			return 0;
		}
		int left = maxPath(root.left, holder);
		int right = maxPath(root.right, holder);

		// if its a part of ans
		int maxPath = root.val + Math.max(left, right);

		// if its the ans
		int tempPathSum = root.val + left + right;
		if (tempPathSum > holder.value) {
			holder.value = tempPathSum;
		}

		return maxPath;
	}
}
