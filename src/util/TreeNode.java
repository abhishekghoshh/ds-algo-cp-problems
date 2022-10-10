package util;

public class TreeNode<T> {
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;

	public TreeNode() {
	}

	public TreeNode(T val) {
		this.val = val;
	}

	TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	TreeNode(T val, TreeNode<T> left, TreeNode<T> right, TreeNode<T> parent) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
}
