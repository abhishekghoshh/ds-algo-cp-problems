package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=SXKAD2svfmI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=50
 * 
 * 
 */
public class InorderSuccessPredecessorInBST {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// inorder predecessor
	private static void type2() {
		TreeNode<Integer> root = TreeNode.makeBST(31);
		int key = 7;

		TreeNode<Integer> curr = root, ans = null;
		while (curr != null) {
			// if key is lesser than node so we need to go to the left subtree
			// if key is the equal to node then also we need to go to the left subtree
			if (key <= curr.val) {
				curr = curr.left;
			} else {
				// key > node
				// it means key is higher than node so node can be key's predecessor
				ans = curr;
				curr = curr.right;
			}
		}
		System.out.println(ans);
	}

	// inorder successor
	private static void type1() {
		TreeNode<Integer> root = TreeNode.makeBST(31);
		int key = 7;

		TreeNode<Integer> curr = root, ans = null;
		while (curr != null) {
			// if key is greater than node so we need to go to the right subtree
			// if key is equal to node then also we need to go to the right subtree
			if (key >= curr.val) {
				curr = curr.right;
			} else {
				// key < node
				// it means key is less than node so node can be key's successor
				ans = curr;
				curr = curr.left;
			}
		}
		System.out.println(ans);
	}

}
