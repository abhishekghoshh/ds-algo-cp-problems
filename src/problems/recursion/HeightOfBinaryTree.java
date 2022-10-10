package problems.recursion;

import util.TreeNode;

public class HeightOfBinaryTree {
	public static void main(String[] args) {
		type1();
	}

	public static void type1() {
		TreeNode<Integer> root = buildTree();
		int height = height(root);
		System.out.println(height);
	}

	private static int height(TreeNode<Integer> root) {
		if (null == root)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	private static TreeNode<Integer> buildTree() {
		return new TreeNode<>(10).left(new TreeNode<Integer>(6)
				.left(new TreeNode<Integer>(5).left(new TreeNode<Integer>(4))).right(new TreeNode<Integer>(7)))
				.right(new TreeNode<Integer>(11));
	}

}
