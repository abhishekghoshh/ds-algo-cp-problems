package problems.binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=zmPj_Ee3B8c&list=PL_z_8CaSLPWfxJPz2-YKqL9gXWdgrhvdn&index=3
 * 
 * */
public class DiameterOfBinaryTree {

	public static void main(String args[]) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(16);
		Diameter diameter = new Diameter();
		height(root, diameter);
		diameter.data--;
		System.out.println(diameter.data);
	}

	// we will compute height and side by we will compute the diameter
	private static int height(TreeNode<Integer> root, Diameter daimeter) {
		if (null == root) {
			return 0;
		}
		int leftHeight = height(root.left, daimeter);
		int rightHeight = height(root.right, daimeter);
		int height = 1 + Math.max(leftHeight, rightHeight);
		// we just computing the diameter and updating it
		// diameter of the a node is 1 + leftHeight + rightHeight
		daimeter.data = Math.max(daimeter.data, 1 + leftHeight + rightHeight);
		return height;
	}

	private static class Diameter {
		public int data = 0;
	}

}
