package problems.recursion;

public class Node<T extends Comparable> {
    public T data;
    public Node<T> left = null;
    public Node<T> right = null;
    public Node(T data){
        this.data=data;
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
    public Node<T> data(T data) {
        this.setData(data);
        return this;
    }
    public Node<T> getLeft() {
        return left;
    }
    public Node<T> left() {
        return this.getLeft();
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public Node<T> left(Node<T> left) {
        this.setLeft(left);
        return this;
    }
    public Node<T> getRight() {
        return right;
    }
    public Node<T> right() {
        return this.getRight();
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
    public Node<T> right(Node<T> right) {
        this.setRight(right);
        return this;
    }
}
