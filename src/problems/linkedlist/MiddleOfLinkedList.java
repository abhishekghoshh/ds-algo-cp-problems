package problems.linkedlist;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimized approach
	// we will take 2 pointer
	// one will go next and one will go next to next
	// So 2nd pointer will go twice the first pointer
	// so when 2nd pointer reaches the end the first pointer only goes to half
	private static void type2() {
		Node<Integer> head = new Node<>(1, 2, 3, 4, 5);
		head.print();
		Node<Integer> slow = head;
		while (null != head && null != head.next) {
			slow = slow.next;
			head = head.next.next;
		}
		slow.print();
	}

	// brute force approach
	// first will count the length
	// now it will go half of the length
	private static void type1() {
		Node<Integer> head = new Node<>(1, 2, 3, 4, 5);
		head.print();
		int length = 0;
		Node<Integer> copy = head;
		while (null != copy) {
			copy = copy.next;
			length++;
		}
		length = length / 2;
		copy = head;
		while (length != 0) {
			copy = copy.next;
			length--;
		}
		copy.print();
	}

}
