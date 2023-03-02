package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=FiFiNvM29ps&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=44
 * 
 * 
 */
public class InsertNodeInBinarySearchTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// iterative way of adding nodes to the leaf
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(4, 2, 7, 1, 3);
		int val = 5;
		if (root == null) {
			root = new TreeNode<>(val);
			return;
		}
		TreeNode<Integer> curr = root;
		while (null != curr) {
			if (curr.val < val && curr.right == null) {
				curr.right = new TreeNode<>(val);
				break;
			} else if (curr.val > val && curr.left == null) {
				curr.left = new TreeNode<>(val);
				break;
			} else if (curr.val < val) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		System.out.println(root.levelOrder());
	}

	// recursive way of adding nodes to the leaf
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(4, 2, 7, 1, 3);
		root = insertIntoBST(root, 5);
		System.out.println(root.levelOrder());
	}

	public static TreeNode<Integer> insertIntoBST(TreeNode<Integer> root, int val) {
		if (root == null) {
			return new TreeNode<>(val);
		} else if (root.val < val && root.right == null) {
			root.right = new TreeNode<>(val);
		} else if (root.val > val && root.left == null) {
			root.left = new TreeNode<>(val);
		} else if (root.val < val) {
			insertIntoBST(root.right, val);
		} else {
			insertIntoBST(root.left, val);
		}
		return root;
	}
}
