package problems.linkedlist;

public class ReverseOfLinkedList {
	public static void main(String[] args) {
		Node<Integer> head = new Node<>(10).next(new Node<>(6)).next(new Node<>(9)).next(new Node<>(15))
				.next(new Node<>(30)).build();
		head.print();
		Node<Integer> reverseHead = reverse(head);
		reverseHead.print();
	}

	private static Node<Integer> reverse(Node<Integer> head) {
		Node<Integer> current = null;
		Node<Integer> prev = null;
		while (null != head) {
			if (current == null) {
				current = head;
				head = head.next;
				current.next = null;
			} else {
				prev = current;
				current = head;
				head = head.next;
				current.next=prev;
			}
		}
		return current;
	}
}
