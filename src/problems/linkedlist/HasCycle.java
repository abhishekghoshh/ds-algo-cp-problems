package problems.linkedlist;

public class HasCycle {

	public static void main(String[] args) {
		type1();

	}

	// tortoise method
	private static void type1() {
		Node<Integer> headA = new Node<>(10, 2);
		Node<Integer> headB = new Node<>(10, 11);
		Node<Integer> headC = new Node<>(15, 30, 45);
		headA.next.next = headB;
		headB.next.next = headC;
		headC.next.next.next = headB;

		Node<Integer> slow = headA;
		boolean hasCycle = false;
		while (null != headA && null != headA.next) {
			slow = slow.next;
			headA = headA.next.next;
			if (slow == headA) {
				hasCycle = true;
				break;
			}
		}
		System.out.println("cycle present : " + hasCycle);
	}

}
