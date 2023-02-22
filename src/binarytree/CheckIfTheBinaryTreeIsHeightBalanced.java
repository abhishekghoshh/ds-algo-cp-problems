package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/balanced-binary-tree/
 * https://www.codingninjas.com/codestudio/problems/975497
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16
 * 
 * https://takeuforward.org/data-structure/check-if-the-binary-tree-is-balanced-binary-tree/
 */
public class CheckIfTheBinaryTreeIsHeightBalanced {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(10);
		boolean isBalanced = height(root) != -1;
		System.out.println(isBalanced);
	}

	private static int height(TreeNode<Integer> root) {
		if (null == root)
			return 0;
		int leftHeight = height(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = height(root.right);
		if (rightHeight == -1)
			return -1;
		if (Math.abs(rightHeight - leftHeight) > 1)
			return -1;
		return 1 + Math.max(leftHeight, rightHeight);
	}

}
