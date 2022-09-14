package problems.linkedlist;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/799897?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * Solution link : https://www.youtube.com/watch?v=iRtLEoL-r-g&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=28
 * 
 * TODO check https://leetcode.com/submissions/detail/797070641/
 * */
public class ReverseOfLinkedList {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// In place reverse without extra space
	private static void type3() {
		LinkedListNode<Integer> head = new LinkedListNode<>(10, 6, 9, 15, 30);
		head.print();
		// new head is the new head, at first it is assign to null
		// next pointer is to store the next pointer until we do the intermediate
		// operation
		// while(null!=head){next = head.next;head = next;}
		// the upper code snippet will traverse the linkedlist
		// newHead actually keeps track of the previous element
		// at first we are assigning next element to next pointer otherwise we will
		// loose the next pointer, then we are attaching the next pointer to previous
		// here we are breaking the forward link and establishes a reverse link
		// then we are assigning current node to previous, which will help in next
		// iteration
		LinkedListNode<Integer> previous = null, next = null, current = head;
		while (null != current) {
			next = current.next;
			current.next = previous;// attaching pointer to previous element
			previous = current;// assigning previous pointer to current
			current = next;
		}
		previous.print();

	}

	// In place reverse without extra space
	private static void type2() {
		LinkedListNode<Integer> head = new LinkedListNode<>(10, 6, 9, 15, 30);
		head.print();
		LinkedListNode<Integer> current = null, previous = null;
		while (null != head) {
			previous = current;
			current = head;
			head = head.next;
			current.next = previous;
		}
		current.print();

	}

	private static void type1() {

	}
}
