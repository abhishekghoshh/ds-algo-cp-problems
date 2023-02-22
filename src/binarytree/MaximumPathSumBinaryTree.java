package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * https://www.codingninjas.com/codestudio/problems/794950
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=WszrfSwMz58&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=18
 * https://www.youtube.com/watch?v=Osz-Vwer6rw&list=PL_z_8CaSLPWfxJPz2-YKqL9gXWdgrhvdn&index=4
 * 
 * https://takeuforward.org/data-structure/maximum-sum-path-in-binary-tree/
 * */
public class MaximumPathSumBinaryTree {

	// A path in a binary tree is a sequence of nodes where each pair of adjacent
	// nodes in the sequence has an edge connecting them. A node can only appear in
	// the sequence at most once. Note that the path does not need to pass through
	// the root.
	// The path sum of a path is the sum of the node's values in the path.
	// Given the root of a binary tree, return the maximum path sum of any non-empty
	// path.
	public static void main(String args[]) {
		type1();
		type2();
		type3();
	}

	private static int maxPath;

	private static void type3() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(1, 2, 3, -2, -1);   
		maxPath = root.val;
		maxPath = Math.max(maxPath(root), maxPath);
		System.out.println(maxPath);
	}

	private static int maxPath(TreeNode<Integer> node) {
		if (node == null)
			return 0;
		int leftMax = Math.max(maxPath(node.left), 0);
		int rightMax = Math.max(maxPath(node.right), 0);
		maxPath = Math.max(leftMax + rightMax + node.val, maxPath);
		return node.val + Math.max(leftMax, rightMax);
	}

	private static void type2() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(1, 2, 3, -2, -1);
		int maxValue[] = { Integer.MIN_VALUE };
		maxPath(root, maxValue);
		System.out.println(maxValue[0]);
	}

	public static int maxPath(TreeNode<Integer> node, int maxValue[]) {
		if (node == null)
			return 0;
		int left = Math.max(0, maxPath(node.left, maxValue));
		int right = Math.max(0, maxPath(node.right, maxValue));
		maxValue[0] = Math.max(maxValue[0], left + right + node.val);
		return Math.max(left, right) + node.val;
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(1, 2, 3, -2, -1);
		MaxPathSum maxPathSum = new MaxPathSum();
		maxPath(root, maxPathSum);
		System.out.println(maxPathSum.value);
	}

	private static int maxPath(TreeNode<Integer> root, MaxPathSum maxPathSum) {
		if (null == root)
			return 0;
		// if left is negative then we will discard left as we are not considering leaf
		// node here, as we need any node to any node sum
		// if leaf to leaf sum required then we should not discard any value
		int left = maxPath(root.left, maxPathSum);
		left = left > 0 ? left : 0;

		// if right is negative then we will discard right
		int right = maxPath(root.right, maxPathSum);
		right = right > 0 ? right : 0;

		// at this time left or right is either 0 or any positive value
		// max between left path and right path
		int maxPath = root.val + Math.max(left, right);

		// max path root.value + left sum + right sum
		maxPathSum.value = Math.max(maxPathSum.value, root.val + left + right);

		return maxPath;
	}

	static class MaxPathSum {
		public int value = Integer.MIN_VALUE;
	}

}
