package binarytree;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=cX_kPV_foZc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=48
 * 
 * 
 */
public class LowestCommonAncestorinBinarySearchTree {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// we will use the bst property left<root<right
	// recursive ways
	private static void type3() {
		TreeNode<Integer> root = TreeNode.makeBST(15);
		TreeNode<Integer> p = new TreeNode<>(7);
		TreeNode<Integer> q = new TreeNode<>(15);
		System.out.println(lowestCommonAncestor(root, p, q));
	}

	public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p,
			TreeNode<Integer> q) {
		if (null == root)
			return null;
		if (root.val == p.val)
			return p;
		if (root.val == q.val)
			return q;
		if (!rootDirection(root, p, q))
			return root;
		if (p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		else
			return lowestCommonAncestor(root.left, p, q);
	}

	public static boolean rootDirection(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
		return (p.val > root.val && q.val > root.val) || (p.val < root.val && q.val < root.val);
	}

	// we will use the bst property left<root<right
	// recursive ways
	private static void type2() {
		TreeNode<Integer> root = TreeNode.makeBST(15);
		TreeNode<Integer> p = new TreeNode<>(7);
		TreeNode<Integer> q = new TreeNode<>(15);
		System.out.println(lca(root, p, q));
	}

	private static TreeNode<Integer> lca(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
		if (null == root)
			return null;
		if (root.val > p.val && root.val > q.val) {
			return lca(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return lca(root.right, p, q);
		} else {
			return root;
		}
	}

	// we will use the bst property left<root<right
	// iterative ways
	private static void type1() {
		TreeNode<Integer> root = TreeNode.makeBST(15);
		TreeNode<Integer> p = new TreeNode<>(7);
		TreeNode<Integer> q = new TreeNode<>(15);
		TreeNode<Integer> curr = root;
		while (null != curr) {
			if (curr.val > p.val && curr.val > q.val) {
				curr = curr.left;
			} else if (curr.val < p.val && curr.val < q.val) {
				curr = curr.right;
			} else {
				break;
			}
		}
		System.out.println(curr);
	}

}
