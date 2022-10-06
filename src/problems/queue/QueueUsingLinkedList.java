package problems.queue;

public class QueueUsingLinkedList<T> {
	private Node<T> front;
	private Node<T> end;
	private int size = 0;

	private static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	QueueUsingLinkedList() {
		front = end = null;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void offer(T item) {
		size++;
		Node<T> node = new Node<>(item);
		if (front == null) {
			front = end = node;
		} else {
			end.next = node;
			end = node;
		}
	}

	public T poll() {
		if (size == 0) {
			throw new UnsupportedOperationException("No element present for popping");
		}
		size--;
		Node<T> node = front;
		if (front == end) {
			front = end = null;
		} else {
			front = node.next;
		}
		return node.data;
	}

	public T peek() {
		if (size == 0) {
			throw new UnsupportedOperationException("No element present for peeking");
		}
		return front.data;
	}

	public static void main(String[] args) {
		QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
		queue.offer(7);
		queue.offer(14);
		queue.offer(24);
		queue.offer(34);
		System.out.println("The peek of the queue before deleting any element " + queue.peek());
		System.out.println("The size of the queue before deletion " + queue.size());
		System.out.println("The first element to be deleted " + queue.poll());
		System.out.println("The peek of the queue after deleting an element " + queue.peek());
		System.out.println("The size of the queue after deleting an element " + queue.size());
		
	}

}
