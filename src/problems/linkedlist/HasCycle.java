package problems.linkedlist;

public class HasCycle {

	public static void main(String[] args) {
		type1();
		type2();

	}

	// efficient approach without any extra space
	// but it can go more than o(n)
	// as it will 
	// tortoise method
	// here we have a slow node and fast node
	// slow node goes one node at a time
	// fast node goes two nodes
	// if there is any loop then slow and fast will travel with different speed
	// and after some they will reach to same node
	// if there is no cycle then fast will exhaust automatically
	private static void type2() {
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

	private static void type1() {

	}
}
