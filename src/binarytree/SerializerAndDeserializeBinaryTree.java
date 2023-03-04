package binarytree;

import java.util.LinkedList;
import java.util.Queue;

import util.TreeNode;

/*
 * Problem link :
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * https://www.codingninjas.com/codestudio/problems/920328
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
		// check both solutions one more time
	}

	// this is done using preorder
	// TODO study it one more time
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(1, 2, -13, null, null, 4, 5);
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		String data = sb.toString();
		System.out.println(data);
		TreeNode<Integer> outputNode = deserialize(data.toCharArray(), new int[1]);
		System.out.println(root.inOrder());
		System.out.println(outputNode.inOrder());
	}

	public static void serialize(TreeNode<Integer> root, StringBuilder curr) {
		if (root == null) {
			curr.append('n');
			return;
		}
		curr.append(root.val).append(" ");
		serialize(root.left, curr);
		curr.append(" ");
		serialize(root.right, curr);
	}

	public static TreeNode<Integer> deserialize(char[] data, int[] index) {
		if (index[0] == data.length)
			return null;
		if (data[index[0]] == 'n')
			return null;
		int start = index[0];
		while (data[index[0]] != ' ')
			index[0]++;
		TreeNode<Integer> root = new TreeNode<>(valueOf(data, start, index[0]++));
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
		TreeNode<Integer> root = TreeNode.withAllNodesGiven(1, 2, 3, null, null, 4, 5);
		String data = serialize(root);
		System.out.println(data);
		TreeNode<Integer> outputNode = deserialize(data);
		System.out.println(root.inOrder());
		System.out.println(outputNode.inOrder());
	}

	public static String serialize(TreeNode<Integer> root) {
		StringBuilder sb = new StringBuilder();
		if (null == root)
			return sb.toString();
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode<Integer> node = queue.poll();
			if (null == node) {
				sb.append("null ");
				continue;
			}
			sb.append(node.val + " ");
			queue.offer(node.left);
			queue.offer(node.right);
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public static TreeNode<Integer> deserialize(String data) {
		if (null == data || "".equals(data.trim()))
			return null;
		String[] datas = data.split(" ");
		TreeNode<Integer> root = new TreeNode<>(Integer.parseInt(datas[0]));
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		int i = 0, n = datas.length;
		while (i < n && !queue.isEmpty()) {
			TreeNode<Integer> node = queue.poll();
			if (i + 1 < n && !"null".equals(datas[++i])) {
				node.left = new TreeNode<>(Integer.parseInt(datas[i]));
				queue.offer(node.left);
			}
			if (i + 1 < n && !"null".equals(datas[++i])) {
				node.right = new TreeNode<>(Integer.parseInt(datas[i]));
				queue.offer(node.right);
			}
		}
		return root;
	}

}
