package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * https://www.codingninjas.com/codestudio/problems/920541
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=_-QHfMDde90&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=28
 * 
 * https://takeuforward.org/data-structure/lowest-common-ancestor-for-two-given-nodes/
 */
public class LowestCommonAncestorOfBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(100);
		TreeNode<Integer> p = root.search(20);
		TreeNode<Integer> q = root.search(40);
		TreeNode<Integer> node = lowestCommonAncestor(root, p, q);
		System.out.println(node.val);
	}

	public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p,
			TreeNode<Integer> q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode<Integer> left = lowestCommonAncestor(root.left, p, q);
		TreeNode<Integer> right = lowestCommonAncestor(root.right, p, q);
		// both left and right are not null, we found our result
		if (left != null && right != null)
			return root;
		// otherwise we will send the corresponding node
		return left == null ? right : left;
	}

	private static TreeNode<Integer> node = null;

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(100);
		TreeNode<Integer> p = root.search(20);
		TreeNode<Integer> q = root.search(40);
		find(root, p, q);
		System.out.println(node.val);

	}

	private static int find(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
		if (null == root)
			return 0;
		int flag = 0;
		if (root.val == p.val || root.val == q.val)
			flag++;
		flag += find(root.left, p, q) + find(root.right, p, q);
		if (flag == 2 && null == node)
			node = root;
		return flag;
	}

}
