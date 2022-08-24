package problems.linkedlist;

public class RemoveNthNodeFromBackOfList {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		Node<Integer> head = new Node<>(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int n = 9;
		
		Node<Integer> start = head;
		Node<Integer> end = head;
		Node<Integer> answer = null;
		int position = n;
		while (position > 0) {
			end = end.next;
			position--;
		}
		if (null == end) {
			answer = head.next;
		} else {
			while (null != end.next) {
				end = end.next;
				start = start.next;
			}
			start.next = start.next.next;
			answer = head;
		}
		answer.print();
	}

	private static void type1() {
		// TODO Auto-generated method stub

	}

}
