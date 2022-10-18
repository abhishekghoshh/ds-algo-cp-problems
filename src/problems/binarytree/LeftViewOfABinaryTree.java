package problems.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.TreeNode;

public class LeftViewOfABinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// Time Complexity O(N)
	// Space Complexity O(H)
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(16);
		List<Integer> leftView = new ArrayList<>();
		leftViewTraversal(root, leftView, 0);
		System.out.println(leftView);

	}

	private static void leftViewTraversal(TreeNode<Integer> root, List<Integer> leftView, int level) {
		if (null == root) {
			return;
		}
		if (leftView.size() <= level) {
			leftView.add(root.val);
		} else {
			leftView.set(level, root.val);
		}
		leftViewTraversal(root.right, leftView, level + 1);
		leftViewTraversal(root.left, leftView, level + 1);
	}

	// Time Complexity O(N)
	// Space Complexity O(2*H)
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(16);
		Map<Integer, Integer> leftViewMap = new HashMap<>();
		List<Integer> leftView = new ArrayList<>();
		leftViewTraversal(root, leftViewMap, 0);
		int level = 0;
		while (true) {
			if (leftViewMap.containsKey(level)) {
				leftView.add(leftViewMap.get(level++));
			} else {
				break;
			}
		}
		System.out.println(leftView);
	}

	private static void leftViewTraversal(TreeNode<Integer> root, Map<Integer, Integer> leftViewMap, int level) {
		if (null == root) {
			return;
		}
		leftViewMap.put(level, root.val);
		leftViewTraversal(root.right, leftViewMap, level + 1);
		leftViewTraversal(root.left, leftViewMap, level + 1);
	}

}
