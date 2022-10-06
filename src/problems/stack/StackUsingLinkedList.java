package problems.stack;

public class StackUsingLinkedList<T> {
	private Node<T> top;
	private int size = 0;

	private static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	StackUsingLinkedList() {
		top = new Node<>(null);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void push(T item) {
		size++;
		Node<T> node = new Node<>(item);
		node.next = top;
		top = node;
	}

	public T pop() {
		if (size == 0) {
			throw new UnsupportedOperationException("No element present for popping");
		}
		size--;
		Node<T> node = top;
		top = top.next;
		return node.data;
	}

	public T peek() {
		if (size == 0) {
			throw new UnsupportedOperationException("No element present for peeking");
		}
		return top.data;
	}

	public static void main(String[] args) {
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		printException(() -> stack.push(4));
		System.out.println(stack.peek() + " " + stack.pop());
		System.out.println(stack.peek() + " " + stack.pop());
		System.out.println(stack.peek() + " " + stack.pop());
		System.out.println(stack.peek() + " " + stack.pop());
		printException(() -> System.out.println(stack.peek()));
		printException(() -> System.out.println(stack.pop()));
	}

	private static void printException(Runnable runnable) {
		try {
			runnable.run();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
