package binarytree;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/recover-binary-search-tree/
 * https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ZWGW7FminDM&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=53
 * 
 * 
 */
public class RecoverBST {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// we can directly store the answer while traversing the tree
	private static void type2() {
		TreeNode<Integer> root = TreeNode.makeBST(15);
		TreeNode<Integer> p = root.search(6);
		TreeNode<Integer> q = root.search(9);
		p.val = 9;
		q.val = 6;
		new SwapTwoElementInBST().recoverTree(root);
		System.out.println(root.inOrder());

	}

	private static class SwapTwoElementInBST {
		private TreeNode<Integer> first;
		private TreeNode<Integer> prev;
		private TreeNode<Integer> middle;
		private TreeNode<Integer> last;

		public void recoverTree(TreeNode<Integer> root) {
			first = middle = last = null;
			prev = new TreeNode<>(Integer.MIN_VALUE);
			inorder(root);
			if (first != null && last != null) {
				int t = first.val;
				first.val = last.val;
				last.val = t;
			} else if (first != null && middle != null) {
				int t = first.val;
				first.val = middle.val;
				middle.val = t;
			}
		}

		private void inorder(TreeNode<Integer> root) {
			if (root == null)
				return;
			inorder(root.left);
			if (prev != null && (root.val < prev.val)) {
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
		TreeNode<Integer> root = TreeNode.makeBST(15);
		TreeNode<Integer> p = root.search(6);
		TreeNode<Integer> q = root.search(9);
		p.val = 9;
		q.val = 6;

		List<TreeNode<Integer>> inorder = new ArrayList<>();
		inorder(root, inorder);

		int curr, prev, next, n = inorder.size();
		TreeNode<Integer> first = null, second = null;

		System.out.println(root.inOrder());

		// in sorted list prev < curr < next property always holds
		// so if we find anything other than this condition then we surely know that the
		// item is in wrong position
		// so first we will traverse from the front and find the first incorrect element
		// so then we will iterate from the back and find the second incorrect element
		for (int i = 0; i < n; i++) {
			curr = inorder.get(i).val;
			prev = i == 0 ? Integer.MIN_VALUE : inorder.get(i - 1).val;
			next = i == (n - 1) ? Integer.MAX_VALUE : inorder.get(i + 1).val;
			if (prev > curr || curr > next) {
				first = inorder.get(i);
				break;
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			curr = inorder.get(i).val;
			prev = i == 0 ? Integer.MIN_VALUE : inorder.get(i - 1).val;
			next = i == (n - 1) ? Integer.MAX_VALUE : inorder.get(i + 1).val;
			if (prev > curr || curr > next) {
				second = inorder.get(i);
				break;
			}
		}
		int x = first.val;
		int y = second.val;
		first.val = y;
		second.val = x;

		System.out.println(root.inOrder());
	}

	private static void inorder(TreeNode<Integer> root, List<TreeNode<Integer>> inorder) {
		if (null == root)
			return;
		inorder(root.left, inorder);
		inorder.add(root);
		inorder(root.right, inorder);
	}

}
