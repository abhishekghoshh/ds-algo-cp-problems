package problems.queue;

public class Queue {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		DeQueue<Integer> queue = new DeQueue<>();
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

	public static class DeQueue<T> {
		private Node<T> start;
		private Node<T> last;
		private int size = 0;

		private static class Node<T> {
			T data;
			Node<T> next;
			Node<T> prev;

			Node(T data) {
				this.data = data;
				this.next = null;
				this.prev = null;
			}
		}

		DeQueue() {
			start = new Node<>(null);
			last = new Node<>(null);
			start.next = last;
			last.prev = start;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public int size() {
			return size;
		}

		public void offer(T item) {
			offerLast(item);
		}

		public void offerFirst(T item) {
			size++;
			Node<T> node = new Node<>(item);
			node.prev = start;
			node.next = start.next;
			start.next.prev = node;
			start.next = node;
		}

		public void offerLast(T item) {
			size++;
			Node<T> node = new Node<>(item);
			node.next = last;
			node.prev = last.prev;
			last.prev.next = node;
		}

		public T poll() {
			return pollFirst();
		}

		public T pollFirst() {
			if (isEmpty()) {
				throw new UnsupportedOperationException("No element present for popping");
			}
			size--;
			Node<T> node = start.next;
			start.next = node.next;
			node.next.prev = start;
			return node.data;
		}

		public T pollLast() {
			if (isEmpty()) {
				throw new UnsupportedOperationException("No element present for popping");
			}
			size--;
			Node<T> node = last.prev;
			node.prev.next = last;
			last.prev = node.prev;
			return node.data;
		}

		public T peek() {
			return peekFirst();
		}

		public T peekFirst() {
			if (isEmpty()) {
				throw new UnsupportedOperationException("No element present for peeking");
			}
			return start.next.data;
		}

		public T peekLast() {
			if (isEmpty()) {
				throw new UnsupportedOperationException("No element present for peeking");
			}
			return last.prev.data;
		}
	}

	private static void type2() {
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

	public static class QueueUsingLinkedList<T> {
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
	}

	private static void type1() {
		QueueUsingArray<Integer> queue = new QueueUsingArray<>(6);
		queue.offer(4);
		queue.offer(14);
		queue.offer(24);
		queue.offer(34);
		System.out.println("The peek of the queue before deleting any element " + queue.peek());
		System.out.println("The size of the queue before deletion " + queue.size());
		System.out.println("The first element to be deleted " + queue.poll());
		System.out.println("The peek of the queue after deleting an element " + queue.peek());
		System.out.println("The size of the queue after deleting an element " + queue.size());
	}

	public static class QueueUsingArray<T> {
		private T[] array;
		private int start, end, size, capacity;

		QueueUsingArray() {
			this(16);
		}

		@SuppressWarnings("unchecked")
		QueueUsingArray(int capacity) {
			this.capacity = capacity;
			array = (T[]) new Object[capacity];
			start = -1;
			end = -1;
			size = 0;
		}

		public void offer(T item) {
			if (size == capacity) {
				System.out.println("Queue is full\nExiting...");
				System.exit(1);
			}
			if (end == -1) {
				start = 0;
				end = 0;
			} else
				end = (end + 1) % capacity;
			array[end] = item;
			System.out.println("The element pushed is " + item);
			size++;
		}

		public T poll() {
			if (start == -1) {
				System.out.println("Queue Empty\nExiting...");
				System.exit(1);
			}
			T popped = array[start];
			if (size == 1) {
				start = -1;
				end = -1;
			} else
				start = (start + 1) % capacity;
			size--;
			return popped;
		}

		public T peek() {
			if (start == -1) {
				System.out.println("Queue is Empty");
				System.exit(1);
			}
			return array[start];
		}

		public int size() {
			return size;
		}

		public boolean isEmpty() {
			return size == 0;
		}
	}
}
