package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/children-sum-parent/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=fnmisPM6cVo&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=30
 * 
 * https://takeuforward.org/data-structure/check-for-children-sum-property-in-a-binary-tree/
 */
public class ChildrenSumProperty {

	// Given a Binary Tree. Check whether all of its nodes have the value equal to
	// the sum of their child nodes.
	public static void main(String[] args) {
		type1();
		type2();
	}

	// NOTE
	// this is taken from striver video
	// this problem is not in the geekforgeeks link
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(2, 35, 10, 2, 3, 5, 2);
		System.out.println(root.levelOrder());
		reorder(root);
		System.out.println(root.levelOrder());
	}

	// TODO study it later
	// it will change the dynamics of the tree
	private static void reorder(TreeNode<Integer> root) {
		if (root == null)
			return;
		int child = 0;
		if (root.left != null)
			child += root.left.val;
		if (root.right != null)
			child += root.right.val;
		if (child < root.val) {
			if (root.left != null)
				root.left.val = root.val;
			else if (root.right != null)
				root.right.val = root.val;
		}
		reorder(root.left);
		reorder(root.right);
		int tot = 0;
		if (root.left != null)
			tot += root.left.val;
		if (root.right != null)
			tot += root.right.val;
		if (root.left != null || root.right != null)
			root.val = tot;
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(10, 10);
		int val = isSumProperty(root) != -1 ? 1 : 0;
		System.out.println(val);
	}

	public static int isSumProperty(TreeNode<Integer> root) {
		if (null == root)
			return 0;
		if (null == root.left && null == root.right) {
			return root.val;
		}
		int leftVal = isSumProperty(root.left);
		int rightVal = isSumProperty(root.right);
		if (leftVal == -1 || rightVal == -1)
			return -1;
		return leftVal + rightVal == root.val ? root.val : -1;
	}

}
