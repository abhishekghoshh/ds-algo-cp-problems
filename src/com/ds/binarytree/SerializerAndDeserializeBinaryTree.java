package com.ds.binarytree;

import com.algo.binarytree.TNode;
import com.util.PrintUtl;

import java.util.LinkedList;
import java.util.Queue;

import static com.algo.binarytree.TNode.NULL;

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

	// this is done using preorder
	// TODO study it one more time
	private static void type2() {
		TNode root = TNode.withNodes(1, 2, -13, NULL, NULL, 4, 5);
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		String data = sb.toString();
		System.out.println(data);
		TNode outputNode = deserialize(data.toCharArray(), new int[1]);
		PrintUtl.inOrder(root);
		PrintUtl.inOrder(outputNode);
	}

	public static void serialize(TNode root, StringBuilder curr) {
		if (root == null) {
			curr.append('n');
			return;
		}
		curr.append(root.data).append(" ");
		serialize(root.left, curr);
		curr.append(" ");
		serialize(root.right, curr);
	}

	public static TNode deserialize(char[] data, int[] index) {
		if (index[0] == data.length)
			return null;
		if (data[index[0]] == 'n')
			return null;
		int start = index[0];
		while (data[index[0]] != ' ')
			index[0]++;
		TNode root = new TNode(valueOf(data, start, index[0]++));
		root.left = deserialize(data, index);
		index[0] += 2;
		root.right = deserialize(data, index);
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

	// this is done using level order
	private static void type1() {
		TNode root = TNode.withNodes(1, 2, 3, NULL, NULL, 4, 5);
		String data = serialize(root);
		System.out.println(data);
		TNode outputNode = deserialize(data);
		PrintUtl.inOrder(root);
		PrintUtl.inOrder(outputNode);
	}

	public static String serialize(TNode root) {
		StringBuilder sb = new StringBuilder();
		if (null == root)
			return sb.toString();
		Queue<TNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TNode node = queue.poll();
			if (null == node) {
				sb.append("null ");
				continue;
			}
			sb.append(node.data + " ");
			queue.offer(node.left);
			queue.offer(node.right);
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public static TNode deserialize(String data) {
		if (null == data || data.trim().isEmpty())
			return null;
		String[] datas = data.split(" ");
		TNode root = new TNode(Integer.parseInt(datas[0]));
		Queue<TNode> queue = new LinkedList<>();
		queue.offer(root);
		int i = 0, n = datas.length;
		while (i < n && !queue.isEmpty()) {
			TNode node = queue.poll();
			if (i + 1 < n && !"null".equals(datas[++i])) {
				node.left = new TNode(Integer.parseInt(datas[i]));
				queue.offer(node.left);
			}
			if (i + 1 < n && !"null".equals(datas[++i])) {
				node.right = new TNode(Integer.parseInt(datas[i]));
				queue.offer(node.right);
			}
		}
		return root;
	}

}
