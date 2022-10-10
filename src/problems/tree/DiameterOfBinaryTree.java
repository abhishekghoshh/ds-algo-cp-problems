package problems.tree;

import util.TreeNode;

public class DiameterOfBinaryTree {

	public static void main(String args[]) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode<>(2);
		root.right = new TreeNode<>(3);
		root.left.left = new TreeNode<>(4);
		root.left.right = new TreeNode<>(5);
		System.out.println(diameterOfBinaryTree(root));
	}

	public static int diameterOfBinaryTree(TreeNode<Integer> root) {
		Value value = new Value();
		height(root, value);
		return value.value - 1;
	}

	private static int height(TreeNode<Integer> root, Value value) {
		if (null == root) {
			return 0;
		}
		int leftHeight = height(root.left, value);
		int rightHeight = height(root.right, value);

		int diameter = 1 + leftHeight + rightHeight;
		int height = 1 + Math.max(leftHeight, rightHeight);
		if (value.value < diameter) {
			value.value = diameter;
		}
		return height;
	}

	private static class Value {
		public int value = Integer.MIN_VALUE;;
	}

}
