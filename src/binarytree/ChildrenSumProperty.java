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
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(9, 3, 3, 1, 2);
		int val = isSumProperty(root) > 0 ? 1 : 0;
		System.out.println(val);
	}

	public static int isSumProperty(TreeNode<Integer> root) {
		if (null == root)
			return -1;
		int leftSum = isSumProperty(root.left);
		int rightSum = isSumProperty(root.right);
		Integer val = root.val;
		if (leftSum == -1 && rightSum == -1) {
			return val;
		} else if (leftSum == -1) {
			return rightSum == val ? val + rightSum : 0;
		} else if (rightSum == -1) {
			return leftSum == val ? val + leftSum : 0;
		} else {
			return leftSum + rightSum == val ? val + leftSum + rightSum : 0;
		}
	}

}
