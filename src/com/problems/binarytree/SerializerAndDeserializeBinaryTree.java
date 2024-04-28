package com.problems.binarytree;

import com.ds.binarytree.TNode;
import com.util.PrintUtl;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.parseInt;

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

	// TODO check it one more time
	public static void main(String[] args) {
		type1();
		type2();
	}

	// TODO check the code one more time
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

	// we are traversing the nodes in BFS
	// and store the node left and right, but we will also save even if they are null.
	// and in the next iteration when we get the null node from the BFS queue, then
	// we will save N char to the answer
	// because is will be used while deserializing
	public static String serialize1(TNode root) {
		StringBuilder sb = new StringBuilder();
		if (null == root) return sb.toString();
		Queue<TNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TNode node = queue.poll();
			// if the node is null, then we will add N into the answer
			if (null == node) {
				sb.append(NULL).append(" ");
			} else {
				sb.append(node.data).append(" ");
				// we will add the nodes into the queue
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	// TODO check it one more time, only the explanation of the video
	public static TNode deserialize1(String data) {
		if (null == data || data.isEmpty()) return null;
		// now we have all the nodes as a string array
		// we can construct a tree from the node array in many ways.
		// but here we will use a queue
		// we could also create an array to calculate the index of the nodes and then build a tree
		String[] nodes = data.split(" ");
		TNode root = new TNode(parseInt(nodes[0]));
		Queue<TNode> queue = new LinkedList<>();
		queue.offer(root);
		int i = 0;
		int n = nodes.length;
		// i will specify which node we are currently specifying
		// the front of the queue will be root node
		// everytime we are incrementing by 2, one for left node another for right
		while (i < n && !queue.isEmpty()) {
			TNode node = queue.poll();
			int left = i + 1;
			if (left < n && !NULL.equals(nodes[left])) {
				node.left = new TNode(parseInt(nodes[left]));
				queue.offer(node.left);
			}
			int right = i + 2;
			if (right < n && !NULL.equals(nodes[right])) {
				node.right = new TNode(parseInt(nodes[right]));
				queue.offer(node.right);
			}
			i += 2;
		}
		return root;
	}

}
