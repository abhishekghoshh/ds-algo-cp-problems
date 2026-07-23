# DeleteTheMiddleNodeOfLinkedList

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/delete-middle-node_763267)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ePpV-_pfOeI)

## 📝 Problem Statement

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing,

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

optimized approach using a slow and a fast pointer to calculate the mid-pointer slight optimization from the previous. we will not start fast from the head pointer, and instead of the slow pointer we will keep track of the prev pointer we will keep track of the previous pointer, we are shifting the fast by one iteration

```java
    private static void type3() {
        Node head = new Node(1, 3, 4, 7, 1, 2, 6);
        head = deleteMiddle3(head);
        print(head);
    }

    private static Node deleteMiddle3(Node head) {
        if (head.next == null) return null;
        // we will keep track of the previous pointer,
        //  we are shifting the fast by one iteration
        Node fast = head.next.next, prev = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
```

### Approach 2

optimized approach using a slow and a fast pointer to calculate the mid-pointer this loop will work for all length linked lists slow is the middle pointer

```java
    private static void type2() {
        Node head = new Node(1, 3, 4, 7, 1, 2, 6);
        head = deleteMiddle2(head);
        print(head);
    }

    private static Node deleteMiddle2(Node head) {
        if (head.next == null) return null;
        Node prev = null, slow = head, fast = head;
        // this loop will work for all length linked lists
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is the middle pointer
        prev.next = slow.next;
        return head;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach store it in an array list find the mid then detach the pointer by the question logic mid is

```java
    private static void type1() {
        Node head = new Node(1, 3, 4, 7, 1, 2, 6);
        head = deleteMiddle1(head);
        print(head);
    }

    public static Node deleteMiddle1(Node head) {
        if (head.next == null) return null;
        List<Node> list = new ArrayList<>();
        Node node = head;
        while (null != node) {
            list.add(node);
            node = node.next;
        }
        // by the question logic mid is
        int mid = list.size() / 2;
        Node prev = list.get(mid - 1);
        node = list.get(mid);
        prev.next = node.next;
        return head;
    }
}
```
