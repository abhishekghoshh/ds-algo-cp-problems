package problems.linkedlist;

public class DeleteNodeInALinkedList {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		// You will not be given access to the head of the list
		// instead you will be given access to the node to be deleted directly.
		// It is guaranteed that the node to be deleted is not a tail node in the list.
		Node<Integer> givenNode = new Node<>(5);
		Node<Integer> head = new Node<>(1, 2, 3, 4).next(givenNode).next(new Node<>(6, 7, 8, 9));
		head.print();
		givenNode.data=givenNode.next.data;
		givenNode.next=givenNode.next.next;
		head.print();
	}

}
