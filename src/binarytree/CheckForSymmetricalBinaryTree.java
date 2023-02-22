package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/symmetric-tree/
 * https://www.codingninjas.com/codestudio/problems/630426
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=nKggNAiEpBE&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=26
 * 
 * https://takeuforward.org/data-structure/check-for-symmetrical-binary-tree/
 */
public class CheckForSymmetricalBinaryTree {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(1, 2, 2, 3, 4, 4, 3);
		boolean isSymmetric = isSymmetric(root.left, root.right);
		System.out.println(isSymmetric);
	}

	private static boolean isSymmetric(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if (null == root1 && null == root2) {
			// if both are null then it is symmetric
			return true;
		} else if (null == root1 || null == root2) {
			// if either is null then it is not symmetric
			return false;
		} else {
			// if both is non null
			// then first we will check the values of node
			// as we are checking the symmetric so we will now check cris-cross
			return root1.val == root2.val && isSymmetric(root1.left, root2.right)
					&& isSymmetric(root1.right, root2.left);
		}
	}
}
