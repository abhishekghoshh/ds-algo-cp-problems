package com.ds.binarytree;

import com.algo.binarytree.TNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/981269
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ySp2epYvgTE&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=14
 * 
 * https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/
 */

public class PreorderInorderAndPostorderTraversalInOneTraversal {

	public static void main(String[] args) {
		type1();
	}

	public static class Pair {
		TNode node;
		int num;

		Pair(TNode node, int num) {
			this.num = num;
			this.node = node;
		}
	}

	// TODO check it later
	private static void type1() {
		TNode root = TNode.withCount(19);
		List<Integer> pre = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		List<Integer> post = new ArrayList<>();

		Stack<Pair> stack = new Stack<Pair>();
		stack.push(new Pair(root, 1));
		if (root == null)
			return;

		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			// this is part of pre
			// increment 1 to 2
			// push the left side of the tree
			if (pair.num == 1) {
				pre.add(pair.node.data);
				pair.num++;
				stack.push(pair);
				if (pair.node.left != null) {
					stack.push(new Pair(pair.node.left, 1));
				}
			}
			// this is a part of in
			// increment 2 to 3
			// push right
			else if (pair.num == 2) {
				in.add(pair.node.data);
				pair.num++;
				stack.push(pair);
				if (pair.node.right != null) {
					stack.push(new Pair(pair.node.right, 1));
				}
			}
			// don't push it back again
			else {
				post.add(pair.node.data);
			}
		}
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}

}
