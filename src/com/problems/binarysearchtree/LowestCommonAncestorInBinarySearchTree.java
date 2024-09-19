package com.problems.binarysearchtree;

import com.ds.binarytree.TNode;

/*
 * Problem link :
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * https://www.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=cX_kPV_foZc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=48
 * 
 * https://takeuforward.org/binary-search-tree/lca-in-binary-search-tree/
 */
public class LowestCommonAncestorInBinarySearchTree {

	public static void main(String[] args) {
		type1();
		type2();
	}


	// we will use the bst property left<root<right
	// same like iterative one
	// we will go left if root data is greater than both p and q.
	// we will go right if both p and q are bigger
	// while traversing anywhere if we find that p and q are in opposite side
	// that node will be the common ancestor
	// recursive ways
	private static void type2() {
		TNode root = TNode.makeBST(15);
		TNode p = new TNode(7);
		TNode q = new TNode(15);
		TNode node = lca1(root, p, q);
		System.out.println(node);
	}

	private static TNode lca1(TNode root, TNode p, TNode q) {
		if (null == root) return null;
		if (root.data > p.data && root.data > q.data)
			// node is greater than both of them
			return lca1(root.left, p, q);
		else if (root.data < p.data && root.data < q.data)
			// node data is lesser than both of them
			return lca1(root.right, p, q);
		else
			// both p and q are in opposite side
			return root;
	}

	// we will use the bst property left<root<right
	// we will go left if root data is greater than both p and q.
	// we will go right if both p and q are bigger
	// while traversing anywhere if we find that p and q is in opposite side
	// that node will be the common ancestor
	// iterative ways
	private static void type1() {
		TNode root = TNode.makeBST(15);
		TNode p = new TNode(7);
		TNode q = new TNode(15);
		TNode node = root;
		while (null != node) {
			// node is greater than both of them
			if (node.data > p.data && node.data > q.data)
				node = node.left;
				// node data is lesser than both of them
			else if (node.data < p.data && node.data < q.data)
				node = node.right;
			else
				// both p and q are in opposite side
				break;

		}
		System.out.println(node);
	}

}
