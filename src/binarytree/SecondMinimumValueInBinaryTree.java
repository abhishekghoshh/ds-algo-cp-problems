package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * 
 * Solution link :
 * 
 * 
 * */
public class SecondMinimumValueInBinaryTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = new TreeNode<>(8).left(new TreeNode<>(5)).right(new TreeNode<>(6));
		long[] data = { Long.MAX_VALUE, Long.MAX_VALUE };
		findSecondMinimumValue(root, data);
		int val = data[1] != Long.MAX_VALUE ? (int) data[1] : -1;
		System.out.println(val);
	}

	public static void findSecondMinimumValue(TreeNode<Integer> root, long[] data) {
		if (null != root) {
			findSecondMinimumValue(root.left, data);
			if (root.val < data[0] && root.val < data[1]) {
				data[1] = data[0];
				data[0] = root.val;
			} else if (root.val > data[0] && root.val < data[1]) {
				data[1] = root.val;
			}
			findSecondMinimumValue(root.right, data);
		}
	}
}
