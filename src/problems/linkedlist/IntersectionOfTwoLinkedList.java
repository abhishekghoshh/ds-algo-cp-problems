package problems.linkedlist;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/630457?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * https://www.youtube.com/watch?v=u4FWXfgS8jw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=34
 * 
 * */
public class IntersectionOfTwoLinkedList {
	public static void main(String[] args) {
		type2();
		type3();
	}

	// two linked list having common point
	// time complexity O(2*(n1+n2))
	// space complexity O(1)
	private static void type3() {
		Node<Integer> common = new Node<>(15, 30);
		Node<Integer> headA = new Node<>(10, 6, 9).next(common);
		Node<Integer> headB = new Node<>(10, 11).next(common);
		int count1 = count(headA);
		int count2 = count(headB);
		while (count1 != count2) {
			if (count1 > count2) {
				headA = headA.next;
				count1--;
			} else {
				headB = headB.next;
				count2--;
			}
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		System.out.println(null != headA ? headA.toString() : "[]");
	}

	private static int count(Node<Integer> head) {
		int length = 0;
		while (null != head) {
			head = head.next;
			length++;
		}
		return length;
	}

	// two linked list has the common data not the common
	// time complexity O(2*(n1+n2))
	// space complexity O(1)
	private static void type2() {
		Node<Integer> headA = new Node<>(10, 6, 9, 15, 30);
		Node<Integer> headB = new Node<>(10, 15, 30);
		Node<Integer> common = null;
		int count1 = count(headA);
		int count2 = count(headB);
		boolean hasCommon = false;
		while (count1 > count2) {
			headA = headA.next;
			count1--;
		}
		while (count2 > count1) {
			headB = headB.next;
			count2--;
		}
		while (null != headA && null != headB) {
			if (headA.data == headB.data) {
				if (!hasCommon) {
					hasCommon = true;
					common = headA;
				}
			} else {
				if (hasCommon) {
					hasCommon = false;
				}
			}
			headA = headA.next;
			headB = headB.next;
		}
		System.out.println(null != common ? common.toString() : "[]");
	}
}
