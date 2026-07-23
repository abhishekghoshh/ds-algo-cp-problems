# SwapNodesInPairs

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/swap-nodes-in-pairs/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=o811TZLAWOo)

## 📝 Problem Statement

Swap every two adjacent nodes in a linked list.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

in place reversal without extra space we will add one extra node at the start we will go two nodes at a time this is the dummy node first node and the second node changing the next pointers of the node1 and node2 updating the previous going to the next node now return without the dummy node


```java
    private static void type2() {
        Node head = new Node(1, 2, 3, 4);
        head = swapPairs2(head);
        PrintUtl.print(head);
    }


    // we will add one extra node at the start
    // we will go two nodes at a time
    public static Node swapPairs2(Node head) {
        if (null == head || head.next == null) return head;
        // this is the dummy node
        Node dummy = new Node();
        Node prev = dummy;
        while (head != null && head.next != null) {
            Node next = head.next.next; // saving the next node
            // first node and the second node
            Node node1 = head, node2 = head.next;
            // changing the next pointers of the node1 and node2
            prev.next = node2;
            node2.next = node1;
            node1.next = next;
            // updating the previous
            prev = node1;
            // going to the next node
            head = next;
        }
        // now return without the dummy node
        return dummy.next;
    }
```

### Approach 1: 🔨 Brute Force

using extra array for reversal as per the problem said we should not change the nodes just change the links adding the nodes to the list we will go to 2 hops everytime changing the next pointers of the node1 and node2 updating the previous

**Time Complexity:** `O(2n)`
**Space Complexity:** `O(n)`

```java
    private static void type1() {
        Node head = new Node(1, 2, 3, 4);
        head = swapPairs1(head);
        PrintUtl.print(head);
    }

    public static Node swapPairs1(Node head) {
        if (null == head || head.next == null) return head;
        // adding the nodes to the list
        List<Node> list = new ArrayList<>();
        Node node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        Node dummyHead = new Node();
        Node prev = dummyHead;
        int n = list.size();
        // we will go to 2 hops everytime
        for (int i = 0; i < n; i += 2) {
            Node node1 = list.get(i);
            Node node2 = list.get(i + 1);
            // changing the next pointers of the node1 and node2
            prev.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // updating the previous
            prev = node1;
        }

        return dummyHead.next;
    }
}
```
