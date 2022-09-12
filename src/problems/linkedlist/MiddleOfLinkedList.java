package problems.linkedlist;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/973250?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * 
 * Solution link : 
 * https://www.youtube.com/watch?v=sGdwSH8RK-o&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=29
 * 
 * If the length is even then we will return the 2nd element
 *  1,2,3,4,5 -> 3
 *  1,2,3,4,5,6 -> 4 
 *  for even elements if we want to return the first element then can store that element to previous pointer
 * */
public class MiddleOfLinkedList {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimized approach
	// Tortoise method
	// we will take 2 pointer slow and fast
	// one will go next and one will go next to next
	// So 2nd pointer will go twice the first pointer
	// so when 2nd pointer reaches the end the first pointer only goes to half
	private static void type2() {
		Node<Integer> head = new Node<>(1, 2, 3, 4, 5);
		head.print();
		Node<Integer> slow = head, fast = head;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.print();
	}

	// brute force approach
	// first will count the length
	// now it will go half of the length
	private static void type1() {
		Node<Integer> head = new Node<>(1, 2, 3, 4, 5);
		head.print();
		int length = 0;
		Node<Integer> copy = head;
		while (null != copy) {
			copy = copy.next;
			length++;
		}
		length = length / 2;
		copy = head;
		while (length != 0) {
			copy = copy.next;
			length--;
		}
		copy.print();
	}

}
