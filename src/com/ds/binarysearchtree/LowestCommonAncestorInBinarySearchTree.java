package com.ds.binarysearchtree;

import com.algo.binarytree.TNode;

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
public class LowestCommonAncestorInBinarySearchTree {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// we will use the bst property left<root<right
	// recursive ways
	private static void type3() {
		TNode root = TNode.makeBST(15);
		TNode p = new TNode(7);
		TNode q = new TNode(15);
		System.out.println(lowestCommonAncestor(root, p, q));
	}

	public static TNode lowestCommonAncestor(TNode root, TNode p, TNode q) {
		if (null == root) return null;
		if (root.data == p.data) return p;
		if (root.data == q.data) return q;
		if (!rootDirection(root, p, q)) return root;
		if (p.data > root.data && q.data > root.data)
			return lowestCommonAncestor(root.right, p, q);
		else
			return lowestCommonAncestor(root.left, p, q);
	}

	public static boolean rootDirection(TNode root, TNode p, TNode q) {
		return (p.data > root.data && q.data > root.data)
				|| (p.data < root.data && q.data < root.data);
	}

	// we will use the bst property left<root<right
	// recursive ways
	private static void type2() {
		TNode root = TNode.makeBST(15);
		TNode p = new TNode(7);
		TNode q = new TNode(15);
		System.out.println(lca(root, p, q));
	}

	private static TNode lca(TNode root, TNode p, TNode q) {
		if (null == root)
			return null;
		if (root.data > p.data && root.data > q.data) {
			return lca(root.left, p, q);
		} else if (root.data < p.data && root.data < q.data) {
			return lca(root.right, p, q);
		} else {
			return root;
		}
	}

	// we will use the bst property left<root<right
	// iterative ways
	private static void type1() {
		TNode root = TNode.makeBST(15);
		TNode p = new TNode(7);
		TNode q = new TNode(15);
		TNode curr = root;
		while (null != curr) {
			if (curr.data > p.data && curr.data > q.data) {
				curr = curr.left;
			} else if (curr.data < p.data && curr.data < q.data) {
				curr = curr.right;
			} else {
				break;
			}
		}
		System.out.println(curr);
	}

}
