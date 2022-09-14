package util;

public class BinaryTreeNode<T extends Comparable<T>> {
	public T data;
	public BinaryTreeNode<T> left = null;
	public BinaryTreeNode<T> right = null;

	public BinaryTreeNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public T data() {
		return this.getData();
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> data(T data) {
		this.setData(data);
		return this;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public BinaryTreeNode<T> left() {
		return this.getLeft();
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> left(BinaryTreeNode<T> left) {
		this.setLeft(left);
		return this;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public BinaryTreeNode<T> right() {
		return this.getRight();
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public BinaryTreeNode<T> right(BinaryTreeNode<T> right) {
		this.setRight(right);
		return this;
	}
}
