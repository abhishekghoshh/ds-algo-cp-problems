package problems.linkedlist;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/1105578?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 
 * https://www.youtube.com/watch?v=icnp4FJdZ_c&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=32
 * 
 * 
 * */
//You are given the node to be deleted node. 
//You will not be given access to the first node of head.All the values of the linked list are unique, 
//and it is guaranteed that the given node node is not the last node in the linked list.
public class DeleteNodeInALinkedList {

	public static void main(String[] args) {
		type1();
	}

	// Time complexity O(1)
	// space complexity O(1)
	private static void type1() {
		// You will not be given access to the head of the list
		// instead you will be given access to the node to be deleted directly.
		// It is guaranteed that the node to be deleted is not a tail node in the list.
		Node<Integer> givenNode = new Node<>(5);
		Node<Integer> head = new Node<>(1, 2, 3, 4).next(givenNode).next(new Node<>(6, 7, 8, 9));
		head.print();
		givenNode.data = givenNode.next.data;
		givenNode.next = givenNode.next.next;
		head.print();
	}
}
