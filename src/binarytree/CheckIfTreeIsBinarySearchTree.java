package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/validate-binary-search-tree/
 * https://practice.geeksforgeeks.org/problems/check-for-bst/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=f-sj7I5oXEI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=47
 * 
 * 
 */
public class CheckIfTreeIsBinarySearchTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.makeBST(15);
		boolean isValidBst = isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
		System.out.println(isValidBst);
	}

	private static boolean isValidBst(TreeNode<Integer> root, long minValue, long maxValue) {
		if (null == root)
			return true;
		if (root.val <= minValue || root.val >= maxValue)
			return false;
		return isValidBst(root.left, minValue, root.val) && isValidBst(root.right, root.val, maxValue);
	}

}
