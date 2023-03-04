package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * https://practice.geeksforgeeks.org/problems/delete-a-node-from-bst/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=kouxiP_H5WE&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=45
 * 
 * 
 */
public class DeleteNodeInBinarySearchTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(5, 3, 6, 2, 4, null, 7);
		root = deleteNode(root, 3);
		System.out.println(root.levelOrder());
	}

	// iterative way
	// first we are searching the node which is to be deleted
	public static TreeNode<Integer> deleteNode(TreeNode<Integer> root, int key) {
		if (null == root)
			return null;
		if (root.val == key) {
			return deleteCurrentNode(root);
		}
		// we are also keep tracking of the parent node
		TreeNode<Integer> curr = root, prev = null;
		while (null != curr) {
			if (key > curr.val) {
				prev = curr;
				curr = curr.right;
			} else if (key < curr.val) {
				prev = curr;
				curr = curr.left;
			} else {
				if (prev.left == curr) {
					prev.left = deleteCurrentNode(curr);
				} else {
					prev.right = deleteCurrentNode(curr);
				}
				return root;
			}
		}
		return root;
	}

	// we are passing the node which is to be deleted
	// if any of it's child node is null then we are returning other one
	// if both of the children node is non empty
	// then we know that all the left nodes is lesser than right node
	// so we can do one of 2 ways
	// either we can attach the right subtree to the right of the highest node left
	// subtree, or we can attach the left subtree to the left of the lowest of right
	// subtree, here we have used the 2nd approach
	private static TreeNode<Integer> deleteCurrentNode(TreeNode<Integer> root) {
		if (null != root.left && null != root.right) {
			TreeNode<Integer> curr = root.right;
			while (curr.left != null) {
				curr = curr.left;
			}
			curr.left = root.left;
			return root.right;
		}
		return null != root.left ? root.left : root.right;
	}

}
