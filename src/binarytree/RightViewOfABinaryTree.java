package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.TreeNode;

public class RightViewOfABinaryTree {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// Time Complexity O(N)
	// Space Complexity O(H)
	private static void type2() {
		TreeNode<Integer> root = TreeNode.withCount(16);
		List<Integer> rightView = new ArrayList<>();
		rightViewTraversal(root, rightView, 0);
		System.out.println(rightView);

	}

	private static void rightViewTraversal(TreeNode<Integer> root, List<Integer> rightView, int level) {
		if (null == root) {
			return;
		}
		if (rightView.size() <= level) {
			rightView.add(root.val);
		} else {
			rightView.set(level, root.val);
		}
		rightViewTraversal(root.left, rightView, level + 1);
		rightViewTraversal(root.right, rightView, level + 1);
	}

	// Time Complexity O(N)
	// Space Complexity O(2*H)
	private static void type1() {
		TreeNode<Integer> root = TreeNode.withCount(16);
		Map<Integer, Integer> rightViewMap = new HashMap<>();
		List<Integer> rightView = new ArrayList<>();
		rightViewTraversal(root, rightViewMap, 0);
		int level = 0;
		while (true) {
			if (rightViewMap.containsKey(level)) {
				rightView.add(rightViewMap.get(level++));
			} else {
				break;
			}
		}
		System.out.println(rightView);
	}

	private static void rightViewTraversal(TreeNode<Integer> root, Map<Integer, Integer> rightViewMap, int level) {
		if (null == root) {
			return;
		}
		rightViewMap.put(level, root.val);
		rightViewTraversal(root.left, rightViewMap, level + 1);
		rightViewTraversal(root.right, rightViewMap, level + 1);
	}

}
