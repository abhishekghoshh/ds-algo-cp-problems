package problems.linkedlist;

public class ReverseOfLinkedList {
	public static void main(String[] args) {
		type1();
		type2();
	}

	// In place reverse without extra space
	private static void type2() {
		Node<Integer> head = new Node<>(10, 6, 9, 15, 30);
		head.print();
		Node<Integer> current = null, previous = null;
		while (null != head) {
			if (null == current) {
				current = head;
				head = head.next;
				current.next = null;
			} else {
				previous = current;
				current = head;
				head = head.next;
				current.next = previous;
			}
		}
		current.print();

	}

	private static void type1() {

	}
}
