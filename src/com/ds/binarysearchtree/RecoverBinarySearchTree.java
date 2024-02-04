package com.ds.binarysearchtree;

import com.algo.binarytree.TNode;

import java.util.ArrayList;
import java.util.List;

import static com.util.PrintUtl.inOrder;

/*
 * Problem link :
 * https://leetcode.com/problems/recover-binary-search-tree/
 * https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1
 * https://www.codingninjas.com/studio/problems/fix-bst_873137
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ZWGW7FminDM&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=53
 * 
 * 
 */
public class RecoverBinarySearchTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// we can directly store the answer while traversing the tree
	private static void type2() {
		TNode root = TNode.makeBST(15);
		TNode p = root.search(6);
		TNode q = root.search(9);
		p.data = 9;
		q.data = 6;
		new SwapTwoElementInBST().recoverTree(root);
		inOrder(root);
	}

	private static class SwapTwoElementInBST {
		private TNode first;
		private TNode prev;
		private TNode middle;
		private TNode last;

		public void recoverTree(TNode root) {
			first = middle = last = null;
			prev = new TNode(Integer.MIN_VALUE);
			inorder(root);
			if (first != null && last != null) {
				int t = first.data;
				first.data = last.data;
				last.data = t;
			} else if (first != null && middle != null) {
				int t = first.data;
				first.data = middle.data;
				middle.data = t;
			}
		}

		private void inorder(TNode root) {
			if (root == null)
				return;
			inorder(root.left);
			if (prev != null && (root.data < prev.data)) {
				// If this is first violation, mark these two nodes as
				// 'first' and 'middle'
				if (first == null) {
					first = prev;
					middle = root;
				}
				// If this is second violation, mark this node as last
				else
					last = root;
			}
			// Mark this node as previous
			prev = root;
			inorder(root.right);
		}

	}

	// The inorder of the BST will give us the sorted list
	// we can store the list and traverse
	// then we will find the nodes in wrong places
	private static void type1() {
		TNode root = TNode.makeBST(15);
		TNode p = root.search(6);
		TNode q = root.search(9);
		p.data = 9;
		q.data = 6;

		List<TNode> inorder = new ArrayList<>();
		inorder(root, inorder);

		int curr, prev, next, n = inorder.size();
		TNode first = null, second = null;

		inOrder(root);

		// in sorted list prev < curr < next property always holds
		// so if we find anything other than this condition then we surely know that the
		// item is in wrong position
		// so first we will traverse from the front and find the first incorrect element
		// so then we will iterate from the back and find the second incorrect element
		for (int i = 0; i < n; i++) {
			curr = inorder.get(i).data;
			prev = i == 0 ? Integer.MIN_VALUE : inorder.get(i - 1).data;
			next = i == (n - 1) ? Integer.MAX_VALUE : inorder.get(i + 1).data;
			if (prev > curr || curr > next) {
				first = inorder.get(i);
				break;
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			curr = inorder.get(i).data;
			prev = i == 0 ? Integer.MIN_VALUE : inorder.get(i - 1).data;
			next = i == (n - 1) ? Integer.MAX_VALUE : inorder.get(i + 1).data;
			if (prev > curr || curr > next) {
				second = inorder.get(i);
				break;
			}
		}
		int x = first.data;
		int y = second.data;
		first.data = y;
		second.data = x;

		inOrder(root);
	}

	private static void inorder(TNode root, List<TNode> inorder) {
		if (null == root)
			return;
		inorder(root.left, inorder);
		inorder.add(root);
		inorder(root.right, inorder);
	}

}
