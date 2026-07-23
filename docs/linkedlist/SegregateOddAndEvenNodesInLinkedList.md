# SegregateOddAndEvenNodesInLinkedList

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/odd-even-linked-list/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/segregate-even-and-odd-nodes-in-a-linked-list_1116100)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=qf6qp7GzD5Q)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

```java
    private static void type3() {

    }
```

### Approach 2

check one more time pointer allocation is little confusing and can be fixed in place link construction first, we will start with two pointers, odd and even

```java
    private static void type2() {
        Node head = new Node(2, 1, 3, 5, 6, 4, 7);
        print(head);
        head = oddEvenList(head);
        print(head);
    }

    // TODO check one more time
    // pointer allocation is little confusing and can be fixed
    // in place link construction
    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null) return head;
        // first, we will start with two pointers, odd and even
        Node odd = head;
        Node even = head.next;
        Node enHead = even;
        while (even != null && even.next != null && odd != null && odd.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = enHead;
        return head;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach we will add all the node data to a list adding all the node data in the array list now we will add data's back to the linked list first we will assign the odd index nodes then we will assign the even index nodes

```java
    private static void type1() {
        Node head = new Node(2, 1, 3, 5, 6, 4, 7);
        print(head);
        Node node = head;
        // adding all the node data in the array list
        List<Integer> list = new ArrayList<>();
        while (null != node) {
            list.add(node.data);
            node = node.next;
        }
        int n = list.size();
        node = head;
        // now we will add data's back to the linked list
        // first we will assign the odd index nodes
        for (int i = 0; i < n && node != null; i += 2) {
            node.data = list.get(i);
            node = node.next;
        }
        // then we will assign the even index nodes
        for (int i = 1; i < n && node != null; i += 2) {
            node.data = list.get(i);
            node = node.next;
        }
        print(head);
    }
}
```
