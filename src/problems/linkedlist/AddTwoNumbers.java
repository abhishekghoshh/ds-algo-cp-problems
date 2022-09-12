package problems.linkedlist;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/add-two-numbers-as-linked-lists_1170520?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/add-two-numbers/ 
 * 
 * https://www.youtube.com/watch?v=LBVsXSMOIk4&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=33
 * 
 * */
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
		int carry = 0, sum;
		Node<Integer> prev = l1, res = l1;
		while (l1 != null || l2 != null || carry != 0) {
			sum = ((null != l1) ? l1.data : 0) + ((null != l2) ? l2.data : 0) + carry;
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
			l1 = (null != l1) ? l1.next : l1;
			l2 = (null != l1) ? l1.next : l1;
		}
		res.print();
	}

	// time complexity o(max(m,n)+1)
	// space o(max(m,n)+1)
	private static void type1() {
		Node<Integer> l1 = new Node<>(2, 4, 3, 5);
		Node<Integer> l2 = new Node<>(5, 6, 4);
		int carry = 0, sum = 0;
		// assigning a dummy pointer
		Node<Integer> head = new Node<>(0);
		// prev will pointing to head
		Node<Integer> prev = head, current;
		// loop will go until both is null or carry is 0
		while (null != l1 || null != l2 || carry != 0) {
			// sum and carry is calculated even if there is any null list
			sum = ((null != l1) ? l1.data : 0) + ((null != l2) ? l2.data : 0) + carry;
			carry = sum / 10;
			// temporary creating node
			current = new Node<>(sum % 10);
			// attaching current pointer to the previous pointer
			// and then assigning current pointer to previous
			prev.next = current;
			prev = current;
			// going to next node if list is not null
			l1 = (null != l1) ? l1.next : l1;
			l2 = (null != l1) ? l1.next : l1;
		}
		head = head.next;
		head.print();
	}

}
