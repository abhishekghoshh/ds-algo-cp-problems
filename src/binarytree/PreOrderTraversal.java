package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.TreeNode;
/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=RlUu72JrOCQ&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=6
 * https://www.youtube.com/watch?v=Bfqd8BsPVuw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=10
 * 
 * https://takeuforward.org/data-structure/preorder-traversal-of-binary-tree/
 */

public class PreOrderTraversal {
	public static void main(String[] args) {
		type1();
		type2();
	}

	// with iteration using stack
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(7);
		Stack<TreeNode<Integer>> stack = new Stack<>();
		List<Integer> answer = new ArrayList<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode<Integer> node = stack.pop();
			answer.add(node.val);
			// We are pushing the right first then left because
			// on the next iteration left will be popped first
			if (null != node.right)
				stack.push(node.right);
			if (null != node.left)
				stack.push(node.left);
		}
		System.out.println(answer);
	}

	// With recursion
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(7);
		List<Integer> answer = preOrder(root, new ArrayList<>());
		System.out.println(answer);
	}

	private static List<Integer> preOrder(TreeNode<Integer> root, List<Integer> answer) {
		if (null != root) {
			answer.add(root.val);
			preOrder(root.left, answer);
			preOrder(root.right, answer);
		}
		return answer;
	}
}
