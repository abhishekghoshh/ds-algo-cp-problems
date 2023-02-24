package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * https://practice.geeksforgeeks.org/problems/construct-tree-1/1
 * Solution link :
 * https://www.youtube.com/watch?v=aZNaLrVebKQ&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=35
 * 
 * https://takeuforward.org/data-structure/construct-a-binary-tree-from-inorder-and-preorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPreorder {
	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		Stack<TreeNode<Integer>> s = new Stack<>();
		TreeNode<Integer> root = new TreeNode<>(preorder[0]), cur = root;
		for (int i = 1, j = 0; i < preorder.length; i++) {
			if (cur.val != inorder[j]) {
				cur.left = new TreeNode<>(preorder[i]);
				s.push(cur);
				cur = cur.left;
			} else {
				j++;
				while (!s.empty() && s.peek().val == inorder[j]) {
					cur = s.pop();
					j++;
				}
				cur = cur.right = new TreeNode<>(preorder[i]);
			}
		}
		System.out.println(TreeNode.preOrder(root, new ArrayList<>()));
		System.out.println(TreeNode.inOrder(root, new ArrayList<>()));
	}

	// recursively
	private static void type1() {
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		int n = preorder.length;
		Map<Integer, Integer> inorderIndices = new HashMap<>();
		for (int i = 0; i < n; i++)
			inorderIndices.put(inorder[i], i);
		TreeNode<Integer> root = makeTree(preorder, inorderIndices, 0, 0, n - 1);
		System.out.println(TreeNode.preOrder(root, new ArrayList<>()));
		System.out.println(TreeNode.inOrder(root, new ArrayList<>()));

	}

	private static TreeNode<Integer> makeTree(int[] preorder, Map<Integer, Integer> indices, int pos, int start,
			int end) {
		if (start > end)
			return null;
		if (start == end)
			return new TreeNode<>(preorder[pos]);
		int item = preorder[pos];
		int inorderIndex = indices.get(item);
		int leftCount = inorderIndex - start;
		TreeNode<Integer> left = makeTree(preorder, indices, pos + 1, start, inorderIndex - 1);
		TreeNode<Integer> right = makeTree(preorder, indices, pos + leftCount + 1, inorderIndex + 1, end);
		return new TreeNode<>(item, left, right);
	}

}
