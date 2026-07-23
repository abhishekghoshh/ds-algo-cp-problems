# ReverseLinkedlistInGroupsOfSizeK

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/reverse-nodes-in-k-group/description/)
- [📄 NeetCode](https://neetcode.io/problems/reverse-nodes-in-k-group)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/763406)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/reverse-list-in-k-groups_983644)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=lIar1skcQYI)
- [▶ YouTube](https://www.youtube.com/watch?v=Of0HPkk3JgI)
- [▶ YouTube](https://www.youtube.com/watch?v=1UOPsfP85V4)
- [📄 takeUforward](https://takeuforward.org/data-structure/reverse-linked-list-in-groups-of-size-k/)

## 📝 Problem Statement

Reverse every K nodes in a linked list.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

check it later one more time In place reversal O(n) for calculating the length O(n) for in place reversal we are taking 3 pointers here previous, current and next as the first pointer does not have any previous so we will add dummy node we will start from 1 at the starting list is 0->1->2->3->4, pre=0 cur=1 next=2 after 1 iteration, it will be 0->2->1->3->4, pre=0,cur=1,next=3 after 2 iteration, it will be 0->3->2->1->4, pre=0,cur=1,next=4 the main operation is to take the next element and put it at the first we are not changing the current or previous

**Time Complexity:** `O(2n)`
**Space Complexity:** `O(1)`

```java
	private static void type3() {
		Node head = new Node(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		int k = 4;
		print(head);
		head = reverseKGroup3(head, k);
		print(head);
	}

	public static Node reverseKGroup3(Node head, int k) {
		if (head.next == null || k == 1) return head;
		int n = length(head);
		// we are taking 3 pointers here previous, current and next
		// as the first pointer does not have any previous so we will add dummy node
		Node dummy = new Node(0);
		dummy.next = head;
		Node prev = dummy, curr, next;
			// we will start from 1
		while (n >= k) {
			curr = prev.next;
			next = curr.next;
			for (int i = 1; i < k; i++) {
				// at the starting list is 0->1->2->3->4, pre=0 cur=1 next=2
				// after 1 iteration, it will be 0->2->1->3->4, pre=0,cur=1,next=3
				// after 2 iteration, it will be 0->3->2->1->4, pre=0,cur=1,next=4
				// the main operation is to take the next element and put it at the first
				// we are not changing the current or previous
				curr.next = next.next;
				next.next = prev.next;
				prev.next = next;
				next = curr.next;
			}
			prev = curr;
			n -= k;
		}
		head = dummy.next;
		return head;
	}

	private static int length(Node head) {
		int n = 0;
		while (null != head) {
			n++;
			head = head.next;
		}
		return n;
	}
```

### Approach 2

best approach discuss it in the interview explain this in the interview sliding window O(n) for sliding the window O(n) for reversal of window in every k start will always be last pointer of the previous window for the first element there is no previous, so we have added a dummy pointer then attach the head with the dummy pointer from go first to last node of any window we need to go size-1 step if we start traversing from start of the window then after k-1 operation current will be on last node of window breaks the link of windows last node to the start of the next window else reverse function will reverse all the remaining node now start = 0 -> window=1->2->3->null current=4 left is 1 after reverse right is 3 and list is 0->1<-2<-3||4->5->6..

**Time Complexity:** `O(2n)`
**Space Complexity:** `O(1)`

```java
	private static void type2() {
		Node head = new Node(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
		int k = 3;
		head = reverseKGroup2(head, k);
		print(head);
	}

	public static Node reverseKGroup2(Node head, int k) {
		// start will always be last pointer of the previous window
		// for the first element there is no previous, so we have added a dummy pointer
		// then attach the head with the dummy pointer
		// from go first to last node of any window we need to go size-1 step
		int n = 0;
		Node dummy = new Node();
		dummy.next = head;
		Node prevWindowStart = dummy;

		Node node = head;
		while (null != node) {
			// if we start traversing from start of the window then
			// after k-1 operation current will be on last node of window
			if (n < k - 1) {
				node = node.next;
				n++;
			} else {
				// breaks the link of windows last node to the start of the next window
				// else reverse function will reverse all the remaining node
				Node next = node.next;
				node.next = null; // breaks the link

				// now start = 0 -> window=1->2->3->null current=4 left is 1
				Node windowStart = prevWindowStart.next;
				Node windowEnd = reverse(windowStart);
				// after reverse right is 3 and list is 0->1<-2<-3||4->5->6..
				prevWindowStart.next = windowEnd; // 0->3
				windowStart.next = next;// 1->4
				prevWindowStart = windowStart; // start=3

				node = next; // reassigning next to node
				n = 0; // resetting the window
			}
		}
		head = dummy.next;
		return head;
	}

	private static Node reverse(Node head) {
		Node prev = null, next;
		while (null != head) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
```

### Approach 1: 🔨 Brute Force

brute force O(n) for inserting everything on array O(n) for reversal of the array O(n) to put it back to linked list

**Time Complexity:** `O(3n)`
**Space Complexity:** `O(n)`

```java
	private static void type1() {
		Node head = new Node(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
		int k = 3;
		head = reverseKGroup1(head, k);
		print(head);
	}

	public static Node reverseKGroup1(Node head, int k) {
		List<Node> list = new ArrayList<>();
		int left = 0, right = 0;
		Node curr = head;
		while (null != curr) {
			list.add(curr);
			right++;
			if (right % k == 0) {
				reverse(list, left, right - 1);
				left = right;
			}
			curr = curr.next;
		}
		head = new Node(0);
		curr = head;
		for (Node node : list) {
			curr.next = node;
			curr = curr.next;
		}
		curr.next = null;
		head = head.next;
		return head;
	}

	private static void reverse(List<Node> list, int left, int right) {
		while (left < right) {
			Node temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
			left++;
			right--;
		}

	}

}
```
