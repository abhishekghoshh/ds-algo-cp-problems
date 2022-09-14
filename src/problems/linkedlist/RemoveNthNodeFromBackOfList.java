package problems.linkedlist;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/799912?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * https://www.youtube.com/watch?v=Lhu3MsXZy-Q&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=31
 * 
 * */
public class RemoveNthNodeFromBackOfList {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// two pointer or sliding window technique
	// time complexity O(n)
	// space complexity O(1)
	private static void type2() {
		LinkedListNode<Integer> head = new LinkedListNode<>(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int n = 3;

		LinkedListNode<Integer> left = head, right = head, prev;
		// moving the right pointer to end of the window
		// after n-1 operation it right will go to last element of the window
		for (int i = 1; i <= n - 1 && null != right; i++) {
			right = right.next;
		}
		// right will be null only if listLength <= n
		// suppose the length of list is n, then after only n-1 traversal it will go to
		// the last element
		if (null == right || null == right.next) {
			head = head.next;
		} else {
			// suppose list is 1 2 3 4 5 6 7 8 9 and n=3
			// then after n-1=2 traversal right will go 3 and left is 1
			// We will slide the window to the last element not the null
			// at this point right will be 9 and left will be 7
			// our target is to remove 7
			// we will assign the left pointer to prev before moving it to next
			// so prev is pointing to 6 now
			// our work is now 6.next=7.next then free the 7 pointer
			prev = left;
			while (null != right.next) {
				right = right.next;
				prev = left;
				left = left.next;
			}
			prev.next = left.next;
		}
		head.print();
	}

	private static void type1() {
		// TODO Auto-generated method stub

	}

}
