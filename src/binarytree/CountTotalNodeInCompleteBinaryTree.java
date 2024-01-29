package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * https://practice.geeksforgeeks.org/problems/count-number-of-nodes-in-a-binary-tree/1
 * https://www.codingninjas.com/studio/problems/nodes-in-complete-binary-tree_1281151
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=u-yWemKGWO0&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=33
 * 
 * https://takeuforward.org/binary-tree/count-number-of-nodes-in-a-binary-tree/
 */
public class CountTotalNodeInCompleteBinaryTree {

	// Given the root of a complete binary tree, return the number of the nodes in the tree.
	// According to Wikipedia, every level, except possibly the last, is
	// filled in a complete binary tree, and all nodes in the last level are as far left as possible.
	// It can have between 1 and 2h nodes inclusive at the last level h.
	// Design an algorithm that runs in less than O(n) time complexity.
	public static void main(String[] args) {
		type1();
	}

	// out problem is to find the number of nodes in tree,
	// so we can apply any dfs or bfs to find the number of node
	// but by the problem statement it was said that the given tree is a complete
	// tree that means all nodes in the last level are as far left as possible
	// so we could use that
	// we will go to all the tree
	// we will just check if left height = right height
	// if this property holds, then the current node is a complete tree
	// we can just return 2^h-1 as the number of nodes
	// else we can go to it's left and right node
	// but as per the problem statement as the tree is complete binary tree so we
	// don't have to go too much to the left and right nodes to get the count
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(16);
		int countNodes = countNodes(root);
		System.out.println(countNodes);
	}

	public static int countNodes(TreeNode<Integer> root) {
		if (null == root) return 0;
		int lh = leftHeight(root);
		int rh = rightHeight(root);
		if (lh == rh) return (1 << lh) - 1;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	private static int rightHeight(TreeNode<Integer> root) {
		if (null == root) return 0;
		return 1 + rightHeight(root.right);
	}

	private static int leftHeight(TreeNode<Integer> root) {
		if (null == root) return 0;
		return 1 + leftHeight(root.left);
	}
}
