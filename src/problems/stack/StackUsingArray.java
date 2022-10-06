package problems.stack;

public class StackUsingArray<T> {
	private static final int DEFAULT_CAPACITY = 100;
	private T[] array;
	private final int capacity;
	private int size = 0;

	StackUsingArray() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	StackUsingArray(int capacity) {
		this.capacity = capacity;
		this.array = (T[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void push(T item) {
		if (size == capacity) {
			throw new UnsupportedOperationException("Capacity is full");
		}
		array[size++] = item;
	}

	public T pop() {
		if (size == 0) {
			throw new UnsupportedOperationException("No element present for popping");
		}
		return array[--size];
	}

	public T peek() {
		if (size == 0) {
			throw new UnsupportedOperationException("No element present for peeking");
		}
		return array[size - 1];
	}

	public static void main(String[] args) {
		StackUsingArray<Integer> stack = new StackUsingArray<>(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		printException(() -> stack.push(4));
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
