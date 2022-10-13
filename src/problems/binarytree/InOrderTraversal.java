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
		TreeNode<Integer> node = root;
		while (null != node || !stack.isEmpty()) {
			// we are going as left as possible
			while (null != node) {
				stack.push(node);
				node = node.left;
			}
			// at this point node is null;
			// now we backtrack from the stack
			// current stack.top will have the most left node
			// so for this node null will be it's left child
			// it will be the root and if it is having any
			// right child then we will explore that also
			node = stack.pop();
			// we will store the left most node
			answer.add(node.val);
			// the left node may or may not have any right node
			node = node.right;
			// if it has any right node then in next iteration it will again go till its
			// left furthest node
		}
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
		if (null == root) {
			return;
		}
		inOrder(root.left, answer);
		answer.add(root.val);
		inOrder(root.right, answer);
	}
}
