package problems.linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// o(max(m,n)) without extra space
	// in place summation
	private static void type2() {
//		Node<Integer> l1 = new Node<>(2, 4, 3, 5);
//		Node<Integer> l2 = new Node<>(5, 6, 4, 4, 8, 2);
		Node<Integer> l1 = new Node<>(9, 9, 9, 9, 9, 9, 9, 9);
		Node<Integer> l2 = new Node<>(9, 9, 9, 9);
		int carry = 0;
		Node<Integer> prev = l1, res = l1;
		while (l1 != null || l2 != null || carry != 0) {
			int sum = ((l1 == null) ? 0 : l1.data) + ((l2 == null) ? 0 : l2.data) + carry;
			if (l1 != null) {
				l1.data = sum % 10;
				carry = sum / 10;
				prev = l1;
			} else if (l1 == null && l2 != null) {
				l2.data = sum % 10;
				carry = sum / 10;
				prev.next = l2;
				prev = l2;
			} else {
				prev.next = new Node<>(carry);
				carry = 0;
			}
			l1 = (l1 == null) ? l1 : l1.next;
			l2 = (l2 == null) ? l2 : l2.next;
		}
		res.print();
	}

	// o(max(m,n)) with extra space
	private static void type1() {
		Node<Integer> l1 = new Node<>(2, 4, 3, 5);
		Node<Integer> l2 = new Node<>(5, 6, 4);
		int carry = 0, sum = 0;
		Node<Integer> head = null, copy = null;
		while (null != l1 && null != l2) {
			if (null == copy) {
				sum = l1.data + l2.data;
				carry = sum / 10;
				copy = new Node<>(sum % 10);
				head = copy;
			} else {
				sum = l1.data + l2.data + carry;
				carry = sum / 10;
				copy.next = new Node<>(sum % 10);
				copy = copy.next;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		if (null != l1) {
			while (null != l1) {
				sum = l1.data + carry;
				carry = sum / 10;
				copy.next = new Node<>(sum % 10);
				copy = copy.next;
				l1 = l1.next;
			}

		}
		if (null != l2) {
			while (null != l2) {
				sum = l2.data + carry;
				carry = sum / 10;
				copy.next = new Node<>(sum % 10);
				copy = copy.next;
				l2 = l2.next;
			}
		}
		if (carry != 0) {
			copy.next = new Node<>(carry);
		}
		head.print();
	}

}
