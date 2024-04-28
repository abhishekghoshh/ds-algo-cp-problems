package com.problems.binarytree;

import com.ds.binarytree.TNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static com.util.PrintUtl.print;
/*
 * Problem link :
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * https://www.codingninjas.com/studio/problems/postorder-traversal_2035933
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=COQOU6klsBg&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=8
 * https://www.youtube.com/watch?v=2YBhNLodD8Q&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=12
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
		TNode root = TNode.withCount(7);
		List<Integer> postOrder = postOrder4(root);
		print(root);
		print(postOrder);
	}

	private static List<Integer> postOrder4(TNode root) {
		List<Integer> postOrder = new ArrayList<>();
		Stack<TNode> st = new Stack<>();
		while (root != null || !st.isEmpty()) {
			if (root != null) {
				st.push(root);
				root = root.left;
			} else {
				TNode temp = st.peek().right;
				if (temp == null) {
					temp = st.peek();
					st.pop();
					postOrder.add(temp.data);
					while (!st.isEmpty() && temp == st.peek().right) {
						temp = st.peek();
						st.pop();
						postOrder.add(temp.data);
					}
				} else
					root = temp;
			}
		}
		return postOrder;
	}

	// TODO best solution, explain this in the interview
	// with iteration using 1 stack,
	// we can use the final answer list as a stack,
	// and at last we can reverse it
	private static void type3() {
		TNode root = TNode.withCount(7);
		List<Integer> postOrder = postOrder3(root);
		print(root);
		print(postOrder);
	}

	private static List<Integer> postOrder3(TNode root) {
		List<Integer> postOrder = new ArrayList<>();
		if (null == root) return postOrder;
		Stack<TNode> stack = new Stack<>();
		stack.push(root);
		// if we see, here we are first printing root -> right -> left
		while (!stack.isEmpty()) {
			TNode node = stack.pop();
			// adding the root
			postOrder.add(node.data);
			// as we will first process the right, so we will add the left first
			// so in the next iteration the right child will come first
			if (null != node.left) stack.push(node.left);
			if (null != node.right) stack.push(node.right);
		}
		// the current order is root -> right -> left,
		// so if we just reverse it then, we will get left -> right -> root
		Collections.reverse(postOrder);
		return postOrder;
	}

	// with iteration using 2 stacks
	private static void type2() {
		TNode root = TNode.withCount(7);
		List<Integer> postOrder = postOrder2(root);
		print(root);
		print(postOrder);
	}

	private static List<Integer> postOrder2(TNode root) {
		List<Integer> postOrder = new ArrayList<>();
		if (null == root) return postOrder;
		Stack<TNode> s1 = new Stack<>();
		Stack<TNode> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			root = s1.pop();
			s2.push(root);
			if (root.left != null) s1.push(root.left);
			if (root.right != null) s1.push(root.right);
		}
		while (!s2.isEmpty()) {
			postOrder.add(s2.peek().data);
			s2.pop();
		}
		return postOrder;
	}

	// With recursion
	private static void type1() {
		TNode root = TNode.withCount(7);
		List<Integer> postOrder = new ArrayList<>();
		postOrder1(root, postOrder);
		print(root);
		print(postOrder);
	}

	// left -> right -> root
	private static void postOrder1(TNode root, List<Integer> postOrder) {
		if (null == root) return;
		postOrder1(root.left, postOrder);
		postOrder1(root.right, postOrder);
		postOrder.add(root.data);
	}
}
