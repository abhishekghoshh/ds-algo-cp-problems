package com.ds.binarytree;

import com.algo.binarytree.TNode;
import com.util.PrintUtl;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem link :
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * https://www.codingninjas.com/codestudio/problems/920328
 * https://www.codingninjas.com/studio/problems/serialize-and-deserialize-binary-tree_920328
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=-YbXySKJsX8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=37
 * 
 * https://takeuforward.org/data-structure/serialize-and-deserialize-a-binary-tree/
 */
public class SerializerAndDeserializeBinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// Using DFS traversal,
	// this is done using preorder
	private static void type2() {
		TNode root = TNode.withNodes(1, 2, -13, TNode.NULL, TNode.NULL, 4, 5);
		String data = serialize2(root);
		System.out.println(data);
		TNode outputNode = deserialize2(data);
		PrintUtl.inOrder(root);
		PrintUtl.inOrder(outputNode);
	}

	private static int index = 0;

	public static String serialize2(TNode root) {
		StringBuilder sb = new StringBuilder();
		preOrder(root, sb);
		return sb.toString();
	}

	public static void preOrder(TNode root, StringBuilder curr) {
		if (root == null) {
			curr.append('n');
			return;
		}
		curr.append(root.data).append(" ");
		preOrder(root.left, curr);
		curr.append(" ");
		preOrder(root.right, curr);
	}

	private static TNode deserialize2(String data) {
		index = 0;
		return deserialize(data.toCharArray());
	}

	public static TNode deserialize(char[] data) {
		if (index == data.length || data[index] == 'n') return null;
		int start = index;
		while (data[index] != ' ') index++;
		TNode root = new TNode(valueOf(data, start, index++));
		root.left = deserialize(data);
		index += 2;
		root.right = deserialize(data);
		return root;
	}

	private static int valueOf(char[] data, int start, int end) {
		int num = 0;
		boolean isNegative = false;
		if (data[start] == '-') {
			isNegative = true;
			start++;
		}
		for (int i = start; i < end; i++)
			num = num * 10 + (data[i] - '0');
		return !isNegative ? num : -num;
	}

	// Using BFS,
	// this is done using level order
	private static void type1() {
		TNode root = TNode.withNodes(1, 2, 3, TNode.NULL, TNode.NULL, 4, 5);
		String data = serialize1(root);
		System.out.println(data);
		TNode outputNode = deserialize1(data);
		PrintUtl.inOrder(root);
		PrintUtl.inOrder(outputNode);
	}

	public static final String NULL = "N";

	public static String serialize1(TNode root) {
		StringBuilder sb = new StringBuilder();
		if (null == root) return sb.toString();
		Queue<TNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TNode node = queue.poll();
			if (null == node) {
				sb.append(NULL).append(" ");
			} else {
				sb.append(node.data).append(" ");
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public static TNode deserialize1(String data) {
		if (null == data || data.isEmpty()) return null;
		String[] nodes = data.split(" ");
		TNode root = new TNode(Integer.parseInt(nodes[0]));
		Queue<TNode> queue = new LinkedList<>();
		queue.offer(root);
		int i = 0;
		int n = nodes.length;
		while (i < n && !queue.isEmpty()) {
			TNode node = queue.poll();
			int left = ++i;
			if (left < n && !NULL.equals(nodes[left])) {
				node.left = new TNode(Integer.parseInt(nodes[left]));
				queue.offer(node.left);
			}
			int right = ++i;
			if (right < n && !NULL.equals(nodes[right])) {
				node.right = new TNode(Integer.parseInt(nodes[right]));
				queue.offer(node.right);
			}
		}
		return root;
	}

}
