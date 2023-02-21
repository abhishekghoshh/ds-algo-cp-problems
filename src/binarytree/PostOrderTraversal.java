package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import util.TreeNode;
/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=COQOU6klsBg&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=8
 * https://www.youtube.com/watch?v=2YBhNLodD8Q&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=12
 * https://www.youtube.com/watch?v=NzIGLLwZBS8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=13
 * 
 * https://takeuforward.org/data-structure/post-order-traversal-of-binary-tree/
 */

public class PostOrderTraversal {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// TODO check it later
	private static void type4() {
		TreeNode<Integer> root = TreeNode.withCount(7);
		List<Integer> postOrder = new ArrayList<>();
		Stack<TreeNode<Integer>> st = new Stack<>();
		while (root != null || !st.isEmpty()) {
			if (root != null) {
				st.push(root);
				root = root.left;
			} else {
				TreeNode<Integer> temp = st.peek().right;
				if (temp == null) {
					temp = st.peek();
					st.pop();
					postOrder.add(temp.val);
					while (!st.isEmpty() && temp == st.peek().right) {
						temp = st.peek();
						st.pop();
						postOrder.add(temp.val);
					}
				} else
					root = temp;
			}
		}
	}

	// with iteration using stack
	// we can use the final answer list as a stack
	// and at last we can reverse it
	private static void type3() {
		TreeNode<Integer> root = TreeNode.withCount(7);
		Stack<TreeNode<Integer>> stack = new Stack<>();
		stack.push(root);
		List<Integer> postOrder = new ArrayList<>();
		while (!stack.isEmpty()) {
			TreeNode<Integer> node = stack.pop();
			postOrder.add(node.getVal());
			if (null != node.left)
				stack.push(node.left);
			if (null != node.right)
				stack.push(node.right);
		}
		Collections.reverse(postOrder);
		System.out.println(postOrder);
	}

	// with iteration using stack
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(7);
		ArrayList<Integer> postOrder = new ArrayList<>();
		Stack<TreeNode<Integer>> s1 = new Stack<>();
		Stack<TreeNode<Integer>> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			root = s1.peek();
			s1.pop();
			s2.push(root);
			if (root.left != null)
				s1.push(root.left);
			if (root.right != null)
				s1.push(root.right);
		}
		while (!s2.isEmpty()) {
			postOrder.add(s2.peek().val);
			s2.pop();
		}
		System.out.println(postOrder);
	}

	// With recursion
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(7);
		List<Integer> answer = postOrder(root, new ArrayList<>());
		System.out.println(answer);
	}

	private static List<Integer> postOrder(TreeNode<Integer> root, List<Integer> answer) {
		if (null != root) {
			postOrder(root.left, answer);
			postOrder(root.right, answer);
			answer.add(root.val);
		}
		return answer;
	}
}
