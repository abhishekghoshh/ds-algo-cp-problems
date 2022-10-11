package problems.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(9);
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
