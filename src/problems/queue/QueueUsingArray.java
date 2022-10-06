package problems.queue;

public class QueueUsingArray<T> {
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

	public static void main(String[] args) {
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

}
