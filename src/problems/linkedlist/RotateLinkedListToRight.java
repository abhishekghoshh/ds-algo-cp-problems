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
		// Node.isLastPoinerCheckEnabled = false;
		type1();
		type2();

	}

	// optimized approach
	// time complexity O(n)
	// space complexity O(1)
	// for example 1,2,3,4,5 will be 4,5,1,2,3 after 2 rotation
	// if list is null or it has only one element or k ==0 then we will just return
	// as we don't have to do anything
	// our job is to attach 5 to 1 then detach 3.next from 4 to null
	// then assign 4 to head
	// so our list will become like 1,2,3,4,5->>1
	// then it will become 1,2,3->>null 4,5->>1 and 4 is head now
	// our list will become 4,5,1,2,3
	// so first we will go to last pointer and along with it we will count length
	// then we will attach last.next = head
	// now our list become cycle
	// we are at 5 and k=2 so we need to travel n-k distance
	// after traveling we will reach node 3
	// now we will assign head to 3.next which is 4
	// also breaks 3's next pointer
	private static void type2() {
		Node<Integer> head = new Node<>(1, 2, 3, 4, 5);
		int k = 2;
		// length is not zero or a single node or number of rotation is not zero
		if (null != head && null != head.next && k != 0) {
			Node<Integer> start = head;
			// we are initializing it length to 1
			int length = 1, reminder;
			// we need to go to the last pointer not null
			// also we will count the length
			while (null != start.next) {
				start = start.next;
				length++;
			}
			reminder = k % length;
			if (reminder == 0)
				return;
			reminder = length - reminder;
			// link last node to first node
			start.next = head;
			while (reminder != 0) {
				start = start.next;
				reminder--;
			}
			// breaking last node link and pointing to NULL
			head = start.next;
			start.next = null;
		}

		System.out.println("new linked list is " + head);
	}

	// brute force approach
	// time complexity O(k*n)
	private static void type1() {

	}

}
