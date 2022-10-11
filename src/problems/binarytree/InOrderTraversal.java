package problems.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;

public class InOrderTraversal {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// with iteration using stack
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(7);
		Stack<TreeNode<Integer>> stack = new Stack<>();
		List<Integer> answer = new ArrayList<>();
		System.out.println(answer);
	}

	// With recursion
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(7);
		List<Integer> answer = new ArrayList<>();
		inOrder(root, answer);
		System.out.println(answer);
	}

	private static void inOrder(TreeNode<Integer> root, List<Integer> answer) {
		if (null != root) {
			inOrder(root.left, answer);
			answer.add(root.val);
			inOrder(root.right, answer);
		}
	}
}
