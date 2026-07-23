# RemoveNthNodeFromBackOfList

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)
- [📄 NeetCode](https://neetcode.io/problems/remove-node-from-end-of-linked-list)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/799912)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=3kMKYQ2wNIU)
- [▶ YouTube](https://www.youtube.com/watch?v=Lhu3MsXZy-Q)
- [▶ YouTube](https://www.youtube.com/watch?v=XVuQxVej6y8)
- [📄 takeUforward](https://takeuforward.org/data-structure/remove-n-th-node-from-the-end-of-a-linked-list/)

## 📝 Problem Statement

Remove the nth node from the end of a linked list.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

reverse the list then delete the node again reverse and return creating a dummy head and attach the head to it going to the node breaking the link again

**Time Complexity:** `O(n)`

```java
	private static void type3() {
		Node head = new Node(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int n = 3;
		Node result = removeNthFromEnd3(head, n);
		print(result);
	}

	private static Node removeNthFromEnd3(Node head, int n) {
		head = reverse(head);
		// creating a dummy head and attach the head to it
		Node dummyHead = new Node();
		dummyHead.next = head;
		Node prev = dummyHead, curr = head;
		// going to the node
		for (int i = 1; i < n; i++) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = prev.next.next;
		// breaking the link again
		head = dummyHead.next;
		dummyHead.next = null;
		// reversing again
		return reverse(head);
	}

	private static Node reverse(Node node) {
		Node prev = null;
		while (null != node) {
			Node next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		return prev;
	}
```

### Approach 2

best approach two pointer or sliding window technique but do it little carefully, this can be confusing sometimes Create two pointers, left and right Move the right pointer N nodes ahead If fast becomes null, the Nth node from the end is the head Move both pointers until fast reaches the end Delete the Nth node from the end

**Time Complexity:** `O(n)`
**Space Complexity:** `O(1)`

```java
	private static void type2() {
		Node head = new Node(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int n = 3;
		Node result = removeNthFromEnd2(head, n);
		print(result);
	}

	public static Node removeNthFromEnd2(Node head, int n) {
		if (head.next == null) return null;
		// Create two pointers, left and right
		Node left = head, right = head;

		// Move the right pointer N nodes ahead
		for (int i = 0; i < n; i++)
			right = right.next;

		// If fast becomes null, the Nth node from the end is the head
		if (right == null) return head.next;

		// Move both pointers until fast reaches the end
		while (right.next != null) {
			right = right.next;
			left = left.next;
		}
		// Delete the Nth node from the end
		left.next = left.next.next;
		return head;
	}
```

### Approach 1: 🔨 Brute Force

brute force approach we will store finds out the nth node by storing all the nodes in an array list then we will just point the prev.next = node.next if there is a single pointer, then we will return null because n can be maximum and minimum 1 we have to remove the head pointer if linked list size equal to n then we have to remove the first pointer we will get the target pointer and it's previous pointer we will change the pointer

```java
	private static void type1() {
		Node head = new Node(1, 2, 3, 4, 5);
		int n = 2;
		Node result = removeNthFromEnd1(head, n);
		print(result);
	}

	public static Node removeNthFromEnd1(Node head, int n) {
		// if there is a single pointer, then we will return null
		// because n can be maximum and minimum 1
		// we have to remove the head pointer
		if (head.next == null) return null;
		List<Node> list = new ArrayList<>();
		Node node = head;
		while (null != node) {
			list.add(node);
			node = node.next;
		}
		int sz = list.size();
		// if linked list size equal to n then we have to remove the first pointer
		if (sz == n) return head.next;
		// we will get the target pointer and it's previous pointer
		node = list.get(sz - n);
		Node prev = list.get(sz - n - 1);
		// we will change the pointer
		prev.next = node.next;
		return head;
	}

}
```
