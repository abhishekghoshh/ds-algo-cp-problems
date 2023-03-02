package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * https://practice.geeksforgeeks.org/problems/search-a-node-in-bst/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=KcNt6v_56cc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=41
 * 
 * 
 */
public class SearchInBinarySearchTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.makeBST(15);
		TreeNode<Integer> node = searchBST(root, 2);
		System.out.println(node);
		System.out.println(root.searchBST(2));
	}

	public static TreeNode<Integer> searchBST(TreeNode<Integer> root, int val) {
		if (null == root || root.val == val)
			return root;
		return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
	}
}
