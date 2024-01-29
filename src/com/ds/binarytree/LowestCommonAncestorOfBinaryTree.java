package com.ds.binarytree;

import com.algo.binarytree.TNode;

/*
 * Problem link :
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * https://www.codingninjas.com/codestudio/problems/920541
 * https://www.codingninjas.com/studio/problems/lca-of-binary-tree_920541
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
		TNode root = TNode.withCount(100);
		TNode p = root.search(20);
		TNode q = root.search(40);

		TNode node = lowestCommonAncestor(root, p, q);
		System.out.println(node.data);
	}

	public static TNode lowestCommonAncestor(TNode root, TNode p, TNode q) {
		if (root == null || root == p || root == q) return root;
		TNode left = lowestCommonAncestor(root.left, p, q);
		TNode right = lowestCommonAncestor(root.right, p, q);
		// both left and right are not null, we found our result
		if (left != null && right != null) return root;
		// otherwise we will send the corresponding node
		return (left != null) ? left : right;
	}


	private static void type1() {
		TNode root = TNode.withCount(100);
		TNode p = root.search(20);
		TNode q = root.search(40);

		find(root, p, q);
		System.out.println(node.data);

	}

	private static TNode node = null;

	private static int find(TNode root, TNode p, TNode q) {
		if (null == root) return 0;
		int flag = 0;
		if (root.data == p.data || root.data == q.data) flag++;
		flag += find(root.left, p, q) + find(root.right, p, q);
		if (flag == 2 && null == node) node = root;
		return flag;
	}

}
