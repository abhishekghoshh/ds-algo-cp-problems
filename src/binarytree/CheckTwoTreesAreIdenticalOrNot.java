package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/same-tree/
 * https://www.codingninjas.com/codestudio/problems/799364
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=BhuvF_-PWS0&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=19
 * 
 * https://takeuforward.org/data-structure/check-if-two-trees-are-identical/
 */
public class CheckTwoTreesAreIdenticalOrNot {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root1 = TreeNode.withCount(20);
		TreeNode<Integer> root2 = TreeNode.withCount(20);
		boolean isIdentical = isSameTree(root1, root2);
		System.out.println(isIdentical);
	}

	private static boolean isSameTree(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if (null == root1 && null == root2) {
			// if both node is null then both are identical
			return true;
		} else if (null == root1 || null == root2) {
			// if either one node is null then tree is not identical
			return false;
		} else {
			// if both node has some value then first we will check the values
			// or then it will check left subtree for both tree and then it will check right
			// subtree
			return root1.val == root2.val && isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
		}
	}

}
