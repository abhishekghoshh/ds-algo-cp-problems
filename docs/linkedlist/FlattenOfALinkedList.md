# FlattenOfALinkedList

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/flatten-a-linked-list_1112655)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/1112655)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ykelywHJWLg)
- [▶ YouTube](https://www.youtube.com/watch?v=ysytSSXpAI0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=39)
- [📄 takeUforward](https://takeuforward.org/data-structure/flattening-a-linked-list/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/flattening-a-linked-list/)

## 📝 Problem Statement

Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

Same as previous just with little optimization using priority queue same approach used in merge K sorted list into one list

**Time Complexity:** `O(n*m*log(n)`
**Space Complexity:** `O(n)`

```java
	private static void type4() {
		Node head = new Node(1).bottom(7, 8, 30);
		head.chain(new Node(19).bottom(22, 50))
				.chain(new Node(28).bottom(35, 40, 45));
		print(head);
		head = flattenLinkedList4(head);
		print(head);
	}

	private static Node flattenLinkedList4(Node head) {
		PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.data));
		Node node = head, next, lowest, currentLowest;
		while (null != node) {
			heap.offer(node);
			next = node.next;
			node.next = null;
			node = next;
		}
		head = new Node(0);
		node = head;
		while (!heap.isEmpty()) {
			lowest = heap.poll();
			if (!heap.isEmpty()) {
				currentLowest = heap.peek();
				while (null != lowest && lowest.data <= currentLowest.data) {
					node.bottom = lowest;
					lowest = lowest.bottom;
					node = node.bottom;
				}
				if (null != lowest) heap.offer(lowest);
			} else {
				while (null != lowest) {
					node.bottom = lowest;
					lowest = lowest.bottom;
					node = node.bottom;
				}
			}
		}
		return head.bottom;
	}
```

### Approach 3

using priority queue same approach used in merge K sorted list into one list

**Time Complexity:** `O(n*m*log(n)`
**Space Complexity:** `O(n)`

```java
	private static void type3() {
		Node head = new Node(1).bottom(7, 8, 30);
		head.chain(new Node(19).bottom(22, 50))
				.chain(new Node(28).bottom(35, 40, 45));

		print(head);
		head = flattenLinkedList3(head);
		print(head);
	}

	private static Node flattenLinkedList3(Node head) {
		PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.data));
		Node node = head, next;
		while (null != node) {
			heap.offer(node);
			next = node.next;
			node.next = null;
			node = next;
		}
		head = new Node(-1);
		Node prev = head;
		while (!heap.isEmpty()) {
			node = heap.poll();
			prev.bottom = node;
			prev = prev.bottom;
			if (node.bottom != null) heap.offer(node.bottom);
		}
		return head.bottom;
	}
```

### Approach 2

merge approach recursively merge last and second last then merge it to previous and the process goes on let's say there is n right nodes and on each m bottom nodes at this point node1 and node2 are merged in l1's bottom but there is a link between node1.next and node2 so, after merge operation we are breaking the next link as node1 and node2 sorted order and the linked list it also sorted so node1.data < node2.data first pointer will always be node1's

**Time Complexity:** `O(n*n*m)`
**Space Complexity:** `O(1)`

```java
	private static void type2() {
		Node head = new Node(1).bottom(7, 8, 30);
		head.chain(new Node(19).bottom(22, 50))
				.chain(new Node(28).bottom(35, 40, 45));
		print(head);
		head = flatten(head);
		print(head);
	}

	private static Node flatten(Node head) {
		if (null == head || null == head.next) return head;
		head.next = flatten(head.next);
		head = merge(head, head.next);
		// at this point node1 and node2 are merged in l1's bottom
		// but there is a link between node1.next and node2
		// so, after merge operation we are breaking the next link
		head.next = null;
		return head;
	}

	// merge operation
	private static Node merge(Node node1, Node node2) {
		// as node1 and node2 sorted order and the linked list it also sorted
		// so node1.data < node2.data
		// first pointer will always be node1's
		Node dummy = new Node(0);
		Node prev = dummy;
		while (null != node1 && null != node2) {
			if (node1.data <= node2.data) {
				prev.bottom = node1;
				prev = node1;
				node1 = node1.bottom;
			} else {
				prev.bottom = node2;
				prev = node2;
				node2 = node2.bottom;
			}
		}
		prev.bottom = (null != node1) ? node1 : node2;
		return dummy.bottom;
	}
```

### Approach 1: 🔨 Brute Force

brute force approach let's say there is n right nodes and on each m bottom nodes O(n*m) to put it in array O((n*m)log(n*m)) to sort the array O(n*m) to create new linked list

**Time Complexity:** `O(2*m*n)`
**Space Complexity:** `O(m*n)`

```java
	private static void type1() {
		Node head = new Node(1).bottom(7, 8, 30);
		head.chain(new Node(19).bottom(22, 50))
				.chain(new Node(28).bottom(35, 40, 45));
		print(head);
		head = flattenLinkedList1(head);
		print(head);
	}

	public static Node flattenLinkedList1(Node head) {
		Node curr = head, next, bottom;
		List<Node> list = new ArrayList<>();
		while (null != curr) {
			bottom = curr;
			while (null != bottom) {
				list.add(bottom);
				bottom = bottom.bottom;
			}
			next = curr.next;
			curr.next = null;
			curr = next;
		}
		list.sort(Comparator.comparingInt(node -> node.data));
		head = new Node(0);
		curr = head;
		for (Node node : list) {
			curr.bottom = node;
			curr = node;
		}
		return head.bottom;
	}

}
```
