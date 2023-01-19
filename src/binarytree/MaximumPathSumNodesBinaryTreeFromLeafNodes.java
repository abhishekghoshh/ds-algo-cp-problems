package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
 * https://www.codingninjas.com/codestudio/problems/maximum-path-sum-between-two-leaves_794950?leftPanelTab=1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ArNyupe-XH0&list=PL_z_8CaSLPWfxJPz2-YKqL9gXWdgrhvdn&index=5
 * 
 * https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
 * 
 * */
public class MaximumPathSumNodesBinaryTreeFromLeafNodes {

	public static void main(String args[]) {
//		TreeNode<Integer> root = TreeNode.withAllNodesGiven(1, 2, 3, -2, -1);
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(6, -9, -10);
		MaxPathSum maxPathSum = new MaxPathSum();
		maxPath(root, maxPathSum);
		System.out.println(maxPathSum.get());
	}

	private static int maxPath(TreeNode<Integer> root, MaxPathSum maxPathSum) {
		if (null == root)
			return 0;
		if (null == root.left && null == root.right) {
			return root.val;
		}
		int left = maxPath(root.left, maxPathSum);
		int right = maxPath(root.right, maxPathSum);

		if (null != root.left && null != root.right) {
			maxPathSum.value = Math.max(maxPathSum.value, root.val + left + right);
			return root.val + Math.max(left, right);
		} else {
			return root.val + (null != root.left ? left : right);
		}
	}

	static class MaxPathSum {
		public int value = Integer.MIN_VALUE;

		public int get() {
			return value != Integer.MIN_VALUE ? value : -1;
		}
	}
}
