package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/preorder-traversal/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=jmy0LaGET1I&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=5
 * 
 * https://takeuforward.org/binary-tree/binary-tree-traversal-inorder-preorder-postorder/
 */

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// Level order traversal
	private static void type4() {
		TreeNode<Integer> treeNode = TreeNode.withCount(10);
		List<List<Integer>> answer = levelOrder(treeNode);
		System.out.println(answer);
	}

	public static List<List<Integer>> levelOrder(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		if (root == null)
			return wrapList;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			wrapList.add(subList);
		}
		return wrapList;
	}

	// Post order traversal
	private static void type3() {
		TreeNode<Integer> treeNode = TreeNode.withCount(10);
		ArrayList<Integer> answer = new ArrayList<>();
		postOrderTraversal(treeNode, answer);
		System.out.println(answer);
	}

	static void postOrderTraversal(TreeNode<Integer> curr, ArrayList<Integer> postOrder) {
		if (curr == null)
			return;

		postOrderTraversal(curr.left, postOrder);
		postOrderTraversal(curr.right, postOrder);
		postOrder.add(curr.val);
	}

	// Pre order traversal
	private static void type2() {
		TreeNode<Integer> treeNode = TreeNode.withCount(10);
		ArrayList<Integer> answer = new ArrayList<>();
		preOrderTraversal(treeNode, answer);
		System.out.println(answer);
	}

	static void preOrderTraversal(TreeNode<Integer> curr, ArrayList<Integer> preOrder) {
		if (curr == null)
			return;

		preOrder.add(curr.val);
		preOrderTraversal(curr.left, preOrder);
		preOrderTraversal(curr.right, preOrder);
	}

	// In order traversal
	private static void type1() {
		TreeNode<Integer> treeNode = TreeNode.withCount(10);
		ArrayList<Integer> answer = new ArrayList<>();
		inOrderTraversal(treeNode, answer);
		System.out.println(answer);
	}

	static void inOrderTraversal(TreeNode<Integer> curr, ArrayList<Integer> inOrder) {
		if (curr == null)
			return;

		inOrderTraversal(curr.left, inOrder);
		inOrder.add(curr.val);
		inOrderTraversal(curr.right, inOrder);
	}

}
