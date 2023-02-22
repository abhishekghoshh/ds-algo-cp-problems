package binarytree;

import java.util.ArrayList;
import java.util.List;

import util.TreeNode;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/920519
 * https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=25
 * 
 * https://takeuforward.org/data-structure/right-left-view-of-binary-tree/
 */
public class LeftRightViewOfBinaryTree {

	public static void main(String[] args) {
		// left view
		type1();
		// right view
		type2();
	}


	// using dfs / recursion
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		ArrayList<Integer> rightView = new ArrayList<>();
		rightViewTraversal(root, rightView, 0);
		System.out.println(rightView);
	}

	// it will go to most right and if there is one level found then it will add
	// that to list
	private static void rightViewTraversal(TreeNode<Integer> root, List<Integer> rightView, int level) {
		if (null == root)
			return;
		if (rightView.size() == level)
			rightView.add(root.val);
		rightViewTraversal(root.right, rightView, level + 1);
		rightViewTraversal(root.left, rightView, level + 1);
	}


	// using dfs / recursion
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(15);
		ArrayList<Integer> leftView = new ArrayList<>();
		leftViewTraversal(root, leftView, 0);
		System.out.println(leftView);
	}

	// it will go to most left and if there is one level found then it will add that
	// to list
	private static void leftViewTraversal(TreeNode<Integer> root, List<Integer> leftView, int level) {
		if (null == root)
			return;
		if (leftView.size() == level)
			leftView.add(root.val);
		leftViewTraversal(root.left, leftView, level + 1);
		leftViewTraversal(root.right, leftView, level + 1);
	}
}
