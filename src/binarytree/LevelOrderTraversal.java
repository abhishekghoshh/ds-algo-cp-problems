package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(19);
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		List<List<Integer>> answer = new ArrayList<>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			answer.add(new ArrayList<>());
			for (int i = 0; i < size; i++) {
				TreeNode<Integer> node = queue.poll();
				answer.get(level).add(node.val);
				if (null != node.left)
					queue.offer(node.left);
				if (null != node.right)
					queue.offer(node.right);
			}
			level++;
		}
		System.out.println(answer);
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(19);
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		List<Integer> answer = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode<Integer> node = queue.poll();
			answer.add(node.val);
			if (null != node.left) {
				queue.offer(node.left);
			}
			if (null != node.right) {
				queue.offer(node.right);
			}
		}
		System.out.println(answer);
	}

}
