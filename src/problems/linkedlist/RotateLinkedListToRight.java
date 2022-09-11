package problems.linkedlist;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/920454?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/rotate-list/
 * 
 * https://www.youtube.com/watch?v=9VPm6nEbVPA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=40
 * 
 * */
public class RotateLinkedListToRight {

	public static void main(String[] args) {
		type1();
		type2();

	}

	// optimized approach
	// time complexity O(n)
	// space complexity O(1)
	// for example 1,2,3,4,5 will be 4,5,1,2,3 after 2 rotation
	// so for this we will traverse until we get 4 also assign the previous node
	// so our current node is 4 and previous node is 3
	// so now will go till last and change the pointer of the last
	// such that last will point to head
	// also change the pointer of previous(3) node such that it points to null;
	// so list will become 1,2,3->Null 4,5->1 => 4,5,1,2,3
	private static void type2() {
		Node<Integer> head = new Node<>(1, 2, 3, 4, 5);
		int k = 2;
		int length = 0, reminder;
		Node<Integer> start = head, previous = null, current = null;
		while (null != start) {
			length++;
			start = start.next;
		}
		if (length == 0) {
			return;
		}
		reminder = k % length;
		if (reminder != 0) {
			reminder = length - reminder;
			start = head;
			while (reminder != 0) {
				previous = start;
				start = start.next;
				current = start;
				reminder--;
			}
			while (null != start.next) {
				start = start.next;
			}
			start.next = head;
			previous.next = null;
			head = current;
		}
		System.out.println("new linked list is " + head);
	}

	// bruteforce approach
	// time complexity O(k*n)
	private static void type1() {

	}

}
