package problems.linkedlist;

public class IntersectionOfTwoLinkedList {
	public static void main(String[] args) {
		findIntersectionByValue();
		findIntersectionByRefeference();
	}

	private static void findIntersectionByRefeference() {
		Node<Integer> common = new Node<>(15).next(new Node<>(30)).build();
		Node<Integer> head1 = new Node<>(10).next(new Node<>(6)).next(new Node<>(9)).next(common).build();

		Node<Integer> head2 = new Node<>(10).next(common).build();
		int count1 = head1.getCount();
		int count2 = head2.getCount();
		int distance = Math.abs(count1 - count2);
		if (count1 > count2) {
			while (distance != 0) {
				distance--;
				head1 = head1.next;
			}
		} else if (count1 < count2) {
			while (distance != 0) {
				distance--;
				head2 = head2.next;
			}
		}
		while (null != head1 && null != head2) {
			if (head1 == head2)
				break;
			head1 = head1.next;
			head2 = head2.next;
		}
		System.out.println(null != head1 ? head1.data : Integer.MIN_VALUE);
	}

	private static void findIntersectionByValue() {
		Node<Integer> head1 = new Node<>(10).next(new Node<>(6)).next(new Node<>(9)).next(new Node<>(15))
				.next(new Node<>(30)).build();

		Node<Integer> head2 = new Node<>(10).next(new Node<>(15)).next(new Node<>(30)).build();
		;

		int count1 = head1.getCount();
		int count2 = head2.getCount();
		int distance = Math.abs(count1 - count2);
		if (count1 > count2) {
			while (distance != 0) {
				distance--;
				head1 = head1.next;
			}
		} else if (count1 < count2) {
			while (distance != 0) {
				distance--;
				head2 = head2.next;
			}
		}
		int data = Integer.MIN_VALUE;
		while (null != head1 && null != head2) {
			if (head1.data == head2.data) {
				if (data == Integer.MIN_VALUE) {
					data = head1.data;
				}
			} else {
				if (data != Integer.MIN_VALUE) {
					data = Integer.MIN_VALUE;
				}
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		System.out.println(data);
	}
}
